package com.softserve.edu.reg.tests;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.reg.apps.ApplicationSources;
import com.softserve.edu.reg.apps.ApplicationSourcesRepository;
import com.softserve.edu.reg.data.IUser;
import com.softserve.edu.reg.data.UserRepository;
import com.softserve.edu.reg.pages.AdminHomePage;
import com.softserve.edu.reg.pages.Application;
import com.softserve.edu.reg.pages.LoginPage;

public class LoginTest {
	private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

	@AfterClass
	public void afterClass() {
		logger.info("START - @AfterClass");
		System.out.println("@AfterClass");
		Application.remove();
		logger.info("DONE - @AfterClass");
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		logger.info("START - @AfterMethod");
		System.out.println("@AfterMethod");
		//Application.get().logout();
		Application.remove();
		logger.info("DONE - @AfterMethod");
	}

	@DataProvider //(parallel = true)
	public Object[][] adminUsers() {
		logger.info("DONE - @DataProvider");
		return new Object[][] {
			//{ ApplicationSourcesRepository.getChromeHeroku(), UserRepository.getAdmin() },
			{ ApplicationSourcesRepository.getFirefoxHeroku(), UserRepository.getAdmin() }
		};
	}

	@Test(dataProvider = "adminUsers")
	public void checkAdminLogin(ApplicationSources applicationSources, IUser admin) throws Exception {
		logger.info("START - @Test");
		// Precondition
		//
		// Steps
		LoginPage loginPage = Application.get(applicationSources).load();
		AdminHomePage adminHomePage = loginPage.successAdminLogin(admin);
		//
		// Check
		Assert.assertEquals(admin.getLogin(),
				adminHomePage.getLoginAccountText());
		//
		// Return to previous state
		Thread.sleep(2000);
		adminHomePage.clickLogout();
		Thread.sleep(2000);
		logger.info("DONE - @Test");
	}

}
