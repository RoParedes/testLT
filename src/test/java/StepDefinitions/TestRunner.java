package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefinitions"},
monochrome=true,
plugin={"pretty","junit:target/reports/cucumber.xml"},
tags="@StandardUser", dryRun=false)
public class TestRunner {

}
