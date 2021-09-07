package testManagers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class DriverManager {

	WebDriver driver;

	String chromePath = "C:\\Users\\JMHR\\OneDrive\\Documentos\\Drivers\\chromedriver_win32\\chromedriver.exe";

	// Before keyword is executed in incrementing way first 1 after 2
	//	@Before(order=1)
	@Before
	public WebDriver setUpDriver(String url) {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			driver.get(url);
		}
		return driver;
	}

	// After keyword is executed in decrementing way first 2 after 1
	// @After(order = 2)
	@After	
	public void closeDriver() {
		System.out.println("After inside step1");
		System.out.println("After inside step1>>>>>>>>>>>>>>>>>>>><<<<<<<<<>>>>>>>>>>>");
		driver.quit();
		driver = null;
	}
}
