package ui.test;

import org.testng.annotations.Test;

import com.base.Utilities;
import com.race.page.HomePage;
import com.race.page.JoinVibrantCommunityPage;
import com.race.page.LoginPage;
import com.race.page.OtpVerificationPage;

public class LoginTest extends Utilities{
	@Test
	public void verifyLoginSignUpButton() {
		System.out.println("Login Test ");
		HomePage homePage=new HomePage( driver,  log);
		homePage.openPageUrl();
		LoginPage Login = new LoginPage(driver,log);
		Login.verifyLoginSignUpButton();
	}
	@Test
	public void ClickOnSignUpButton() {
		System.out.println("Login Test ");
		HomePage homePage=new HomePage( driver,  log);
		homePage.openPageUrl();
		LoginPage Login = new LoginPage(driver,log);
		Login.verifyLoginSignUpButton();
		Login.clickOnSignUpButton();
		sleeps(5000);
		JoinVibrantCommunityPage joinUs =new JoinVibrantCommunityPage(driver,log);
		joinUs.verifyJoinVibrantCommunityPage();
	}
	@Test
	public void loginWithMobileNo() {
		LoginPage Login = new LoginPage(driver,log);
		ClickOnSignUpButton();
		Login.login("9647201667");
		OtpVerificationPage otp =new OtpVerificationPage(driver,log);
		otp.verifyOTP();
		Login.verifyUserProfile();
		sleeps(5000);
		
	}

}
