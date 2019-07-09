package main;

import org.junit.platform.engine.TestExecutionResult.Status;

public class ClassResultTestHelper {

	private static final String ABOUT_OBJECTS = "[env]:[class:beginner.AboutObjects]";

	public static ComparableClassResult createClassResult() {
		return new ComparableClassResult(ABOUT_OBJECTS);
	}

	public static void addPassingTest(ComparableClassResult result, String testName) {
		result.add(testName, Status.SUCCESSFUL);
	}

	public static void addFailingTest(ComparableClassResult result, String testName) {
		result.add(testName, Status.FAILED);
	}
}
