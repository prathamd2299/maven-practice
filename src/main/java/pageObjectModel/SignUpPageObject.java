package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageObject {
	public WebDriver driver;

	private By firstname = By.xpath("//input[@name='UserFirstName']");
	private By lastname = By.xpath("//input[@name='UserLastName']");
	private By email = By.xpath("//input[@name='UserEmail']");
	private By jobTitle = By.xpath("//select[@name='UserTitle']");
	private By companyName = By.xpath("//input[@name='CompanyName']");
	private By employee = By.xpath("//select[@name='CompanyEmployees']");
	private By phoneNumber = By.xpath("//input[@name='UserPhone']");
	private By country = By.xpath("//select[@name='CompanyCountry']");

	public SignUpPageObject(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebElement enterFirstname() {
		return driver.findElement(firstname);
	}

	public WebElement enterLastname() {
		return driver.findElement(lastname);
	}

	public WebElement enterEmail() {
		return driver.findElement(email);
	}

	public WebElement selectJobTitle() {
		return driver.findElement(jobTitle);
	}

	public WebElement enterCompanyName() {
		return driver.findElement(companyName);
	}

	public WebElement selectEmployee() {
		return driver.findElement(employee);
	}

	public WebElement enterPhoneNumber() {
		return driver.findElement(phoneNumber);
	}

	public WebElement selectCountry() {
		return driver.findElement(country);
	}

}
