package com.herokuapp.qa.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Base64;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.herokuapp.qa.base.Base;
import com.herokuapp.qa.pages.InvalidUserPage;
import com.herokuapp.qa.util.TestUtil;



public class InvalidUserPageTest extends Base{
	String sheetName="LoginPageTest";
	InvalidUserPage invalidpage;
	static String decodepassword="aGFwcHltYW4xNjM=";
	
	
	
	public InvalidUserPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		initialization();
		invalidpage= new InvalidUserPage();
	
	}
	
	@Test (priority=31, description="verify the empty data")
	public void verifhtmlmessagebothfiled() throws InterruptedException {
		
        invalidpage.user_Name("");
		
		invalidpage.pass_word("");
		
		invalidpage.loginbutton();
		
	}
	
	@Test (priority=32, description="verify the empty for password filed")
	public void verifhtmlmessageforpassword() throws InterruptedException {
		
        invalidpage.user_Name("ChhotuMannual");
		
		invalidpage.pass_word("");
		
		invalidpage.loginbutton();
		Thread.sleep(1000);
		
	}
	
	@DataProvider
	public Object[][] TracifyData() {
	Object data[][]=TestUtil.getTestData(sheetName);	
	 return data;		
	}
	
	@Test (priority=33, dataProvider="TracifyData", description="Fills the crate mission filed")
	public void veriferror(String Username, String Password) throws InterruptedException {
		
		
 
	


          invalidpage.Name(Username);
		
			
		
		invalidpage.pass(Password);
		
		invalidpage.loginbutton();
		Thread.sleep(1000);
		
		String text=invalidpage.Verify_errormessage();
       
       text=text.replaceAll("×", "").trim();
       System.out.println(text);
       assertEquals(text, "Oups ! Le nom d'utilisateur ou le mot de passe est incorrecte. Veuillez réessayer.","validation message is not matched");
		Thread.sleep(1000);
      
	}
	
	public static String getDecodedpassword1()
	{
	return new String(Base64.getDecoder().decode(decodepassword.getBytes()));
	}
	@Test (priority=34,description="verify encrypted password")
	public  void getDecoded(){
	
		System.err.println("ppp :"+ getDecodedpassword1());
	invalidpage.user_Name("ChhotuMannual");
		
		invalidpage.pass_word(getDecodedpassword1());
		
	
	}
	
		 
}

