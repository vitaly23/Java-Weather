package Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverHandler {
	//SINGELTONE
	private static WebDriver driver;
	
	WebdriverHandler() {}

	public static WebDriver getInstance() {
		if (driver==null) {
			//Initialisation 
			driver = new ChromeDriver();
			configDriver();
		}
		return driver;
	}
	
	private static void configDriver() {
		//Setting the driver executable (add your own path)						
		System.setProperty("webdriver.chrome.driver", "Your PATH");
						
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);			
	}
	
}
