package testcases;

import pages.login;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basepage;
public class invalid_login extends basepage {
	
	@BeforeTest
	public void testDetails() {
		
		
		testName = "invalid credentials";
		testDescription ="Verify, if the user is getting error by using invalid credentials";
		testAuthor = "Suryavamsi Panchagnula";
		
	}
	
	@Test
	public void Invalid_login() throws Exception {
		
		login login = new login();
		login.invalid();
		Assert.assertEquals(login.loginerror(),"Please enter a valid email address");
		takeScreenshot("invalid_login");
		if (login.loginerror().contains("Please enter a valid email address")) {
			test.pass("Login with invalid details test passed");
		} else
			test.fail("Login with invalid details failed");	
	}
	

}
