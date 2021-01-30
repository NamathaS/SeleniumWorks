package seleniumTestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumPOM.ParaBankHome;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Parameters({"UserName","Password"})
	@Test
	public void verifyLogin(@Optional("UserName123") String UserName, @Optional("Password123") String Password) {
		
		ParaBankHome ParaHome = new ParaBankHome(driver);
		ParaHome.enterUserName(UserName);
		ParaHome.entePassword(Password);
		ParaHome.clickLoginButton();
		ParaHome.verifyLogIn();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

  
  

}
