package com.race.page;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OtpVerificationPage extends BasePageObject {

	 public OtpVerificationPage(WebDriver driver, Logger log) {
			super(driver, log);
		}	  

		private By OTP_BUTTON = By.xpath("//span[text()='Get OTP']");
		private By OTP_PAGE = By.xpath("//*[contains(text(), concat(\"Let\", \"'\", \"s Verify\"))]");
		private By OTP_VERIFY_BUTTON = By.xpath("//span[text()='Verify']");

		public  void verifyOTP() {  
			waitForVisibilityOf(OTP_BUTTON);
		    clickOnElement(OTP_BUTTON);
		    waitForVisibilityOf(OTP_PAGE, 10);
		    Assert.assertTrue(isElementPresent(OTP_PAGE), "OTP Verification Page is opened successfully");
			log.info("OTP Verification Page is  opened ");
			enterOTP("1234");
			waitForVisibilityOf(OTP_VERIFY_BUTTON, 10);
			clickOnElement(OTP_VERIFY_BUTTON);
			
		}
		public void enterOTP(String otpValues) {
	        for (int i = 0; i < 4; i++) {
	         //   WebElement otpBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otp" + i)));
	        //	WebElement otp= id("otp" + i);
	        	 By otp = By.id("otp" + i);
	            waitForVisibilityOf(otp, 5);
	            enterText(Character.toString(otpValues.charAt(i)), otp, 2);
	   
	        }
	    }
	

}