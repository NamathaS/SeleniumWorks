package SeleniumMethodsAssignments;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		System.out.println("Para Bank Website is opened ");
		
		//Switch to another window 
		System.out.println("Swith to another window .. ");
		System.out.println("");
		switchToAnotherWindow(driver);
		switchToAlertBoxes(driver);
	}

	private static void switchToAlertBoxes(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	private static void switchToAnotherWindow(WebDriver driver) {
		// TODO Auto-generated method stub
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
		driver.close();
		System.out.println("Closed Parent Window");
		driver.switchTo().window(ChildHandle);
		driver.close();
		System.out.println("Closed Child Window");
		
	}

}
