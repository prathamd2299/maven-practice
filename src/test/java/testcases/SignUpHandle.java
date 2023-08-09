package testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.LoginPageObject;
import pageObjectModel.SignUpPageObject;
import resources.BrowserHandle;

public class SignUpHandle extends BrowserHandle {
	@Test
	public void signup() throws InterruptedException, IOException {
		LoginPageObject lpo = new LoginPageObject(driver);
		Thread.sleep(5000);
		lpo.clickOnTryForFree().click();
		System.out.println("clicked on Try for free button...");
		Thread.sleep(3000);
		// Hard assertion
		Assert.assertEquals(driver.getTitle(), "Free CRM Trial: Salesforce 30-Day Trial - Salesforce IN");
		Thread.sleep(3000);
		SignUpPageObject reg = new SignUpPageObject(driver);
// *********** FirstName Textbox *************
		reg.enterFirstname().sendKeys("Prathamesh");
		System.out.println("Firstname value is: " + reg.enterFirstname().getAttribute("value"));
		Thread.sleep(2000);
// ***************LastName Textbox *************
		reg.enterLastname().sendKeys("Dhasade");
		System.out.println("Lastname value is: " + reg.enterLastname().getAttribute("value"));
		Thread.sleep(2000);
// *********	Email Textbox ****************	
		reg.enterEmail().sendKeys("prathameshdhasade99@gmail.com");
		System.out.println("Email value is: " + reg.enterEmail().getAttribute("value"));
		Thread.sleep(2000);
// ***************	Job Title Dropdown *****************
		WebElement jobTitleDrp = reg.selectJobTitle();
		Thread.sleep(2000);
		jobTitleDrp.click();

		Select select = new Select(jobTitleDrp);

		// Get the list of all the options
		System.out.println("The job title dropdown options are -");

		List<WebElement> options = select.getOptions();

		for (WebElement option : options)
			System.out.println(option.getText());

		select.selectByIndex(6);
		System.out.println("Selected option is: " + select.getFirstSelectedOption().getText());
		Thread.sleep(2000);
// ****************	Company Name Textbox ************ 		
		reg.enterCompanyName().sendKeys("SsquareIt");
		System.out.println("CompanyName value is: " + reg.enterCompanyName().getAttribute("value"));
		Thread.sleep(2000);
// ******************	Employee Dropdown *********** 	
		WebElement employeeDrp = reg.selectEmployee();
		Thread.sleep(2000);
		employeeDrp.click();

		Select select1 = new Select(employeeDrp);

		// Get the list of all the options
		System.out.println("The dropdown employee options are -");

		List<WebElement> employees = select1.getOptions();

		for (WebElement employee : employees)
			System.out.println(employee.getText());

		select1.selectByIndex(2);
		System.out.println("Selected option is: " + select1.getFirstSelectedOption().getText());
		Thread.sleep(2000);

// ****************	Phone Number Textbox **************	
		reg.enterPhoneNumber().sendKeys("9834530434");
		System.out.println("Phone number value is: " + reg.enterPhoneNumber().getAttribute("value"));
		Thread.sleep(2000);

// ****************	Country Dropdown **************	
		WebElement countryDrp = reg.selectCountry();
		Thread.sleep(2000);
		countryDrp.click();

		Select select2 = new Select(countryDrp);
		// Get the list of all the options
		System.out.println("The country dropdown options are -");

		List<WebElement> countries = select2.getOptions();

		for (WebElement country : countries) {
			System.out.println(country.getText());
		}

		select2.selectByVisibleText("India");
		System.out.println("Selected option is: " + select2.getFirstSelectedOption().getText());
		countryDrp.sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}
}
