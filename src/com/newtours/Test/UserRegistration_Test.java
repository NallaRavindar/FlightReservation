package com.newtours.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtours.functional.Test_Registration;
import com.newtours.module.Login.Registration;
import com.newtours.util.Generic_Methods;


public class UserRegistration_Test {


	WebDriver driver = null;
	Test_Registration objTest_Registration = new Test_Registration();

	Registration objRegistration;
	
	@Test (dataProvider = "getXlsData")
	public void userRegistration(String firstName,String lastName,String phoneNo,String EmailID,String sAddress1,String sAddress2,String sCity,String State,String sPostalCode,String sCountry, String  UserName, String Password,String ConfirmPassword)
 throws Exception{
		
		Reporter.log("Start of Registration of the application.");
		objTest_Registration.getInstance(driver).userRegistration(firstName,lastName,phoneNo,EmailID,sAddress1,sAddress2,sCity,State,sPostalCode,sCountry,  UserName,Password,ConfirmPassword);
	}
	

	@DataProvider
	 public Object[][] getXlsData(java.lang.reflect.Method method)  throws Exception {	
		if (method.getName().equalsIgnoreCase("userRegistration")) {
			
			//Reporter.log("Data file for login credentials :"+defLogindatafile);
			return Generic_Methods.getData_XLS("E:\\WorkSpace\\src\\com\\newtours\\resource\\TestData\\UserRegistration_testdata.xlsx","sheet",12);	
		} else {
		
			Reporter.log("Not able to get Data file :");
			return Generic_Methods.getData_XLS("","sheet",13);	
		}
	 }
	
}
