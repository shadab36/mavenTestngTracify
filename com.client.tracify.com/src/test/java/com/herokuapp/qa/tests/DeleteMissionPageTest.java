package com.herokuapp.qa.tests;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.DeleteMissionPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;


public class DeleteMissionPageTest extends Base {


	LoginPage loginpage;
	HomePage homepage;
	DeleteMissionPage deleteMission;

public DeleteMissionPageTest() {
	super();
}

@BeforeMethod
 public void setup() throws MalformedURLException {
	 initialization();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		deleteMission=new DeleteMissionPage();
		
 }




@Test (priority=15, description="update the created record")
public void veriflabel() throws Throwable {
	deleteMission.Delet_mission();
	 Thread.sleep(1000);
	 deleteMission.Delete_mission();
	 Thread.sleep(1000);
}
}
