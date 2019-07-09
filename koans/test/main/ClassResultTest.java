package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult.Status;

public class ClassResultTest {

	private static final String BEGINNER_ABOUT_OBJECTS = "beginner.AboutObjects";
	private static final String TEST_FAILED = "testFailed()";
	private static final String TEST_PASSED = "testPassed()";
	private static final String PASSED = "PASSED";
	private static final String OTHER_CLASS = "[env]:[class:other.Class]";
	private static final String ABOUT_OBJECTS = "[env]:[class:beginner.AboutObjects]";
	private ClassResult classResult;

	@BeforeEach
	public void setUp() {
		classResult = new ClassResult(ABOUT_OBJECTS);
	}

	@Test
	public void classNameShouldBeConvertedFromClassId() {
		assertEquals(BEGINNER_ABOUT_OBJECTS, classResult.className);
	}

	@Test
	public void invalidClassIdShouldCauseException() {
		assertThrows(IllegalArgumentException.class, () -> new ClassResult("invalidFormat"));
	}

	@Test
	public void addSuccessfulTestShouldIncreasePassedCount() {
		classResult.add("exampleTest", Status.SUCCESSFUL);
		assertEquals(1, classResult.getPassedCount());
	}

	@Test
	public void addSuccessfulTestShouldIncreaseTestCount() {
		classResult.add("exampleTest", Status.SUCCESSFUL);
		assertEquals(1, classResult.getTestCount());
	}

	@Test
	public void addFailedTestShouldNotIncreasePassedCount() {
		classResult.add("exampleTest", Status.FAILED);
		assertEquals(0, classResult.getPassedCount());
	}

	@Test
	public void addFailedTestShoulIncreaseTestCount() {
		classResult.add("exampleTest", Status.FAILED);
		assertEquals(1, classResult.getTestCount());
	}

	@Test
	public void classResultsAreEqualWhenClassNamesAreTheSame() {
		assertEquals(classResult, new ClassResult(ABOUT_OBJECTS));
	}

	@Test
	public void classResultsAreNotEqualWhenClassNamesAreDifferent() {
		assertNotEquals(classResult, new ClassResult(OTHER_CLASS));
	}

	@Test
	public void formattingPassessNeededDataToFormatter() {
		ClassResultFormatter formatter = mock(ClassResultFormatter.class);

		when(formatter.format(eq(BEGINNER_ABOUT_OBJECTS),
				eq(Set.of(TEST_PASSED)),
				eq(Set.of(TEST_FAILED))))
						.thenReturn(PASSED);

		classResult.add(TEST_PASSED, Status.SUCCESSFUL);
		classResult.add(TEST_FAILED, Status.FAILED);
		assertEquals(PASSED, classResult.getFormatted(formatter));
	}

}
