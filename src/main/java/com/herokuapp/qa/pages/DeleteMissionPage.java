package com.herokuapp.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class DeleteMissionPage extends Base {
	@FindBy(xpath="(//a[contains(text(),'Automation Department')])[position()>1]")
	WebElement Departement;

	@FindBy(xpath="//i[contains(@class,'icon-trash-o')]")
	WebElement Delete;
	
	
	@FindBy(xpath="//button[contains(@class,'btn-danger')]")
	WebElement Delete_Yes;
	
	
	public DeleteMissionPage() {
		PageFactory.initElements(driver, this);
	}
	
public void Delete_mission() throws InterruptedException {
	List<WebElement> lstDrp = driver.findElements(By.xpath("(//a[contains(text(),'Automation Department')])[position()>1]"));
	System.out.println(lstDrp.size());	
	lstDrp.get(0).click();
	Thread.sleep(1000);
	Delete.click();
	Thread.sleep(1000);
	Delete_Yes.click();
	Thread.sleep(3000);
	List<WebElement> ls = driver.findElements(By.xpath("(//a[contains(text(),'Automation Department')])[position()>1]"));
	System.out.println(ls.size());
	System.out.println(lstDrp.size()-1==ls.size());
	
	
} 

public void Delet_mission() throws InterruptedException {


	List<WebElement> lstDrp = driver.findElements(By.xpath("(//a[contains(text(),'Testing  New Department')])[position()>1]"));
	System.out.println(lstDrp.size());
	
	lstDrp.get(0).click();
	Thread.sleep(1000);
	Delete.click();
	Thread.sleep(1000);
	Delete_Yes.click();
	Thread.sleep(3000);
	List<WebElement> ls = driver.findElements(By.xpath("(//a[contains(text(),'Testing  New Department')])[position()>1]"));
	System.out.println(ls.size());
	System.out.println(lstDrp.size()-1==ls.size());

}}
