package com.herokuapp.qa.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.CreateMissionsPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.herokuapp.qa.pages.UpdateMissionPage;

public class UpdateMissionPageTest extends Base{
	String sheetName="create_mission";
	LoginPage loginpage;
	HomePage homepage;
	CreateMissionsPage createmission;
	UpdateMissionPage updatemission;

public UpdateMissionPageTest() {
	super();
}

@BeforeMethod
 public void setup() throws MalformedURLException {
	 initialization();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		 updatemission=new UpdateMissionPage();
		 createmission=new CreateMissionsPage();
 }

@Test (priority=14, description="update the created record")
public void verifymissionlabel() throws Throwable {
	 updatemission.Click_Departement();
	 Thread.sleep(1000);
	createmission.Select_date();
	 Thread.sleep(1000);
		createmission.Save_mission();
		 Thread.sleep(1000);
}
}