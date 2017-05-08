package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	
	
	protected WebDriver driver;
	protected String pageTitle;
	protected String pageHandle;
	protected int timeOut = 30;
	
	/**
	 * This constructor accepts a WebDriver object and instantiates the
	 * page object.
	 * 
	 * @param driver
	 */
	public Page(WebDriver driver) {
		this.driver = driver;
		this.pageHandle = driver.getWindowHandle();
		this.pageTitle = driver.getTitle();
	}
	
	public Page(WebDriver driver, String pageTitle) {
		this.driver = driver;
		this.pageHandle = driver.getWindowHandle();
		
		// Check that we're on the right page.
		if (isPageTitle(pageTitle)) {
			this.pageTitle = pageTitle; 
		} else {
			throw new IllegalStateException("Incorrect page loaded: found " + driver.getTitle() + " expected " + pageTitle);
		}
	}
	
	public WebElement getWhenClickable(By locator) {
		WebElement foundElement = null;
		foundElement = (new WebDriverWait(driver, timeOut)).until(ExpectedConditions.elementToBeClickable(locator));
		return foundElement;
	}

	
	public boolean isPageTitle(String pageTitle) {
		boolean matchFound = false;
		try {
			matchFound = (new WebDriverWait(driver, timeOut)).until(ExpectedConditions.titleContains(pageTitle));
		} catch (TimeoutException toe) {
				throw toe;
		}

		return matchFound;
	}
}
