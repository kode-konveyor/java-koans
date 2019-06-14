package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class ComparableClassResultTest {

	private static final String ABOUT_OBJECTS = "[env]:[class:beginner.AboutObjects]";
	private static final String ABOUT_COLLECTIONS = "[env]:[class:intermediate.AboutCollections]";
	private static final String ABOUT_LOCAL_TIME = "[env]:[class:java8.AboutLocalTime]";

	@Test
	public void sortShouldGiveTheCorrectOrderOfKoans() {
		List<ComparableClassResult> unorderedList = List.of(
				new ComparableClassResult(ABOUT_LOCAL_TIME),
				new ComparableClassResult(ABOUT_COLLECTIONS),
				new ComparableClassResult(ABOUT_OBJECTS));

		List<ComparableClassResult> expectedOrder = List.of(
				new ComparableClassResult(ABOUT_OBJECTS),
				new ComparableClassResult(ABOUT_COLLECTIONS),
				new ComparableClassResult(ABOUT_LOCAL_TIME));

		assertEquals(expectedOrder, sortList(unorderedList));
	}

	private List<ComparableClassResult> sortList(List<ComparableClassResult> unorderedList) {
		return unorderedList.stream().sorted().collect(Collectors.toList());
	}
}
