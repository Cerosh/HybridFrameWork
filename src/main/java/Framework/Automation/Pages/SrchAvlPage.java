package Framework.Automation.Pages;

import org.openqa.selenium.By;
import Framework.Automation.Test.Driver;

public class SrchAvlPage {
	private final Driver driver;
	public final By SEL_PSNGR_LOCATOR = By.xpath(
			"(//md-input-container[@class='md-block ng-scope flex-gt-md flex-gt-lg mb-40 flex-gt-sm md-input-has-value'])[3]");
	public final By PROCEED_LOCATOR = By.xpath("(//button[@class='cabin-pessanger-proceed-btn ng-binding'])[1]");

	public SrchAvlPage(Driver driver) {
		this.driver = driver;
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

	public ClkSrchBtn clkSrchBtn() {
		return new ClkSrchBtn(driver);
	}

}
