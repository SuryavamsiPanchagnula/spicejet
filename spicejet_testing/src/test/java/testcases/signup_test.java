package testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basepage;
import pages.signup;

public class signup_test extends basepage {

	@BeforeTest
	public void testDetails() {
		
		testName="signup test";
		testDescription="Verify, whether a new user is able to signup or not";
		testAuthor = "Suryavamsi";
	}
	
	@Test
	public void signup() throws IOException, InterruptedException {
		
		signup new_signup = new signup();
		new_signup.valid_signup();
		Assert.assertEquals(new_signup.confirmationtext(),"OTP Verification");
		takeScreenshot("TC7_signup");
		if(new_signup.confirmationtext().contains("OTP Verification")) {
			test.pass("Signup was successful and the test is passed");
		}
		else {
			test.fail("Signup was not successfull and the test is failed");
		}
	}
	
}
