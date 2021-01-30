package testMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModel.HomePage;

public class HomeTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\namat\\Documents\\Testing\\Automation\\SeleniumWorks\\SeleniumAssignments\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		
	}
	@Test
	public void login() {
		HomePage hp = new HomePage(driver);
		hp.enterUserName();
		hp.enterPassword();
		hp.clickLogin();
		hp.verifyLogout();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
