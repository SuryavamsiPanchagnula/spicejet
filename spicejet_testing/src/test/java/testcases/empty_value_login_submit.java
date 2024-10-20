package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basepage;
import pages.login;
public class empty_value_login_submit extends basepage {
	
	@BeforeTest 
	public void testDetails() {
		
		testName ="empty credentials login";
		testDescription = "Verify, if user is getting error in directly submitting without credentials";
		testAuthor ="Suryavamsi";
		
	}
	
	@Test
	public void direct_submit() throws IOException {
		
		login direct_submit = new login();
		direct_submit.directsubmit();
		Assert.assertEquals(direct_submit.loginerror2(),"Please enter a valid mobile number");
		takeScreenshot("direct_submit");
		if(direct_submit.loginerror2().contains("Please enter a valid mobile number")) {
			test.pass("direct login submit condition is passed");
		}
		else {
			test.fail("direct login submit condition is failed");
		}
		
	}

}
