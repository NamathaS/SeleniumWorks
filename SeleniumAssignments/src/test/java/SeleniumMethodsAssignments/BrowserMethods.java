package SeleniumMethodsAssignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMethods {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		//Navigate to the url
		driver.get("https://parabank.parasoft.com/parabank/index.htm");		
		System.out.println("Parabank website opened ... ");
		
		//Url of the Website
		System.out.println("URL of the website opened");
		System.out.println(driver.getCurrentUrl());
		
		//Title of the Website
		System.out.println("Title of the website opened");
		System.out.println(driver.getTitle());
		
		//Source of the Website
		System.out.println("Source of the website opened");
		System.out.println(driver.getPageSource());
		
		driver.close();
		System.out.println("Browser closed");
		
		driver.quit();
		System.out.println("Browser object is disallocated");
		
	}

}
