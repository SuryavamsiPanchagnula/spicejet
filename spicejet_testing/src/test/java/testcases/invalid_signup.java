package testcases;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basepage;
import pages.signup;

public class invalid_signup extends basepage {
	
	@BeforeTest
	public void testDetails() {
		
		testName = "invalid signup";
		testDescription = "Verify whether user is getting error on invalid signup";
		testAuthor ="Suryavamsi";
	}
	@Test
	public void Invalid_signup() {
		
		signup signup_page=new signup();
		signup_page.invalid_signup();
		Assert.assertEquals(signup_page.signuperror(),"Please fill all mandatory fields marked with an '*' to proceed");
		if(signup_page.signuperror().contains("Please fill all mandatory fields marked with an '*' to proceed")) {
		test.pass("Invalid signup is working where user is unable to signup and the test is passed");
	}
		else {
			test.fail("Invalid is not working and the test is not passed");
		}
	}
}
