package browserSetup;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cucumber.listener.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BrowserSetup{ 
	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static String browserName;
	public static Logger log;
	public static WebElement webelement;
	public static String local_chrome;
	public static String local_FFbrowser;
@BeforeClass
	public static void before_Class() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader("configure//Configure.properties"));
		AppURL = property.getProperty("App_url");
		local_chrome = property.getProperty("local_chrome");
		local_FFbrowser= property.getProperty("local_FFbrowser");
		// on source lab setup
		AppURL = property.getProperty("App_url");
		System.out.println("Bname=====" + AppURL);

//		 if (browser.equalsIgnoreCase("chrome"))
		if ((local_chrome.equals("yes"))) {
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			// Set ACCEPT_SSL_CERTS  variable to true
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			Thread.sleep(1000);
		}
			// if (browser.equalsIgnoreCase("firefox"))
			
			// if (browser.equalsIgnoreCase("chrome"))
			else if((local_FFbrowser.equals("yes"))) {
				WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		
				Thread.sleep(1000);
		}
		else {
			
	System.out.println("platform does not provide");
		
		}
		
		
		
		}
	
	@AfterClass
	public static void after_Class() throws InterruptedException {

		driver.quit();
		Thread.sleep(2000);
//		driver = null;
	}

}



