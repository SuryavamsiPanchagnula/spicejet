package testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.booking_flight;
import pages.search_flight;
import base.basepage;
public class one_way_booking_confirmation extends basepage {
	
	@BeforeTest
	public void testDetails() {
		testName = "one_way_booking";
		testDescription = "Booking a flight for oneway trip by providing passenger and payment details";
		testAuthor = "Suryavamsi";
	}
	
	@Test
	public void onewaytripbookingTest() throws InterruptedException, IOException {
		search_flight bookingpage = new search_flight();
		bookingpage.oneway_booking();
		booking_flight details = new booking_flight();
		details.book_flight();
		Assert.assertEquals(details.paymenterrorText(), "Please enter a valid card");
		takeScreenshot("onewaytripbookingTest");
		if (details.paymenterrorText().contains("Please enter a valid card")) {
			test.pass("Flight booking test passed");
		} else
			test.fail("Flight Booking test failed");
	}

}
