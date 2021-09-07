package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import testManagers.DriverManager;

public class MyFirstStepDef {

	WebDriver driver;

	public MyFirstStepDef(DriverManager driverManger) {
		driver = driverManger.setUpDriver(
				"https://www.facebook.com/campaign/landing.php?&campaign_id=1661872069&extra_1=s%7Cc%7C320310174887%7Ce%7Cfacebook%7C&placement=&creative=320310174887&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D1661872069%26adgroupid%3D64818685900%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-541132862%26loc_physical_ms%3D1003659%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMI_tKIu9667wIVUopaBR0rBgbfEAAYASAAEgJk6PD_BwE");
	}

	@When("^User enters user \"([^\"]*)\" first name$")
	public void user_enters_user_first_name(String username) {
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(username);
	}

	@Then("^User checks user \"([^\"]*)\" name is present$")
	public void user_checks_user_name_is_present(String usernameVerification) {
		String userNameActual = driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value");
		Assert.assertEquals(usernameVerification, userNameActual);
	}

	@And("^User enters user \"([^\"]*)\" surname$")
	public void user_enters_user_surname(String surname) {
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(surname);
	}

	@Then("^User Mobile field should be blank$")
	public void user_Mobile_field_should_be_blank() {
		String mobileField = driver.findElement(By.xpath("//input[@name='reg_email__']")).getAttribute("value");
		Assert.assertEquals("", mobileField);
	}

	@When("^Enter following data$")
	public void enter_following_data(DataTable table) throws InterruptedException {

		/*
		 * List<List<String>> data = table.raw(); // Row/Column -- get the fist row
		 * String data1 = data.get(0).get(0); String data2 = data.get(0).get(1); String
		 * data3 = data.get(0).get(2);
		 * 
		 * //Get the second row String data4 = data.get(1).get(0); String data5 =
		 * data.get(1).get(1); String data6 = data.get(1).get(2);
		 * 
		 * //Get the third row String data7 = data.get(2).get(0); String data8 =
		 * data.get(2).get(1); String data9 = data.get(2).get(2);
		 * 
		 * driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(data4);
		 * driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data5);
		 * driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(data6);
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(data7);
		 * driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data8);
		 * driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(data9);
		 * Thread.sleep(2000);
		 */

		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));

		for (int i = 1; i < table.raw().size(); i++) { // Rows
			for (int j = 0; j < (table.raw().get(i).size() - 1); j++) {// Columns
				firstname.clear();
				firstname.sendKeys(table.raw().get(i).get(j));
				Thread.sleep(2000);
				lastname.clear();
				lastname.sendKeys(table.raw().get(i).get(++j));
				Thread.sleep(2000);
				mobile.clear();
				mobile.sendKeys(table.raw().get(i).get(++j));
				Thread.sleep(2000);
			}
		}
	}
}
