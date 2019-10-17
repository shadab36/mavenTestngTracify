package browserSetup;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "." },
plugin = { "pretty",
		"html:target/site/cucumber-pretty", "json:target/cucumber/cucumber.json", "usage:target/usage.jsonx",
		"junit:target/cucumber.xml"},
		monochrome = true
		,glue = {"browserSetup.loginStep"}
		,dryRun=false)

public class TestRuner {
	@BeforeClass  
	public static void beforeClass() throws Exception {
		BrowserSetup.before_Class();
		

	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		BrowserSetup.after_Class();
		

	}
	

}
