package com.newtours.module.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.newtours.util.Generic_Methods;

public class Registration {
	
	private final WebDriver driver;

	//@FindBy(xpath = "//div[@id='profileFirstLevelLibraryContainer'][contains(@style,'display: block;')]//input[@placeholder='Search Profiles']")  protected WebElement text_ProfileLibToggle;

	// Objects of user registration form.
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='firstName']") 		private WebElement text_FirstName;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='lastName']")  		private WebElement text_LastName;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='phone']")    		private WebElement text_Phone;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='userName']")			private WebElement text_EmailID;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='address1']")			private WebElement text_Address1;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='address2']")			private WebElement text_Address2;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='city']")				private WebElement text_City;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='state']")			private WebElement text_State;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='postalCode']")		private WebElement text_PostalCode;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//select[@name='country']")			private WebElement dropDown_Country;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@id='email']")				private WebElement input_UserName;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='password']")			private WebElement input_Password;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='confirmPassword']")	private WebElement input_ConfirmPassword;
	@FindBy(xpath = "//form[@action='mercurycreate_account.php']//input[@name='register']")			private WebElement button_SubmitRegistration;
	@FindBy(xpath = "//a[text()='SIGN-ON']")														private WebElement link_SignOn;
	@FindBy(xpath = "//a[text()='REGISTER']")														private WebElement link_Registration;

	
	/**
	 *Ajax page load time.
	 * @param driver
	 */
	public Registration(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(driver, this);

	}
	
	
/**
 * Click on User Registration link.
 * @throws Exception
 */
	public void clickOnRegistrationLink() throws Exception {

		System.out.println("Start of clickOnRegistrationLink method." + driver);

		try {
			Generic_Methods.WaitforElementVisible(driver, link_SignOn);
			Generic_Methods.highlightElement(driver, link_Registration);
			link_Registration.click();
	
		} catch (Exception e) {

			throw new Exception("Error in clickOnRegistrationLink ");
		}

		/*
		 * List<WebElement> Links = driver.findElements(By.tagName("a"));
		 * System.out.println("Size of links ===>"+Links.size()); for(WebElement
		 * link : Links){
		 * String linkText = link.getText();
		 * if(linkText.equalsIgnoreCase("Register here")) { link.click();
		 * System.out.println("Registration link present and clicked it."); } }
		 */

		System.out.println("End of clickOnRegistrationLink method.");
	}
	
/**
 * 	Contact information of user  while registering of form.
 * @throws Exception
 */
	public void contactInformation(String firstName,String lastName,String phoneNo,String EmailID) throws Exception {

		System.out.println("Start of contactInformation method of Regristration page.");

		try {

			Generic_Methods.WaitforElementVisible(driver, text_FirstName);
			Generic_Methods.highlightElement(driver, text_FirstName);
			text_FirstName.sendKeys(firstName);
			Generic_Methods.highlightElement(driver, text_LastName);
			text_LastName.sendKeys(lastName);
			Generic_Methods.highlightElement(driver, text_Phone);
			text_Phone.sendKeys(phoneNo);
			Generic_Methods.highlightElement(driver, text_EmailID);
			text_EmailID.sendKeys(EmailID);

		} catch (Exception e) {

			throw new Exception("Error in contactInformation of Regristration page." + e);
		}

		System.out.println("END of contactInformation method of Regristration page.");
	}
	
/***
 * Mail information of user while registering of form.
 * @throws Exception
 */
	public void mailingInformation(String sAddress1,String sAddress2,String sCity,String State,String sPostalCode,String sCountry) throws Exception {

		System.out.println("Start of mailingInformation method of Regristration page.");

		try {

			Generic_Methods.WaitforElementVisible(driver, text_Address1);
			Generic_Methods.highlightElement(driver, text_Address1);
			text_Address1.sendKeys(sAddress1);
			Generic_Methods.highlightElement(driver, text_Address2);
			text_Address2.sendKeys(sAddress2);
			Generic_Methods.highlightElement(driver, text_City);
			text_City.sendKeys(sCity);
			Generic_Methods.highlightElement(driver, text_State);
			text_State.sendKeys(State);
			Generic_Methods.highlightElement(driver, text_PostalCode);
			text_PostalCode.sendKeys(sPostalCode);
			Generic_Methods.getSelectedOption(dropDown_Country,sCountry);
		
		} catch (Exception e) {
			throw new Exception("Error in mailingInformation of Regristration page." + e);
		}

		System.out.println("END of mailingInformation method of Regristration page.");

	}
/**
 * User information details while registration of form.
 * @throws Exception
 */
	public void UserInformation(String UserName,String strPassword,String ConfirmPassword) throws Exception {

		System.out.println("Start of UserInformation method of Regristration page.");

		try {

			Generic_Methods.WaitforElementVisible(driver, input_UserName);
			Generic_Methods.highlightElement(driver, input_UserName);
			input_UserName.sendKeys(UserName);
			Generic_Methods.highlightElement(driver, input_Password);
			input_Password.sendKeys(strPassword);
			Generic_Methods.highlightElement(driver, input_ConfirmPassword);
			input_ConfirmPassword.sendKeys(ConfirmPassword);
			Thread.sleep(2000);
			Generic_Methods.highlightElement(driver, button_SubmitRegistration);
			//button_SubmitRegistration.click();
			Thread.sleep(5000);
		} catch (Exception e) {

			throw new Exception("Error in UserInformation of Regristration page." + e);
		}

		System.out.println("END of UserInformation method of Regristration page.");

	}
	
}
