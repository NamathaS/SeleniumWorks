package seleniumPOM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {
	
	WebDriver driver;
	
	By LnkRegister = By.linkText("Register");
	By txtFirstName = By.id("customer.firstName");
	By txtLastName = By.id("customer.lastName");
	By txtStreet = By.id("customer.address.street");
	By txtCity = By.id("customer.address.city");
	By txtState =By.id("customer.address.state");
	By txtZipCode =By.id("customer.address.zipCode");
	By txtPhone = By.id("customer.phoneNumber");
	By txtSsn = By.id("customer.ssn");
	By txtUserName = By.id("customer.username");
	By txtPassWord = By.id("customer.password");
	By txtConfirmPassword = By.id("repeatedPassword");
	By ButtonRegister = By.xpath("//input[@value='Register']");
	By lnkLogOut = By.linkText("Log Out");
	
	public Registration(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterFirstName(String FirstName) {
		driver.findElement(txtFirstName).sendKeys(FirstName);
	}
	public void enterLastName(String LastName) {
		driver.findElement(txtLastName).sendKeys(LastName);
	}
	public void enterStreet(String Street) {
		driver.findElement(txtStreet).sendKeys(Street);
	}
	public void enterCity(String City) {
		driver.findElement(txtCity).sendKeys(City);
	}
	public void enterState(String State) {
		driver.findElement(txtState).sendKeys(State);
	}
	public void enterZip(String Zip) {
		driver.findElement(txtZipCode).sendKeys(Zip);
	}
	public void enterSsn(String Ssn) {
		driver.findElement(txtSsn).sendKeys(Ssn);
	}
	public void enterPhoneNumber(String PhoneNumber) {
		driver.findElement(txtPhone).sendKeys(PhoneNumber);
	}
	public void enterUserName(String UserName) {
		driver.findElement(txtUserName).sendKeys(UserName);
	}
	public void enterPassword(String Password) {
		driver.findElement(txtPassWord).sendKeys(Password);
	}
	public void enterConfirmPassword(String ConfirmPassword) {
		driver.findElement(txtConfirmPassword).sendKeys(ConfirmPassword);
	}
	public void clickRegisterButton() {
		driver.findElement(ButtonRegister).click();
	}
	public void clickRegisterLink() {
		driver.findElement(LnkRegister).click();
	}
	public void verifyRegisterPage() {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Register"));
		System.out.println("Verified Registration Page Title");
	}
	public void verifyLogOutSuccessful() {
		Assert.assertTrue(driver.findElement(lnkLogOut).isDisplayed());
		
	}
	public void LogOut() {
		driver.findElement(lnkLogOut).click();
	}

	
	
	
	
	
}
