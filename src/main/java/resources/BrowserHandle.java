package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandle {
	public static WebDriver driver;

	public void driverInitialization() throws IOException {
		// This will read the data
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\FirstProject\\src\\main\\java\\resources\\data.properties");

		// This will access the data
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");

//		if (browserName.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (browserName.equalsIgnoreCase("Edge")) {
//			driver = new EdgeDriver();
//		} else if (browserName.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			System.out.println("Browser is not valid");
//		}

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Invalid browser");
			break;
		}
	}

	@BeforeMethod
	public void openUrl() throws IOException {
		driverInitialization();
		driver.navigate().to("https://login.salesforce.com/?locale=in");
		System.out.println("This will execute before method");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		System.out.println("This will execute after method");
	}
}
