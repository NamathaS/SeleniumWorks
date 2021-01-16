package SeleniumMethodsAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaviagationMethods {

	static WebDriver edgeDriver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		
		edgeDriver = new EdgeDriver();
		edgeDriver.manage().window().maximize();
		
		edgeDriver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");		
		System.out.println("Para bank website is opened ");
		
		System.out.println("Initial Title"+ edgeDriver.getTitle());
		System.out.println("");
		
		//Naviagate to register page 
		edgeDriver.findElement(By.linkText("Register")).click();
		System.out.println("Navigated Title"+ edgeDriver.getTitle());
		System.out.println("");
		
		edgeDriver.navigate().back();
		System.out.println("Title back page"+ edgeDriver.getTitle());
		System.out.println("");
		
		edgeDriver.navigate().forward();
		System.out.println("Forward Title"+ edgeDriver.getTitle());
		System.out.println("");
		
		edgeDriver.close();
		System.out.println("Broser closed");
		System.out.println("");
		
		edgeDriver.quit();
		System.out.println("Broser object closed");
		System.out.println("");
	}

}
