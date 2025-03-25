package com.race.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class  LoginPage  extends BasePageObject{
	
	private By LOGIN = By.xpath("//span[text()='Log In']");
	private By SIGNIN = By.xpath("//span[text()='Sign Up']");

	 public LoginPage(WebDriver driver, Logger log) {
			super(driver, log);
		}
	 public void verifyLoginSignUpButton() {
		 
	 }
}
