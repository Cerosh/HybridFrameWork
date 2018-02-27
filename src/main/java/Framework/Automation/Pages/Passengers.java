package Framework.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Framework.Automation.Test.Driver;

public class Passengers {
	Driver driver;

	private final By SEL_ADULT_LOCATOR = By
			.xpath("(//button[@class='cabin-pessaneger-button pessanger-plus-button'])[1]");
	private final By SEL_TEEN_LOCATOR = By
			.xpath("(//button[@class='cabin-pessaneger-button pessanger-plus-button'])[2]");
	private final By SEL_CHLD_LOCATOR = By
			.xpath("(//button[@class='cabin-pessaneger-button pessanger-plus-button'])[3]");
	private final By SEL_INFT_LOCATOR = By
			.xpath("(//button[@class='cabin-pessaneger-button pessanger-plus-button'])[4]");

	public Passengers(Driver driver) {
		this.driver = driver;
	}

	public SrchAvlPage selPsngr(int adult, int teenager, int child, int infant) throws InterruptedException {
		
		SrchAvlPage srchAvlPage = new SrchAvlPage(driver);
		WebElement SelPsngrTxtBox = driver.findElement(srchAvlPage.SEL_PSNGR_LOCATOR);
		Thread.sleep(1000);
		SelPsngrTxtBox.click();
		Thread.sleep(1000);
		WebElement SelAdltPsngr = driver.findElement(SEL_ADULT_LOCATOR);
		WebElement ProcdBtn = driver.findElement(srchAvlPage.PROCEED_LOCATOR);

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
			WebElement SelTeenPsngr = driver.findElement(SEL_TEEN_LOCATOR);
			for (int i = 1; i <= teenager; i++) {
				SelTeenPsngr.click();
				Thread.sleep(1000);
			}
		}
		if (child > 0) {

			WebElement SelChldPsngr = driver.findElement(SEL_CHLD_LOCATOR);
			for (int i = 1; i <= child; i++) {
				SelChldPsngr.click();
				Thread.sleep(1000);
			}
		}
		if (infant > 0) {
			WebElement SelInftPsngr = driver.findElement(SEL_INFT_LOCATOR);
			for (int i = 1; i <= infant; i++) {
				SelInftPsngr.click();
				Thread.sleep(1000);
			}
		}
		ProcdBtn.click();
		Thread.sleep(1000);
		return new SrchAvlPage(this.driver);
	}

}
