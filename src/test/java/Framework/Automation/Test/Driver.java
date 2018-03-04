package Framework.Automation.Test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver implements WebDriver {
	private final String browserName;
	private WebDriver driver;

	public Driver(String browserName) {
		this.browserName = browserName;
		this.driver = createDriver(browserName);
	}

	private WebDriver createDriver(String browserName) {
		WebDriver driver;
		switch (browserName.toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",
					"/Users/ceroshjacob/Downloads/PageObjectModel/Browserdrivers/chromedriver");
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("", "");
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Wrong browser name passed");
		}
		return driver;
	}

	public WebDriver wrappedDriver() {
		return this.driver;
	}

	@Override
	public void close() {
		driver.close();

	}

	@Override
	public WebElement findElement(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, 50);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		return driver.findElements(arg0);
	}

	@Override
	public void get(String LocatorAndURL) {
		
		String splitter = "https";
		String[] LocatorAndURLArray = LocatorAndURL.split(splitter);
		String Locator = LocatorAndURLArray[0];
		String URL = splitter + LocatorAndURLArray[1];
		final By FEEDBACKBAR = By.xpath(Locator);	
		driver.get(URL);
		new WebDriverWait(this.driver, 50).until(ExpectedConditions.visibilityOfElementLocated(FEEDBACKBAR));
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	@Override
	public Options manage() {
		return driver.manage();
	}

	@Override
	public Navigation navigate() {
		return driver.navigate();
	}

	@Override
	public void quit() {
		driver.quit();

	}

	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

}
