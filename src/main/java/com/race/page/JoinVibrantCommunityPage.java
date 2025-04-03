package com.race.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JoinVibrantCommunityPage extends BasePageObject{
	 public JoinVibrantCommunityPage(WebDriver driver, Logger log) {
			super(driver, log);
		}

		private By VIBRANTCOMMUNITYPAGE = By.xpath("//*[text()='Join a vibrant']");
		private By MOBILENUMBERINPUTFIELD = By.xpath("//input[@placeholder=\"Mobile number\"]");

		public void verifyJoinVibrantCommunityPage() {
			waitForVisibilityOf(VIBRANTCOMMUNITYPAGE, 10);
			Assert.assertTrue(isElementPresent(VIBRANTCOMMUNITYPAGE), "Join a vibrant\r\n"
					+ "Community! ");
			waitForVisibilityOf(MOBILENUMBERINPUTFIELD, 10);
			Assert.assertTrue(isElementPresent(MOBILENUMBERINPUTFIELD), "Mobile Number Input Field Is Present");
		}

}
