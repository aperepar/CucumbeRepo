package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	monochrome=true,
	//dryRun=true,
	tags="@correr1", features= "FeaturesFiles",glue= "StepDefinitionRunner",
	plugin= {"pretty",
			"html:target/cucumber-htmlreport",
			"json:target/cucumber-report1.json",
			
	}
	
			)
	
	public class TestRunner {
	
	
		
		
	
}
