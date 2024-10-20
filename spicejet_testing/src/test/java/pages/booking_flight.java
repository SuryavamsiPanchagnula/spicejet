package pages;
import base.basepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class booking_flight extends basepage{
	
	@FindBy(xpath = "//div[@data-testid='title-contact-detail-card']")
	private WebElement title;
	
	@FindBy(xpath = "//div[contains(text(),'Mr')]")
	private WebElement titleSelect;
	
	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	private WebElement lastname;

	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	private WebElement phone;

	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	private WebElement email;

	@FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
	private WebElement city;
	
	@FindBy(xpath = "//div[contains(text(),'I am flying as the primary passenger')]")
	private WebElement primary_passenger_agree;
	
	@FindBy(xpath= "//div[@data-testid='continue-search-page-cta']")
	private WebElement continue_booking;
	
	@FindBy(xpath ="//div[@data-testid='traveller-info-continue-cta']")
	private WebElement redirect_to_pay;
	
	@FindBy(xpath = "//div[contains(text(),'Continue')]")
	private WebElement Confirm_Pay;
	
	@FindBy(xpath ="//div[@data-testid='common-proceed-to-pay']")
	private WebElement proceed_to_pay;
	
	@FindBy(id="card_number")
	private WebElement Card_Number;
	
	@FindBy(id="name_on_card")
	private WebElement Card_Name;
	
	@FindBy(id="card_exp_month")
	private WebElement Expiry_month;
	
	@FindBy(id ="card_exp_year")
	private WebElement Expiry_year;
	
	@FindBy(id ="security_code")
	private WebElement CVV;
	
	@FindBy(id="payment_form_card_number_error")
	private WebElement card_error;
	
	@FindBy(id = "at_addon_close_icon")
	private WebElement closebutton;
	
	public String paymenterrorText() {
		return card_error.getText();
	}
	
	public void book_flight() {
		
	    elementvisiblitywait(continue_booking);
	    wait(continue_booking);
		continue_booking.click();
		wait(title);
		title.click();
		titleSelect.click();
		firstname.sendKeys("Suryavamsi");
		lastname.sendKeys("Panchagnula");
		phone.sendKeys("8206492745");
		email.sendKeys("test55@gmail.com");
		city.sendKeys("Visakhapatnam");
		primary_passenger_agree.click();
		wait(redirect_to_pay);
		redirect_to_pay.click();
		clickRedirectToPay();
		System.out.println("Passenger details completed");
		Card_Number.sendKeys("0001 0001 0001 0001");
		Card_Name.sendKeys("Testing");
		Expiry_year.sendKeys("2034");
		Expiry_month.sendKeys("10");
		CVV.sendKeys("122");
		proceed_to_pay.click();
	}
	
	public booking_flight() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickRedirectToPay() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    int attempts = 0;

	    while (attempts < 3) {  
	        try {
	            
	            WebElement redirectToPayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='traveller-info-continue-cta']")));
	            redirectToPayElement.click();  
	            break;
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Caught StaleElementReferenceException, retrying... Attempt: " + (attempts + 1));
	            attempts++;
	        }
	    }

	    if (attempts == 3) {
	        throw new RuntimeException("Failed to interact with the 'redirect_to_pay' element after multiple attempts due to StaleElementReferenceException.");
	    }
	}
	
}
