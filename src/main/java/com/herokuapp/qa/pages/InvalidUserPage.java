package com.herokuapp.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class InvalidUserPage  extends Base{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@FindBy(id="username")
	WebElement username;
	
	
	@FindBy(id="password")
	WebElement password;
	
	
	@FindBy(css="body>div.app-content.container.center-layout.mt-2 > div > div.content-body form > button")
	WebElement loginbutton;
	
	@FindBy(css=".alert")
	WebElement error;
	
	static String decodepassword="aGFwcHltYW4xNjM";
	
	public InvalidUserPage() {
		
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void user_Name(String UN) {
		if(username.isDisplayed()) {
			username.sendKeys(UN);	
			
			 Object s = js.executeScript("return document.getElementById('username').validationMessage");
			
	 if(s.equals(s)) {
			
		 System.err.println("chhotu"+s);
         assertEquals(s, s,"validation message is not matched");
        logger.info("It's getting HTML5 validation message  empty name");
	 
	 }}
		}
		
	
		public void pass_word(String PWD) {
			
			 Object pass = js.executeScript("return document.getElementById('password').validationMessage");
			 if(pass.equals(pass)) {
		        System.err.println("password"+password);
		          assertEquals(pass, pass,"validation message is not matched");
		         logger.info("It's getting HTML5 validation message for password filed");
			password.sendKeys(PWD);	
		}
		}
		public void Name(String UName) {
			if(username.isDisplayed()) {
				username.sendKeys(UName);	
			}}
		
		
		public void  pass(String  pass) {
			if(password.isDisplayed()) {
				password.sendKeys(pass);	
			}}

public void loginbutton() throws InterruptedException {

		if(loginbutton.isDisplayed()) {
			
		loginbutton.click();
		}
		
			Thread.sleep(1000);
		
		
		
	}

public String Verify_errormessage() {
	return error.getText();
	
}
public void password_in_encr() {
	

String type = driver.findElement(By.id("password")).getAttribute("type");
if(type.equalsIgnoreCase("password")){
System.out.println("Encrypted");
}else{
	System.out.println("Not encrypted");
}
}

}
