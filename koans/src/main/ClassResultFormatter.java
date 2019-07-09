package main;

import java.util.Set;

public interface ClassResultFormatter {

	String format(String className, Set<String> passed, Set<String> failed);

}
