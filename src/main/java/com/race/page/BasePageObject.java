package com.race.page;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class BasePageObject extends BaseClass {
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
		try {
			WebElement element = driver.findElement(locator);
			System.out.println("Element found: " + locator.toString());
			return element;
		} catch (NoSuchElementException e) {
			System.out.println("Element not found in DOM: " + locator.toString());
			throw e;
		}
	}

	protected boolean isElementPresent(By locator) {
		try {
			WebElement element = find(locator);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element is NOT present in DOM: " + locator.toString());
			return false;
		}
	}

	protected void enterText(String text, By locator, Integer sec) {
		waitForVisibilityOf(locator, sec);
		find(locator).sendKeys(text);
		System.out.println("Successfully Entered Text "+text);
	}

	protected void clickOnElement(By locator) {
		try {
			find(locator).click();
			System.out.println("Successfully clicked Element ");
		} catch (NoSuchElementException e) {
			System.out.println("Unable to find Clickable Element ");
		}
	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(condition);
	}

	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 3) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	public void scrollToBottom() {
		log.info("Scrolling to the bottom of the page");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void setDate(By locator, String date) {
		enterText(date, locator, 10);
	}
	
	public void selectByValue(By locator, String value) {
		boolean flag = false;
		try {
			Select s = new Select(find(locator));
			s.selectByValue(value);
			flag = true;
			
		} catch (Exception e) {

		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}
	
	public void scrollToElementUsingActions(By element) {    
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0].getBoundingClientRect().top - 100);", element);
        System.out.println("Scrolled to element using offset: " + element);

}

}
