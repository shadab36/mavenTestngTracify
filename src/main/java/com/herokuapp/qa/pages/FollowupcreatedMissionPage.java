package com.herokuapp.qa.pages;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;



public class FollowupcreatedMissionPage extends Base{

	@FindBy(xpath="(//*[@class='icon-cogs2'])[position()>2]")
	WebElement WidgetIcon;
	
	@FindBy(xpath="//button[contains(@class,'btn-success')]")
	WebElement Save;
	
	@FindBy(xpath="(//*[@class='icon-calendar3'])[2]")
	WebElement EndTime;
	
	@FindBy(id="id_progress_bar")
	
	WebElement Progress;
	
	
	@FindBy(xpath="(//*[contains(text(),'Follow Up Mission')]//preceding::*[@class='icon-tasks'])[2]")
	WebElement Task_icon;

	
	@FindBy(xpath="//i[@class='icon-pause3']")
	WebElement hold;
	
	
	@FindBy(xpath="//button[contains(@class,'btn-outline-success')]")
	WebElement Finish;

	@FindBy(xpath="//i[contains(@class,'icon-trash-o')]")
	WebElement Delete;
	
	
	@FindBy(xpath="//button[contains(@class,'btn-danger')]")
	WebElement Delete_Yes;
	
	public FollowupcreatedMissionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Widgeticon() throws InterruptedException {
		WidgetIcon.click();
		Thread.sleep(1000);
	}

	public void StartTime() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript(
					"return document.getElementsByClassName('icon-calendar3')[0].click();");
			Thread.sleep(1000); 
	
		
	}
	
	
	
	
	
	public void EndTime() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions ac= new Actions(driver);
		ac.doubleClick(EndTime).build().perform();
		 Thread.sleep(2000);  
		//end date of weekened
//			Calendar c = Calendar.getInstance();
//			if((c.get(Calendar.DAY_OF_MONTH)== Calendar.MONDAY)) {
//				
//			
//				  System.out.println("abchbbjbkSUNDAY!");
//				  jse.executeScript(
//							"return document.getElementsByClassName('day active')[0].parentElement.getElementsByClassName('day new')[0].click();");
//			}
			 jse.executeScript(
						"return	 document.getElementsByClassName('day active')[0].parentNode.nextElementSibling.getElementsByClassName('day weekend')[0].click();"); 
			 Thread.sleep(2000); 
			 
			 
			 
			 //select time 
			 jse.executeScript(
						"return document.getElementsByClassName('icon-clock-o')[0].click();");
			 Thread.sleep(1000); 
			 
			 
			 JavascriptExecutor clo = (JavascriptExecutor) driver;
					
					clo.executeScript(
							//for hour
								"return document.getElementsByClassName('timepicker-hour')[0].click();");
					Thread.sleep(500);
					clo.executeScript(
							"return document.getElementsByClassName('hour')[6].click();");
					Thread.sleep(500);
					
					//for minute
					
					clo.executeScript("return document.getElementsByClassName('timepicker-minute')[0].click();");
					Thread.sleep(500);
			clo.executeScript(
					"return document.getElementsByClassName('minute')[6].click();");
			Thread.sleep(5000);
			 
	}
	
	
	public void ProgressBar() throws InterruptedException {
		Progress.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Progress.sendKeys(Keys.BACK_SPACE);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Progress.sendKeys("100");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		Thread.sleep(1000);
	}
	
	
	//
	public void Progress_notdone_100percentage() throws InterruptedException {
	Progress.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Progress.sendKeys(Keys.BACK_SPACE);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Progress.sendKeys("50");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	Thread.sleep(1000);
}
	
	public  void uploadFile() throws InterruptedException, AWTException
	   {
	     //Store the location of the file in clipboard
		WebElement fileimage=driver.findElement(By.id("id_followup_task_files"));
//		fileimage.click();
		
		fileimage.sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\com\\herokuapp\\qa\\testdata\\image.jpg");
		  Thread.sleep(1500);
		
//	    Thread.sleep(1500);
//	    String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\herokuapp\\qa\\testdata\\image.jpg";
//	        Thread.sleep(1500);
//	         StringSelection strSel = new StringSelection(path);
//	         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
//	        
//	        //Create an object for robot class
//	        Robot robot = new Robot();
//	        
//	        //Control key in the keyboard
//	        //Ctrl+V
//	        robot.keyPress(KeyEvent.VK_CONTROL);
//	        robot.keyPress(KeyEvent.VK_V);
//	        robot.keyRelease(KeyEvent.VK_CONTROL);
//	        
//	        Thread.sleep(3000);
//	        robot.keyPress(KeyEvent.VK_ENTER);
//	        robot.keyRelease(KeyEvent.VK_ENTER);
//	        Thread.sleep(3000);
	   }

	
	public void increaseQuantity() throws InterruptedException {
		WebElement quantity=driver.findElement(By.id("id_quantity_done"));
	
		Thread.sleep(1000);
		


		for (int i=0; i<2; i
		++)
		{
			quantity.sendKeys(Keys.ARROW_UP);
			Thread.sleep(1000);
			quantity.sendKeys(Keys.ARROW_UP);
			Thread.sleep(1000);
			quantity.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		}   // for
//		quantity.sendKeys(Keys.ENTER);
	
	}
	
	public void Save() throws InterruptedException {
		
		
		try {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",Save);
		Thread.sleep(2000); 
		Save.click();
		 Thread.sleep(5000); 
	}catch(Exception e) {
		
	}
	}
	
	public void Hold_finsih_Mission() throws InterruptedException {
		Task_icon.click();
		 Thread.sleep(2000); 
		 hold.click();
		 Thread.sleep(8000); 
		 Task_icon.click();
		 Thread.sleep(2000); 
		 Finish.click();
		 Thread.sleep(2000); 
	}
	
	public void finish() throws InterruptedException {
		Task_icon.click();
		 Thread.sleep(2000); 
		 Finish.click();
		 Thread.sleep(2000); 
	}
	
	
	public void Delete_folloup() throws InterruptedException {
		
		    driver.findElement(By.xpath("(//a[text()='Follow Up Mission'])[1]")).click();
		    Delete.click();
		    Thread.sleep(1000); 
		    Delete_Yes.click();
		    Thread.sleep(1000); 
		
	}
	//verify the validation message when user is not completed the progress bar
	
	
	public void ValidationProgress() throws InterruptedException {
		
		driver.findElement(By.cssSelector(".animateErrorIcon")).isDisplayed();
		Thread.sleep(1000);
		String error=driver.findElement(By.xpath("//h2[contains(text(),'Désolé !')]")).getText();
		Thread.sleep(1000);
		String errormessage="Désolé !";
		Thread.sleep(1000);
        assertEquals(error, errormessage, "not matched");
        Thread.sleep(1000);
		
        driver.findElement(By.xpath("//*[@class='confirm']")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.cssSelector(".btn-outline-primary")).click();
        Thread.sleep(2000);
	}
}
		

	
		

