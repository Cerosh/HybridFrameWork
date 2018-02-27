package Framework.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Framework.Automation.Test.Driver;

public class TrvlDate {
	Driver driver;
	private final By DATE_BTN_LOCATOR = By.name("return-date-btn");

	public TrvlDate(Driver driver) {
		this.driver = driver;
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

}
