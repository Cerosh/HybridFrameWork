package Framework.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Framework.Automation.Test.Driver;

public class TripType {
	private final Driver driver;
	private final By RETURN_LOCATOR = By.cssSelector("md-tab-item[aria-controls='tab-content-0']");
	private final By ONEWAY_LOCATOR = By.cssSelector("md-tab-item[aria-controls='tab-content-1']");
	private final By MULTICITY_LOCATOR = By.cssSelector("md-tab-item[aria-controls='tab-content-2']");

	public TripType(Driver driver) {
		this.driver = driver;
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
}
