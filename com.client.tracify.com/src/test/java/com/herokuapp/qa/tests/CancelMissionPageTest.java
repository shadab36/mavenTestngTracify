package com.herokuapp.qa.tests;



import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.CancelMissionPage;
import com.herokuapp.qa.pages.CreateMissionsPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;


public class CancelMissionPageTest extends Base{
	LoginPage loginpage;
	HomePage  homepage;
	CreateMissionsPage createmission;
	CancelMissionPage CancelPage;
	public CancelMissionPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		createmission=new CreateMissionsPage();
		CancelPage=new CancelMissionPage ();
	}
	
	

	@Test (priority=20, description="Cancel the mission create page")
	public void verifymissionlabel() throws Throwable {
		
		createmission.Select_all_department();
		createmission.Add_mission();
		
		createmission.Select_Département("Testing  New Department");	
		createmission.Select_Catégorie("Testing Category");
		createmission.Select_client("Client 1");	
		createmission.Select_responsible("chhotuManual");
		createmission.Select_projectManager("chhotuManual");
		createmission.Deadline("Test Deadline1 (Test Deadline1)");	
		createmission.Select_date();

	
			CancelPage.cancel_mission();
			Thread.sleep(1000);
			String Missiontable=driver.findElement(By.xpath("//h4[@class='card-title']")).getText();
			assertEquals(Missiontable, "Tableau Des Missions", "Not redirect on Mission Table");
			System.out.println(Missiontable=="Tableau Des Missions");
			
		
		
	
}
}
