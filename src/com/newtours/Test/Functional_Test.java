package com.newtours.Test;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.newtours.functional.Test_FlightBooking;
import com.newtours.functional.Test_Registration;
import com.newtours.module.Login.Login;
import com.newtours.module.Login.Registration;
import com.newtours.util.Generic_Methods;
import com.newtours.util.ReadPropertiesFile;

public class Functional_Test {

	private static ReadPropertiesFile propFile;
	WebDriver driver = null;
	
	Registration objRegistration;
	Login objLogin;
	Test_FlightBooking objTest_FlightBooking = new Test_FlightBooking() ;
	Test_Registration objTest_Registration = new Test_Registration();
	//private final Logger logger = Logger.getLogger(Functional_Test.class.getName());
	
@BeforeSuite
	public void setUP() throws Exception {

		propFile = new ReadPropertiesFile();
		System.out.println("Browser Type ==> "+propFile.getBrowser() );
		System.out.println("Site URL ==> "+propFile.getSite() );
		driver = Generic_Methods.launchBrowser(propFile.getBrowser());
		driver.manage().window().maximize();
		driver.get(propFile.getSite());

	}

@BeforeTest
public void testLogin() throws Exception{
	

/*	Reporter.log("Start of Registration of the application.");
	objTest_Registration.getInstance(driver).userRegistration();*/

	Reporter.log("Start of user logged into method.");
	objTest_Registration.getInstance(driver).userLogin(propFile.getUserName(),propFile.getPassword());
	Reporter.log("END of user logged into method.");
	//logger.info("END of user logged into method.");
	
}
	
@Test(description = "test_OneWayFlights")
public void test_OneWayFlights() throws Exception{
	
	Reporter.log("Start of test_OneWayFlights method.");
	objTest_FlightBooking.getInstance(driver).testOneWayBooking();
	//logger.info("Start of test_OneWayFlights method.");
}


@Test(description = "test_PassengetDetails")
public void test_PassengetDetails() throws Exception{
	
	Reporter.log("Start of test_PassengetDetails method.");
	objTest_FlightBooking.getInstance(driver).testPassengetDetails();
	//logger.info("Start of test_PassengetDetails method.");
}


@Test(description = "testHomePage02", priority = '1')
public void testHomePage02() throws Exception{
	
	Reporter.log("Login into testHomePage02.....");
	//Assert.assertFalse(true,"Failed Homepage ..");
	//logger.info("Login into HomePage02.....");
}

@Test(dependsOnMethods="testHomePage02")
public void testHomePage03() throws Exception{
	
	Reporter.log("Login into testHomePage03.....");
	//Assert.assertTrue(true,"Failed Homepage ..");
	
	
}

@AfterSuite
public void tearDown()throws Exception{
	
	objLogin = new Login(driver);
	Reporter.log("After suire to close browser..");
	//logger.info("After suire to close browser..");
	objLogin.signOff();
	driver.close();
	driver.quit();
	
	
	}

}
