package testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basepage;
import pages.search_flight;
public class invalid_booking extends basepage {
	
	@BeforeTest
	public void testDetails() {
		testName = "Invalid_booking";
		testDescription = "Searching for flight on Spicejet website for round trip";
		testAuthor = "Suryavamsi";
	}

	@Test
	public void Invalid_booking() throws InterruptedException, IOException {
		search_flight bookingpage = new search_flight();
		bookingpage.invalid_booking();
		Assert.assertEquals(bookingpage.checkin(), "Check-In");
		takeScreenshot("invalid booking");
		if (bookingpage.checkin().contains("Check-In")) {
			test.pass("Round trip Flight search with invalid search deatils test passed");
		} else
			test.fail("Round trip Flight search with invalid search deatils test failed");
	}

}
