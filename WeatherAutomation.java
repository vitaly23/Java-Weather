package Project;

import Project.Locators;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeatherAutomation {

	public static void main(String[] args)  {
		
	}
	
	
	public static  WebElement openChrome(WebDriver driver) {
	//open browser with desired URL
		driver.get(Locators.initalWebsite);
	//Maximise window
		driver.manage().window().maximize();
		System.out.println("opened");
		//search for current weather
		WebElement searchbar = (WebElement) driver.findElement(By.xpath(Locators.searchbarXPATH));
		searchbar.click();
		searchbar.clear();
		searchbar.sendKeys(Locators.subject);
		WebElement searchButton = (WebElement) driver.findElement(By.name(Locators.buttonName));
		searchButton.click();
		return searchbar;
	}
	
	public static String fetchWeather() {
		WebDriver driver = getWebdriver();
		WebElement search = openChrome(driver);
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.resultId)));
		String value = driver.findElement(By.id(Locators.resultId)).getText();
		//Closing driver
		driver.close();
		
		return "It's currently "+value+" degrees celcius";
		
	}
	public static WebDriver getWebdriver() {
		
		//Setting the driver executable						
		System.setProperty("webdriver.chrome.driver", "Your PATH");
		
		//Initiating my chrome driver
		WebDriver driver = new ChromeDriver();
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		return driver;
	}
}
