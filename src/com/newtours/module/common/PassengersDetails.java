package com.newtours.module.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.newtours.util.Generic_Methods;

public class PassengersDetails {
	
	private final WebDriver driver;

	// Objects of login user page.
	@FindBy(xpath = "//a[text()='SIGN-ON']")														private WebElement link_SignOn;
	@FindBy(xpath = "//a[text()='REGISTER']")														private WebElement link_Registration;
	@FindBy(xpath = "//a[text()='SIGN-OFF']")														private WebElement link_SignOff;

	@FindBy(xpath = "//form[@name='bookflight']//input[@name='passFirst0']")						private WebElement input_PassenFirstName;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='passLast0']")							private WebElement input_PassenLastName;
	@FindBy(xpath = "//form[@name='bookflight']//select[@name='pass.0.meal']")						private WebElement dropdwon_PassenMeal;
	@FindBy(xpath = "//form[@name='bookflight']//select[@name='creditCard']")						private WebElement dropdwon_PassenCreditCard;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='creditnumber']")						private WebElement input_Passencreditnumber;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='cc_frst_name']")						private WebElement input_PassenCardFrstName;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='cc_last_name']")						private WebElement input_PassenCardLastName;
	
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='billAddress1']")						private WebElement input_PassenBillAddress1;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='billAddress2']")						private WebElement input_PassenBillAddress2;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='billCity']")							private WebElement input_PassenBillCity;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='billState']")							private WebElement input_PassenBillState;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='billZip']")							private WebElement input_PassenBillZip;
	@FindBy(xpath = "//form[@name='bookflight']//select[@name='billCountry']")						private WebElement dropdwon_PassenBillCountry;
	


	@FindBy(xpath = "//form[@name='bookflight']//input[@name='delAddress1']")						private WebElement input_PassenDelAddress1;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='delAddress2']")						private WebElement input_PassenDelAddress2;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='delCity']")							private WebElement input_PassenDelCity;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='delState']")							private WebElement input_PassenDelState;
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='delZip']")							private WebElement input_PassenDelZip;
	@FindBy(xpath = "//form[@name='bookflight']//select[@name='delCountry']")						private WebElement dropdwon_PassenDelCountry;
	
	@FindBy(xpath = "//form[@name='bookflight']//input[@name='buyFlights']")						private WebElement input_PassenBuyFlights;
	
	@FindBy(xpath = "//img[@src='/images/forms/Logout.gif']")						private WebElement src_LogOut;

	
	/**
	 *Ajax page load time.
	 * @param driver
	 */
	public PassengersDetails (WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(driver, this);

	}
	
	
	public void PassengerContactDetails() throws Exception{
		
		System.out.println("Start of PassengersDetails method  ");

		try {
		
			Generic_Methods.WaitforElementVisible(driver,input_PassenFirstName);
			Generic_Methods.highlightElement(driver,input_PassenFirstName);
			input_PassenFirstName.sendKeys("PFName");
			input_PassenLastName.sendKeys("PLName");
			Generic_Methods.getSelectedOption(dropdwon_PassenMeal,"Hindu");
			Generic_Methods.getSelectedOption(dropdwon_PassenCreditCard,"Visa");
			input_Passencreditnumber.sendKeys("1234567890123456");
			input_PassenCardFrstName.sendKeys("CCardFName");
			input_PassenCardLastName.sendKeys("CCLName");
					
		} catch (Exception e) {
			throw new Exception("Error at PassengersDetails method. "+e);
		}
		System.out.println("End of PassengersDetails method  ");
	}
	
	public void passengerBillingAddress() throws Exception{

		System.out.println("Start of PassengersDetails method  ");

		try {
			Generic_Methods.highlightElement(driver, input_PassenBillAddress1);
			input_PassenBillAddress1.sendKeys("BillingAddress01");
			input_PassenBillAddress2.sendKeys("BillingAddress02");
			input_PassenBillCity.sendKeys("BillingCity");
			input_PassenBillState.sendKeys("TELAGANA");
			input_PassenBillZip.sendKeys("11111111");
			Generic_Methods.getSelectedOption(dropdwon_PassenBillCountry,"INDIA");
			
		} catch (Exception e) {
			throw new Exception("Error at PassengersDetails method. "+e);
		}
		System.out.println("End of PassengersDetails method  ");
	}


	public void passengerDeliveryAddress() throws Exception{

		System.out.println("Start of passengerDeliveryAddress method  ");

		try {
			Generic_Methods.highlightElement(driver, input_PassenBillAddress1);
			input_PassenDelAddress1.sendKeys("DeliveryAddress01");
			input_PassenDelAddress2.sendKeys("DeliveryAddress02");
			input_PassenDelCity.sendKeys("DeliveryCity");
			input_PassenDelState.sendKeys("TELAGANA");
			input_PassenDelZip.sendKeys("11111111");
			Generic_Methods.getSelectedOption(dropdwon_PassenDelCountry,"UNITED STATES");
			Generic_Methods.highlightElement(driver,input_PassenBuyFlights);
			Thread.sleep(3000);
			input_PassenBuyFlights.click();
			Thread.sleep(3000);
			//driver.switchTo().alert().accept();
			//Thread.sleep(3000);
			
		} catch (Exception e) {
			throw new Exception("Error at passengerDeliveryAddress method. "+e);
		}
		System.out.println("End of passengerDeliveryAddress method  ");
	}
	
	
	public void LogOut() throws Exception {
		
		System.out.println("Start of LogOut method  ");

		try {
			Generic_Methods.WaitforElementVisible(driver,src_LogOut);
			System.out.println("test01");
			Generic_Methods.highlightElement(driver,src_LogOut);
			src_LogOut.click();
			Thread.sleep(3000);
			
		} catch (Exception e) {
			throw new Exception("Error at LogOut method. "+e);
		}
		System.out.println("End of LogOut method  ");
	}
}
