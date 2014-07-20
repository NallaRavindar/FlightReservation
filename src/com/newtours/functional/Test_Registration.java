package com.newtours.functional;

import org.openqa.selenium.WebDriver;

import com.newtours.module.Login.Login;
import com.newtours.module.Login.Registration;
import com.newtours.util.ReadPropertiesFile;

public class Test_Registration {
	
	
	private static ReadPropertiesFile propFile;
	private  WebDriver driver;
	
	Registration objRegistration;
	Login objLogin;
	
	
	public Test_Registration getInstance(WebDriver driver) throws Exception{
		
	this.driver = driver;
	return this;
	
	}
	
	
	public void userRegistration(String firstName,String lastName,String phoneNo,String EmailID,String sAddress1,String sAddress2,String sCity,String State,String sPostalCode,String sCountry,String UserName,String strPassword,String ConfirmPassword) throws Exception{
		
		try{
		
			System.out.println("Start of userRegistration method.");
			objRegistration = new Registration(driver);
			objRegistration.clickOnRegistrationLink();
			objRegistration.contactInformation(firstName,lastName,phoneNo,EmailID);
			objRegistration.mailingInformation(sAddress1,sAddress2,sCity,State,sPostalCode,sCountry);
			objRegistration.UserInformation( UserName, strPassword,ConfirmPassword);
			System.out.println("End of userRegistration method.");
			
		}catch(Exception e){
			throw new Exception("Error in userRegistration method ...");
		}
		
		
		
	}
	
	/**
	 * User logged into application.
	 * @param userName
	 * @param Password
	 * @throws Exception
	 */
	
	public void userLogin(String userName,String Password) throws Exception{
		
	try{
			
		System.out.println("Start of userLogin method.");
		objLogin = new Login(driver);
		objLogin.clickOnSignOnLink();
		objLogin.userLogin(userName,Password);
		objLogin.verifyLogin();
		System.out.println("End of userLogin method.");
		
	}catch(Exception e){
		throw new Exception("Error in userLogin method ...");
	}
  }
}
