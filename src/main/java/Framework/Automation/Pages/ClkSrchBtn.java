package Framework.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Framework.Automation.Test.Driver;

public class ClkSrchBtn {
	Driver driver;
	private final By SHOW_RSLT_LOCATOR = By.xpath("(//div[@id='procdBtn'])[1]");


	public ClkSrchBtn(Driver driver) {
		this.driver = driver;
	}
	
	public SrchRsltPage clkSrch() {
		WebElement ShowRsltBtn = driver.findElement(SHOW_RSLT_LOCATOR);
		ShowRsltBtn.click();
		return new SrchRsltPage(this.driver);
	}
}
