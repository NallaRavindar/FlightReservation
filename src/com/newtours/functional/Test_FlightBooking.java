package com.newtours.functional;

import org.openqa.selenium.WebDriver;

import com.newtours.module.Login.Login;
import com.newtours.module.Login.Registration;
import com.newtours.module.Oneway.FlightOneWay;
import com.newtours.module.common.PassengersDetails;


public class Test_FlightBooking {
		
	private  WebDriver driver;
	
	Registration objRegistration;
	Login objLogin;
	FlightOneWay objFlightOneWay;
	PassengersDetails objPassengersDetails;
	
	
	
	public Test_FlightBooking getInstance(WebDriver driver) throws Exception{
	
	System.out.println("WebDriver ===> "+driver);
	this.driver = driver;
	return this;
	
	}
	
	public void testOneWayBooking() throws Exception{
		
		try{
			System.out.println("Start of testOneWayBooking method.. ");
			objFlightOneWay = new FlightOneWay(driver);
			objFlightOneWay.oneWayFlightDetails();
			objFlightOneWay.preferences();
			objFlightOneWay.selectFlights();
			System.out.println("End of testOneWayBooking method.. ");
			
		}catch(Exception e){
			throw new Exception(" Error in testOneWayBooking method.. " );
		}
		
		System.out.println("END of OneWayBooking method.. ");
	}
	
	
	public void testPassengetDetails()throws Exception{
		
		System.out.println("Start of testPassengetDetails method.. ");
	
		//try{
			objPassengersDetails = new PassengersDetails(driver);
			objPassengersDetails.PassengerContactDetails();
			objPassengersDetails.passengerBillingAddress();
			objPassengersDetails.passengerDeliveryAddress();
			//objPassengersDetails.LogOut();
	
		/*}catch(Exception e){
			throw new Exception(" Error in testPassengetDetails method.. " );
		}*/
		
		System.out.println("END of testPassengetDetails method.. ");
	}
}