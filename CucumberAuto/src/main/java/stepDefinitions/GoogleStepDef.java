package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.When;
import testManagers.DriverManager;

public class GoogleStepDef {

	WebDriver driver;
	
	public GoogleStepDef(DriverManager driverManger){
		driver = driverManger.setUpDriver("https://www.google.com/");
	}
	
	@When("^I make a search using the string \"([^\"]*)\"$")
	public void i_make_a_search_using_the_string(String wordToSearch) throws Throwable {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(wordToSearch);
		Thread.sleep(5000);
	}

}
