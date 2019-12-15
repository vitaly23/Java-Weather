package Project;

import Project.Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeatherAutomation implements Locators {

	public static void main(String[] args)  {
		fetchWeather();
	}
	
	
	public static  WebElement openChrome(WebDriver driver) {
	//open browser with desired URL
		driver.get(initalWebsite);
	//Maximise window
		driver.manage().window().maximize();
		System.out.println("opened");
		//search for current weather
		WebElement searchbar = (WebElement) driver.findElement(By.xpath(searchbarXPATH));
		searchbar.click();
		searchbar.clear();
		searchbar.sendKeys(subject);
		WebElement searchButton = (WebElement) driver.findElement(By.name(buttonName));
		searchButton.click();
		return searchbar;
	}
	
	public static String fetchWeather() {
		
		WebDriver driver = WebdriverHandler.getInstance();
		openChrome(driver);
		WebDriverWait wait = new WebDriverWait(driver, 6);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(resultId)));
		String value = driver.findElement(By.id(resultId)).getText();
		//Closing driver
		driver.close();
		
		return "It's currently "+value+" degrees celcius";
		
	}
	
	}

