package com.softserve.edu.reg.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.reg.data.IUser;

public class LoginPage extends ATopPage {
	private static final Logger logger = LoggerFactory.getLogger(ATopPage.class);
	//
	public static final String SRC_ATTRIBUTE = "src"; 
	public static final String NAME_IMAGE = "ukraine_logo2.gif";
	
	public static enum LoginPageL10n {
        LOGIN_LABEL("Логін","Логин","Login"),
        PASSWORD_LABEL("Пароль","Пароль","Password"),
		SUBMIT_BUTTON("Увійти","Войти","Sign in");
        //
        private HashMap<ChangeLanguageFields, String> field;

        private LoginPageL10n(String... localization) {
        	this.field = new HashMap<ChangeLanguageFields, String>();
        	int i = 0;
        	for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
        		this.field.put(language, localization[i]);
        		i++;
        	}
        }

        public String getLocalization(ChangeLanguageFields language) {
            return this.field.get(language).trim();
        }
    }

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields
	
    private WebElement loginLabel;
    private WebElement loginInput;
    private WebElement passwordLabel;
    private WebElement passwordInput;
    private WebElement signin;
    private WebElement logo;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.loginLabel = driver.findElement(By.xpath("//label[contains(@for,'inputEmail')]"));
		this.loginInput = driver.findElement(By.id("login"));
		this.passwordLabel = driver.findElement(By.xpath("//label[contains(@for,'inputPassword')]"));
		this.passwordInput = driver.findElement(By.id("password"));
		this.signin = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		this.logo = driver.findElement(By.cssSelector("img.login_logo.col-md-8.col-xs-12"));
	}

    // PageObject

	// get Data

	public WebElement getLoginLabel() {
		return this.loginLabel;
	}

	public WebElement getLoginInput() {
		return this.loginInput;
	}

	public WebElement getPasswordLabel() {
		return this.passwordLabel;
	}

	public WebElement getPasswordInput() {
		return this.passwordInput;
	}

	public WebElement getSignin() {
		return this.signin;
	}

	public WebElement getLogo() {
		return this.logo;
	}

	// Functional
	
	public String getLoginLabelText() {
		return getLoginLabel().getText().trim();
	}

	public String getLoginInputText() {
		return getLoginInput().getText();
	}

	public String getPasswordLabelText() {
		return getPasswordLabel().getText().trim();
	}

	public String getPasswordInputText() {
		return getPasswordInput().getText();
	}

	public String getSignintText() {
		return getSignin().getText().trim();
	}
	
	public String getLogoAttributeText(String attribute) {
		return getLogo().getAttribute(attribute).trim();
	}

	public String getLogoAttributeSrcText() {
		return getLogoAttributeText(SRC_ATTRIBUTE);
	}

	// set Data

	public void setLoginInput(String login) {
		getLoginInput().sendKeys(login);
	}

	public void setLoginInputClear(String login) {
		clearLoginInput();
		setLoginInput(login);
	}

	public void setPasswordInput(String password) {
		getPasswordInput().sendKeys(password);
	}

	public void setPasswordInputClear(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	public void clearLoginInput() {
		getLoginInput().clear();
	}

	public void clearPasswordInput() {
		getPasswordInput().clear();
	}

	public void clickLogin() {
		getLoginInput().click();
	}

	public void clickPassword() {
		getPasswordInput().click();
	}

	public void clickSignin() {
		getSignin().click();
	}

    // Business Logic

    public LoginPage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new LoginPage(driver);
    }

    // TODO Develop User class
    private void setLoginData(IUser user) {
    	logger.trace("START - private void setLoginData(IUser user)");
    //private void setLoginData(String login, String password) {
		setLoginInputClear(user.getLogin());
    	logger.trace("AFTER - setLoginInputClear(user.getLogin())");
		setPasswordInputClear(user.getPassword());
    	logger.trace("AFTER - setPasswordInputClear(user.getPassword())");
		//setLoginInputClear(login);
		//setPasswordInputClear(password);
		clickSignin();
    	logger.trace("DONE - private void setLoginData(IUser user)");
	}

//    public HomePage successUserLogin(IUser user) {
//        setLoginData(user);
//        // Return a new page object representing the destination.
//        return new HomePage();
//    }

    public AdminHomePage successAdminLogin(IUser admin) {
    	logger.debug("START - public AdminHomePage successAdminLogin(IUser admin)");
    //public AdminHomePage successAdminLogin(String login, String password) {
		setLoginData(admin);
		//setLoginData(login, password);
		// Return a new page object representing the destination.
    	logger.debug("DONE - public AdminHomePage successAdminLogin(IUser admin)");
		return new AdminHomePage(driver);
	}

//	public RegistratorHomePage successRegistratorLogin(IUser registrator) {
//		setLoginData(registrator);
//		// Return a new page object representing the destination.
//		return new RegistratorHomePage();
//	}
//
    // TODO Develop User class
    public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
	//public LoginValidatorPage unsuccessfulLogin(String login, String password) {
    	setLoginData(invalidUser);
		//setLoginData(login, password);
		return new LoginValidatorPage(driver); // return this;
	}

}