package com.herokuapp.qa.pages;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class CustomerFormPage extends Base{

	public static String name;
	@FindBy(id="id_customer_name")
	WebElement CustomerName;
	
	@FindBy(id="id_customer_logo")
	WebElement Logo;
	
	@FindBy(id="id_email")
	WebElement email;
	
	@FindBy(id="id_siret_number")
	WebElement siretNumber;
	

	@FindBy(id="id_ape_naf_code")
	WebElement apeCode;
	
	@FindBy(css=".btn-success")
	WebElement Save_cta;

	@FindBy(id="delete_customer")
	WebElement delete;
	
	
	@FindBy(css=".btn-danger")
	WebElement deleteYes;
	
	
	@FindBy(css=".btn-success")
	WebElement Save;
	
	public CustomerFormPage() {
		PageFactory.initElements(driver, this);
	}
	public void Enter_Customername() {
		name="Chhotu Customer";
		CustomerName.sendKeys(name);
		
	}
	public void select_Logo() throws InterruptedException, AWTException {
//		Logo.click();
//		  Thread.sleep(1500);
		  
		  Logo.sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\com\\herokuapp\\qa\\testdata\\image.jpg");
		  Thread.sleep(1500);
//		    String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\herokuapp\\qa\\testdata\\image.jpg";
//		        Thread.sleep(1500);
//		         StringSelection strSel = new StringSelection(path);
//		         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
//		        
//		        //Create an object for robot class
//		        Robot robot = new Robot();
//		        
//		        //Control key in the keyboard
//		        //Ctrl+V
//		        robot.keyPress(KeyEvent.VK_CONTROL);
//		        robot.keyPress(KeyEvent.VK_V);
//		        robot.keyRelease(KeyEvent.VK_CONTROL);
//		        
//		        Thread.sleep(3000);
//		        robot.keyPress(KeyEvent.VK_ENTER);
//		        robot.keyRelease(KeyEvent.VK_ENTER);
//		        Thread.sleep(3000);
	}

	
	public void Enter_email() {
		 email.sendKeys("Chhotu@getnada.com");
		
	}

	public void Enter_siretNumber() {
		siretNumber.sendKeys("74586");
		
	}

	public void Enter_apeCode() {
		apeCode.sendKeys("47899");
		
	}
	public void Save() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",Save_cta);	
		Thread.sleep(1000);
		Save_cta.click();
		Thread.sleep(3000);
	}
public void VerifyCustomername() {
	String Text=driver.findElement(By.id("name_0")).getText();
	
	System.out.println(Text);
	assertEquals(Text, name);
}
public void DeleteCustomer() throws InterruptedException {
	WebElement details=
			driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]//ancestor::div//descendant::button[@id='btn_details_0']"));
	Thread.sleep(1000);
	
	
	WebElement Status=
			driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]//ancestor::div//descendant::button[@id='btn_other_info_0']"));
	Thread.sleep(1000);
	
	if(Status.isDisplayed()) {
		System.out.println("Status is dispalyed: " + Status.getText());
	}
	
	details.click();
	Thread.sleep(1000);
	
	WebElement update_custome=driver.findElement(By.id("update_customer"));
	
	if(update_custome.isDisplayed()) {
	 update_custome.click();
	 Thread.sleep(1000);
	 JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",Save);
		Thread.sleep(2000); 
		Save.click();
		Thread.sleep(6000); 
	}
	delete.click();
	Thread.sleep(2000);
	deleteYes.click();
	Thread.sleep(1000);
}}
