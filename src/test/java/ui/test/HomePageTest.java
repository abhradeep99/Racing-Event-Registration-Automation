package ui.test;



import org.testng.annotations.Test;

import com.base.Utilities;
import com.race.page.HomePage;


public class HomePageTest extends Utilities{
//	Logger log;
//	private HomePage homePage;
//	public void initializePageOpjects() {
//		HomePage homePage=new HomePage( driver,  log);
//	}
	@Test
	public void verifyHomePageUrl() {
		HomePage homePage=new HomePage( driver,  log);
		homePage.openPageUrl();
		sleeps(5000);
	}
	@Test
	public void verifyHomePage() {
	//	initializePageOpjects();
		HomePage homePage=new HomePage( driver,  log);
		homePage.openPageUrl();
		sleeps(5000);
		homePage.VerifyHomePage();
	}
	
	


}
