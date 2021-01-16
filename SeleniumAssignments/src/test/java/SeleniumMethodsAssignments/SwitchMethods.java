package SeleniumMethodsAssignments;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchMethods {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		switchToAlertBoxes(driver);
		switchManyAlers(driver);
		switchToFrame(driver);
		switchToAnotherWindow(driver);
		driver.close();
		driver.quit();
	}

	private static void switchManyAlers(WebDriver driver) {
		// TODO Auto-generated method stub
		
		//Navigate to website
		driver.get("https://demoqa.com/alerts");
		System.out.println("Website is opened ");
		
		//First Alert Box 
		System.out.println("First Alert box");
		driver.findElement(By.id("alertButton")).click();
		System.out.println("First alert message is accepted..");
		
		//Navigate to Alert message
		driver.switchTo().alert().accept();
		
		//Second Alert Box 
		System.out.println("");
		System.out.println("Second Alert box");
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println("Second timed alert message is accepted..");
		
		//Third Alert Box 
		System.out.println("");
		System.out.println("Third Alert box - Accept Alert ");
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().accept();
		System.out.println("Accepted value :"+driver.findElement(By.id("confirmResult")).getText());

		
		System.out.println("");
		System.out.println("Third Alert box - Dismiss Alert ");
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("Accepted value :"+driver.findElement(By.id("confirmResult")).getText());
		
		driver.navigate().refresh();
		//Fourth Alert Box 
		System.out.println("");
		System.out.println("Fourth  Accept box ");
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("Namatha");
		driver.switchTo().alert().accept();
		System.out.println("Prompt message : "+driver.findElement(By.id("promptResult")).getText());
		
	}

	private static void switchToFrame(WebDriver driver) {
		// TODO Auto-generated method stub
		
		//Navigate to website
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		System.out.println("Website is opened ");
		
		//Access Frame element 
		driver.switchTo().frame("additionalInfo");
		System.out.println("Accessed Frame element");
		driver.findElement(By.id("contactPersonName")).sendKeys("Namatha");
		driver.findElement(By.id("contactPersonPhone")).sendKeys("0210224563");
		
		//Display the details entered
		System.out.println("");
		System.out.println("Contact Person Name"+ driver.findElement(By.id("contactPersonName")).getText());
		System.out.println("Contact Person Phone"+ driver.findElement(By.id("contactPersonPhone")).getText());
		
		//Navigate Back to Home Page
		driver.switchTo().defaultContent();
		System.out.println("");
		System.out.println("Naviagated back to page");
		//Display Item on Home page
		
		System.out.println("");
		System.out.println("Able to Access :"+driver.findElement(By.id("personalInfo")).getText());
		
		//Close browser
		/*
		 * driver.close(); System.out.println("");
		 * 
		 * System.out.println("Browser closed");
		 */
	}

	private static void switchToAlertBoxes(WebDriver driver) {
		// TODO Auto-generated method stub
			
		//Navigate to website
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		System.out.println("Website is opened ");
		
		//Click on Third Party Button
		driver.findElement(By.id("thirdPartyButton")).click();
		System.out.println("Accept the agreement ");
		System.out.println("");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("thirdPartyResponseMessage")).getText());
		System.out.println("");
		
		System.out.println("Dismiss the agreement ");
		System.out.println("");
		driver.findElement(By.id("thirdPartyButton")).click();
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("thirdPartyResponseMessage")).getText());
				
		/*
		 * driver.close(); System.out.println("Browser closed after");
		 */
	}

	private static void switchToAnotherWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		
		//Navigate to website
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		System.out.println("Website is opened ");
		
		//Get parent window handle 
		String ParentHandle = driver.getWindowHandle();
		System.out.println("Parent page handle is :"+ParentHandle);
		System.out.println("");
		
		//Navigate to another page
		driver.findElement(By.xpath(".//button[text()='Related documents (click)']")).click();
		
	
		Set<String> AllWindowHandles = driver.getWindowHandles();
		//iterate through all open windows and take control to the last / new window
		for(String Handle:AllWindowHandles) {
			driver.switchTo().window(Handle);
			System.out.println("Current Window Title : "+driver.getTitle());
			
		}
		System.out.println("Total number of windows opened .. :"+AllWindowHandles.size());
		
		//Get New Window handle 
		String ChildHandle = driver.getWindowHandle();
		System.out.println("Child page handle is :"+ChildHandle);
		System.out.println("Current Child Window Title : "+driver.getTitle());
		System.out.println("");
		
		//Navigate back to parents 
		driver.switchTo().window(ParentHandle);
		System.out.println("Current Parent Window Title : "+driver.getTitle());
		/*
		 * driver.close(); System.out.println("Closed Parent Window");
		 * driver.switchTo().window(ChildHandle); driver.close();
		 * System.out.println("Closed Child Window");
		 */
	}

}
