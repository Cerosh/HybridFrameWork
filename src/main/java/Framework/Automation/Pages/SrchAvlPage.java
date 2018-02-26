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
	private final String URL = "https://mobile.emirates.com/ui/english/index.xhtml#/";
	private final String TITLE = "Plan and book | Make a booking | Emirates";
	public final String FEEDBACK_LOCATOR = "//div[@class='s001-toggle']";
	private final String LocatorAndURL = FEEDBACK_LOCATOR + URL;

	private final By RETURN_LOCATOR = By.cssSelector("md-tab-item[aria-controls='tab-content-0']");
	private final By ONEWAY_LOCATOR = By.cssSelector("md-tab-item[aria-controls='tab-content-1']");
	private final By MULTICITY_LOCATOR = By.cssSelector("md-tab-item[aria-controls='tab-content-2']");

	private final By DEPARTURE_LOCATOR = By.name("departureReturnOne");
	private final By DEPARTURE_CONTAINER = By.xpath(
			"(//input[@class='md-input input-box ng-pristine ng-untouched ng-not-empty ng-valid ng-valid-required'])[1]");
	private final By SRCHARPRT_FRM_LOCATOR = By.xpath("(//input[@id='autocompleteId_fromCity'])[1]");
	private final By SRCHARPRT_FRM_LST_LOCATOR = By.xpath("(//li[@class='city-autocomplete-row ng-scope'])[1]");
	private final By ARRIVAL_LOCATOR = By.name("arrivalReturnOne");
	private final By SRCHARPRT_TO_LOCATOR = By.xpath("(//input[@id='autocompleteId_toCity'])[1]");
	private final By SRCHARPRT_TO_LST_LOCATOR = By.xpath("(//div[@class='d-table autocomplete-city-details'])[2]");

	private final By SEL_PSNGR_LOCATOR = By.xpath(
			"(//md-input-container[@class='md-block ng-scope flex-gt-md flex-gt-lg mb-40 flex-gt-sm md-input-has-value'])[3]");
	private final By SEL_ADULT_LOCATOR = By
			.xpath("(//button[@class='cabin-pessaneger-button pessanger-plus-button'])[1]");
	private final By SEL_TEEN_LOCATOR = By
			.xpath("(//button[@class='cabin-pessaneger-button pessanger-plus-button'])[2]");
	private final By SEL_CHLD_LOCATOR = By
			.xpath("(//button[@class='cabin-pessaneger-button pessanger-plus-button'])[3]");
	private final By SEL_INFT_LOCATOR = By
			.xpath("(//button[@class='cabin-pessaneger-button pessanger-plus-button'])[4]");

	private final By PROCEED_LOCATOR = By.xpath("(//button[@class='cabin-pessanger-proceed-btn ng-binding'])[1]");

	private final By ECONOMY_CLS_LOCATOR = By.cssSelector("md-radio-button[id= 'radio_3']");
	private final By BUSINESS_CLS_LOCATOR = By.cssSelector("md-radio-button[id= 'radio_4']");
	private final By FIRST_CLS_LOCATOR = By.cssSelector("md-radio-button[id= 'radio_5']");

	private final By DATE_BTN_LOCATOR = By.name("return-date-btn");
	private final By SHOW_RSLT_LOCATOR = By.xpath("(//div[@id='procdBtn'])[1]");

	public SrchAvlPage(Driver driver) {
		this.driver = driver;
	}

	public void open() throws InterruptedException {
		this.driver.get(LocatorAndURL);
		Thread.sleep(1000);

	}

	public SrchAvlPage selTripType(String tripType) {

		switch (tripType.toUpperCase()) {

		case "RETURN":
			WebElement returnTab = driver.findElement(RETURN_LOCATOR);
			returnTab.click();
			break;

		case "ONEWAY":
			WebElement oneWayTab = driver.findElement(ONEWAY_LOCATOR);
			oneWayTab.click();
			break;

		case "MULTICITY":
			WebElement multiCityTab = driver.findElement(MULTICITY_LOCATOR);
			multiCityTab.click();
			break;

		default:
			throw new IllegalArgumentException("Wrong trip type passed");
		}

		return new SrchAvlPage(this.driver);
	}

	public SrchAvlPage selDstn(String departure, String arrival) throws InterruptedException {

		WebElement DepatureTxtBox = driver.findElement(DEPARTURE_LOCATOR);
		DepatureTxtBox.click();
		WebElement SrchArprtFrmTxtBox = driver.findElement(SRCHARPRT_FRM_LOCATOR);
		SrchArprtFrmTxtBox.click();
		SrchArprtFrmTxtBox.sendKeys(departure);
		WebElement SrchArprtFrmLst = driver.findElement(SRCHARPRT_FRM_LST_LOCATOR);
		SrchArprtFrmLst.click();
		WebElement DepartureContainer = driver.findElement(DEPARTURE_CONTAINER);
		String Departure = DepartureContainer.getText();
		System.out.println(Departure);
		Thread.sleep(1000);
		WebElement ArrivalTxtBox = driver.findElement(ARRIVAL_LOCATOR);
		ArrivalTxtBox.click();
		WebElement SrchArprtToTxtBox = driver.findElement(SRCHARPRT_TO_LOCATOR);
		SrchArprtToTxtBox.click();
		SrchArprtToTxtBox.sendKeys(arrival);
		WebElement SrchArprtToLst = driver.findElement(SRCHARPRT_TO_LST_LOCATOR);
		SrchArprtToLst.click();
		Thread.sleep(1000);
		return new SrchAvlPage(this.driver);
	}

	public SrchAvlPage selPsngr(int adult, int teenager, int child, int infant) throws InterruptedException {

		WebElement SelPsngrTxtBox = driver.findElement(SEL_PSNGR_LOCATOR);
		Thread.sleep(1000);
		SelPsngrTxtBox.click();
		Thread.sleep(1000);
		WebElement SelAdltPsngr = driver.findElement(SEL_ADULT_LOCATOR);
		WebElement SelTeenPsngr = null;
		WebElement SelChldPsngr = null;
		WebElement SelInftPsngr = null;
		WebElement ProcdBtn = driver.findElement(PROCEED_LOCATOR);

		switch (adult) {
		case 1:
			break;
		default:
			for (int i = 1; i < adult; i++) {
				SelAdltPsngr.click();
				Thread.sleep(1000);
			}
		}
			
			if (teenager > 0) {
				SelTeenPsngr = driver.findElement(SEL_TEEN_LOCATOR);
				for (int i = 1; i <= teenager; i++) {
					SelTeenPsngr.click();
					Thread.sleep(1000);
				}
			}
			if (child > 0) {
				SelChldPsngr = driver.findElement(SEL_CHLD_LOCATOR);
				for (int i = 1; i <= child; i++) {
					SelChldPsngr.click();
					Thread.sleep(1000);
				}
			}
			if (infant > 0) {
				SelInftPsngr = driver.findElement(SEL_INFT_LOCATOR);
				for (int i = 1; i <= infant; i++) {
					SelInftPsngr.click();
					Thread.sleep(1000);
				}
			}
			ProcdBtn.click();
			Thread.sleep(1000);
		

		return new SrchAvlPage(this.driver);
	}

	public SrchAvlPage selClass(String cabinCls) throws InterruptedException {

		WebElement SelPsngrTxtBox = driver.findElement(SEL_PSNGR_LOCATOR);
		SelPsngrTxtBox.click();
		Thread.sleep(1000);
		switch (cabinCls.toUpperCase()) {

		case "ECONOMY":
			WebElement selEconCls = driver.findElement(ECONOMY_CLS_LOCATOR);
			selEconCls.click();
			break;

		case "BUSINESS":
			WebElement selBizCls = driver.findElement(BUSINESS_CLS_LOCATOR);
			selBizCls.click();
			break;

		case "FIRST":
			WebElement selFstCls = driver.findElement(FIRST_CLS_LOCATOR);
			selFstCls.click();
			break;

		default:
			throw new IllegalArgumentException("Wrong cabin class Selected");
		}
		WebElement ProcdBtn = driver.findElement(PROCEED_LOCATOR);
		ProcdBtn.click();
		Thread.sleep(1000);
		return new SrchAvlPage(this.driver);

	}

	public SrchAvlPage selDate(int month, int date) throws InterruptedException {
		final By SEL_DATE_LOCATOR = By.xpath("(//*[@data-month='" + month + "'])[" + date + "]");
		WebElement SelDateBtn = driver.findElement(DATE_BTN_LOCATOR);
		SelDateBtn.click();
		Thread.sleep(1000);
		WebElement SelToDateClnd = driver.findElement(SEL_DATE_LOCATOR);
		SelToDateClnd.click();

		Thread.sleep(1000);
		return new SrchAvlPage(this.driver);
	}

	public SrchRsltPage clkSrch() {
		WebElement ShowRsltBtn = driver.findElement(SHOW_RSLT_LOCATOR);
		ShowRsltBtn.click();
		return new SrchRsltPage(this.driver);
	}

}
