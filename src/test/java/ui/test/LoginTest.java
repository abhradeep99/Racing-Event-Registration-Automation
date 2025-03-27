package ui.test;

import org.testng.annotations.Test;

import com.base.Utilities;
import com.race.page.HomePage;
import com.race.page.JoinVibrantCommunityPage;
import com.race.page.LoginPage;

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
		JoinVibrantCommunityPage joinUs =new JoinVibrantCommunityPage(driver,log);
		joinUs.verifyJoinVibrantCommunityPage();
	}

}
