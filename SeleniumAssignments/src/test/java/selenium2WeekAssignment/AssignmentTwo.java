package selenium2WeekAssignment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsDeep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;  
import java.util.Random;

public class AssignmentTwo {

	public static void main(String[] args) {
		String title,UserName;
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the url
		driver.get("https://parabank.parasoft.com/parabank/index.htm");	
		try {
			title = driver.getTitle();
			Assert.assertTrue(title.contains("ParaBank")&&title.contains("Welcome"));
			
			System.out.println("Parabank website opened ... ");
		
			//Registering the user
			UserName = registerUser(driver);
			
			//User login
			loginUser(UserName,driver);
				
			//ContactUs
			ContactUs(driver);
			
			//Forget Login Info
			ForgetLoginInfo(driver);
			
			driver.close();
			driver.quit();
		}
		catch(Error e){
			
			System.out.println("Error while loading page "+e.getMessage());
		}
	}

	private static void ForgetLoginInfo(WebDriver driver) {
		// TODO Auto-generated method stub
		
		driver.findElement(By.linkText("Forgot login info?")).click();
		System.out.println("title "+driver.getTitle());
		try {
			String title = driver.getTitle();
			Assert.assertTrue(title.contains("Lookup"));
			driver.findElement(By.id("firstName")).sendKeys("Namatha");
			driver.findElement(By.id("lastName")).sendKeys("Scavish");
			driver.findElement(By.id("address.street")).sendKeys("26 Stranolar");
			driver.findElement(By.id("address.city")).sendKeys("Mount Roskill");
			driver.findElement(By.id("address.state")).sendKeys("Auckland");
			driver.findElement(By.id("address.zipCode")).sendKeys("1041");
			driver.findElement(By.id("ssn")).sendKeys("556677");
			driver.findElement(By.xpath("//input[@value='Find My Login Info']")).click();
		
			if(driver.findElement(By.className("title")).getText().contains("Customer"))
			{
				System.out.println("Details loaded successfully ");
			}
			else if(driver.findElement(By.className("title")).getText().contains("Error"))
			{
				System.out.println("Customer details couldn't load ");
			}
			System.out.println("Forget info test is passed");
		}
		catch(Error e) {
			System.out.println("Failed to get user details ");
			
		}	
	}

	private static void ContactUs(WebDriver driver) {
		// TODO Auto-generated method stub
		try{
				Assert.assertTrue(driver.findElement(By.linkText("contact")).isDisplayed());
				driver.findElement(By.linkText("contact")).click();
				driver.findElement(By.id("name")).sendKeys("Amanda");
				driver.findElement(By.id("email")).sendKeys("test@test.com");			
				driver.findElement(By.id("phone")).sendKeys("02102234595");
				driver.findElement(By.id("message")).sendKeys("This is a message");
				driver.findElement(By.xpath("//input[@value='Send to Customer Care']")).click();
				driver.findElement(By.linkText("home")).click();
				System.out.println("Contact Us Test is passed");
		}
		catch(Error e) {
			System.out.println("Error in loading page"+e.getMessage());
		}
	}

	private static void loginUser(String UserName,WebDriver driver) {
		// TODO Auto-generated method stub
		try{
				Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Log In']")).isDisplayed());		
				driver.findElement(By.name("username")).sendKeys(UserName);
				driver.findElement(By.name("password")).sendKeys("PassWord123");
				driver.findElement(By.xpath("//input[@value='Log In']")).click();
				ValidateAndSignOut("Log In",driver);
			}
			catch(Error e) {
				System.out.println("Error while login "+e.getMessage());
			}
	}

	private static String registerUser(WebDriver driver) {
		// TODO Auto-generated method stub
		String UserName;
		int RandomNumber;
		
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
			ValidateAndSignOut("Register",driver);
		}
		catch(Error e){
			System.out.println("Page Failed to Load..");
		}
		return UserName;
	}

	private static void ValidateAndSignOut(String Method ,WebDriver driver) {
		// TODO Auto-generated method stub
		
		try{
			System.out.println(Method+"Test is passed ");
			driver.findElement(By.linkText("Log Out")).click();
		}
		catch(Error e) {
			System.out.println(e.toString());
		}	
	}

}
