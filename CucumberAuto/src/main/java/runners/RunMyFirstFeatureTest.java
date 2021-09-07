package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome=true, dryRun= false, strict = true, features = { "src/test/resources/featureFiles/"}, glue = "stepDefinitions/", 
plugin = {
		"pretty", 
		"html:target/cucumber-htmlreport", 
		"json:target/cucumber-report.json",
		"com.cucumber.listener.ExtentCucumberFormatter:target/ExtendReport.html"}, tags= {"@D1"})

public class RunMyFirstFeatureTest {

}
