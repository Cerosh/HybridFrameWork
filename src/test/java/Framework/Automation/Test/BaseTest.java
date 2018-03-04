package Framework.Automation.Test;

import org.junit.After;
import org.junit.Before;

import Framework.Automation.Pages.SrchAvlPage;

public class BaseTest {
	Driver driver;
	private final String URL = "https://mobile1.emirates.com/ui/english/index.xhtml#/";
	private final String TITLE = "Plan and book | Make a booking | Emirates";
	public final String FEEDBACK_LOCATOR = "//div[@class='s001-toggle']";
	private final String LocatorAndURL = FEEDBACK_LOCATOR + URL;

	@Before
	public void startUp() {
		driver = new Driver("CHROME");
	}

	@After
	public void tearDown() {
		driver.quit();

	}

	protected SrchAvlPage visitSite() {
		this.driver.get(LocatorAndURL);
		if (this.driver.getTitle().equalsIgnoreCase(TITLE) == false)
			throw new RuntimeException("home page not displayed");
		return new SrchAvlPage(this.driver);
	}
}
