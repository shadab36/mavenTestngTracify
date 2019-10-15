package com.herokuapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class MissionProductionPage extends Base {
	
	@FindBy(css="#main-menu-navigation > li:nth-child(2) > a")
	WebElement Missionproduction;
	
	@FindBy(css="#main-menu-navigation > li:nth-child(2) > ul > li:nth-child(1) >a")
	WebElement Current_missions;
	
	@FindBy(css="#main-menu-navigation > li:nth-child(2) > ul > li:nth-child(2) >a")
	WebElement Pending_missions;
	
	@FindBy(css="#main-menu-navigation > li:nth-child(2) > ul > li:nth-child(3) >a")
	WebElement Missions_completed;
	
	@FindBy(css="#main-menu-navigation > li:nth-child(2) > ul > li:nth-child(4) >a")
	WebElement All_follow_ups_missions;
	
	
	public MissionProductionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void HoverMission_production() throws InterruptedException {
		new Actions(driver).moveToElement(Missionproduction).build().perform();
		Thread.sleep(1000);
	}
	
	public String current_missionUrl() throws InterruptedException {
		Current_missions.click();
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		return driver.getCurrentUrl();
		
	}
	
	public String pending_missionUrl() throws InterruptedException {
		Pending_missions.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
		
		
	}
	public String complete_missionUrl() throws InterruptedException {
		Missions_completed.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
		
	}
	
	public String all_follow_missionUrl() throws InterruptedException {
		All_follow_ups_missions.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
		
	}
	
	
	
}
