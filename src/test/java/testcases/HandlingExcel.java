package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.LoginPageObject;
import resources.BrowserHandle;

public class HandlingExcel extends BrowserHandle {
	@Test
	public void excel() throws IOException, InterruptedException {
		FileInputStream fs = new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop\\Book1data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0); // to select first sheet
		XSSFRow row = sheet.getRow(0); // to select first row
		XSSFCell cell1 = row.getCell(0); // to select first cell
		System.out.println(cell1);
		XSSFCell cell2 = row.getCell(1); // to select first cell
		System.out.println(cell2);
		String c1 = cell1.toString();
		String c2 = cell2.toString();

		LoginPageObject lpo = new LoginPageObject(driver);
		Thread.sleep(2000);
		lpo.enterUsername().sendKeys(c1);
		Thread.sleep(2000);
		lpo.enterPassword().sendKeys(c2);
		Thread.sleep(2000);
		lpo.clickOnLogin().click();

		// Hard assertion
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actual = lpo.errorMessage().getText();

		Assert.assertEquals(actual, expected, "error message is not correct");
		System.out.println("hard assertion pass");

		// Soft assertion
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected);
		System.out.println("soft assertion pass");
		// This is required to see the exceptions,
		// otherwise, the tester won't know what passed and what failed.
		sa.assertAll();
	}
}
