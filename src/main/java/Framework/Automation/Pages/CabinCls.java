package Framework.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Framework.Automation.Test.Driver;

public class CabinCls {
	Driver driver;
	private final By ECONOMY_CLS_LOCATOR = By.cssSelector("md-radio-button[id= 'radio_3']");
	private final By BUSINESS_CLS_LOCATOR = By.cssSelector("md-radio-button[id= 'radio_4']");
	private final By FIRST_CLS_LOCATOR = By.cssSelector("md-radio-button[id= 'radio_5']");

	public CabinCls(Driver driver) {
		this.driver = driver;
	}

	public SrchAvlPage selClass(String cabinCls) throws InterruptedException {

		SrchAvlPage srchAvlPage = new SrchAvlPage(driver);
		WebElement SelPsngrTxtBox = driver.findElement(srchAvlPage.SEL_PSNGR_LOCATOR);
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
		WebElement ProcdBtn = driver.findElement(srchAvlPage.PROCEED_LOCATOR);
		ProcdBtn.click();
		Thread.sleep(1000);
		return new SrchAvlPage(this.driver);

	}

}
