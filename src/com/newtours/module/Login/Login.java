package com.newtours.module.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.newtours.util.Generic_Methods;
import com.newtours.util.ReadPropertiesFile;

public class Login {
	
	

private final WebDriver driver;

// Objects of login user page.
@FindBy(xpath = "//a[text()='SIGN-ON']")														private WebElement link_SignOn;
@FindBy(xpath = "//a[text()='REGISTER']")														private WebElement link_Registration;
@FindBy(xpath = "//a[text()='SIGN-OFF']")														private WebElement link_SignOff;

@FindBy(xpath = "//form[@action='login.php']//input[@name='userName']")							private WebElement input_UserName;
@FindBy(xpath = "//form[@action='login.php']//input[@name='password']")							private WebElement input_Password;
@FindBy(xpath = "//form[@action='login.php']//input[@name='login']")							private WebElement button_Login;

/**
 *Ajax page load time.
 * @param driver
 */
public Login(WebDriver driver) {
	this.driver = driver;
	AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
	PageFactory.initElements(driver, this);

}

/**
 * Click on SignOn link
 * @throws Exception
 */
	public void clickOnSignOnLink() throws Exception {

		System.out.println("Start of clickOnSignOnLink method." + driver);
		try {
			Generic_Methods.WaitforElementVisible(driver, link_SignOn);
			Generic_Methods.highlightElement(driver, link_SignOn);
			link_SignOn.click();
		} catch (Exception e) {
			throw new Exception("Error in clickOnSignOnLink method" + e);
		}

		System.out.println("End of clickOnSignOnLink method.");
	}

	/**
	 * Login into application.
	 * @throws Exception
	 */
	public void userLogin(String userName,String Password) throws Exception {

		System.out.println("Start of Login method.");
		try {
			Generic_Methods.WaitforElementVisible(driver, input_UserName);
			Generic_Methods.highlightElement(driver, input_UserName);
			input_UserName.sendKeys(userName);
			Generic_Methods.highlightElement(driver, input_Password);
			input_Password.sendKeys(Password);
			Generic_Methods.highlightElement(driver, button_Login);
			button_Login.click();
		} catch (Exception e) {
			throw new Exception("Error in Login method" + e);
		}

		System.out.println("End of Login method.");
	}
 
 /**
  * Verify login page.
  * @throws Exception
  */
	public void verifyLogin() throws Exception {
		
		System.out.println("Start of verifyLogin method.");
		try {
			Generic_Methods.WaitforElementVisible(driver, link_SignOff);
			Generic_Methods.highlightElement(driver, link_SignOff);
			Thread.sleep(3000);
		} catch (Exception e) {
			throw new Exception("Error in verifyLogin method." + e);
		}

		System.out.println("End of verifyLogin method.");
	}
	
	/**
	 * Sign Off of user.
	 * @throws Exception
	 */
	public void signOff() throws Exception {

		System.out.println("Start of SignOff method.");

		try {
			Generic_Methods.WaitforElementVisible(driver, link_SignOff);
			Generic_Methods.highlightElement(driver, link_SignOff);
			link_SignOff.click();
			Generic_Methods.WaitforElementVisible(driver,input_UserName);
		} catch (Exception e) {
			throw new Exception("Error in verifyLogin method." + e);
		}

		System.out.println("Start of SignOff method.");
	} 
 
}
