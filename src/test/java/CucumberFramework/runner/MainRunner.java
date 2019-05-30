package CucumberFramework.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"src/test/java/CucumberFramework/featurefiles/"},
		glue= {"CucumberFramework.stepFiles"},
		monochrome = true,
		plugin = {"pretty","html:taget/cucumber", 
				"json:taget/cucumber.json", 
				"com.cucumber.listner.ExtentCucumberFormatter:taget/report.html"}
	
		)


public class MainRunner {

}
