package com.herokuapp.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.herokuapp.qa.base.Base;

public class CustomerPage extends Base{
	
	@FindBy(xpath="//a[@href='/customers/']")
	WebElement customer;
	
	
	@FindBy(xpath="//*[contains(text(),'Ajouter un client')]")
	WebElement Add_Customer;
	

	@FindBy(xpath="//h1//font[contains(text(),'Ajouter un client')]")
	WebElement Add_Customer_title;
	
	
	
	// all form page type button
	
	
	@FindBy(css=".btn-success")
	WebElement Save_cta;

	
	@FindBy(css=".btn-primary")
	WebElement Save_and_addnew;
	
	@FindBy(css=".btn-outline-deep-orange")
	WebElement Save_add_contact;
	
	@FindBy(css=".btn-outline-blue")
	WebElement Save_add_adress;
	
	@FindBy(css=".btn-outline-amber")
	WebElement Register_and_accescode;
	
	@FindBy(css=".btn-danger")
	WebElement Cancel;
	
	public CustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public void Customer_click() {
		
		customer.click();
		
	}
	
	public String cPage() {
		
		return driver.getCurrentUrl();
		
	}
	
	public void click_addcustomer() throws InterruptedException {
		Add_Customer.click();
		Thread.sleep(2000);
		
	}
	
	public String verify_addcustomer() throws InterruptedException {
		return Add_Customer.getText();
	}
	
	public void Verify_Save_OnlyButton() throws InterruptedException {
	
		if(Save_cta.isEnabled()) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);",Save_cta);	
			Thread.sleep(2000);
			String abc=Save_cta.getText();
			System.out.println(abc);
			assertEquals(abc, "Enregistrer uniquement", "Cta is not matched");
		
	}}
		
		public void Verify_SaveAnd_NewButton() throws InterruptedException {
			
			if(Save_and_addnew.isEnabled()) {
				
				String abc=Save_and_addnew.getText();
				System.out.println(abc);
				assertEquals(abc, "Enregistrer et ajouter un nouveau", "Cta is not matched");
			
		}
			
		}
			public void Verify_SaveAnd_AddContactButton() throws InterruptedException {
				
				if(Save_add_contact.isEnabled()) {
					String abc=Save_add_contact.getText();
					System.out.println(abc);
					assertEquals(abc, "Enregistrer et ajouter des contacts", "Cta is not matched");
				}
			}
				
			
			public void Verify_addAddress_OnlyButton() throws InterruptedException {
				
				if(Save_add_adress.isEnabled()) {
	
					String abc=Save_add_adress.getText();
					System.out.println(abc);
					assertEquals(abc, "Enregistrer et ajouter des adresses", "Cta is not matched");
				
			}}
			
				public void Verify_reister_OnlyButton() throws InterruptedException {
					
					if(Register_and_accescode.isEnabled()) {
		
						String abc=Register_and_accescode.getText();
						System.out.println(abc);
						assertEquals(abc, "Enregistrer et ajouter des codes d'accès", "Cta is not matched");
					
				}}
					
					public void Verify_CancelButton() throws InterruptedException {
						
						if(Cancel.isEnabled()) {
							
							Thread.sleep(2000);
							String abc=Cancel.getText();
							System.out.println(abc);
							assertEquals(abc, "Annuler", "Cta is not matched");
						
					}
						
					
	}}
