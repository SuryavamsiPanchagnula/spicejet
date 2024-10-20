package testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basepage;
import pages.login;

public class logintest extends basepage{
	
	@BeforeTest 
	public void testDetails() {
		
		testName ="login";
		testDescription = "Verify, if user is able to registered user is able to login or not";
		testAuthor ="Suryavamsi";
		
	}
	
	@Test
	public void LoginTest() throws Exception {
		login login = new login();
		login.logintest();
		Assert.assertEquals(login.logintext(), "Hi Suryavamsi");
		takeScreenshot("LoginTest");
		if (login.logintext().contains(testAuthor)) {
			test.pass("Login test passed");
		} else
			test.fail("Login test failed");
	}
	
	
	
	

}