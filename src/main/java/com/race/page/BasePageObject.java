package com.race.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class BasePageObject extends BaseClass{
	protected WebDriver driver;
	protected Logger log;

	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}
	
	protected void openUrl(String url) {
		driver.get(url);
	}
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	protected boolean isElementPresent(By by) {
	        try {
	            WebElement element = find(by);
	            return element.isDisplayed(); 
	        } catch (NoSuchElementException e) {
	            return false;  
	        }
	    }
//	protected void clickOnElement(By locator) {
//				  try {
//					  find(locator).click();
//					  System.out.println("Successfully clicked Element ");
//	        } catch (NoSuchElementException e) {
//	            System.out.println("Unable to find Clickable Element ");
//	        }
//	    }
	


}
