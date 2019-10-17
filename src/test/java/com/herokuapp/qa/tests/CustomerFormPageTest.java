package com.herokuapp.qa.tests;



import java.awt.AWTException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.CustomerFormPage;
import com.herokuapp.qa.pages.CustomerPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;

public class CustomerFormPageTest extends Base {
	LoginPage loginpage;
	HomePage  homepage;
	CustomerFormPage customerForm;
	CustomerPage customerpage;
	
	public CustomerFormPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));	
		customerpage=new CustomerPage();
		customerForm=new CustomerFormPage();
	}
	@Test(priority=29,description="Fill the customer form details")
	public void Customer() throws InterruptedException, AWTException {
		
		customerpage.Customer_click();
		Thread.sleep(1000);
		customerpage.click_addcustomer();
		Thread.sleep(1000);
		customerForm.Enter_Customername();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		customerForm.select_Logo();
		customerForm.Enter_email();
		customerForm.Enter_siretNumber();
		
		customerForm.Enter_siretNumber();
		Thread.sleep(2000);
		customerForm.Save() ;
		Thread.sleep(2000);
		customerForm.VerifyCustomername();
		customerForm.DeleteCustomer();
		
		
		
	
}
}
