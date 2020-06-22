package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SeleniumUtilitario {

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
		log("Se cierra el webdriver.");	
	}
	
	
	public static String reemplazarEnXpath(String xpath, String palabraACambiar, String... args) {
		for (int i = 0; i < args.length; i++) {
		xpath = xpath.replaceFirst(palabraACambiar, args[i]);
		}
		return xpath;
		}
	
	public static String capturarPantalla(WebDriver driver, String ScreenshotName) {

		String destinationPath = null;
		try {
			File destFolder = new File("CapturasDePantalla");
			
			destinationPath = destFolder.getCanonicalPath() + "/" + ScreenshotName + ".png";
	
			File screeShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(screeShot, new File(destinationPath));

		} catch (Exception e) {
		}
		return destinationPath;
	}


		public static void log(String texto) {
			System.out.println(texto);
		}
	
}

