package Framework.Automation.Test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
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
	private String arrival;
	private String departure;
	private int adult;
	private int teen;
	private int child;
	private int infant;
	private String cabinCls;
	private int trvlMnth;
	private int trvlDay;
	
	public SrchTest(String trip, String departure, String arrival, int adult, int teen, 
			int child, int infant, String cabinCls,int trvlMnth, int trvlDay) {
		this.trip = trip;
		this.arrival= arrival;
		this.departure = departure;
		this.adult = adult;
		this.teen = teen;
		this.child = child;
		this.infant = infant;
		this.cabinCls = cabinCls;
		this.trvlMnth= trvlMnth;
		this.trvlDay = trvlDay;
	}
	@Parameterized.Parameters
	   public static Collection srchFlights() {
	      return Arrays.asList(new Object[][] {
	        { "ONE WAY", "Dubai", "London", 1, 0, 2, 1,"ECONOMY",3, 10},
	    	  
	      });
	   }
	
	@Test	
	public void search() throws Exception {
		SrchAvlPage srchAvlPage = visitSite();
		Thread.sleep(5000);
		srchAvlPage = srchAvlPage
				.tripType().selTripType(trip)
				.destinations().selDstn(departure, arrival)
				.passengers().selPsngr(adult, teen, child, infant)
				.cabinCls().selClass(cabinCls)
				.trvlDate().selDate(trvlMnth, trvlDay);
		SrchRsltPage srchRslPage = 	srchAvlPage.clkSrchBtn().clkSrch();
		assertTrue(srchRslPage.validateData());
		
	}
}
