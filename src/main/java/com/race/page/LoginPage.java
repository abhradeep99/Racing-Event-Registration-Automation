package com.race.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class  LoginPage  extends BasePageObject{
	
	private By LOGIN = By.xpath("//span[text()='Log In']");
	private By SIGNIN = By.xpath("//span[text()='Sign Up']");
	
	 public LoginPage(WebDriver driver, Logger log) {
			super(driver, log);
		}
	 public void verifyLoginSignUpButton() {		
		 isElementPresent(LOGIN);
		 Assert.assertTrue( isElementPresent(LOGIN), "Login Button Is Present in HomePage");
		 isElementPresent(SIGNIN);
		 Assert.assertTrue( isElementPresent(LOGIN), "SIGNIN Button Is Present in HomePage");	 
	 }
	 public void clickOnSignUpButton() {
		 verifyLoginSignUpButton();
		 clickOnElement(SIGNIN);
	 }
	
}
