package com.herokuapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class ColleaguesPage extends Base{
	
	@FindBy(xpath="//a[@href='/home/colleagues/']")
	
	WebElement colleagues;
	
	@FindBy(xpath="(//*[contains(@class,'breadcrumb-wrapper')]//h1[contains(text(),'Collègues')])[1]")
	WebElement Titlecolleagues;

	public ColleaguesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Colleagues() throws InterruptedException {
		colleagues.click();
		Thread.sleep(2000);
	
	}
	
	public String Title() {
		String text=Titlecolleagues.getText();
		System.out.println(text);
		return (Titlecolleagues.getText());
	}
}
