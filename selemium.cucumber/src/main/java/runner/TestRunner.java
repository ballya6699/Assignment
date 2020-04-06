package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="features", 
		glue={"stepDefination"},
		plugin={"html:target/cucumber-html-report",
				"usage:target/cucumber-usage.json",
				"json:target/cucumber.json"}
		)
public class TestRunner 
{

}
