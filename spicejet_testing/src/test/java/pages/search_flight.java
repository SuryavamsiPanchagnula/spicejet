package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.basepage;

public class search_flight extends basepage {
	
	@FindBy(xpath ="//div[contains(text(),'check-in')]") private WebElement checkin;
	
	@FindBy(xpath ="//div[contains(text(),'flight status')]") private WebElement flight_status;
	
	@FindBy(xpath ="//div[@data-testid='manage booking-horizontal-nav-tabs']") private WebElement manage_booking;
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement from_city;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement to_city;
	
	@FindBy(xpath ="//div[@data-testid='one-way-radio-button']")
	private WebElement oneway_trip;
	
	@FindBy(xpath ="//div[@data-testid='round-trip-radio-button']")
	private WebElement round_trip;
	
	@FindBy(xpath ="//div[contains(text(),'Departure Date')]")
	private WebElement departure;
	
	@FindBy(xpath = "//div[@data-testid='undefined-month-November-2024']//div[@data-testid='undefined-calendar-day-17']")
	private WebElement departure_date;
	
	@FindBy(xpath="//div[contains(text(),'Return Date')]")
	private WebElement returnback;
	
	@FindBy(xpath ="//div[@data-testid='undefined-month-November-2024']//div[@data-testid='undefined-calendar-day-29']")
	private WebElement return_date;
	
	@FindBy(xpath ="//div[@data-testid='home-page-flight-cta']")
	private WebElement search_flight;
	
	@FindBy(xpath = "(//span[@class='css-76zvg2 css-16my406 r-homxoj r-1s6pnzw'])[1]")
	private WebElement searchResultText;

	@FindBy(xpath = "(//div[contains(.,'Round Trip')])[9]")
	private WebElement searchResultRoundTripText;

	@FindBy(xpath = "//div[text()='Please select a date for the return trip']")
	private WebElement roundTripTextErrorText;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-1qxgc49']")
	private WebElement formElement;

	@FindBy(xpath = "//div[contains(text(),'Please select a date for the return trip']")
	private WebElement errorText;
	
	@FindBy(xpath ="//div[@data-testid='undefined-month-November-2024']")
	private WebElement calendar;
	
	@FindBy(xpath="//div[contains(text(),'Welcome aboard')]")
	private WebElement welcome;
	
	public search_flight() {
		PageFactory.initElements(driver, this);
	}


	public String managebookingtext() {
		return manage_booking.getText();
	}
	
	public String flight_status() {
		return flight_status.getText();
	}
	
	public String checkin() {
		return checkin.getText();
	}

	public String onewaytripText() {
		return searchResultText.getText();
	}

	public String triperrorText() {
		return errorText.getText();
	}
	
	public String roundtripText() {
		return searchResultRoundTripText.getText();
	}
	
	public void checkNavigationTabs() {
		String checkinText = checkin.getText();
		Assert.assertEquals(checkinText, "Check-In");
		String flightstatustext = flight_status.getText();
		Assert.assertEquals(flightstatustext, "Flight Status");
		String managebookingtext = manage_booking.getText();
		Assert.assertEquals(managebookingtext, "Manage Booking");
	}
	
	public void oneway_booking()  {
		
		oneway_trip.click();
		from_city.sendKeys("DEL");
		to_city.clear();
		to_city.sendKeys("BOM");
		departure_date.click();
		implicitWait();
		search_flight.click();
		wait(searchResultText);
	}
	
	public void round_trip_booking() throws InterruptedException {
		
		round_trip.click();
		from_city.sendKeys("DEL");
		to_city.clear();
		to_city.sendKeys("BOM");
		departure_date.click();
		implicitWait();
		returnback.click();
		return_date.click();
		implicitWait();
		search_flight.click();
		wait(searchResultText);
	}
	
	public void invalid_booking() throws InterruptedException {
		
		round_trip.click();
		Thread.sleep(10000);
		from_city.sendKeys("HYD");
		mouse_click();
		wait(search_flight);
		search_flight.click();
		
	}
	
	public void mouse_click() {
		
	  welcome.click();
	}
	
	
	
	
}
