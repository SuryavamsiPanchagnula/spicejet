 package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.basepage;
public class signup extends basepage {

	@FindBy(xpath="//div[contains(text(),'Signup')]") private WebElement Signuplink;
	
	@FindBy(xpath="//select[@class='form-control form-select ']") private WebElement title;
	
	@FindBy(id="first_name") private WebElement firstname;
	
	@FindBy(id="last_name") private WebElement lastname;
	
	@FindBy(xpath ="//div[@class='col-sm-6 mt-30 px-sm-4']//select[@class='form-control form-select']") 
	private WebElement select_country;
	
	@FindBy(xpath ="//img[@alt='date']") private WebElement calendar;
	
	@FindBy(xpath ="//select[@class='react-datepicker__month-select']") private WebElement month;
	
	@FindBy(xpath = "//select[@class='react-datepicker__year-select']") private WebElement year;
	
	@FindBy(xpath="//div[@class='react-datepicker__week']//div[@class='react-datepicker__day react-datepicker__day--009 react-datepicker__day--weekend']")
	private WebElement date;
	
	@FindBy(xpath ="//input[@type='tel']") private WebElement phone;
	
	@FindBy(xpath ="//input[@id='email_id']") private WebElement email;
	
	@FindBy(id="new-password") private WebElement password;
	
	@FindBy(id ="c-password") private WebElement confirmpassword;
	
	@FindBy(id= "defaultCheck1") private WebElement agree;
	
	@FindBy(xpath ="//button[contains(text(),\"Submit\")]") private WebElement submit;
	
	@FindBy(xpath ="//label[contains(text(),'OTP Verification')]") 
	private WebElement confirmationtext;
	
	@FindBy(xpath ="//div[contains(text(),\"Please fill all mandatory fields marked with an '*' to proceed\")]") private WebElement error;
	
	
	public String confirmationtext() {
		return confirmationtext.getText();
	}
	
	public String signuperror() {
		return error.getText();
	}
	
	public void valid_signup() throws InterruptedException {
		Signuplink.click();
		switchtochildwindow();
		wait(title);
		selectFromDropdown(title, "Mr");
		firstname.sendKeys("Suryavamsi");
		Thread.sleep(10000);
		elementvisiblitywait(lastname);
		lastname.sendKeys("Panchagnula");
		scroll();
		Thread.sleep(2000);
		calendar.click();
		selectFromDropdown(month, "July");
		selectFromDropdown(year, "2000");
		date.click();
		phone.sendKeys("9100121712");
		implicitWait();
		elementvisiblitywait(email);
		email.sendKeys("psuryavamsi89@gmail.com");
		Thread.sleep(2000);
		wait(password);
		password.sendKeys("Test@123");
		confirmpassword.sendKeys("Test@123");
		agree.click();
		wait(submit);
		submit.click();
		Thread.sleep(2000);
	}
	
	public void invalid_signup() {
		
		Signuplink.click();
		scrollToElement(agree);
		System.out.println("agree");
		wait(agree);
		agree.click();
		wait(submit);
		submit.click();
	}
	public signup(){
		PageFactory.initElements(driver, this);
	}
}
