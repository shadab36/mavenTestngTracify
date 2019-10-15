package com.herokuapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class LoginPage extends Base {

	//page Factory- OR:

		@FindBy(id="username")
		WebElement username;
		
		
		@FindBy(id="password")
		WebElement password;
		
		
		
		@FindBy(css="body>div.app-content.container.center-layout.mt-2 > div > div.content-body form > button")
		WebElement loginbutton;
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		public static String verifyloginpage() {
			
			return driver.getTitle();
		}
		
		public HomePage login(String UN,String PWD) {
		
			if(username.isDisplayed()) {
				logger.info("usernameFiled is dispalyed");
				username.sendKeys(UN);	
			}
			if(password.isDisplayed()) {
				logger.info("passwordFiled is dispalyed");
				password.sendKeys(PWD);	
			}
			if(loginbutton.isDisplayed()) {
				logger.info("login button is dispalyed");
			loginbutton.click();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
			return new HomePage();
			
		}

	
	
		
		
		

}