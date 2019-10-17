package ObjectRepository;

import org.openqa.selenium.By;

public class LoginObject {
	public static By UserId=By.cssSelector("#payrollpandaapp input[type='email']");
	public static By userpass = By.cssSelector("#payrollpandaapp input[type='password']");
	public static By login = By.cssSelector("#payrollpandaapp button[type='submit']");
	
	// Error message for invalid data
	public static By uesremail_val=By.cssSelector(".js-email");
	public static By pass_val=By.cssSelector(".js-password");
	public static By error_val=By.cssSelector("#payrollpandaapp div.js-error");
	public static By userprofile=By.cssSelector("#side-menu .text-muted.text-xs.block");
	public static By Logout=By.cssSelector("#side-menu li a[href='#logout']");
	
	


}
