package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.basepage;

public class login extends basepage{
	
	@FindBy(xpath="//div[contains(text(),'Login')]") private WebElement loginlink;
	
	@FindBy(xpath ="//div[contains(text(),'Email')]") private WebElement EmailToggle;
	
	@FindBy(xpath="//input[@data-testid='user-mobileno-input-box']") private WebElement enteremail;
	
	@FindBy(xpath ="//input[@data-testid='password-input-box-cta']") private WebElement enterpassword;
	
	@FindBy(xpath ="//div[@data-testid='login-cta']") private WebElement loginbutton;
	
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid email address')]") private WebElement loginerrortext;
	
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid mobile number')]") private WebElement loginerror;
	
	@FindBy(xpath ="//div[contains(text(),'Hi Suryavamsi')]") private WebElement loginname;
	
	public void logintest() throws Exception {
		wait(loginlink);
		loginlink.click();
		EmailToggle.click();
		enteremail.sendKeys(readProperty("email"));
		enterpassword.sendKeys(readProperty("password"));
		loginbutton.click();
		wait(loginname);
	}
	
	public void invalid() throws Exception {
		wait(loginlink);
		loginlink.click();
		wait(EmailToggle);
		EmailToggle.click();
		enterpassword.sendKeys(readProperty("password"));
		loginbutton.click();
	}
	
	public void directsubmit() {
		wait(loginlink);
		loginlink.click();
		loginbutton.click();
	}
	
	public String logintext() {
		return loginname.getText();
	}
	
	public String loginerror() {
		return loginerrortext.getText();
	}
	
	public String loginerror2() {
		return loginerror.getText();
	}
	
	public login(){
		PageFactory.initElements(driver, this);
	}

}
