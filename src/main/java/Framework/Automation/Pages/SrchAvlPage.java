package Framework.Automation.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Automation.Test.Driver;

public class SrchAvlPage {
	private final Driver driver;
	private final String URL = "https://mobile1.emirates.com/ui/english/index.xhtml#/";
	private final String TITLE = "Plan and book | Make a booking | Emirates";
	public final String FEEDBACK_LOCATOR = "//div[@class='s001-toggle']";
	private final String LocatorAndURL = FEEDBACK_LOCATOR + URL;

	public final By SEL_PSNGR_LOCATOR = By.xpath(
			"(//md-input-container[@class='md-block ng-scope flex-gt-md flex-gt-lg mb-40 flex-gt-sm md-input-has-value'])[3]");
	public final By PROCEED_LOCATOR = By.xpath("(//button[@class='cabin-pessanger-proceed-btn ng-binding'])[1]");

	
	
	public SrchAvlPage(Driver driver) {
		this.driver = driver;
	}

	public void open() throws InterruptedException {
		this.driver.get(LocatorAndURL);
		Thread.sleep(1000);
	}

	public TripType tripType() {
		return new TripType(driver);
	}

	public Destinations destinations() {
		return new Destinations(driver);
	}

	public Passengers passengers() {
		return new Passengers(driver);
	}

	public CabinCls cabinCls() {
		return new CabinCls(driver);
	}

	public TrvlDate trvlDate() {
		return new TrvlDate(driver);
	}
	
	public ClkSrchBtn clkSrchBtn(){
		return new ClkSrchBtn(driver);
	}
	

}
