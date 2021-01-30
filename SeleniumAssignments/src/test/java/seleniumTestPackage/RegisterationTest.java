package seleniumTestPackage;
import seleniumPOM.ParaBankHome;
import seleniumPOM.Registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterationTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Parameters({ "FirstName", "LastName","Street","City","State","Zip","PhoneNumber","Ssn","UserName","Password"})
	@Test
	public void Registration(@Optional("UserFirstName") String FirstName, 
							 @Optional("UserLastName") String LastName,
							 @Optional("UserStreet") String Street, 
							 @Optional("UserCity") String City,
							 @Optional("UserState") String State, 
							 @Optional("232342") String Zip,
							 @Optional("210223344") String PhoneNumber,
							 @Optional("72726373") String Ssn, 
							 @Optional("UserName123") String UserName,
							 @Optional("Password123") String Password		 
							 ) 
	{
		Registration Reg = new Registration(driver);
		
		Reg.clickRegisterLink();
		Reg.verifyRegisterPage();
		Reg.enterFirstName(FirstName);
		Reg.enterLastName(LastName);
		Reg.enterStreet(Street);
		Reg.enterCity(City);
		Reg.enterState(State);
		Reg.enterZip(Zip);
		Reg.enterPhoneNumber(PhoneNumber);
		Reg.enterSsn(Ssn);
		Reg.enterUserName(UserName);
		Reg.enterPassword(Password);
		Reg.enterConfirmPassword(Password);
		Reg.clickRegisterButton();
		Reg.verifyLogOutSuccessful();
		Reg.LogOut();
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	

}
