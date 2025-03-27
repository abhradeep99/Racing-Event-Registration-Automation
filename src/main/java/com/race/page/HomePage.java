package com.race.page;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePageObject {

	 public HomePage(WebDriver driver, Logger log) {
			super(driver, log);
		}
	  
		private String pageUrl = "https://ir-staging.bombayrunning.com/";

		private By logo = By.xpath("//img[@alt='IR-logo']");


		public void openPageUrl() {
			log.info("Opening page : " + pageUrl);
			openUrl(pageUrl);
			Assert.assertEquals(driver.getCurrentUrl(), pageUrl);
			log.info("Page opened "+ pageUrl);
		
		}
		public void VerifyHomePage() {  
			//find(logo);
			log.info("Page opened "+ isElementPresent(logo));
		}

}
