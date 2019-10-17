package com.herokuapp.qa.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.ColleaguesPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;

public class ColleaguesPageTest extends Base{
	
	LoginPage loginpage;
	HomePage  homepage;
	ColleaguesPage colleaguespage;
	
	
	public ColleaguesPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));	
		colleaguespage=new ColleaguesPage();
	}
	@Test(priority=30,description="Test ColleaguesPage")
	public void 	colleagues_link() throws InterruptedException, AWTException {
		colleaguespage.Colleagues();
		String Ctitle= colleaguespage.Title();
		assertEquals(Ctitle, "Collègues","colleagues title is not matched");
}
}