package base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import operations.actions;

public class basepage extends actions {
	
	@BeforeSuite
	public void startReport() {
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(new Date());
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/result-" + timeStamp + ".html");
		reporter.setAppendExisting(false);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void detail() {
		test = extent.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
	}

	@BeforeMethod()
	public void setUp() throws Exception {
		LaunchBrowser(readProperty("browser"));
		launch_website(readProperty("url"));
	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

	
}
