package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

/**
 * This class is help to instantiate the driver object and fire the required browser
 *
 */
public class Browser {
    static WebDriver driver ;
    

    public static WebDriver Firefox() 
    {
        return new FirefoxDriver();
    }
    public static WebDriver Chrome()
    {
        return new ChromeDriver();
    }
    
    public static WebDriver Open( String browserName)
    {
    	//Check if parameter passed from TestNG is 'firefox'
    			if(browserName.equalsIgnoreCase("firefox")){
    			//create firefox instance
    				System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver");
    				driver =  Firefox();
    			}
    			//Check if parameter passed as 'chrome'
    			else if(browserName.equalsIgnoreCase("chrome")){
    				//set path to chromedriver.exe
    				System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
    				//create chrome instance
    				driver =  Chrome();
    			}     
    			
    	 return driver;		
    }    
}