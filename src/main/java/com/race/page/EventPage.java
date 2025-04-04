package com.race.page;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EventPage extends BasePageObject {

	public EventPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private By CREATE_EVENT_BTN = By.xpath("//*[contains(text(),'Create Event')]");
	private By MY_EVENT_HEADER = By.xpath("//*[text()=\"My Events\"]");

	private By EVENT_NAME_INPUT = By.xpath("//input[@id='Event Name_text']");

	private By EVENT_TYPE_RADIO_ONGROUND = By.xpath("//input[@id='On-Ground']");
	private By EVENT_TYPE_RADIO_VIRTUAL = By.xpath("//label[@for='Virtual']");
	private By EVENT_TYPE_RADIO_ONGROUND_VIRTUAL = By.xpath("//input[@id='On-Ground+Virtual']");

	private By START_DATE_INPUT = By.xpath("//input[@id='event_start_date']");
	private By END_DATE_INPUT = By.xpath("//input[@id='event_end_date']");

	private By SAVE_BUTTON = By.xpath("//*[text()=\"Save and Proceed\"]");
	private By LOCATION_FIELD = By.xpath("//input[@placeholder='Search location here']");
	private By ADDRESS_FIELD = By.xpath("//input[@id='Address_text']");
	private By AREA_FIELD = By.xpath("//input[@id='Area_text']");
	private By CITY_FIELD = By.xpath("//input[@id='City_text']");
	private By STATE = By.xpath("//input[@id='State_text']");
	private By PINCODE = By.xpath("//input[@id='PinCode']");
	private By COUNTRY_FIELD = By.xpath("//select[@id='country']");

	private By RUNNING_ACTIVITY = By.xpath("//input[@id='Running']");
	private By CYCLING_ACTIVITY = By.xpath("//input[@id='Cycling']");
	private By DISTANCE_DROPDOWN = By.xpath("//select[contains(@id, 'distance')]");
	private By CATEGORY = By.xpath("//input[contains(@id, 'Name of the Category_text')]");
	private By PRICE_INPUT = By.xpath("//input[contains(@id, 'Base Price')]");
	private By MIN_AGE = By.xpath("//input[contains(@id, 'Age Limit for Registration')]");
	private By Reg_STRT_Date = By.xpath("//*[contains(@id, 'reg_start_date')]");
	private By REG_TIME = By.xpath("//*[contains(@name, 'reg_start_time')]");
	
	public void verifyandOpenEventPage() {
		clickOnElement(CREATE_EVENT_BTN);

	}

	public void validateEventPage() {
		waitForVisibilityOf(MY_EVENT_HEADER, 10);
		Assert.assertTrue(isElementPresent(MY_EVENT_HEADER), "Event Page is loaded");
	}

	public void click_Create_Event() {
		scrollToBottom();
		waitForVisibilityOf(CREATE_EVENT_BTN, 10);
		clickOnElement(CREATE_EVENT_BTN);
		log.info("Clicked on 'Create Event' button");
	}

	public void fill_Event_Information(String eventName, String eventType, String startDate, String endDate,
			String location, String address, String area, String city, String state, String pincode, String country) {
		enterText(eventName, EVENT_NAME_INPUT, 10);

		switch (eventType) {
		case "On-Ground":
			clickOnElement(EVENT_TYPE_RADIO_ONGROUND);
			setDate(START_DATE_INPUT, startDate);
			setDate(END_DATE_INPUT, endDate);
			fillDetailsForOnGround(location, address, area, city, state, pincode, country);
			break;
		case "Virtual":
			clickOnElement(EVENT_TYPE_RADIO_VIRTUAL);
			setDate(START_DATE_INPUT, startDate);
			setDate(END_DATE_INPUT, endDate);
			break;
		case "On-Ground+Virtual":
			clickOnElement(EVENT_TYPE_RADIO_ONGROUND_VIRTUAL);
			setDate(START_DATE_INPUT, startDate);
			setDate(END_DATE_INPUT, endDate);
			fillDetailsForOnGround(location, address, area, city, state, pincode, country);
			break;
		default:
			log.info("Invalid event type: " + eventType);

		}

	}

	public void fillDetailsForOnGround(String location, String address, String area, String city, String state,
			String pincode, String country) {
		enterText(location, LOCATION_FIELD, 10);
		enterText(address, ADDRESS_FIELD, 10);
		enterText(area, AREA_FIELD, 10);
		enterText(city, CITY_FIELD, 10);
		enterText(state, STATE, 10);
		enterText(pincode, PINCODE, 10);
		enterText(country, COUNTRY_FIELD, 10);
	}

	public void clickOnSaveButton() {
		scrollToBottom();
		scrollToElementUsingActions(SAVE_BUTTON);
		clickOnElement(SAVE_BUTTON);
	}

	public void fill_Event_Details() {

	}

	public void fill_Ticket_Details(String activityType, String km, String category, String ticketPrice, String minAge, String regStrtDate, String regtime) {
		if (activityType.contains("Running"))
			clickOnElement(RUNNING_ACTIVITY);
		else if (activityType.contains("Cycling"))
			clickOnElement(CYCLING_ACTIVITY);
		else
			log.info("Enter Vllid Activity Type");

		selectByValue(DISTANCE_DROPDOWN, km);//
		enterText(category, CATEGORY, 10);
		enterText(ticketPrice, PRICE_INPUT, 10);
		enterText(minAge, MIN_AGE, 10);
		setDate(Reg_STRT_Date, regStrtDate);
		setDate(REG_TIME, regtime);
		
		
		
	}
}
