package seleniumTestNG;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNGExample {
	WebDriver driver;

	
	@BeforeTest
	public void OpenWebsite() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		//driver.manage().window().maximize();
		System.out.println("Website has opened ... ");
	}
  @Test
  public void Register() {
		// TODO Auto-generated method stub

		int RandomNumber;
		String UserName;
		Random  RandomObj = new Random();
		RandomNumber=RandomObj.nextInt();
		
		UserName = "UserName"+RandomNumber;
		try {

			driver.findElement(By.linkText("Register")).click();
			Assert.assertTrue((driver.getTitle()).contains("Register"));
			
			driver.findElement(By.id("customer.firstName")).sendKeys("Namatha");
			driver.findElement(By.id("customer.lastName")).sendKeys("Scavish");
			driver.findElement(By.id("customer.address.street")).sendKeys("26 Stranolar");
			driver.findElement(By.id("customer.address.city")).sendKeys("Mount Roskill");
			driver.findElement(By.id("customer.address.state")).sendKeys("Auckland");
			driver.findElement(By.id("customer.address.zipCode")).sendKeys("1041");
			driver.findElement(By.id("customer.phoneNumber")).sendKeys("0210223342");
			driver.findElement(By.id("customer.ssn")).sendKeys("556677");
			driver.findElement(By.id("customer.username")).sendKeys(UserName);
			driver.findElement(By.id("customer.password")).sendKeys("PassWord123");
			driver.findElement(By.id("repeatedPassword")).sendKeys("PassWord123");	
			driver.findElement(By.xpath("//input[@value='Register']")).click();

		}
		catch(Error e){
			System.out.println("Page Failed to Load..");
		}

		
  }
  
  
  @AfterTest
  public void terminatetest() {
     driver.close();
  }
}
