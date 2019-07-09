package main;

import java.util.Set;

public class ColoredClassResultFormatter implements ClassResultFormatter {
	
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String RESET = "\033[0m";
	
	private String getColor(Set<String> passed, Set<String> failed) {
		if (failed.size() == 0) 
			return ANSI_GREEN;
		if (passed.size() == 0)
			return ANSI_RED;
		return ANSI_YELLOW;
	}

	@Override
	public String format(String className, Set<String> passed, Set<String> failed) {
		
		return getColor(passed, failed) + className + ": " + passed.size() + " / " + (passed.size() + failed.size()) + RESET;
	}

	public static ClassResultFormatter create() {
		return new ColoredClassResultFormatter();
	}

}
