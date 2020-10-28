package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitionsCRM"},
   //tags = "@Activity1_1"
   //tags = "@activity1_2",
     //tags = "@activity1_3",
    tags = "@crmActivity1",
    plugin = {"pretty","html:target/cucumber-reports/reports.html"},
    monochrome = true
)

public class ActivityRunner1 {
   
}


