package Framework.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Framework.Automation.Test.Driver;
import Framework.Automation.Test.SrchTest;

public class SrchRsltPage {
private final Driver driver;
private final By TRIP_PSNGRS_CCLS_LOCATOR = By.xpath("//p[@class='route-passenger-class']");
private final By DESTINATIONS_LOCATOR = By.xpath("//p[@class='header-title']");
private final By TRVL_DATE_LOCATOR = By.xpath("//div[@class='actual-date']");

	public SrchRsltPage(Driver driver) {
		this.driver = driver;
	}
public SrchRsltPage validateData() {
	WebElement SeltdTrip_Psngrs_Ccls = driver.findElement(TRIP_PSNGRS_CCLS_LOCATOR);
	String SeltdTrip_Psngrs_Ccls_Str = SeltdTrip_Psngrs_Ccls.getText();
	System.out.println(SeltdTrip_Psngrs_Ccls_Str);
//	spltTrip_Psngrs_Ccls( SeltdTrip_Psngrs_Ccls_Str);
	WebElement SeltdDestinations = driver.findElement(DESTINATIONS_LOCATOR);
	System.out.println(SeltdDestinations.getText());
	WebElement  SeltdTrvlDate = driver.findElement(TRVL_DATE_LOCATOR);
	System.out.println(SeltdTrvlDate.getText());
	
	return new SrchRsltPage(driver);
}
/*
public boolean spltTrip_Psngrs_Ccls(String SeltdTrip_Psngrs_Ccls_Str) {
	 
	String Splitter1 = "for";
	String Splitter2 = "in";
	String [] Trip_Psngrs_CclsArray=	SeltdTrip_Psngrs_Ccls_Str.split(Splitter1);
	String Trip = Trip_Psngrs_CclsArray[0].trim().toUpperCase();
	String [] Psngrs_CclsArray = Trip_Psngrs_CclsArray[1].split(Splitter2);
	String Psngrs = Psngrs_CclsArray[0].substring(0, 2).trim();
	String Ccls = Psngrs_CclsArray[1].trim().toUpperCase();
	SrchTest st = new SrchTest();
	
	
	
	
	if(Trip.equals(Slctd_TripType)) {
		System.out.println("Pass");
		return true;
	}{
		System.out.println("False");
	return false;
	}
}*/
}
