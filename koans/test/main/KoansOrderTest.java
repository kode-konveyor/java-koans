package main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class KoansOrderTest {

	@Test
	public void aboutArraysIsBeforeAboutVarArgs() {
		assertTrue(KoansOrder.compare("beginner.AboutArrays",
				"beginner.AboutVarArgs") < 0);
	}
	
	@Test
	public void aboutVarArgsIsAfterAboutArrays() {
		assertTrue(KoansOrder.compare("beginner.AboutVarArgs",
				"beginner.AboutArrays") > 0);
	}
	
	@Test
	public void notDefinedClassesAreAtTheEndOfTheList() {
		assertTrue(KoansOrder.compare("class name that will never exist",
				"java8.AboutBase64") > 0);
	}
}
