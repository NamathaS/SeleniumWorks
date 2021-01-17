package SeleniumMethodsAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		//Navigate to the url
		driver.get("https://parabank.parasoft.com/parabank/index.htm");		
		System.out.println("Parabank website opened ... ");
		
		driver.manage().window().maximize();
		
	
		//1. Find Method 
		System.out.println("Find the element : "+ driver.findElement(By.name("username")).getTagName());
		
		//2. Send key methods
		driver.findElement(By.name("username")).sendKeys("User123");
		driver.findElement(By.name("password")).sendKeys("Password123");
	

		//3. Clear the text box 
		driver.findElement(By.name("password")).clear();
		
		// Re-entered te value 
		driver.findElement(By.name("password")).sendKeys("Password123");
	
		//4. Click the  Element
		
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		//5. Get Attribute 
		System.out.println(driver.findElement(By.className("title")).getAttribute("className"));
		
		//6. css property
		System.out.println("background-color"+driver.findElement(By.linkText("Home")).getCssValue("background-color"));
		
		//7. css property font size
		System.out.println("Font size "+driver.findElement(By.className("title")).getCssValue("font-size"));
		//8.location
		System.out.println("Location :"+driver.findElement(By.linkText("Log Out")).getLocation());

		driver.close();
	}

}
