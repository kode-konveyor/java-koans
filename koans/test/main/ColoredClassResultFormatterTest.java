package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ColoredClassResultFormatterTest {

	private static final String FAILED_TEST2 = "failedTest2()";
	private static final String PASSED_TEST = "passedTest()";
	private static final String CLASS_NAME = "ClassName";
	private static final String FAILED_TEST1 = "failedTest1()";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String RESET = "\033[0m";

	private ColoredClassResultFormatter formatter;
	private String mixedResult;

	@BeforeEach
	public void setUp() {
		formatter = new ColoredClassResultFormatter();
		mixedResult = formatter.format(CLASS_NAME, Set.of(PASSED_TEST), Set.of(FAILED_TEST1, FAILED_TEST2));
	}

	@Test
	public void classWithoutPassedTestShouldBeRed() {
		assertColorBySets(Set.of(), Set.of(FAILED_TEST1), ANSI_RED);
	}

	@Test
	public void classWithPassedAndFailedTestsShouldBeYellow() {
		assertColorBySets(Set.of(PASSED_TEST), Set.of(FAILED_TEST1), ANSI_YELLOW);
	}

	@Test
	public void classWithoutFailedTestShouldBeGreen() {
		assertColorBySets(Set.of(PASSED_TEST), Set.of(), ANSI_GREEN);
	}

	@Test
	public void formatterResetsTheConsoleAfterTheContent() {
		assertTrue(mixedResult.endsWith(RESET));
	}

	@Test
	public void formattedTextContainsTheClassName() {
		assertTrue(mixedResult.contains(CLASS_NAME));
	}

	@Test
	public void formattedTextContainsRateOfPassedTests() {
		assertTrue(mixedResult.contains("1 / 3"));
	}

	@Test
	public void formattedTextBuildsUpAsExpected() {
		assertEquals(ANSI_YELLOW + CLASS_NAME + ": 1 / 3" + RESET, mixedResult);
	}

	private void assertColorBySets(Set<String> passed, Set<String> failed, String color) {
		String formatted = formatter.format(CLASS_NAME, passed, failed);
		assertTrue(formatted.startsWith(color));
	}
}
