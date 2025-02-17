package main;

import java.util.HashSet;
import java.util.Set;

import org.junit.platform.engine.TestExecutionResult.Status;

public class ClassResult {
	protected String className;
	private Set<String> passed;
	private Set<String> failed;
	
	public ClassResult(String classId) {
		this.className = reduceClassIdToName(classId);
		this.passed = new HashSet<String>();
		this.failed = new HashSet<String>();
	}

	private String reduceClassIdToName(String classId) {
		try {
			return classId.split("[\\[\\]]")[3].substring("class:".length());
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(String.format("Illegal ClassId [%s]", classId), e);
		}
	}

	public void add(String test, Status status) {
		if (Status.SUCCESSFUL.equals(status)) {
			passed.add(test);
		} else {
			failed.add(test);
		}
	}
	
	public String getFormatted(ClassResultFormatter formatter) {
		return formatter.format(className, passed, failed);
	}

	public int getPassedCount() {
		return passed.size();
	}

	public int getTestCount() {
		return passed.size() + failed.size();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof ClassResult) {
			return className.equals(((ClassResult) other).className);
		}
		return false;
	}
}