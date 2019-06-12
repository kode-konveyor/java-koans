package main;

import java.io.PrintWriter;

public class App {
	
	public static void main(String[] args) {
		
		JUnit5TestsFromJava runner = new JUnit5TestsFromJava();
	    runner.runAll();
	 
	    TestSummaryByClass summary = runner.listener.getSummaryByClass();
	    summary.printTo(new PrintWriter(System.out));
	}

}
