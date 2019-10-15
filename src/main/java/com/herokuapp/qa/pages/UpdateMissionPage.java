package com.herokuapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class UpdateMissionPage extends Base{

	@FindBy(xpath="(//tr[@role='row'])[2]//td[3]")
	WebElement Departement;
	
	@FindBy(xpath="//i[contains(@class,'icon-pencil3')]")
	WebElement Edit; 
	
public UpdateMissionPage() {
	PageFactory.initElements(driver, this);
}

public void Click_Departement() throws InterruptedException {
	Departement.click();
	Thread.sleep(1000);
	 Edit.click();
	 Thread.sleep(1000);
}
	
}
