package main;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.io.PrintWriter;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult.Status;
import org.mockito.ArgumentCaptor;

public class TestSummaryByClassTest {

	private TestSummaryByClass summary;
	private PrintWriter printWriter;
	private ArgumentCaptor<String> captor;

	@BeforeEach
	public void setUp() {
		summary = new TestSummaryByClass();
		printWriter = mock(PrintWriter.class);
		captor = ArgumentCaptor.forClass(String.class);
		doNothing().when(printWriter).println(captor.capture());
		fillSummary();
		summary.printTo(printWriter);
	}

	private void fillSummary() {
		summary.add(Optional.of("[env]:[class:ClassA]"), "methodA1", Status.FAILED);
		summary.add(Optional.of("[env]:[class:ClassA]"), "methodA2", Status.FAILED);
		summary.add(Optional.of("[env]:[class:ClassB]"), "methodB1", Status.FAILED);
		summary.add(Optional.of("[env]:[class:ClassB]"), "methodB2", Status.SUCCESSFUL);
	}

	@Test
	public void firstLineContainsProgressPercentage() {
		assertFirstLineContains("25.00%");
	}

	@Test
	public void firstLineContainsProgressRate() {
		assertFirstLineContains("1/4");
	}

	private void assertFirstLineContains(String substring) {
		String result = captor.getAllValues().get(0);
		assertTrue(result.contains(substring));
	}

}
