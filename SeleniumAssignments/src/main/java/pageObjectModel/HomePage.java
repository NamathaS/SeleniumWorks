package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;
	
	By txtUserName = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath(".//input[@value='Log In']");
	By lnkRegister = By.linkText("Register");
	By lnkLogOut = By.linkText("Log Out");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUserName() {
		driver.findElement(txtUserName).sendKeys("manty");
	}
	
	public void enterPassword() {
		driver.findElement(txtPassword).sendKeys("manty1");
	}
	
	public void clickLogin() {
		driver.findElement(btnLogin).click();
	}
	
	public void clickRegister() {
		driver.findElement(lnkRegister).click();
	}
	
	public void verifyLogout() {
		Assert.assertTrue(driver.findElement(lnkLogOut).isDisplayed());
		
	}
}
