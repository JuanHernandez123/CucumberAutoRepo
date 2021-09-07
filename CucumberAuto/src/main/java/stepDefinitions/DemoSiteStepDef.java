package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.When;
import testManagers.DriverManager;

public class DemoSiteStepDef {
	WebDriver driver;
	DriverManager driverManger = new DriverManager();

	public DemoSiteStepDef(DriverManager driverManger) {
		driver = driverManger.setUpDriver("http://demo.automationtesting.in/Register.html");
	}

	@When("^I fill the first name$")
	public void i_fill_the_first_name() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tom");
		Thread.sleep(5000);
	}

	@When("^I fill the last name$")
	public void i_fill_the_last_name() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Yerry");
		Thread.sleep(5000);
	}
	
}
