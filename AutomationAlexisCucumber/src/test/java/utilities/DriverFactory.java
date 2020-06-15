package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class DriverFactory {

	WebDriver driver; 
	
	@Before
	public WebDriver open(){
		if (driver==null) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\PROBOOK\\Documents\\Automation & Performance\\ProyectoAutomationAlexis\\webdrivers\\chromedriver.exe");			
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	@After
	public void tearDown() {
		driver.quit();
		driver = null;
		logger.log("Se cierra el webdriver.");	
	}
	
}