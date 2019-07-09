package main;

import static org.junit.platform.engine.discovery.DiscoverySelectors.*;


import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;



public class JUnit5TestsFromJava {
	
	    private SummaryGeneratingListener listener;
	    
	    public JUnit5TestsFromJava(SummaryGeneratingListener listener) {
	    	this.listener = listener;
	    }
	 
	    public void runAll() {
	        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
	          .selectors(
	        		  selectPackage("beginner"),
	        		  selectPackage("intermediate"),
	        		  selectPackage("advanced"),
	        		  selectPackage("java7"),
	        		  selectPackage("java8"))
	          .build();
	        Launcher launcher = LauncherFactory.create();
	        launcher.discover(request);
	        launcher.registerTestExecutionListeners(listener);
	        launcher.execute(request);
	    }
}
