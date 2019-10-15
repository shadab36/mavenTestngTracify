package com.herokuapp.qa.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.CustomerPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;

public class CustomerPageTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerpage;
	
	public CustomerPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));	
		customerpage=new CustomerPage();
	}
	@Test(priority=28,description="verify the all CTA on customer page")
	public void Customer() throws InterruptedException {
		customerpage.Customer_click();
		Thread.sleep(1000);
		String Ctitle= customerpage.cPage();
		assertEquals(Ctitle, "https://tracify-test.herokuapp.com/customers/","Customer Page URL does not match");
		
		customerpage.click_addcustomer();
		
		String Cform=customerpage.verify_addcustomer();
		assertEquals(Cform, "Ajouter un client","Customer form tile is not matched");
		Thread.sleep(2000);
		customerpage.Verify_Save_OnlyButton();
		customerpage.Verify_SaveAnd_NewButton();
		customerpage.Verify_SaveAnd_AddContactButton();
		customerpage.Verify_addAddress_OnlyButton();
		customerpage.Verify_reister_OnlyButton();
		customerpage.Verify_CancelButton();
		
	
}
}