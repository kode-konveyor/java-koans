package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;

public class TestSummaryListenerTest {

	private static final String METHOD2 = "method2()";
	private static final String METHOD = "method()";
	private static final String CLASS_ID = "[][class:ClassName]";
	private TestSummaryListener testSummaryListener;

	@BeforeEach
	public void setUp() {
		testSummaryListener = new TestSummaryListener();
		TestIdentifierWrapper testIdentifier = createMock();
		testSummaryListener.executionFinished(testIdentifier, TestExecutionResult.successful());
		testSummaryListener.executionFinished(testIdentifier, TestExecutionResult.failed(null));
	}

	private TestIdentifierWrapper createMock() {
		TestIdentifierWrapper testIdentifier = mock(TestIdentifierWrapper.class);
		when(testIdentifier.isTest()).thenReturn(true);
		when(testIdentifier.getDisplayName()).thenReturn(METHOD).thenReturn(METHOD2);
		when(testIdentifier.getParentId()).thenReturn(Optional.of(CLASS_ID));
		return testIdentifier;
	}

	@Test
	public void summaryContainsClass() {
		TestSummaryByClass summary = testSummaryListener.getSummaryByClass();
		assertTrue(summary.getResult().containsKey(CLASS_ID));
	}

	@Test
	public void summaryContainsPassedTest() {
		TestSummaryByClass summary = testSummaryListener.getSummaryByClass();
		assertEquals(1, summary.getResult().get(CLASS_ID).getPassedCount());
	}

	@Test
	public void summaryContainsTestCount() {
		TestSummaryByClass summary = testSummaryListener.getSummaryByClass();
		assertEquals(2, summary.getResult().get(CLASS_ID).getTestCount());
	}
}
