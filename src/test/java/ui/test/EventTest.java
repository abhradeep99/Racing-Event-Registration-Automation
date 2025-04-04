package ui.test;

import org.testng.annotations.Test;

import com.base.Utilities;
import com.race.page.EventPage;
import com.race.page.HomePage;
import com.race.page.LoginPage;
import com.race.page.OtpVerificationPage;

public class EventTest  extends Utilities{
//	@Test
	public void verifyandOpenEventPage() {
	HomePage homePage=new HomePage( driver,  log);
	homePage.openPageUrl();
	sleeps(5000);
	EventPage eventPage=new EventPage(driver,  log);
	eventPage.verifyandOpenEventPage();
	LoginPage login = new LoginPage(driver,log);
	login.login("abhragarai@gmail.com");
	OtpVerificationPage otp =new OtpVerificationPage(driver,log);
	otp.verifyOTP();
	eventPage.validateEventPage();
	
	}
	@Test
	public void creteEvent() {
		EventPage eventPage=new EventPage(driver,  log);
		verifyandOpenEventPage();
		eventPage.click_Create_Event();
		eventPage.fill_Event_Information("cts Event", "Virtual", "2025-04-01", "2025-04-02", "WB", "NewTon",
                "Candor", "Kolkata", "WB", "722222", "India");
		eventPage.clickOnSaveButton();
		eventPage.fill_Event_Details();
		eventPage.clickOnSaveButton();
		eventPage.fill_Ticket_Details("Running","10 Kilometers","tstcsat","10","18","2025-04-04","11:59");


		
	}

	
	

}
