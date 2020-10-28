package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitionsHRM"},
		tags = "@activity1",
		dryRun = false,
		plugin = {"pretty","html: test-reports"},
	    monochrome = true
	)


	public class ActivityRunner2 {

	}