package Framework.Automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Framework.Automation.Test.Driver;
import Framework.Automation.Test.SrchTest;

public class SrchRsltPage {
	private final Driver driver;
	private final By TRIP_PSNGRS_CCLS_LOCATOR = By.xpath("//p[@class='route-passenger-class']");
	private final By DESTINATIONS_LOCATOR = By.xpath("//p[@class='header-title']");
	private final By TRVL_DATE_LOCATOR = By.xpath("//div[@class='actual-date']");
	private String tripFrmTst;
	private String arrivalFrmTst;
	private String departureFrmTst;
	private int adultFrmTst;
	private int teenFrmTst;
	private int childFrmTst;
	private int infantFrmTst;
	private String cabinClsFrmTst;
	private int trvlMnthFrmTst;
	private int trvlDayFrmTst;
	
	private String tripActl;
	private String psngrsActl;
	private String cabinClsActl;
	private String departureActl;
	private String arrivalActl;
	private int dayActl;
	private int monthActl;

	public SrchRsltPage(Driver driver) {
		this.driver = driver;
	}

	public boolean validateData() throws ParseException {
		WebElement SeltdTrip_Psngrs_Ccls = driver.findElement(TRIP_PSNGRS_CCLS_LOCATOR);
		String SeltdTrip_Psngrs_Ccls_Str = SeltdTrip_Psngrs_Ccls.getText();
		spltTrip_Psngrs_Ccls(SeltdTrip_Psngrs_Ccls_Str);
		
		WebElement SeltdDestinations = driver.findElement(DESTINATIONS_LOCATOR);
		String SeltdDestinations_Str = SeltdDestinations.getText();
		splt_SeltdDestinations(SeltdDestinations_Str);
		
		WebElement SeltdTrvlDate = driver.findElement(TRVL_DATE_LOCATOR);
		String SeltdTrvlDate_Str = SeltdTrvlDate.getText();
		splt_SeltdTrvlDate(SeltdTrvlDate_Str);
		
		return cmprActl_Tst();
	}

	private void splt_SeltdTrvlDate(String seltdTrvlDate_Str) throws ParseException {
		String trvlDate =seltdTrvlDate_Str.substring(4);
	    String [] dateArray = trvlDate.split(" ");
	    dayActl = Integer.parseInt(dateArray[0]);
	    String monthActl_Str = dateArray[1];
	    Date dateInt = new SimpleDateFormat("MMM").parse(monthActl_Str);
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(dateInt);
	    monthActl = cal.get(Calendar.MONTH);
	    
		
	}

	private void splt_SeltdDestinations(String seltdDestinations_Str) {
		String DstnSplt1 = "-";
		String DstnSplt2 = "\\(";
		String [] DstnArray = seltdDestinations_Str.split(DstnSplt1);
		departureActl = DstnArray[0].trim();
		String [] ArrivalArray = DstnArray[1].split(DstnSplt2);
		arrivalActl = ArrivalArray[0].trim();	
	}

	public void spltTrip_Psngrs_Ccls(String SeltdTrip_Psngrs_Ccls_Str) {
		String Splitter1 = "for";
		String Splitter2 = "in";
		String[] Trip_Psngrs_CclsArray = SeltdTrip_Psngrs_Ccls_Str.split(Splitter1);
		tripActl = Trip_Psngrs_CclsArray[0].trim();
		String[] Psngrs_CclsArray = Trip_Psngrs_CclsArray[1].split(Splitter2);
		psngrsActl = Psngrs_CclsArray[0].substring(0, 2).trim();
		cabinClsActl = Psngrs_CclsArray[1].trim().toUpperCase();
	}
	

	public boolean cmprActl_Tst() {
		SrchTest sT = new SrchTest(tripFrmTst,  departureFrmTst,arrivalFrmTst, adultFrmTst, teenFrmTst, childFrmTst,
									infantFrmTst, cabinClsFrmTst, trvlMnthFrmTst, trvlDayFrmTst);
		ArrayList<Object[]> srchCrtraArrLst = new ArrayList<Object[]>(sT.srchFlights());
		ArrayList<String> arrlistobj = new ArrayList<String>();
		for (Object[] srchCrtraArr : srchCrtraArrLst) {

			for (Object srchCrtra : srchCrtraArr) {
				String srchCrtraStr = srchCrtra.toString();
				arrlistobj.add(srchCrtraStr);
			}
		}
		int psngrsExptd = Integer.parseInt(arrlistobj.get(3)) + Integer.parseInt(arrlistobj.get(4))
				+ Integer.parseInt(arrlistobj.get(5)) + Integer.parseInt(arrlistobj.get(6));
		

		boolean retValue = (tripActl.equalsIgnoreCase(arrlistobj.get(0)))
						& (psngrsActl.equalsIgnoreCase(String.valueOf(psngrsExptd)))
						& (cabinClsActl.equalsIgnoreCase(arrlistobj.get(7)))
						& (departureActl.contains(arrlistobj.get(1)))
						& (arrivalActl.contains(arrlistobj.get(2)))
						& (monthActl== Integer.parseInt(arrlistobj.get(8))
						& (dayActl== Integer.parseInt(arrlistobj.get(9))));
	
		return retValue;

	}
}
