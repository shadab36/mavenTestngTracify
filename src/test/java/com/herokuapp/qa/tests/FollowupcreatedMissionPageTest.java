package com.herokuapp.qa.tests;

import java.awt.AWTException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.CreateMissionsPage;
import com.herokuapp.qa.pages.FollowupcreatedMissionPage;
import com.herokuapp.qa.pages.HomePage;
import com.herokuapp.qa.pages.LoginPage;
import com.herokuapp.qa.util.TestUtil;

public class FollowupcreatedMissionPageTest extends Base {
	String sheetName = "CreateandFollowupMission";
	LoginPage loginpage;
	HomePage homepage;
	CreateMissionsPage createmission;
	FollowupcreatedMissionPage Followuppage;

	public FollowupcreatedMissionPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws MalformedURLException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		createmission = new CreateMissionsPage();
		Followuppage = new FollowupcreatedMissionPage();

	}

	@DataProvider
	public Object[][] Followup() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test

	(priority = 21, dataProvider = "Followup", description = "Fills the crate mission filed")
	public void verifymissionlabel(String Department, String Category, String Customer, String Responsible,
			String ProjectManager, String Typeofdeadline) throws InterruptedException, AWTException {
		createmission.Select_all_department();

		createmission.Select_all_department();
		createmission.Add_mission();

		createmission.Select_Département(Department);
		createmission.Select_Catégorie(Category);
		createmission.Select_client(Customer);
		createmission.Select_responsible(Responsible);
		createmission.Select_projectManager(ProjectManager);
		createmission.Deadline(Typeofdeadline);
		createmission.Select_date();
		try {
			createmission.Save_mission();
			Thread.sleep(1000);
		} catch (Throwable e) {

			e.printStackTrace();
		}

		Followuppage.Widgeticon();

		Followuppage.StartTime();

		Followuppage.EndTime();
		Thread.sleep(2000);

		Followuppage.Progress_notdone_100percentage();
		Thread.sleep(2000);

		Followuppage.Save();
		Thread.sleep(6000);

		Followuppage.finish();
		Thread.sleep(2000);

		Followuppage.ValidationProgress();
		Thread.sleep(3000);

		//

		Followuppage.StartTime();

		Followuppage.EndTime();
		Thread.sleep(2000);
		Followuppage.uploadFile();
		Thread.sleep(2000);

		Followuppage.ProgressBar();
		Thread.sleep(2000);
		Followuppage.increaseQuantity();
		Thread.sleep(2000);

		Followuppage.Save();
		Thread.sleep(6000);

		Followuppage.Hold_finsih_Mission();
		Thread.sleep(2000);
		Followuppage.Delete_folloup();
		Thread.sleep(2000);
	}

}
