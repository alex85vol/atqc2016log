package com.softserve.edu.reg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	@Test
	public void testApp() {
		System.out.println("\nsurefire.reports.directory = " + System.getProperty("surefire.reports.directory"));
		System.out.println("\nselenium-version = " + System.getProperty("selenium-version"));
		//
		long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("\nUsed Memory = " + usedMemory / (1024.0 * 1024.0) + "Mb");
		System.out.println("\nTotal Amount of Memory = " + Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0) + "Mb");
		System.out.println("\nMaximum Amount of Memory = " + Runtime.getRuntime().maxMemory() / (1024.0 * 1024.0) + "Mb");
		Assert.assertTrue(true);
	}

}
