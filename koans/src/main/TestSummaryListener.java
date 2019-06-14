package main;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

public class TestSummaryListener extends SummaryGeneratingListener {
	
	private TestSummaryByClass result = new TestSummaryByClass();

	@Override
	public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
		executionFinished(new TestIdentifierWrapper(testIdentifier), testExecutionResult);
		super.executionFinished(testIdentifier, testExecutionResult);
	}

	protected void executionFinished(TestIdentifierWrapper testIdentifier, TestExecutionResult testExecutionResult) {
		if (testIdentifier.isTest()) {
			result.add(testIdentifier.getParentId(), testIdentifier.getDisplayName(), testExecutionResult.getStatus());
		}
	}

	public TestSummaryByClass getSummaryByClass() {
		return result;
	}

	
	
}
