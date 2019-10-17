package com.herokuapp.qa.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.herokuapp.qa.pages.MissionProductionPage;

public class MissionProductionPageTest extends Base{
	
	LoginPage login;
	HomePage homepage;
	MissionProductionPage missionProduct;
	
	
	public MissionProductionPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		login=new LoginPage();
		homepage = login.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		 missionProduct=new MissionProductionPage();
	}

	
@Test(priority=16, description="verify current mission production page title")
public void VerifyCurrentMission() throws InterruptedException {
	missionProduct.HoverMission_production();
	String Current_mission= missionProduct.current_missionUrl();
	assertEquals(Current_mission, "https://tracify-test.herokuapp.com/tasksmanager/list-prod/","title filed does not matched");	
	
	
	
}
@Test(priority=17, description="verify pending mission production page title")
public void pendingMission() throws InterruptedException {
	missionProduct.HoverMission_production();
	String Current_mission= missionProduct.pending_missionUrl();
	assertEquals(Current_mission, "https://tracify-test.herokuapp.com/tasksmanager/list-waiting/","title filed does not matched");	
	
	
	
}
@Test(priority=18, description="verify compelte mission production page title")
public void completeMission() throws InterruptedException {
	missionProduct.HoverMission_production();
	String Current_mission= missionProduct.complete_missionUrl();
	assertEquals(Current_mission, "https://tracify-test.herokuapp.com/tasksmanager/list-done/","title filed does not matched");	
	
	
	
}
@Test(priority=19, description="verify all mission production page title")
public void allMission() throws InterruptedException {
	missionProduct.HoverMission_production();
	String Current_mission= missionProduct.all_follow_missionUrl();
	assertEquals(Current_mission, "https://tracify-test.herokuapp.com/tasksfollower/","title filed does not matched");	
	
	
	
}

}
