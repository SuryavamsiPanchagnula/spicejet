package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.basepage;
import pages.search_flight;
public class booking_tabs extends basepage {
	
	@BeforeTest
	public void testDetails() {
		
		testName ="TC1_Navigation Tabs";
		testDescription="Verify whether user is able to view home page tabs";
		testAuthor ="Suryavamsi";
	}
	
	@Test
	public void Booking_tabs() throws IOException {
		
		search_flight navigation = new search_flight();
		navigation.checkNavigationTabs();
		takeScreenshot("booking_tabs");
		if(navigation.managebookingtext().contains("Manage Booking")) {
			test.pass("Navigation tabs are visible and the test is passed");
		}
		else {
			test.fail("Navigation tabs are not visible and the test is not passed");
		}
		
	}

}
