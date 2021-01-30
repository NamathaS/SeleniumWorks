package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Register {
	
	WebDriver driver;
	By  txtFirstName = By.id("firstName");
	By 	txtLastName = By.id("lastName");
	By 	txtStreet = By.id("address.street");
	By 	txtCity = By.id("address.city");
	By 	txtState = By.id("address.state");
	By 	txtZipCode = By.id("address.zipCode");
	By 	txtSsn = By.id("ssn");
	By 	lnkLogin = By.xpath("//input[@value='Find My Login Info']");
	
	public Register(WebDriver driver) {
		this.driver=driver;
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
	public void enterZipCode(String ZipCode) {
		driver.findElement(txtZipCode).sendKeys(ZipCode);
	}
	public void enterSsn(String ssn) {
		driver.findElement(txtSsn).sendKeys(ssn);
	}
	public void clickLoginLink() {
		driver.findElement(lnkLogin).click();
	}
	
	public void verifyRegisterPage() {
		Assert.assertTrue(driver.getTitle().contains("Register"));
	}
}
