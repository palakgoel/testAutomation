package menu;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import pageobjects.HomePage;
import pageobjects.Page;
import components.Menu;
import framework.Browser;


public class MenuTests {
  private WebDriver driver;
  
  
  // A simple test to verify title of 'Deal' page
  @Test
  public void testDealsMenuOption()
  {
      HomePage home = new HomePage(driver);
      Menu main = home.getMenu();
      Page newPage = main.clickDeals();
      driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
      Assert.assertTrue(newPage.isPageTitle("Top 5 Vacation Rental Deals | Tripping.com"), "Incorrect page loaded.");
  }
  
  @BeforeMethod
  public void beforeMethod() {
      driver = Browser.Open("firefox");
	  driver.navigate().to("http://www.tripping.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}