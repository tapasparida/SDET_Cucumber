package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions_JobProject"},
    tags = "@hrm1",
    plugin = {"pretty","html:target/cucumber-reports/html_report.html"},
    publish = true,
    monochrome = true
)
public class Activities_ProjectRunner {

}
