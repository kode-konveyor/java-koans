package main;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.TestExecutionResult.Status;
import org.junit.platform.launcher.TestIdentifier;

public class TestSummaryByClass {
	
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String RESET = "\033[0m";
	
	private class ClassResult {
		String className;
		Set<String> passed;
		Set<String> failed;
		
		public ClassResult(String classId) {
			this.className = reduceClassIdToName(classId);
			this.passed = new HashSet<String>();
			this.failed = new HashSet<String>();
		}
		
		private String reduceClassIdToName(String classId) {
			return classId.split("[\\[\\]]")[3].substring("class:".length());
		}

		public void add(String test, Status status) {
			if (Status.SUCCESSFUL.equals(status)) {
				passed.add(test);
			} else {
				failed.add(test);
			}
		}
		
	}
	
	Map<String, ClassResult> results = new HashMap<String, ClassResult>();
	
	private Comparator<? super ClassResult> comparator = new Comparator<ClassResult>() {

		@Override
		public int compare(ClassResult o1, ClassResult o2) {
			double rate1 = getRate(o1);
			double rate2 = getRate(o2);
			if (rate1 == rate2)
				return o1.className.compareTo(o2.className);
			return  Double.compare(rate2, rate1);
		}

		private double getRate(ClassResult o1) {
			return Double.valueOf(o1.passed.size()) / (o1.passed.size() + o1.failed.size());
		}
	};
	
	public void printTo(PrintWriter writer) {
		int allPassed = countSubset(r->r.passed.size());
		int allTestCases = countSubset(r->r.failed.size()) + allPassed;
		double percent = Double.valueOf(allPassed) / allTestCases;
		
		writer.println(String.format(RESET + "PROGRESS: %.2f%% %d/%d", percent*100, allPassed, allTestCases));
		writer.println();
		results.values().stream()
			.sorted(comparator)
			.forEach(printClassResult(writer));
		writer.print(RESET);
		writer.flush();
	}

	private Consumer<? super ClassResult> printClassResult(PrintWriter writer) {
		return (result) -> writer.println(getColor(result) + result.className + " " + getRate(result));
	}

	private String getColor(ClassResult result) {
		if (result.failed.size() == 0) 
			return ANSI_GREEN;
		if (result.passed.size() == 0)
			return ANSI_RED;
		return ANSI_YELLOW;
	}

	private int countSubset(ToIntFunction<? super ClassResult> mapper) {
		return results.values().stream().mapToInt(mapper).sum();
	}

	private String getRate(ClassResult result) {
		int passed = result.passed.size();
		int all = passed + result.failed.size();
		
		return passed + " / " + all;
	}

	public void add(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
		String classId = testIdentifier.getParentId().orElse("Undefined");
		results.putIfAbsent(classId, new ClassResult(classId));
		results.get(classId).add(testIdentifier.getDisplayName(), testExecutionResult.getStatus());
		
	}

}
