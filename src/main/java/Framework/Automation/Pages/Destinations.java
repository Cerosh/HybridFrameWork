package Framework.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Framework.Automation.Test.Driver;

public class Destinations {
	
	Driver driver;
	private final By DEPARTURE_LOCATOR = By.name("departureReturnOne");
	private final By DEPARTURE_CONTAINER = By.xpath(
			"(//input[@class='md-input input-box ng-pristine ng-untouched ng-not-empty ng-valid ng-valid-required'])[1]");
	private final By SRCHARPRT_FRM_LOCATOR = By.xpath("(//input[@id='autocompleteId_fromCity'])[1]");
	private final By SRCHARPRT_FRM_LST_LOCATOR = By.xpath("(//li[@class='city-autocomplete-row ng-scope'])[1]");
	private final By ARRIVAL_LOCATOR = By.name("arrivalReturnOne");
	private final By SRCHARPRT_TO_LOCATOR = By.xpath("(//input[@id='autocompleteId_toCity'])[1]");
	private final By SRCHARPRT_TO_LST_LOCATOR = By.xpath("(//div[@class='d-table autocomplete-city-details'])[2]");

	public Destinations(Driver driver) {
		this.driver = driver;
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
		Thread.sleep(2000);
		WebElement ArrivalTxtBox = driver.findElement(ARRIVAL_LOCATOR);
		ArrivalTxtBox.click();
		WebElement SrchArprtToTxtBox = driver.findElement(SRCHARPRT_TO_LOCATOR);
		SrchArprtToTxtBox.click();
		Thread.sleep(2000);
		SrchArprtToTxtBox.sendKeys(arrival);
		WebElement SrchArprtToLst = driver.findElement(SRCHARPRT_TO_LST_LOCATOR);
		Thread.sleep(2000);
		SrchArprtToLst.click();
		Thread.sleep(1000);
		return new SrchAvlPage(this.driver);
	}
}
