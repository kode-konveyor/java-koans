package main;

import java.util.List;

public class KoansOrder {

	private static final List<String> order =
			List.of("beginner.AboutKoans",
					"beginner.AboutAssertions",
					"beginner.AboutEquality",
					"beginner.AboutStrings",
					"beginner.AboutArithmeticOperators",
					"beginner.AboutConditionals",
					"beginner.AboutLoops",
					"beginner.AboutPrimitives",
					"beginner.AboutObjects",
					"beginner.AboutInheritance",
					"beginner.AboutCasting",
					"beginner.AboutConstructors",
					"beginner.AboutEnums",
					"beginner.AboutExceptions",
					"beginner.AboutMethodPreference",
					"beginner.AboutBitwiseOperators",
					"beginner.AboutArrays",
					"beginner.AboutVarArgs",
					"intermediate.AboutAutoboxing",
					"intermediate.AboutCollections",
					"intermediate.AboutComparison",
					"intermediate.AboutDates",
					"intermediate.AboutEquality",
					"intermediate.AboutFileIO",
					"intermediate.AboutInnerClasses",
					"intermediate.AboutLocale",
					"intermediate.AboutRegularExpressions",
					"intermediate.AboutSerialization",
					"advanced.AboutMocks",
					"java7.AboutJava7LiteralsEnhancements",
					"java7.AboutStringsInSwitch",
					"java7.AboutDiamondOperator",
					"java7.AboutTryWithResources",
					"java7.AboutRequireNotNull",
					"java8.AboutDefaultMethods",
					"java8.AboutOptional",
					"java8.AboutLocalTime",
					"java8.AboutLambdas",
					"java8.AboutStreams",
					"java8.AboutMultipleInheritance",
					"java8.AboutBase64"
					);
	
	public static int compare(String first, String second) {
		for (String name : order) {
			if (name.equals(first))
				return -1;
			if (name.equals(second))
				return 1;
		}
		return 0;
	}
}
