package Framework.Automation.Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Framework.Automation.Pages.SrchAvlPage;
import Framework.Automation.Pages.SrchRsltPage;

@RunWith(Parameterized.class)
public class SrchTest extends BaseTest{
	private String trip;
	public SrchTest(String trip) {
		this.trip = trip;
	}
	@Parameterized.Parameters
	   public static Collection srchFlights() {
	      return Arrays.asList(new Object[][] {
	       //  { "ONE WAY", "Dubai", "London", 1, 0, 2, 2,"ECONOMY",3, 10},
	    	  { "ONE WAY"},
	      });
	   }
	
	@Test	
	public void search() throws InterruptedException {
		SrchAvlPage srchAvlPage = visitSite();
		Thread.sleep(5000);
		srchAvlPage = srchAvlPage
				.tripType().selTripType(trip)
				.destinations().selDstn("Dubai", "London")
				.passengers().selPsngr(1, 0, 2, 2)
				.cabinCls().selClass("ECONOMY")
				.trvlDate().selDate(3, 10);
		SrchRsltPage srchRslPage = srchAvlPage
				.clkSrchBtn().clkSrch();
		srchRslPage.validateData();
		
	}
}
