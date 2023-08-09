package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModel.LoginPageObject;
import resources.BrowserHandle;

public class LoginHandle extends BrowserHandle {
	@Test(dataProvider = "testData")
	public void login(String un, String pwd) throws InterruptedException, IOException {

		LoginPageObject lo = new LoginPageObject(driver);
		Thread.sleep(2000);
		lo.enterUsername().sendKeys(un);
		System.out.println("Username value is: " + lo.enterUsername().getAttribute("value"));
		Thread.sleep(2000);
		lo.enterPassword().sendKeys(pwd);
		System.out.println("Username value is: " + lo.enterPassword().getAttribute("value"));
		Thread.sleep(2000);
		lo.clickOnLogin().click();
		System.out.println("clicked on login button...");
		Thread.sleep(2000);
		// Hard assertion
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actual = lo.errorMessage().getText();

		Assert.assertEquals(actual, expected, "error message is not correct");
		System.out.println("hard assertion pass");
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] testData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "pratham";
		data[0][1] = "pratham@123";
		data[1][0] = "prat";
		data[1][1] = "pratham@123";
		data[2][0] = "test";
		data[2][1] = "test@123";
		return data;
	}

}
