package main;

import java.util.Optional;

import org.junit.platform.launcher.TestIdentifier;

public class TestIdentifierWrapper {

	private TestIdentifier testIdentifier;

	public TestIdentifierWrapper(final TestIdentifier testIdentifier) {
		this.testIdentifier = testIdentifier;
	}

	public boolean isTest() {
		return testIdentifier.getType().isTest();
	}

	public Optional<String> getParentId() {
		return testIdentifier.getParentId();
	}

	public String getDisplayName() {
		return testIdentifier.getDisplayName();
	}

}
