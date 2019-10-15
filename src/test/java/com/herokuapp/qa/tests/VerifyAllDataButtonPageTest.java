package com.herokuapp.qa.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.herokuapp.qa.pages.VerifyAllDataButtonPage;

public class VerifyAllDataButtonPageTest extends Base{
	LoginPage loginpage;
	HomePage  homepage;
	VerifyAllDataButtonPage Databutton;
	public VerifyAllDataButtonPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		Databutton=new VerifyAllDataButtonPage();
		
	}
	@Test(priority=21, description="verify the search filed")
	public void searchandnextprevios_button() throws InterruptedException {
		Databutton.search();
	}
	
	@Test(priority=22, description="verify the copy button")
	public void Importcopy() throws InterruptedException {
		Databutton.Copy();
	
	}
	@Test(priority=23, description="verify the csv button")
	public void Importcsv() throws InterruptedException {
		Databutton.csv();
	}
	@Test(priority=24,description="verify the excel button")
	public void Impotexcel() throws InterruptedException {
		Databutton.excel();
	}
	@Test(priority=25,description="verify the pdf button")
	public void Importpdf() throws InterruptedException {
		Databutton.pdf();
	}
	@Test(priority=26,description="verify the print button")
	public void Importprint() throws InterruptedException {
		Databutton.print();
	}
	@Test(priority=27,description="verify next and previous button")
	public void nextandprevious() throws InterruptedException {
		Databutton.NextandPreviosButton();
	}
}
