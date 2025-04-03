package com.race.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePageObject {

	private By LOGIN = By.xpath("//span[text()='Log In']");
	private By SIGNIN = By.xpath("//span[text()='Sign Up']");
	private By MOBILENUMBERINPUTFIELD = By.xpath("//input[@placeholder=\"Mobile number\"]");
	private By EMAILINPUTFIELD = By.xpath("input[@id='email']");
	private By LOGOUT = By.xpath("//*[text()='Logout']");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void verifyLoginSignUpButton() {
		waitForVisibilityOf(LOGIN, 5);
		Assert.assertTrue(isElementPresent(LOGIN), "Login Button Is Present in HomePage");
		waitForVisibilityOf(SIGNIN, 5);
		Assert.assertTrue(isElementPresent(LOGIN), "SIGNIN Button Is Present in HomePage");
	}
	public void verifyUserProfile() {
		waitForVisibilityOf(LOGOUT, 10);
		Assert.assertTrue(isElementPresent(LOGOUT), "LOGOUT Button Is Present in ProfilePage");
		log.info("Profile page is oppened");
	}

	public void clickOnSignUpButton() {
		verifyLoginSignUpButton();
		clickOnElement(SIGNIN);

	}

	public void login(String userid) {
		log.info("Executing Negative LogIn with username " + userid);
		if (isValidEmail(userid)) {
			enterText(userid, EMAILINPUTFIELD, 5);
		} else if (isValidMobile(userid)) {
			enterText(userid, MOBILENUMBERINPUTFIELD, 5);
		} else {
			log.info("Invalid Email or Mobile Number");
		}

	}

	private boolean isValidEmail(String email) {
		return email.contains("@") && email.contains(".");
	}

	private boolean isValidMobile(String mobile) {
		if (mobile.length() == 10)
			return true;
		else
			return false;
	}
	
	
}
