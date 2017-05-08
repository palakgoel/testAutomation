package pageobjects;
import org.openqa.selenium.WebDriver;
import components.Menu;


public class HomePage extends Page {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}
	
	public Menu getMenu() {
		return new Menu(driver);
	}

}