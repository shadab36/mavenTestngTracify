package com.herokuapp.qa.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class CancelMissionPage extends Base{
JavascriptExecutor js = (JavascriptExecutor) driver;
	

@FindBy(xpath="//button[@class='btn btn-danger']")
WebElement Cancel;
	
	public CancelMissionPage() {
		PageFactory.initElements(driver, this);
	}
	

public void cancel_mission()throws Throwable       {
	js.executeScript("arguments[0].scrollIntoView();", Cancel);
	Thread.sleep(2000);
	js.executeScript("arguments[0].style.border='2px solid yellow'",Cancel);
	Thread.sleep(2000);
	js.executeScript("return document.getElementsByClassName('btn-danger')[0].click();");
	Thread.sleep(2000);
}


}

