package com.newtours.module.Oneway;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.newtours.util.Generic_Methods;

public class FlightOneWay {

	
	private final WebDriver driver;

	// Objects of login user page.
	@FindBy(xpath = "//a[text()='SIGN-ON']")														private WebElement link_SignOn;
	@FindBy(xpath = "//a[text()='REGISTER']")														private WebElement link_Registration;
	@FindBy(xpath = "//a[text()='SIGN-OFF']")														private WebElement link_SignOff;

	@FindBy(xpath = "//form[@name='findflight']//input[@value='oneway']")							private WebElement rbutton_Oneway;
	@FindBy(xpath = "//form[@name='findflight']//select[@name='passCount']")						private WebElement dropdown_PassengerCount;
	@FindBy(xpath = "//form[@name='findflight']//select[@name='fromPort']")							private WebElement dropdwon_Depart;
	
	@FindBy(xpath = "//form[@name='findflight']//select[@name='fromMonth']")						private WebElement dropdwon_FromMonth;
	@FindBy(xpath = "//form[@name='findflight']//select[@name='fromDay']")							private WebElement dropdwon_FromDay;
	@FindBy(xpath = "//form[@name='findflight']//select[@name='toPort']")							private WebElement dropdwon_Return;
	@FindBy(xpath = "//form[@name='findflight']//select[@name='toMonth']")							private WebElement dropdwon_ToMonth;
	@FindBy(xpath = "//form[@name='findflight']//select[@name='toDay']")							private WebElement dropdwon_ToDate;
	
	@FindBy(xpath = "//form[@name='findflight']//input[@value='Coach']")							private WebElement button_Economy;
	@FindBy(xpath = "//form[@name='findflight']//select[@name='airline']")							private WebElement dropdown_Ariline;
	@FindBy(xpath = "//form[@name='findflight']//input[@name='findFlights']")						private WebElement button_Continue;
	@FindBy(xpath = "//form[@name='results']//table[1]//input[@checked='']")						private WebElement button_DeptFlight;
	@FindBy(xpath = "//form[@name='results']//table[2]//input[@checked='']")						private WebElement button_ReturnFlight;
	
	@FindBy(xpath = "//form[@name='results']//input[@name='reserveFlights']")						private WebElement button_ContinueReserveFlights;
	/**
	 *Ajax page load time.
	 * @param driver
	 */
	public FlightOneWay (WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(driver, this);

	}
	
	public void oneWayFlightDetails() throws Exception {

		System.out.println("Start of oneWayFlightDetails method  ");

		try {
			
			//Alert tl = driver.switchTo().alert();
			//driver.getPageSource()
		//	driver.manage().timeouts().implicitlyWait(arg0, TimeUnit.SECONDS)
			//driver.switchTo().window("xyz").
			//System.out.println("Getting the page source: " +driver.getPageSource());
			Generic_Methods.WaitforElementVisible(driver, rbutton_Oneway);
			Generic_Methods.highlightElement(driver, rbutton_Oneway);
			rbutton_Oneway.click();
			Thread.sleep(2000);
			Generic_Methods.getSelectedOption(dropdown_PassengerCount, "2");
			Thread.sleep(2000);
			Generic_Methods.getSelectedOption(dropdwon_Depart,"New York");
			Thread.sleep(100);
			Generic_Methods.getSelectedOption(dropdwon_FromMonth,"July");
			Generic_Methods.getSelectedOption(dropdwon_FromDay,"10");
			Generic_Methods.getSelectedOption(dropdwon_Return,"London");
			Generic_Methods.getSelectedOption(dropdwon_ToMonth,"July");
			Generic_Methods.getSelectedOption(dropdwon_ToDate,"30");
			
		} catch (Exception e) {

			throw new Exception("Error at oneWayFlightDetails method. ");
		}

		System.out.println("End of oneWayFlightDetails method  ");
	}
	
	
	public void preferences() throws Exception {
		
		System.out.println("Start of preferences method  ");

		try {
			Generic_Methods.WaitforElementVisible(driver, button_Economy);
			Generic_Methods.highlightElement(driver, button_Economy);
			button_Economy.click();
			Generic_Methods.getSelectedOption(dropdown_Ariline,"Blue Skies Airlines");
			button_Continue.click();
			Thread.sleep(4000);
		} catch (Exception e) {

			throw new Exception("Error at preferences method. "+e);
		}

		System.out.println("End of preferences method  ");
	}
	
	
	public void selectFlights() throws Exception {
		
		System.out.println("Start of selectFlights method  ");

		try {
		
			boolean selectedFlght = button_DeptFlight.isSelected();
			if(selectedFlght){
				System.out.println("Selected Departure flight.");
				Generic_Methods.highlightElement(driver, button_DeptFlight);
				button_ContinueReserveFlights.click();
				Thread.sleep(3000);
	       	}else{
	       		Assert.assertTrue(selectedFlght,"Not selected the Depature flight in Select Filght widnow.");
	       	}
			
		} catch (Exception e) {

			throw new Exception("Error at selectFlights method. "+e);
		}

		System.out.println("End of selectFlights method  ");
	}
	
	
	
	
}
