package seleniumPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ParaBankHome {
	
	WebDriver driver;
	
	By txtUserName = By.name("username");
	By txtPassword = By.name("password");
	By LnkLogin = By.xpath("//input[@value='Log In']");
	By LnkForgetInfo = By.linkText("Forgot login info?");
	By LnkRegister = By.linkText("Register");
	By LnkAbout = By.linkText("about");
	By lnkHome = By.linkText("home");
	By lnkLogOut = By.linkText("Log Out");
	
	public ParaBankHome(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUserName(String name) {
		driver.findElement(txtUserName).sendKeys(name);
	}
	
	public void entePassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(LnkLogin).click();
	}
	public void clickRegisterButton() {
		driver.findElement(LnkRegister).click();
	}
	public void clickAboutButton() {
		driver.findElement(LnkAbout).click();
	}
	public void clickHomeButton() {
		driver.findElement(lnkHome).click();
	}
	public void clickForgetInfo() {
		driver.findElement(LnkForgetInfo).click();
	}
	public void verifyLogIn() {
		Assert.assertTrue(driver.findElement(lnkLogOut).isDisplayed());
		
	}

}
