package Framework.Automation.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Automation.Pages.SrchAvlPage;
import Framework.Automation.Pages.SrchRsltPage;

public class SrchTest {
	Driver driver;

	@Before
	public void startUp() {
		driver = new Driver("CHROME");
	}

	@After
	public void tearDown() {
		driver.quit();

	}
	

	@Test
	public void search() throws InterruptedException {
		SrchAvlPage srchAvlPage = new SrchAvlPage(driver);
		srchAvlPage.open();

		srchAvlPage = srchAvlPage
				.tripType().selTripType("ONEWAY")
				.destinations().selDstn("Dubai", "London")
				.passengers().selPsngr(1, 0, 2, 2)
				.cabinCls().selClass("ECONOMY")
				.trvlDate().selDate(3, 10);
		SrchRsltPage srchRslPage = srchAvlPage
				.clkSrchBtn().clkSrch();
		
	}
}
