package main;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestIdentifier;

public class TestSummaryByClass {
	
	Map<String, ComparableClassResult> results = new HashMap<String, ComparableClassResult>();
	
	public void printTo(PrintWriter writer) {
		int allPassed = countSubset(r->r.getPassedCount());
		int allTestCases = countSubset(r->r.getTestCount());
		double percent = Double.valueOf(allPassed) / allTestCases;
		
		writer.println(String.format("PROGRESS: %.2f%% %d/%d", percent*100, allPassed, allTestCases));
		writer.println();
		results.values().stream()
			.sorted()
			.forEach(printClassResult(writer));
		writer.flush();
	}

	private Consumer<? super ClassResult> printClassResult(PrintWriter writer) {
		return (result) -> writer.println(result.getFormatted(ColoredClassResultFormatter.create()));
	}

	

	private int countSubset(ToIntFunction<? super ClassResult> mapper) {
		return results.values().stream().mapToInt(mapper).sum();
	}

	public void add(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
		String classId = testIdentifier.getParentId().orElse("Undefined");
		results.putIfAbsent(classId, new ComparableClassResult(classId));
		results.get(classId).add(testIdentifier.getDisplayName(), testExecutionResult.getStatus());
		
	}
}
