package main;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

public class TestSummaryListener extends SummaryGeneratingListener {
	
	private TestSummaryByClass result = new TestSummaryByClass();

	@Override
	public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
		if (testIdentifier.getType().isTest()) {
			result.add(testIdentifier, testExecutionResult);
		}
		super.executionFinished(testIdentifier, testExecutionResult);
		
	}

	public TestSummaryByClass getSummaryByClass() {
		return result;
	}

	
	
}
