package com.softserve.edu.reg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage {

	// Fields
	
	protected WebDriver driver;
	private WebElement loginAccount;
	
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		this.loginAccount = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']"));
	}

	// PageObject

	// get Data

	public WebElement getLoginAccount() {
		return this.loginAccount;
	}

	// Functional
	
	public String getLoginAccountText() {
		return getLoginAccount().getText();
	}

	// set Data

	// TODO
	public LoginPage clickLogout() {
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
		return new LoginPage(driver);  
	}

}