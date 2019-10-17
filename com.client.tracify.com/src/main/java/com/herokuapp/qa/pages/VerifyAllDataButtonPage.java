package com.herokuapp.qa.pages;

import java.awt.Robot;

import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class VerifyAllDataButtonPage extends Base{
	
	@FindBy(xpath="//*[contains(text(),'Copier')]")
	WebElement Copy;
	
	@FindBy(xpath="//*[contains(text(),'CSV')]")
	WebElement CSV;

	
	@FindBy(xpath="//*[contains(text(),'Excel')]")
	WebElement Excel;

	
	@FindBy(xpath="//*[contains(text(),'PDF')]")
	WebElement PDF;

	@FindBy(xpath="//*[contains(text(),'Imprimer')]")
	WebElement Print;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	//next and previous
	
	@FindBy(xpath="//a[contains(text(),'Suivant')]")
	WebElement next;
	
	
	@FindBy(xpath="//a[contains(text(),'Précédent')]")
	WebElement previous;
	
	public VerifyAllDataButtonPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void search() throws InterruptedException {
		search.clear();
		search.sendKeys("Testing");
		Thread.sleep(2000);
		search.clear();
		Thread.sleep(2000);
		
	}
	
	public void NextandPreviosButton() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",next);
		Thread.sleep(2000);
		next.click();
		Thread.sleep(3000);
		previous.click();
		Thread.sleep(2000);
	}
	
	public void Copy() throws InterruptedException {
		Copy.click();
		Thread.sleep(2000);
		
		Runtime runTime=Runtime.getRuntime();
		try{
			runTime.exec("Notepad");
			Thread.sleep(2000);
			//Create instance of Robot class
			   Robot robot = new Robot();
			//Create instance of Clipboard class

			

			

			  robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_V);
			  robot.keyRelease(KeyEvent.VK_V);
			  Thread.sleep(2000);
			  Runtime.getRuntime().exec("taskkill /IM notepad.exe");
				Thread.sleep(2000);
			    robot.keyPress(KeyEvent.VK_RIGHT);
			    robot.keyRelease(KeyEvent.VK_RIGHT);
				Thread.sleep(1000);
		        robot.keyPress(KeyEvent.VK_ENTER);
			   robot.keyRelease(KeyEvent.VK_ENTER);
			   Thread.sleep(500);
			   robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(500);
			
			}

			catch(Exception e){

			}
	}
	public void csv() throws InterruptedException {
		CSV.click();
		Thread.sleep(1000);
	}
	public void excel() throws InterruptedException {
		Excel.click();
		Thread.sleep(1000);
	}
	public void pdf() throws InterruptedException {
		PDF.click();
		Thread.sleep(1000);
	}
	public void print() throws InterruptedException {
		Print.click();
		Thread.sleep(1000);
}
}