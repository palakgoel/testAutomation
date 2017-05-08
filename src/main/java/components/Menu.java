package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageobjects.Page;


public class Menu extends Page {
	private static final By mnuDeals = By.cssSelector(".deals-button");
	
	public Menu(WebDriver driver) {
		super(driver);
	}
	
	public Page clickDeals() {
		WebElement deals = this.getWhenClickable(mnuDeals);
		deals.click();
		return new Page(driver);
	}
	
	
}