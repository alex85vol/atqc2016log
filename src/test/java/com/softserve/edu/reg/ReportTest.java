package com.softserve.edu.reg;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ReportTest {
	//ublic Calendar c;

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("CalcTest @Before setUp()");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("CalcTest @After tearDown()");
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>@AfterMethod Non Conditional.</FONT><BR>", true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 3</FONT><BR>", 3, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 5</FONT><BR>", 5);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 7</FONT><BR>", 7, true);
	}

	@Test
	public void testApp() {
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>Non Conditional.</FONT><BR>", true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 3</FONT><BR>", 3, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 5</FONT><BR>", 5);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 7</FONT><BR>", 7, true);
		System.out.println("Running . . .");
		// ReporterWrapper.get().debug("DEBUG - messages");
		// ReporterWrapper.get().info("INFO - messages");
		// ReporterWrapper.get().warning("WARNING - messages");
		// ReporterWrapper.get().error("ERROR - messages");
		Assert.assertTrue(true);
	}

}
