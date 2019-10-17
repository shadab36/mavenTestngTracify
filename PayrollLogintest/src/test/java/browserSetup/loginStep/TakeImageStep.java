package browserSetup.loginStep;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import browserSetup.BrowserSetup;
import cucumber.api.Scenario;
import cucumber.api.java.After;



	public class TakeImageStep extends BrowserSetup {
		@After
		public void tearDown(Scenario scenario) {
		    if (scenario.isFailed()) {	    	
		      log.info("Scenario failed, now taking screenshot");
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.embed(screenshot, "image/png");
		    }
		}
	}
