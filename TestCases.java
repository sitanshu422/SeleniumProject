package TestSuites;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import Pages.TripCost;

public class TestCases extends Base {

	TripCost ha = new TripCost();

	@BeforeTest
	public void invokeBrowser() {
		logger = report.createTest("Executing Test Cases");

		ha.invokeBrowser();
		reportPass("Browser is Invoked");
	}

	@Test(priority = 1)
	public void hotels() throws InterruptedException, IOException {

		ha.displayHotels();
		ha.cruises();
		Thread.sleep(5000);
		reportPass("All Test Cases Passed Successfully");
	}


	@AfterTest
	public void closeBrowser() {
		ha.endReport();
		ha.closeBrowser();
	}

}
