package main;

import java.io.PrintWriter;

public class App {
	
	public static void main(String[] args) {
		TestSummaryListener listener = new TestSummaryListener();
		JUnit5TestsFromJava runner = new JUnit5TestsFromJava(listener);
	    runner.runAll();
	 
	    TestSummaryByClass summary = listener.getSummaryByClass();
	    summary.printTo(new PrintWriter(System.out));
	}

}
