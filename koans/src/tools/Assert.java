package tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assert {
	
	public static void assertTrue(String arg) {
		assertEquals(true, arg);
	}
	
	public static void assertFalse(String arg) {
		assertEquals(false, arg);
	}

}
