package tools;

import org.junit.jupiter.api.Assertions;

public class Assert {
	
	public static void assertTrue(String arg) {
		Assertions.assertTrue(false);
	}
	
	public static void assertFalse(String arg) {
		Assertions.assertFalse(true);
	}

}
