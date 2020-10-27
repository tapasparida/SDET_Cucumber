package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
   //tags = "@Activity1_1"
   //tags = "@activity1_2",
     //tags = "@activity1_3",
    tags = "@jobBoard1",
    plugin = {"pretty","html:target/cucumber-reports/reports"},
    monochrome = true
)

public class ActivitiesRunner {
   
}
