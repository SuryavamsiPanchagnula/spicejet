package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basepage;
import pages.booking_flight;
import pages.search_flight;
public class two_way_booking_confirmation extends basepage {

	@BeforeTest
	public void testDetails() {
		testName = "two_way_booking";
		testDescription = "Booking a flight for oneway trip by providing passenger and payment details";
		testAuthor = "Suryavamsi";
	}

	@Test
	public void roundtripbookingTest() throws InterruptedException, IOException {
		search_flight bookingpage = new search_flight();
		bookingpage.round_trip_booking();
		booking_flight details = new booking_flight();
		details.book_flight();
		Assert.assertEquals(details.paymenterrorText(), "Please enter a valid card");
		takeScreenshot("roundtripbookingTest");
		if (details.paymenterrorText().contains("Please enter a valid card")) {
			test.pass("Flight booking test passed");
		} else
			test.fail("Flight Booking test failed");
	}
}
