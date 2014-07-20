package com.newtours.util;
/*package com.newtours.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONException;
import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Function;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
//import com.rms.nextgen.util.ConstantElement.DatabaseType;
//import com.rms.nextgen.util.ConstantElement.Locator;
//import com.rms.nextgen.util.ConstantElement.FileType;


*//**
 * @author Amitabh Rai RMS Inc.
 *
 *//*

public class Generic_Methods {

	private static Connection dbConnection=null;
	static Logger logger = Logger.getLogger(Generic_Methods.class.getName());
	private static ReadPropertiesFile propFile;

	///This Method Lunch the Browser
	public static WebDriver fn_LaunchBrowser(String BrowserType) throws Exception{

		WebDriver  Driver_Object=null;
		if(BrowserType.equalsIgnoreCase("firefox")||BrowserType.equalsIgnoreCase("Firefox")){
			Driver_Object=new FirefoxDriver();
		} else if (BrowserType.equalsIgnoreCase("Safari")) {
			Driver_Object = new SafariDriver();
		}else if(BrowserType.equalsIgnoreCase("chrome")||BrowserType.equalsIgnoreCase("Chrome")){

			System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
			Driver_Object=new ChromeDriver();
		}else if(BrowserType.equalsIgnoreCase("IE")||BrowserType.equalsIgnoreCase("InternetExplorer")){
			System.setProperty("webdriver.ie.driver", "");
			Driver_Object=new InternetExplorerDriver();
		}else if(BrowserType.equalsIgnoreCase("remote")){
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			Driver_Object = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);
		}
		//DO NOT DELETE IT
		else if(BrowserType.equalsIgnoreCase("bmp")){
			ProjectSnappyProxy objProjectSnappyProxy = ProjectSnappyProxy.getInstance();
			System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
			Driver_Object=new ChromeDriver(objProjectSnappyProxy.getProxyDesiredCapabilties(4567));

	    }
		else{

			System.out.println("Provided Browser Type is invalid, please check");
		}
	propFile = new ReadPropertiesFile();
	Driver_Object.manage().timeouts().implicitlyWait(Integer.parseInt(new ReadPropertiesFile().getImplicitWait()), TimeUnit.SECONDS);

		return Driver_Object;
	}

	public void fn_OpenURL(String url){
		System.out.println("url>>>>>>>>>>>>>>>>>>>>>>>>>>>>>."+url);
		logger.info("url>>>>>>>>>>>>>>>>>>>>>>>>>>>>>."+url);
		Driver_Object.get(url);
	}

	public void fn_Logout() throws SQLException{
		fn_Click("Home_SignOut_LK");
	}
	public void fn_CloseDriver(){
		Driver_Object.close();
		Driver_Object.quit();
	}
	public void Fn_OpenApp(String Br_Type, String appURL) throws NumberFormatException, IOException{
		fn_LaunchBrowser(Br_Type);
		fn_OpenURL(appURL);
	}


	*//**
	 * Selects a particular WebElement from the Select . It can be used when HTML have Select <Option> DOM
	 *
	 * @param lstElementList
	 * @param sValueToBeSelected
	 *//*
	public static void getElementFromList(WebElement select,String sValueToBeSelected){
		System.out.println("Inside getElementFromList method");
		List<WebElement> options = select.findElements(By.tagName("option"));
		System.out.println("Total elements having Option TAG :"+options.size());
		for(WebElement option : options){
			System.out.println(option.getText());
			if(option.getText().trim().equalsIgnoreCase(sValueToBeSelected.trim())) {
				System.out.println("Tag Name matched and will be clicked");
				option.click();

				//return option;
				break;
			}

		}
		//return null;
	}

	*//**
	 * Select option from Select
	 * @param select
	 * @param sValueToBeSelected
	 *//*
	public static boolean select(WebElement options,String sValueToBeSelected){
		logger.info("INTO THE METHHOD select");
		try{

			Select select = new Select(options);
			select.selectByVisibleText(sValueToBeSelected);
			logger.info("OUT OF METHHOD select");
			return true;
		}
		catch(Exception e)
		{
			logger.error("Some error came on function->select->"+e.getMessage());
			return false;
		}
	}
	*//**
	 * Select elements from list of Element	when HTML have ul li tags
	 * @param lstElementList
	 * @param sValueToBeSelected
	 * @throws Exception
	 *//*
	public static boolean selectFromList(List<WebElement> lstElementList, String sValueToBeSelected) throws Exception{
		logger.info("START OF FUNCTION->selectFromList");
		boolean flag = false;
		try{
			System.out.println("Total element found "+ lstElementList.size());
			System.out.println("Value to be selected "+ sValueToBeSelected + " from list" + lstElementList);

			for(WebElement e: lstElementList){
				///System.out.println(">>>>>>>>>>>>>"+e.getText()+"<<<<<<<<<<<<<<<");
				if (e.getText().equalsIgnoreCase(sValueToBeSelected)){
					logger.info("Value matched in list as->"+e.getText());
					e.click();
					flag=true;
					break;
				}
			}
			if(flag==false)
			{
				throw new Exception("No match found in the list for value->"+sValueToBeSelected);
			}
			logger.info("END OF FUNCTION->selectFromList");
		}
		catch(Exception e)
		{
			throw new Exception("THERE IS AN EXCEPTION ON SELECTING VALUE FROM LIST->"+e.getMessage());
		}finally{
			return flag;
		}
	}

	*//**
	 * Select elements from list of Element
	 * @param lstElementList
	 * @param sValueToBeSelected
	 *//*
	public static WebElement fetchElementFromList(List<WebElement> lstElementList, String sValueToBeSelected){
		WebElement element=null;
		// System.out.println("Total element found "+ lstElementList.size());
		// System.out.println("Value to be selected "+ sValueToBeSelected +
		// " from list" + lstElementList);
		try{
			for(WebElement e: lstElementList){
				// System.out.println(">>>>>>>>>>>>>"+e.getText()+"<<<<<<<<<<<<<<<");
				if (e.getText().equalsIgnoreCase(sValueToBeSelected)){
					return e;
					//e.click();

				}
			}
		}catch(Exception e)
		{
			logger.error("Element to be fetched does not existsed in drop down ");
		}

		return element;
	}


	*//**
	 * Click on lint in a list of elements
	 * @author bpant
	 * @param lstElementList
	 * @param sValueToBeSelected
	 * @param driver
	 * @return clickStatus
	 *//*
	public static boolean selectLinkInList(List<WebElement> lstElementList, String sValueToBeSelected,WebDriver driver)
	{
		logger.info("INTO THE METHHOD selectLinkInList");
		boolean status=false;
		try{
			logger.info("Total element found "+ lstElementList.size());
			logger.info("Value to be selected "+ sValueToBeSelected + " from list" + lstElementList);

			for(WebElement e: lstElementList){
				logger.info(">>>>>>>>>>>>>"+e.getText()+"<<<<<<<<<<<<<<<");
				if (e.getText().equalsIgnoreCase(sValueToBeSelected)){
					//Generic_Methods.findElement(Locator.XPATH, ".//a", driver, e).click();
					System.out.println("result01");
					status = true;
					break;

				}
			}
		}catch(Exception e)
		{
			logger.error("Some error came on function->selectLinkInList->"+e.getMessage());
		}
		logger.info("OUT OF METHHOD selectLinkInList");
		return status;
	}


	*//**
	 * Waits for an element by polling for its availability after every 1 sec
	 * @author ssachdeva
	 * @param driver
	 * @param sXpathLocator
	 * @param iTimeOut
	 * @return
	 *//*
	public static WebElement fluentWait(WebDriver driver, final WebElement element,int iTimeOut) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(iTimeOut, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return element;
			}
		});

		return  foo;
	};

	*//**
	 * Find element with the help of driver or parent WebElement till a given default time(30 Sec Max)
	 * @param locator for locator use Locator enumration
	 * @param locatorString  the string contain xpath/css/tagname/id/link text
	 * @param activeElement
	 * @return
	 *//*
	public static WebElement findElement(ConstantElement.Locator locatorString locatorString,WebDriver driver,Object... activeElement)
	{

		int timeOut =30;
		int sleepTime =1000;
		WebElement elementToReturn = null;

		try
		{
			switch( "xpath"locator.getLocatorName().toLowerCase().trim() )
			{
				case "xpath":
					elementToReturn = findElement(timeOut, sleepTime, By.xpath(locatorString), driver, activeElement);
					break;
				case "id":
					elementToReturn = findElement(timeOut, sleepTime, By.id(locatorString), driver, activeElement);
					break;
				case "css":
					elementToReturn = findElement(timeOut, sleepTime, By.cssSelector(locatorString), driver, activeElement);
					break;
				case "class":
					elementToReturn = findElement(timeOut, sleepTime, By.className(locatorString), driver, activeElement);
					break;
				case "linktext":
					elementToReturn = findElement(timeOut, sleepTime, By.linkText(locatorString), driver, activeElement);
					break;
				case "partiallinktext":
					elementToReturn = findElement(timeOut, sleepTime, By.partialLinkText(locatorString), driver, activeElement);
					break;
				case "tagname":
					elementToReturn = findElement(timeOut, sleepTime, By.tagName(locatorString), driver, activeElement);
					break;
				default:
					System.out.println("Wrong Locator mentioned!");
					logger.error("Wrong Locator mentioned!");
			}

		}
		catch(Exception e)
		{
			logger.error(e.getStackTrace());
		}

		return elementToReturn;

	}

	*//**
	 *  Find element with the help of driver or patent WebElement till a time mentioned in timeOut  parameter
	 * @param locator
	 * @param locatorString
	 * @param timeOut
	 * @param driver
	 * @param activeElement
	 * @return
	 *//*
	public static WebElement findElement(ConstantElement.Locator locatorString locatorString,int timeOut,WebDriver driver,Object... activeElement)
	{

		int sleepTime =1000;
		WebElement elementToReturn = null;

		try
		{
			switch("xpath"locator.getLocatorName().toLowerCase().trim())
			{
				case "xpath":
					elementToReturn = findElement(timeOut, sleepTime, By.xpath(locatorString), driver, activeElement);
					break;
				case "id":
					elementToReturn = findElement(timeOut, sleepTime, By.id(locatorString), driver, activeElement);
					break;
				case "css":
					elementToReturn = findElement(timeOut, sleepTime, By.cssSelector(locatorString), driver, activeElement);
					break;
				case "class":
					elementToReturn = findElement(timeOut, sleepTime, By.className(locatorString), driver, activeElement);
					break;
				case "linktext":
					elementToReturn = findElement(timeOut, sleepTime, By.linkText(locatorString), driver, activeElement);
					break;
				case "partiallinktext":
					elementToReturn = findElement(timeOut, sleepTime, By.partialLinkText(locatorString), driver, activeElement);
					break;
				case "tagname":
					elementToReturn = findElement(timeOut, sleepTime, By.tagName(locatorString), driver, activeElement);
					break;
				default:
					System.out.println("Wrong Locator mentioned!");
					logger.error("Wrong Locator mentioned!");
			}

		}

		catch(Exception e)
		{
			logger.error("Error came on finding an element->"+e.getMessage());
			throw e;
		}

		return elementToReturn;

	}

	private static WebElement findElement(int timeOutInSeconds,int sleepInMillis,final By locator,WebDriver driver,Object... activeElements)
	{
		// WebDriver driver = (WebDriver)activeElements[0];
		// final WebElement activeElement = activeElements.length==2?(WebElement)activeElements[1]:null;
		final WebElement activeElement = activeElements.length==1?(WebElement)activeElements[0]:null;

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
		WebElement elementToReturn =  wait.until(new Function<WebDriver,WebElement>()
				{
			@Override
			public WebElement apply(WebDriver driver) {

				if(activeElement!=null)
				{
					return activeElement.findElement(locator);
				}
				else
				{
					return driver.findElement(locator);
				}
			}

				});

		return elementToReturn;
	}

	*//**
	 * To verify if a text present in the list of webelements
	 * @param allElement
	 * @param driver
	 * @param textToMatch
	 * @return
	 *//*
	public static boolean isElementInScreen(List<WebElement> allElement,WebDriver driver,String textToMatch)
	{
		boolean flag = false;
		try{
			for(WebElement header:allElement)
			{
				if(header.getText().toLowerCase().trim().contains(textToMatch.toLowerCase().trim()))
				{
					flag = true;
					logger.info("Traversing in header->"+header.getText());
					break;
				}
			}
			logger.info("flag value is->"+flag);
			logger.info("OUT OF isColumnVisible METHOD");
		}
		catch(Exception e){
			logger.error("Error came on isElementInScreen METHOD->"+e.getMessage());
		}
		return flag;
	}

	//Method to execute an exe file
	public void executeScript(String scriptPath) throws IOException
	{
		//scriptPath is the path of the executable
		Runtime.getRuntime().exec(scriptPath);
	}

	// This Method gives the Input value to a Element
	public void fn_Input(String ObjectLogicalName_XL, Object ValueToInput) throws SQLException{
		System.out.println("IN Fn_Input>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ObjectLogicalName_XL+ ">>>>>>>>>>>>>"+ValueToInput );
		WebElement myAppObject=fn_GetApplicationObject(ObjectLogicalName_XL);
		System.out.println("IN Fn_Input    myAppObject >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+myAppObject);
		String tagName=myAppObject.getTagName();
		if(tagName.equalsIgnoreCase("select")){
			String InputVal_Select=ValueToInput.toString();
			try{
				double val_double=Double.parseDouble(InputVal_Select);

				int indexnum=BigDecimal.valueOf(val_double).intValue();
				new Select(myAppObject).selectByIndex(indexnum);
			}catch(Exception e){
				try{
					new Select(myAppObject).selectByVisibleText((String) ValueToInput);
				}catch(Exception c){
					new Select(myAppObject).selectByValue((String) ValueToInput);
				}
			}

		}else{
			myAppObject.clear();
			String ValueToInput_ED=(String) ValueToInput;
			myAppObject.sendKeys(ValueToInput_ED);
		}


	}




	// This click on the Element
	
	 * public void fn_Click(String ObjectInfo) throws SQLException{ WebElement
	 * myAppObject=fn_GetApplicationObject(ObjectInfo); myAppObject.click();
	 * //////String Query="Select Object_Identification_Value from ["+SheetName+
	 * "$] where Object_Logical_Name='"+ObjLogicalName+"'";
	 *
	 *
	 *
	 * }
	 

	//This method return the actual location of the element.
	public WebElement fn_GetApplicationObject(String ObjectLogicalName_XL) throws SQLException{
		System.out.println("Driver Obect: " +Driver_Object);
		String[]ArrObjInfo=ObjectLogicalName_XL.split("##");
		String RealObjectInfo=ArrObjInfo[0];
		String LocatorType=ArrObjInfo[1];
		WebElement AppObject=null;
		if(LocatorType.equalsIgnoreCase("NM")){
			AppObject=Driver_Object.findElement(By.name(RealObjectInfo));
		}else if(LocatorType.equalsIgnoreCase("XP")){
			AppObject=Driver_Object.findElement(By.xpath(RealObjectInfo));
		}else if(LocatorType.equalsIgnoreCase("LT")){
			AppObject=Driver_Object.findElement(By.linkText(RealObjectInfo));
		}else if(LocatorType.equalsIgnoreCase("CLS")){
			AppObject=Driver_Object.findElement(By.className(RealObjectInfo));
		}else if(LocatorType.equalsIgnoreCase("ID")){
			AppObject=Driver_Object.findElement(By.id(RealObjectInfo));

		}else if(LocatorType.equalsIgnoreCase("CSS")){
			AppObject=Driver_Object.findElement(By.cssSelector(RealObjectInfo));
		}

		return AppObject;
	}

	*//**
	 *  this Method HighLight a element
	 * @param driver
	 * @param element
	 *//*

	public static void highlightElement(WebDriver driver, WebElement element) {
		try{
			logger.info("INTO METHOD highlightElement");
			//propFile = new ReadPropertiesFile();
			if(propFile.getHighlightElement().trim().equals("1")){
				logger.info("highlight Element Started");
				for (int i = 0; i < 1; i++) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
							element, "background: yellow; border: 4px solid red;");
					Thread.sleep(400L);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
							element, "");
				}
			}
			else if(propFile.getHighlightElement().trim().equals("0"))
			{
				logger.info("highlight Element Blocked In Config");
			}
			else
			{
				logger.info("Wrong Flag Set In Config File For HighlightElement");
			}
		}catch(Exception e){
			logger.error("SOME ERROR IN METHOD highlightElement->"+e.getMessage());
			e.printStackTrace();
		}
		logger.info("OUT OF METHOD highlightElement");

	}


	//this Method HighLight a element
	public static void highlightElementBorder(WebDriver driver, WebElement element) {
		try{
			for (int i = 0; i < 1; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
						element, "border: 4px solid red;");
				Thread.sleep(1000L);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
						element, "");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//for use in homePage
	public static void WaitforElementVisible(WebDriver driver,WebElement e) throws Exception
	{

		//WebElement dynamicObjectLink = null;
		try {


			(new WebDriverWait(driver, 150))
			.until(ExpectedConditions.visibilityOf(e));

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex);
		}

	}


	*//**
	 * Take snapshot
	 * @param WebDriver_Object
	 * @return
	 * @throws Exception
	 * @throws IOException
	 *//*
	public static String Fn_TakeSnapShotAndRetPath(WebDriver WebDriver_Object) throws Exception{
		logger.info("INTO METHOD->Fn_TakeSnapShotAndRetPath");
		String FullSnapShotFilePath="";
		// ReadPropertiesFile propFile=null;
		//try {
		//propFile = new ReadPropertiesFile();
		//} catch (IOException e1) {
		// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
		try{
			if(propFile.getTakeSnapshot().trim().equals("1")){
				logger.info("Take Screen shot started");
				StackTraceElement [] stackTrace = Thread.currentThread().getStackTrace();

				File SrcFile=((TakesScreenshot)WebDriver_Object).getScreenshotAs(OutputType.FILE);

				String TimeStamp=fn_GetCurrentTimeStamp();
				String FolderPath="";
				for(StackTraceElement element : stackTrace)
				{

					if(element.getClassName().toLowerCase().contains("com.rms.nextgen.test"))
					{
						FolderPath = "test-output/SnapshotFolder/"+element.getMethodName()+"/";
						System.out.println(element.getMethodName());
					}
				}



				File FolderObj=new File(FolderPath);
				FolderObj.mkdir();
				FolderPath=FolderObj.getAbsolutePath();
				FullSnapShotFilePath=FolderPath+"/"+WebDriver_Object.getTitle()+TimeStamp+".bmp";
				File DestFile=new File(FullSnapShotFilePath);
				FileUtils.copyFile(SrcFile, DestFile);
			}
			else if(propFile.getTakeSnapshot().trim().equals("0"))
			{
				logger.info("TakeSnapshot blocked in config file");
			}
			else
			{
				logger.error("wrong TakeSnapshot flag in config file");
			}
			logger.info("OUT OF METHOD->Fn_TakeSnapShotAndRetPath");
		}
		catch(Exception e)
		{
			logger.error("SOME ERROR IN METHOD->Fn_TakeSnapShotAndRetPath->"+e.getMessage());
			throw new Exception("SOME ERROR IN METHOD->Fn_TakeSnapShotAndRetPath->"+e.getMessage());
		}

		return FullSnapShotFilePath;

	}

	 Method for taking the Screen Shot  End 
	//This Method Return the Date as String
	public static String fn_GetCurrentTimeStamp(){
		Date dte=new Date();
		DateFormat df=DateFormat.getDateTimeInstance();
		String strdte=df.format(dte);
		strdte=strdte.replaceAll(":", "_");
		return strdte;
	}

	public void waitForElementToGetLoaded(long waitSec){
		Driver_Object.manage().timeouts().implicitlyWait(waitSec, TimeUnit.SECONDS);
	}


	//This Method return Total Number of the Portfolios
	public static int  total_Number_OfRecords(WebElement element)
	{
		int total_no_of_Exposure=0 ;
		try{

			String pagerLableString=element.getText();
			String pagerLableInt=pagerLableString.replaceAll("[a-zA-z]","");
			System.out.println(pagerLableString);
			StringTokenizer str = new StringTokenizer(pagerLableInt);
			String s1=null;
			while(str.hasMoreElements()) {
				System.out.println(str.nextElement());
				s1=(String) str.nextElement();

			}
			total_no_of_Exposure=Integer.parseInt(s1);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return total_no_of_Exposure;
	}


	public static String returnLogFilePath() throws IOException{
		String TimeStamp=fn_GetCurrentTimeStamp();
		String FolderPath="test-output\\ApplicationLog\\application_"+TimeStamp+"\\";
		File FolderObj=new File(FolderPath);
		FolderObj.mkdir();
		FolderPath=FolderObj.getAbsolutePath();
		String FullFilePath=FolderPath+"\\"+"application.log";
		System.setProperty("filename",FullFilePath);
		return FullFilePath;

	}

	public static Logger returnLogFilePath(String name) throws IOException{
		logger = Logger.getLogger(name);
		String TimeStamp=fn_GetCurrentTimeStamp();
		String FolderPath="test-output\\ApplicationLog\\"+name+"_"+TimeStamp+"\\";
		File FolderObj=new File(FolderPath);
		FolderObj.mkdir();
		FolderPath=FolderObj.getAbsolutePath();
		String FullFilePath=FolderPath+"\\"+"application.log";
		System.setProperty("filename",FullFilePath);
		Generic_Methods.getLoggerConfiguration();

		logger.info("Log file for "+name+" has been created!");
		return logger;

	}


	public void LoadTime(WebDriver webDriver, WebElement element ){

		long startTime = System.currentTimeMillis()/1000;
		System.out.println("The startTime is "+startTime);
		//Set the acceptable Page load time to 600 sec
		webDriver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);

		WebElement search = webDriver.findElement(By.name("q"));
		//Iterate through the loop as long as time(60sec) is with in the acceptable Page load time
		while(((System.currentTimeMillis()/1000)-startTime)<600){
			if(search.isDisplayed()){
				long endTime = System.currentTimeMillis()/1000;
				System.out.println("The endTime is "+endTime);
				long loadTime = endTime - startTime;
				System.out.println("Totaltime: " +loadTime + " seconds");
				break;
			}
		}
	}

	@Deprecated
	public void fn_mouseOverByXPATH(WebDriver DriverObject,WebElement element){


		Actions builder = new Actions(DriverObject);
		builder.moveToElement(element).build().perform();
	}

	*//**
	 * mouse overs to an element specified.
	 * @param driver
	 * @param Element
	 *//*
	public static void mouseOverElement(WebDriver driver,WebElement Element){
		Actions builder = new Actions(driver);
		builder.moveToElement(Element).build().perform();
	}

	*//**
	 * mouse overs to an element and click specified.
	 * @param driver
	 * @param Element
	 *//*
	public static void mouseOverElementClick(WebDriver driver,WebElement Element){
		Actions builder = new Actions(driver);
		builder.moveToElement(Element).click().build().perform();
	}
	public  String[][] getData_XL(String WorkbookPath, String SheetName) throws IOException{

		System.out.println("WorkbookPath============================="+WorkbookPath);
		System.out.println("SheetName============================="+SheetName);
		FileInputStream fisObj=new FileInputStream(WorkbookPath);
		// System.out.println("fisObj=========================================="+fisObj);
		Workbook WBookObj=new HSSFWorkbook(fisObj);
		Sheet WSheetObj=WBookObj.getSheet(SheetName);
		int RowCount=WSheetObj.getLastRowNum();
		int ColmCount=WSheetObj.getRow(1).getLastCellNum();
		System.out.println("=============================================="+RowCount);
		System.out.println("ColmCount====================================="+ColmCount);
		Object CellVal="";
		String[][] ArrObj=new String[RowCount][ColmCount];
		for(int i=0; i<=RowCount-1; i++){
			Row RowObject=WSheetObj.getRow(i+1);
			int CellCount=RowObject.getLastCellNum();
			for(int j=0; j<=CellCount-1; j++){
				int CellType=RowObject.getCell(j).getCellType();
				if(CellType==Cell.CELL_TYPE_STRING){
					CellVal=RowObject.getCell(j, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
				}else if(CellType==Cell.CELL_TYPE_NUMERIC){
					CellVal=RowObject.getCell(j, Row.CREATE_NULL_AS_BLANK).getNumericCellValue();
				}else if(CellType==Cell.CELL_TYPE_BLANK){
					CellVal="";
				}
				System.out.println("CellVal================================="+CellVal);
				ArrObj[i][j]=(String) CellVal;
			}


		}
		return ArrObj;
	}


	@Deprecated
	public Connection getDBConnection() throws Exception {

		try {

			//propFile = new ReadPropertiesFile();
			if (dbConnection == null) {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://" +propFile.getDBServerName()+ ":1433;DatabaseName=" + propFile.getDBName() + "";
				dbConnection = DriverManager.getConnection(url, propFile.getDBUserId(),propFile.getDBPassword());
				System.out.println("performance DB connection : " + dbConnection);
				System.out.println("connection state :"+ dbConnection.isClosed());
			}

			return dbConnection;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	*//**
	 * Get Connected to SQL Server
	 * @param db_SQLServer
	 * @param db_SQLDBName
	 * @param db_userid
	 * @param db_pwd
	 * @return
	 * @throws SQLException
	 *//*
	public static Connection getConnectionToSQLServer(String db_SQLServer,String db_SQLDBName,String db_userid,String db_pwd) throws SQLException
	{

		try
		{

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			if(dbConnection!=null)
			{
				dbConnection.close();

			}
			dbConnection = DriverManager.getConnection("jdbc:sqlserver://"+db_SQLServer+";"+"databaseName="+db_SQLDBName,db_userid,db_pwd);

		}
		catch(Exception e)
		{
			logger.error("SOME ERROR IN getConnectionToSQLServer->"+e.getMessage());
			e.printStackTrace();


		}
		return dbConnection;

	}




	*//**
	 * To connect with correct Database
	 * @param databaseType
	 * @return
	 * @throws Exception
	 *//*
	public static Connection getDBConnection(DatabaseType databaseType) throws Exception {

		try {

			logger.info("INTO METHOD getDBConnection");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="";
			if(dbConnection!=null)
			{
				dbConnection.close();
			}
			switch(databaseType.getDatabaseType().toUpperCase())
			{
				case "SERVICE_DB":
					url = "jdbc:sqlserver://" + propFile.getDBServerName() + ":1433;DatabaseName=" + propFile.getDBName() + "";
					dbConnection = DriverManager.getConnection(url, propFile.getDBUserId(), propFile.getDBPassword());
					logger.info("performance DB connection : " + dbConnection);
					logger.info("connection state :" + dbConnection.isClosed());
					break;
				case "APPLICATION_DB":
					url = "jdbc:sqlserver://" + propFile.getDBServerName() + ":1433;DatabaseName=" + propFile.getDBName() + "";
					dbConnection = DriverManager.getConnection(url, propFile.getDBUserId(), propFile.getDBPassword());
					logger.info("performance DB connection : " + dbConnection);
					logger.info("connection state :" + dbConnection.isClosed());
					break;


			}



			logger.info("OUT OF METHOD getDBConnection");
			return dbConnection;
		} catch (Exception e) {
			logger.error("SOME ERROR IN getDBConnection->"+e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	//public boolean waitUntilPresent(WebDriver DriverObject,WebElement element){
	//	boolean isElementPresent = false;
	//	WebDriverWait wait = new WebDriverWait(DriverObject,90);
	//	 wait.until(ExpectedConditions.presenceOfElementLocated()
	//	return element;
	//}
	//
	//public WebElement waitUntilClickable(WebDriver DriverObject,WebElement element){
	//
	//	WebDriverWait wait = new WebDriverWait(DriverObject,60);
	//	element = wait.until(ExpectedConditions.elementToBeClickable(fn_GetObjectBY());
	//	return element;
	//}


	*//**
	 * Get a hashmap containing all the table Filters as values and key will be the name of the column
	 * @param headers
	 * @param thead
	 * @return
	 * @throws InterruptedException
	 *//*
	public static  Map<String,WebElement> getTableFilters(Map<String,WebElement> headers,WebElement thead) throws InterruptedException
	{
		logger.info("START OF FUNCTION ->getTableFilters");
		Map<String,WebElement> storeFilters = new LinkedHashMap<String,WebElement>();
		//Thread.sleep(5000l);
		List<WebElement> allFilters =  thead.findElements(By.className("ui-iggrid-filtercell"));

		Object [] allKey =  headers.keySet().toArray();
		for(int i=0;i<allFilters.size();i++ )
		{
			storeFilters.put(allKey[i].toString(), allFilters.get(i));
			logger.info("Key for table filters::-> "+storeFilters.keySet().toArray()[i]+"  -> AND -> Filter in hashmap::->"+storeFilters.get(storeFilters.keySet().toArray()[i]));
		}
		logger.info("END OF FUNCTION ->getTableFilters");
		return storeFilters;
	}


	*//**
	 * Get a hashmap containing all the table headers as values and key will be the name of the column
	 * @param thead
	 * @return
	 * @throws InterruptedException
	 *//*
	public static  Map<String,WebElement> getTableHeaders(WebElement thead) throws InterruptedException
	{
		System.out.println("Into getTableHeaders method");
		logger.info("START OF FUNCTION ->getTableHeaders");
		Map<String,WebElement> storeHeader = new LinkedHashMap<String,WebElement>();
		//Thread.sleep(4000l);
		List<WebElement> allHeader =  thead.findElements(By.tagName("th"));
		int i=0;
		for(WebElement header:allHeader )
		{
			if(header.getText().trim().toLowerCase()!=null)
			{
				//System.out.println(header.getText().trim().toLowerCase()+":::header count:::"+allHeader.size());
				storeHeader.put(header.getText().trim().toLowerCase(), header);
				i++;
			}

		}
		logger.info("All Header Controls added in hash map!");
		logger.info("END OF FUNCTION ->getTableHeaders");
		return storeHeader;
	}



	*//**
	 * Open feature chooser list
	 * @param allHeaders map of all headers
	 * @param columnName column name for which you want to choose column
	 * @param driver
	 * @throws InterruptedException
	 *//*
	public static void clickFeatureChooser(Map<String,WebElement>  allHeaders,String columnName,WebDriver driver) throws InterruptedException
	{
		try
		{
			logger.info("START OF FUNCTION::->clickFeatureChooser");
			Map<String,WebElement>  list_allHeaders = allHeaders;
			WebElement header = Generic_Methods.findElement(ConstantElement.Locator.CLASS, "ui-iggrid-indicatorcontainer", driver,list_allHeaders.get(columnName));

			logger.info("Type of selected header->"+header.getTagName());

			//WebElement featureChooser = Generic_Methods.findElement(ConstantElement.Locator.XPATH, ".//a[contains(@id,'_featureChooser_headerButton_')]/span",driver,header );
			WebElement featureChooser = Generic_Methods.findElement(ConstantElement.Locator.XPATH, "//a[contains(@id,'_featureChooser_headerButton_JobId')]/span",driver,header );

			Generic_Methods.highlightElement(driver, featureChooser);
			featureChooser.click();
			logger.info("END OF FUNCTION::->clickFeatureChooser");
		}
		catch(Exception e)
		{
			logger.error("An error occurred:::->" + e.getMessage());
		}
	}

	*//**
	 * new clickFeatureChooser
	 * @param allHeaders
	 * @param columnName
	 * @param driver
	 * @param featureChooser
	 * @throws InterruptedException
	 *//*
	public static void clickFeatureChooser_new(Map<String,WebElement>  allHeaders,String columnName,WebDriver driver,WebElement featureChooser) throws InterruptedException
	{
		try {
			logger.info("START OF FUNCTION::->clickFeatureChooser");
			Map<String, WebElement> list_allHeaders = allHeaders;
			System.out.println("clickFeatureChooser02");
			// WebElement header =
			// Generic_Methods.findElement(ConstantElement.Locator.CLASS,
			// "ui-iggrid-indicatorcontainer",
			// driver,list_allHeaders.get(columnName));

			// logger.info("Type of selected header->"+header.getTagName());

			Generic_Methods.highlightElement(driver, featureChooser);
			featureChooser.click();
			logger.info("END OF FUNCTION::->clickFeatureChooser");
		} catch (Exception e) {
			logger.error("An error occurred:::->" + e.getMessage());
		}
	}


	*//**
	 * get the filter icon
	 * @param filters
	 * @param columnName
	 * @param driver
	 * @return
	 * @throws InterruptedException
	 *//*
	public static WebElement getFilterIcon(Map<String, WebElement> filters,String columnName,WebDriver driver,String  loc) throws InterruptedException {
		logger.info("START OF FUNCTION::->getFilterIcon");
		System.out.println("Column to click for filter:->"+columnName);
		System.out.println("getFilterIcon 01");
		//WebElement link_filterIcon = Generic_Methods.findElement(ConstantElement.Locator.XPATH, "./div[contains(@class,'ui-iggrid-indicatorcontainer')]/a[contains(@id,'_button')]",driver,filters.get(columnName) );
		WebElement link_filterIcon = Generic_Methods.findElement(ConstantElement.Locator.XPATH,loc,driver, filters.get(columnName));
		System.out.println("getFilterIcon 02");
		Generic_Methods.highlightElement(driver, link_filterIcon);
		logger.info("END OF FUNCTION::->getFilterIcon");
		return link_filterIcon;

	}
	*//**
	 * new getFilterIcon
	 * @param filters
	 * @param columnName
	 * @param driver
	 * @param loc
	 * @return
	 * @throws InterruptedException
	 *//*

	public static WebElement getFilterIcon_new(Map<String, WebElement> filters,String columnName,WebDriver driver,String  loc) throws InterruptedException {
		logger.info("START OF FUNCTION::->getFilterIcon");
		System.out.println("Column to click for filter:->" + columnName);
		// WebElement link_filterIcon =
		// Generic_Methods.findElement(ConstantElement.Locator.XPATH,
		// "./div[contains(@class,'ui-iggrid-indicatorcontainer')]/a[contains(@id,'_button')]",driver,filters.get(columnName)
		// );
		WebElement link_filterIcon = Generic_Methods.findElement(ConstantElement.Locator.XPATH,loc,driver, filters.get(columnName));
		Generic_Methods.highlightElement(driver, link_filterIcon);

		Generic_Methods.highlightElement(driver, link_filterIcon);
		link_filterIcon.click();
		logger.info("END OF FUNCTION::->getFilterIcon");
		return link_filterIcon;

	}


	*//**
	 * Select filter criteria
	 * @param filterCriteria
	 * @param driver
	 * @throws InterruptedException
	 *//*
	public static void selectFilterCriteria(String filterCriteria, WebDriver driver) throws InterruptedException {
		try
		{
			logger.info("START OF FUNCTION::->selectFilterCriteria");
			Thread.sleep(4000l);
			System.out.println("Filter criteria Is:::->"+filterCriteria);

			String dynamicPath ="//li[contains(@class,'ui-iggrid-filterddlistitemicons')]/span[text()='"+ filterCriteria +"']";

			System.out.println("Complete XPath ->"+dynamicPath);
			List <WebElement> list_allFilterOptions = driver.findElements(By.xpath(dynamicPath ));
			System.out.println("Number of elements find ->"+list_allFilterOptions.size());
			boolean flag = false;
			for(WebElement list_element : list_allFilterOptions)
			{
				System.out.println("ID->:"+list_element.getAttribute("id")+"::::::::");
				if(list_element.isDisplayed())
				{
					Generic_Methods.highlightElement(driver, list_element);
					list_element.click();
					flag = true;
					break;
				}
			}
			if(flag==false)
			{
				System.out.println("Wrong value given for filter, Please mention right value!");
				Reporter.log("Wrong value given for filter, Please mention right value!");
			}
			logger.info("END OF FUNCTION::->selectFilterCriteria");
		}
		catch(Exception e)
		{
			logger.error("An error occurred:::->" + e.getMessage());
		}
	}

	*//**
	 * Select the appropriate feature chooser value
	 * Here if you want to hide filters pass True in optionalFlag, if you want to unhide filters pass Fasle in optionalFlag,
	 * if optionalFlag is null feature always be clicked (Ex. in the case of clicking 'Column Chooser')
	 * @author bpant
	 * @param featureChooser
	 * @param driver
	 * @param optionalFlag
	 * @throws InterruptedException
	 *//*
	public static void selectFeatureChooser(String featureChooser ,WebDriver driver,Object ... optionalFlag) throws InterruptedException
	{
		try
		{
			logger.info("START OF FUNCTION::->selectFeatureChooser");

			Thread.sleep(2000l);
			System.out.println("before filter");
			// List<WebElement> list_allChooser =
			// driver.findElements(By.xpath("//li[contains(@id,'featurechooser_dd_li_')]//span[contains(text(),'"+featureChooser+"')]"));
			List<WebElement> list_allChooser =  driver.findElements(By.xpath("//div[@class='ui-widget-content ui-corner-all']//ul//li"));
			System.out.println("before filter01");
			for(WebElement list_element : list_allChooser)
			{
				System.out.println("list_element"+list_element.getText());
				if(list_element.isDisplayed())
				{
					if(optionalFlag.length==0)
					{
						Generic_Methods.highlightElement(driver, list_element);
						Thread.sleep(1000);
						System.out.println("before filter00");
						list_element.click();

					}
					else if((boolean)optionalFlag[0]==true)
					{
						if(!Generic_Methods.findElement(ConstantElement.Locator.XPATH, "//tr[@data-role='filterrow']", driver).isDisplayed())

						{
							Generic_Methods.highlightElement(driver, list_element);
							Thread.sleep(1000);
							System.out.println("before filter02");
							list_element.click();
							System.out.println("before filter03");
							Thread.sleep(1000);

						}
					}
					else if((boolean)optionalFlag[0]==false)
					{
						if(Generic_Methods.findElement(ConstantElement.Locator.XPATH, "//tr[@data-role='filterrow']", driver).isDisplayed())
						{

							Generic_Methods.highlightElement(driver, list_element);
							System.out.println("before filter04");
							list_element.click();

						}
					}
					Generic_Methods.waitForLoadImageHide(list_element, 100);
					break;
				}
			}
			logger.info("END OF FUNCTION::->selectFeatureChooser");
		}
		catch(Exception e)
		{
			logger.error("An error occurred:::->" + e.getMessage());
		}
	}


	*//**
	 *  if no value is passed in allHeaderText the function will reset the hidden fields
	 *  if multiple parameter passed in allHeaderText the function will hide these all fields
	 * @param driver
	 * @param allHeaders
	 * @param columnName
	 * @param allHeaderText
	 * @throws InterruptedException
	 *//*
	*//**
	 * Function to perform column chooser,(Must be called inside POM)
	 * @param driver
	 * @param allHeaders
	 * @param columnName
	 * @param hideShow
	 * @throws InterruptedException
	 *//*
	public static void performColumnChooser(WebDriver driver,Map<String,WebElement>  allHeaders,String columnName, boolean hideShow) throws InterruptedException
	{
		try
		{
			logger.info("START OF FUNCTION::->performColumnChooser");
			// selectFeatureChooser("Column Chooser",driver);

			if(columnName==null)
			{
				try
				{

					WebElement span_performChooser = Generic_Methods.findElement(ConstantElement.Locator.XPATH, "//span[text()='reset']", driver);
					Generic_Methods.highlightElement(driver, span_performChooser);
					span_performChooser.click();
				}
				catch(NoSuchElementException e)
				{
					System.out.println("The reset button is not present now!");
					logger.info("The reset button is not present now!");
				}
				//   Thread.sleep(2000l);

			}
			else
			{

				List<WebElement> list_allColumnChooser = driver.findElements(By.xpath("//ul[contains(@class,'ui-iggrid-columnchooser-listitems')]/li"));


				for(WebElement list_element:list_allColumnChooser)
				{
					if(hideShow==false){
						if((list_element.getText().trim().toLowerCase().contains(columnName.toLowerCase().trim()))&&(list_element.findElements(By.xpath(".//span/a[text()='Hide']")).size()!=0))
						{
							Generic_Methods.highlightElement(driver, list_element);
							list_element.click();
							break;
						}
					}
					else if(hideShow==true)
					{
						if((list_element.getText().trim().toLowerCase().contains(columnName.toLowerCase().trim()))&&(list_element.findElements(By.xpath(".//span/a[text()='Show']")).size()!=0))
						{
							Generic_Methods.highlightElement(driver, list_element);
							list_element.click();
							break;
						}
					}
				}



			}

			//  WebElement span_ApplyButton = Generic_Methods.findElement(ConstantElement.Locator.XPATH, "//span[text()='Apply']", driver);
			//   span_ApplyButton.click();

			logger.info("END OF FUNCTION::->performColumnChooser");
		}
		catch(Exception e)
		{
			logger.error("An error occurred:::->" + e.getMessage());
		}
	}

	*//**
	 * Click on apply filter on feature chooser
	 * @param driver
	 *//*
	public static void clickApplyInColumnCooser(WebDriver driver)
	{
		logger.info("START OF FUNCTION::->performColumnChooser");
		try{
			WebElement span_ApplyButton = Generic_Methods.findElement(ConstantElement.Locator.XPATH, "//span[text()='Apply']", driver);
			span_ApplyButton.click();
		}
		catch(Exception e)
		{
			logger.error("An error occurred in clickApplyInColumnCooser:::->" + e.getMessage());
		}
		logger.info("END OF FUNCTION::->performColumnChooser");
	}

	*//**
	 * Sort column on the basis of a column name
	 * @author bpant
	 *@param headers (contain all the header node)
	 *@param columnName (Name of the coumn want to sort)
	 *@category Generic function
	 *//*
	public static void sortTable(Map<String,WebElement>  allHeaders,String columnName,boolean flag,WebDriver driver,WebElement image_LoadIcon)
	{
		logger.info("START OF FUNCTION::->sortTable");
		try{
			if(flag==false)
			{
				if((allHeaders.get(columnName.trim().toLowerCase()).findElements(By.xpath(".//div[contains(@class,'ui-iggrid-indicatorcontainer')]/span[contains(@class,'ui-iggrid-colindicator-desc')]")).size()==0))
				{
					if(allHeaders.get(columnName.trim().toLowerCase()).findElements(By.xpath(".//div[contains(@class,'ui-iggrid-indicatorcontainer')]/span[contains(@class,'ui-iggrid-colindicator-asc')]")).size()==0)
					{
						//Generic_Methods.highlightElement(driver, allHeaders.get(columnName.trim().toLowerCase()));
						allHeaders.get(columnName.trim().toLowerCase()).click();
						Generic_Methods.waitForLoadImageDisplay(image_LoadIcon, 4);
						Generic_Methods.waitForLoadImageHide(image_LoadIcon, 100);
					}
					//Generic_Methods.highlightElement(driver, allHeaders.get(columnName.trim().toLowerCase()));
					allHeaders.get(columnName.trim().toLowerCase()).click();
				}
			}
			else if((flag==true)&&(allHeaders.get(columnName.trim().toLowerCase()).findElements(By.xpath(".//div[contains(@class,'ui-iggrid-indicatorcontainer')]/span[contains(@class,'ui-iggrid-colindicator-asc')]")).size()==0))
			{
				//Generic_Methods.highlightElement(driver, allHeaders.get(columnName.trim().toLowerCase()));
				allHeaders.get(columnName.trim().toLowerCase()).click();
			}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		logger.info("START OF FUNCTION::->sortTable");
	}


	public static void getTimeOnSortTable(Map<String,WebElement>  allHeaders,String columnName,boolean flag,WebDriver driver,String xpathForTableBody)
	{
		logger.info("START OF FUNCTION::->sortTable");
		// HashMap<String, Long> timeDifference = new HashMap<String, Long>();
		//RMS_PerformanceData performanceData = new RMS_PerformanceData();
		try{
			if(flag==false)
			{
				   if((allHeaders.get(columnName.trim().toLowerCase()).findElements(By.xpath(".//div[contains(@class,'ui-iggrid-indicatorcontainer')]/span[contains(@class,'ui-iggrid-colindicator-desc')]")).size()==0))
                                {
                                  if(allHeaders.get(columnName.trim().toLowerCase()).findElements(By.xpath(".//div[contains(@class,'ui-iggrid-indicatorcontainer')]/span[contains(@class,'ui-iggrid-colindicator-asc')]")).size()==0)
                                  {
                                	            new Generic_Methods().highlightElement(driver, allHeaders.get(columnName.trim().toLowerCase()));
                                                allHeaders.get(columnName.trim().toLowerCase()).click();
                                                Generic_Methods.waitForLoadImageDisplay(image_LoadIcon, 4);
                                                Generic_Methods.waitForLoadImageHide(image_LoadIcon, 100);
                                  }
                                  new Generic_Methods().highlightElement(driver, allHeaders.get(columnName.trim().toLowerCase()));
                                  allHeaders.get(columnName.trim().toLowerCase()).click();
                                }
			}
			else if(flag==true)
			{


				//System.out.println("IN TRUE ASC ORDER!");
				//Generic_Methods.highlightElement(driver, allHeaders.get(columnName.trim().toLowerCase()));
				// System.out.println("AFTER HIGHLIGHT ASC ORDER!");
				//  performanceData.setStartTime(new Date().getTime());
				// timeDifference.put("start time",new Date().getTime());
				//  System.out.println("START TIME IS:"+timeDifference.get("start time"));
				// System.out.println("START TIME IS:"+performanceData.getStartTime());
				allHeaders.get(columnName.trim().toLowerCase()).click();
				WebDriverWait wait = new WebDriverWait(driver,10,1);
				wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(xpathForTableBody))));
				// timeDifference.put("end time",new Date().getTime() );
				//performanceData.setEndTime(new Date().getTime());
				//System.out.println("END TIME IS:"+timeDifference.get("end time"));
				//System.out.println("END TIME IS:"+performanceData.getEndTime());
				// performanceData.setDiffTime(performanceData.getEndTime()-performanceData.getStartTime());
				//System.out.println("TimeDifference="+performanceData.getDiffTime());
				// System.out.println("TimeDifference="+(timeDifference.get("end time")-timeDifference.get("start time")));

			}
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
		}
		logger.info("START OF FUNCTION::->sortTable");

	}


	*//**
	 * Set filter condition in Grid filter textbox which is currently in focus
	 * @param filterCondition
	 * @param filters
	 * @param columnName
	 * @throws InterruptedException
	 *//*
	public static void setTextInFocusedFilter(String filterCondition,Map<String, WebElement> filters, String columnName,WebDriver driver) throws InterruptedException
	{
		logger.info("START OF FUNCTION::->setTextInFocusedFilter");

		WebElement text_filterValue =   Generic_Methods.findElement(ConstantElement.Locator.XPATH, "//*[contains(@class,'ui-igedit-focus')]/input", driver,filters.get(columnName));
		Generic_Methods.highlightElement(driver, text_filterValue);
		text_filterValue.sendKeys(filterCondition);
		logger.info("END OF FUNCTION::->setTextInFocusedFilter");
	}

	*//**
	 * Wait for load image to be display on screen
	 * @param loadImage
	 * @param maxSecondTimeout
	 * @param isFailOnExcaption( optional parameter true if fail on exception)
	 *//*
	@Deprecated
	public static boolean waitForLoadImageDisplay(WebElement loadImage,int maxSecondTimeout,boolean... isFailOnExcaption)
	{
		try{
			logger.info("INTO METHOD waitForLoadImageDisplay");
			maxSecondTimeout = maxSecondTimeout*20;
			while((!loadImage.isDisplayed()&&(maxSecondTimeout>0)))
			{
				logger.info("Loading...CountDown="+maxSecondTimeout);
				System.out.println("Loading...CountDown="+maxSecondTimeout);
				try {
					Thread.sleep(50l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maxSecondTimeout--;
			}
			logger.info("OUT OF METHOD waitForLoadImageDisplay");
			return true;
		}
		catch(Exception e)
		{
			logger.error("SOME ERROR CAME IN METHOD->waitForLoadImageDisplay->"+e.getMessage());
			if(isFailOnExcaption.length!=0)
			{
				if(isFailOnExcaption[0]==true)
				{
					try{
						Assert.fail("SOME ERROR IN METHOD waitForLoadImageHide METHOD");

					}
					catch(AssertionError ee){
						return false;
					}
				}

			}
		}
		return false;

	}

	*//**
	 * Wait for Loading image to be disappear from screen
	 * @param loadImage
	 * @param maxSecondTimeout
	 * @param isFailOnExcaption( optional parameter true if fail on exception)
	 * @throws IOException
	 *//*
	@Deprecated
	public static void waitForLoadImageHide(WebElement loadImage,int maxSecondTimeout,boolean...isFailOnExcaption)
	{
		try{
			maxSecondTimeout = maxSecondTimeout*20;
			logger.info("INTO waitForLoadImageHide METHOD");
			while(loadImage.isDisplayed()&&(maxSecondTimeout>0))
			{
				System.out.println("Loading...CountDown="+maxSecondTimeout);
				logger.info("Loading...CountDown="+maxSecondTimeout);
				try {
					Thread.sleep(50l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				maxSecondTimeout--;
			}
			logger.info("OUT OF waitForLoadImageHide METHOD");
		}
		catch(Exception e)
		{

			logger.error("SOME ERROR IN METHOD waitForLoadImageHide METHOD->"+e.getMessage());
			if(isFailOnExcaption.length!=0)
			{
				if(isFailOnExcaption[0]==true)
				{
					Assert.fail("SOME ERROR IN METHOD waitForLoadImageHide METHOD");
				}
			}
		}
	}


	*//**
	 * Wait for html element to be display
	 * @param element
	 * @param maxSecondTimeout
	 * @param isFailOnExcaption( optional parameter true if fail on exception)
	 * @throws Exception
	 *//*
	public static boolean waitForElementToBeDisplay(WebElement element,int maxSecondTimeout,boolean... isFailOnExcaption) throws Exception
	{
		try{
			logger.info("INTO METHOD waitForElementToBeDisplay");
			maxSecondTimeout = maxSecondTimeout*20;
			while((!element.isDisplayed()&&(maxSecondTimeout>0)))
			{
				// logger.info("Loading...CountDown="+maxSecondTimeout);
				Thread.sleep(50l);
				maxSecondTimeout--;
			}
			if((maxSecondTimeout==0)&&(isFailOnExcaption.length!=0))
			{
				if(isFailOnExcaption[0]==true){
					logger.error("Element is not display within "+(maxSecondTimeout/20)+"Sec.");
					throw new Exception("Element is not display within "+(maxSecondTimeout/20)+"Sec.");
				}
			}
			logger.info("OUT OF METHOD waitForElementToBeDisplay");
			return true;
		}
		catch(UnhandledAlertException e)
		{
			throw new UnhandledAlertException("Unexpected alert is coming->waitForElementToBeDisplay->"+e.getMessage());
		}
		catch(NoSuchElementException e)
		{
			throw new NoSuchElementException("The element to be search is not present in the page->waitForElementToBeDisplay->"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Some exception in waitForElementToBeDisplay"+e.getMessage());
		}
	}

	*//**
	 * wait till test present on element
	 * @param element
	 * @param maxSecondTimeout
	 * @param isFailOnExcaption( optional parameter true if fail on exception)
	 * @throws Exception
	 *//*
	public static boolean waitForTextToBePresentOnElement(WebElement element,int maxSecondTimeout,String matchText,boolean... isFailOnExcaption) throws Exception
	{
		try{
			logger.info("INTO METHOD waitForTextToBePresentOnElement");
			maxSecondTimeout = maxSecondTimeout*20;
			while((!element.isDisplayed()&&(maxSecondTimeout>0)&&(element.getText().toLowerCase().equalsIgnoreCase(matchText.toLowerCase().trim()))))
			{
				logger.info("Loading...CountDown=" + maxSecondTimeout);
				Thread.sleep(50l);
				maxSecondTimeout--;
			}
			if((maxSecondTimeout==0)&&(isFailOnExcaption.length!=0))
			{
				if(isFailOnExcaption[0]==true){
					logger.error("Element is not display within "+(maxSecondTimeout/20)+"Sec.");
					throw new Exception("Element is not display within "+(maxSecondTimeout/20)+"Sec.");
				}
			}
			logger.info("OUT OF METHOD waitForTextToBePresentOnElement");
			return true;
		}
		catch(UnhandledAlertException e)
		{
			throw new UnhandledAlertException("Unexpected alert is coming->waitForTextToBePresentOnElement->"+e.getMessage());
		}
		catch(NoSuchElementException e)
		{
			throw new NoSuchElementException("The element to be search is not present in the page->waitForTextToBePresentOnElement->"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Some exception in waitForTextToBePresentOnElement"+e.getMessage());
		}
	}
	*//**
	 * Wait for html element to be hidden
	 * @param element
	 * @param maxSecondTimeout
	 * @param isFailOnExcaption( optional parameter true if fail on exception)
	 * @throws Exception
	 * @throws IOException
	 *//*
	public static boolean waitForElementToBeHidden(WebElement element,int maxSecondTimeout,boolean...isFailOnExcaption) throws Exception
	{
		try{
			logger.info("INTO waitForElementToBeHidden METHOD");
			maxSecondTimeout = maxSecondTimeout*20;
			while(element.isDisplayed()&&(maxSecondTimeout>0))
			{
				// logger.info("Loading...CountDown="+maxSecondTimeout);
				Thread.sleep(50l);
				maxSecondTimeout--;
			}
			if((maxSecondTimeout==0)&&(isFailOnExcaption.length!=0))
			{
				if(isFailOnExcaption[0]==true){
					logger.error("Element is not hidden within "+(maxSecondTimeout/20)+"Sec.");
					throw new Exception("Element is not hidden within "+(maxSecondTimeout/20)+"Sec.");
				}
			}
			logger.info("OUT OF METHOD waitForElementToBeHidden");
			return true;
		}
		catch(NoSuchElementException e)
		{
			throw new Exception("The element to be serach is not present in the page->waitForElementToBeHidden->"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Some exception in waitForElementToBeHidden"+e.getMessage());
		}
	}

	*//**
	 * Uses ExpectedCondition to wait for Element to Appear
	 * @param driver
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingInMilliSeconds
	 * @return
	 * @throws Exception
	 * @author ssachdeva
	 *//*
	public static boolean waitForElementToAppear(WebDriver driver, final WebElement element,int timeOutInSeconds,int pollingInMilliSeconds) throws Exception {
		try
		{
			return (new WebDriverWait(driver, timeOutInSeconds,pollingInMilliSeconds)).until(new ExpectedCondition<Boolean>()
					{
				@Override
				public Boolean apply(WebDriver driver) {
					logger.info("Waiting dfor element to be displayed ");
					return element.isDisplayed();
				}});

		}
		catch(NoSuchElementException e)
		{
			throw new Exception("The element to be serach is not present in the page->waitForElementToBeHidden->"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Some exception in waitForElementToBeHidden"+e.getMessage());
		}

	}

	public static boolean waitForElementToDisAppear(WebDriver driver, final WebElement element,int timeOutInSeconds,int pollingInMilliSeconds) throws Exception {
		try
		{
			return (new WebDriverWait(driver, timeOutInSeconds,pollingInMilliSeconds)).until(new ExpectedCondition<Boolean>()
					{
				@Override
				public Boolean apply(WebDriver driver) {

					logger.info("Waiting dfor element to be disappear ");
					return !element.isDisplayed();
				}});

		}
		catch(NoSuchElementException e)
		{
			throw new Exception("The element to be serach is not present in the page->waitForElementToBeHidden->"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new Exception("Some exception in waitForElementToBeHidden"+e.getMessage());
		}

	}





	*//**
	 * Select multiple checkbox from list
	 * @author bpant
	 * @param str_allValues
	 * @param list_AllNodes
	 * @param driver
	 * @throws Exception
	 *//*
	public static void selectCheckboxesInList(String[] str_allValues,List<WebElement> list_AllNodes,WebDriver driver) throws Exception
	{
		try
		{
			logger.info("START OF Function :::->selectCheckboxesInList");
			for(int int_start=0;int_start<str_allValues.length;int_start++){

				for(WebElement list_Node:list_AllNodes)
				{
					Generic_Methods.highlightElement(driver, list_Node);
					System.out.println(list_Node.getText());
					if(list_Node.getText().toLowerCase().contains(str_allValues[int_start].trim().toLowerCase()))
					{
						logger.info("Value matched for->"+list_Node.getText().trim());
						Generic_Methods.findElement(Locator.XPATH, ".//input[@type='checkbox']", driver, list_Node).click();
					}
				}
			}
			logger.info("END OF  Function:::->RMS_Home");
		}
		catch(Exception e)
		{
			logger.error("Some error  came on selectCheckboxesInList:::->"+e.getMessage());
			throw new Exception("Some error  came on selectCheckboxesInList:::->"+e.getMessage());
		}
	}



	*//**
	 * Execute DB Query
	 * @param query
	 * @param connection
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *//*
	public static ResultSet executeDBQuery(String query,Connection connection) throws IOException, ClassNotFoundException, SQLException
	{
		try{
			logger.info("INTO METHOD executeDBQuery");
			logger.info("connection is closed?==========="+connection.isClosed());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			//  if(rs.next())
			logger.info("....>>>"+connection.isClosed());
			logger.info("OUT OF METHOD executeDBQuery");
			return rs;
		}catch(Exception e){
			logger.info("SOME ERROR IN executeDBQuery->"+e.getMessage());
			System.out.println(e.getStackTrace());
			return null;
		}
	}

	public static int generateRandomNumber(int min, int max){
		Random r = new Random();

		int mynumber = r.nextInt(max - min) + min;
		return mynumber;
	}

	@Deprecated
	*//**
	 * Wait till element deleted from DOM
	 * @param driver
	 * @param xpathForElement Xpath of element
	 * @param waitSec
	 *//*
	public static void waitStalnessOf(WebDriver driver,String xpathForElement,int waitSec)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver,waitSec,1);
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(xpathForElement))));
		}
		catch(StaleElementReferenceException e)
		{
			System.out.println("ELEMENT IS NOT DELETED FROM GUI->"+e.getMessage());
			logger.info("ELEMENT IS NOT DELETED FROM GUI->"+e.getMessage());
		}
	}


	*//**
	 * Wait till element deleted from DOM using web element
	 *
	 * @param driver
	 * @param element
	 * @param waitSec
	 * @throws StaleElementReferenceException
	 * @throws NoSuchElementException
	 * @throws Exception
	 *//*
	public static void waitStalnessOf(WebDriver driver,WebElement element,int waitSec) throws StaleElementReferenceException,NoSuchElementException, Exception
	{
		try{
			logger.info("INTO METHOD->waitStalnessOf with webelement");
			WebDriverWait wait = new WebDriverWait(driver, waitSec, 1);
			wait.until(ExpectedConditions.stalenessOf(element));
			logger.info("OUT OF METHOD->waitStalnessOf with webelement");
		}
		catch(StaleElementReferenceException e)
		{
			throw new StaleElementReferenceException("ELEMENT IS NOT DELETED FROM GUI->"+e.getMessage());
		}
		catch(NoSuchElementException e)
		{
			throw new NoSuchElementException("Element not found->"+element);
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("=====================================");
			System.out.println(e.getMessage());
			throw new Exception("Some error in function->"+e.getStackTrace());
		}
	}


	*//**
	 * Wait till element deleted from DOM
	 * @param driver
	 * @param xpathForElement Xpath of element
	 * @param waitSec
	 *//*

	public static void waitStalnessOf(WebDriver driver,By by,int waitSec) throws StaleElementReferenceException,NoSuchElementException, Exception
	{
		try{
			logger.info("INTO METHOD->waitStalnessOf");
			WebDriverWait wait = new WebDriverWait(driver, waitSec, 1);
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(by)));
			logger.info("OUT OF METHOD->waitStalnessOf");
		}
		catch(StaleElementReferenceException e)
		{

			throw new StaleElementReferenceException("ELEMENT IS NOT DELETED FROM GUI->"+e.getMessage());
		}
		catch(NoSuchElementException e)
		{
			throw new NoSuchElementException("Element not found with By->"+by);
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println("=====================================");
			System.out.println(e.getMessage());
			throw new Exception("Some error in function->"+e.getStackTrace());
		}
	}



	//Refreshing Page
	public static void refresh(WebDriver driver)
	{
		driver.navigate().refresh();
		boolean executedActionStatus = false;
		try{

			((JavascriptExecutor)driver).executeScript("document.location.reload()");

			Thread.sleep(2000);
			executedActionStatus = true;
		}
		catch(Exception er)
		{
			er.printStackTrace();

		}
		return executedActionStatus;
	}

	*//**
	 * the method getRMSDatabaseTableData() performs connection with RMS database
	 * @author Manish Shridhar
	 * @param ServerName: name of the server(like ec2-54-234-251-94.compute-1.amazonaws.com for qa1) depending on the environment.
	 * @param DBName: name of the database(like NGJob)
	 * @param UserName: user name(like 'sa')
	 * @param Password: password(like 'Nextg3n')
	 * @param query: the query to be executed
	 * @return return the ResultSet object containing the data that resulted from the query.
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *//*
	public static ResultSet getRMSDatabaseTableData(String ServerName, String DBName, String UserName, String Password, String query) throws ClassNotFoundException, SQLException{
		ResultSet rs = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionString = "jdbc:sqlserver://"+ServerName+";databaseName="+DBName+";user="+UserName+";password="+Password;
		Connection conn=null;
		try{
			if(conn == null) {
				conn = DriverManager.getConnection(connectionString);
			}
		}catch(Exception e){
			System.out.println("Connection is NOT formed");
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		//ResultSet rs = null;
		try{
			System.out.println(query);
			rs = stmt.executeQuery(query);
			//System.out.println(rs.getFetchSize());
		}
		catch(Exception e){
			System.out.println("Your Datbase Query has some syntax error");
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
		//rs.next();
		//System.out.println(rs.getInt("JobID"));
		while(rs.next()){
		System.out.print(rs.getString("JobID"));
		System.out.print("---");
		System.out.print(rs.getString("JobDefinitionName"));
		System.out.print("---");
		System.out.print(rs.getString("JobTypeName"));
		System.out.print("---");
		System.out.print(rs.getString("JobStatusName"));
		System.out.print("---");
		System.out.print(rs.getString("JobTypeDescr"));
		System.out.print("---");
		System.out.print(rs.getString("PriorityName"));
		System.out.print("---");
		System.out.print(rs.getString("LoginName"));
		System.out.print("---");
		System.out.print(rs.getString("StartTime"));
		System.out.println();
		System.out.println();
	}

		//ResultSet rs = Generic_Methods.executeDBQuery(query);


		return rs;
	}


	public static String getDateFormat(long milliSeconds)
	{
		// Create a DateFormatter object for displaying date in specified format.

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		return formatter.format(calendar.getTime());
	}

	public static String convertTOSeconds(long millisconds){
		double seconds = millisconds/1000.0 ;
		return String.valueOf(seconds);
	}

	*//**
	 * This method wait for element to be clickable and once found it clicks on the element
	 * @param driver
	 * @param Locator
	 * @param iTimeout
	 *//*
	public static void clickWhenReady(WebDriver driver, By Locator, int iTimeout) {
		WebDriverWait wait = new WebDriverWait(driver, iTimeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		Generic_Methods.highlightElement(driver, element);
		element.click();

	}
	public static void waitForAlert(WebDriver driver, int maxTimeInSeconds) throws InterruptedException{
		while((maxTimeInSeconds)!=0){
			try{
				driver.switchTo().alert().accept();
				System.out.println("Alert Accepted");
				break;
			}
			catch(Exception e){
				Thread.sleep(100);
				System.out.println();
				maxTimeInSeconds--;
			}
		}
	}



	*//**
	 * This Method closes the Modeule Tab except for Home.So Dont Pass Home as Parameter
	 * @author ssachdeva
	 * @param sTabName
	 * @throws InterruptedException
	 *//*
	public static void setCloseTab(WebDriver driver,String sTabName){
		try{
			logger.info("INTO setCloseTab Method");
			Thread.sleep(1000);
			String sXPathForTabDIV ="//ul[@class='gradient ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']/li";
			String sUITabName;
			List<WebElement> lstTabs = driver.findElements(By.xpath(sXPathForTabDIV));
			System.out.println("Tatal number of Tabs opened in UI:" + lstTabs.size());
			if(lstTabs.size() >1){
				for(WebElement element : lstTabs){
					sUITabName=element.findElement(By.tagName("a")).getText();
					System.out.println("Tab name on UI is: "+ sUITabName);
					if(sUITabName.toLowerCase().contains(sTabName.toLowerCase().trim())){
						WebElement eleCloseTab = element.findElement(By.xpath("./a/following-sibling::span[@title='Close']"));
						System.out.println("Close Tab is displayed on UI");
						highlightElementBorder(driver, eleCloseTab);
						eleCloseTab.click();
						break;
					}
					else{
						System.out.println("No Tab Found with name: "+ sTabName);
					}
				}
			}
			else{
				System.out.println("HOME Tab is present which can not be closed");
			}
			logger.info("OUT OF setCloseTab Method");
		}
		catch(Exception e){
			logger.error("SOME ERROR IN setCloseTab Method->"+e.getMessage());
			e.printStackTrace();

		}
	}

	*//**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 *//*
	public static ExpectedCondition<WebElement> elementToBeClickable(
			final By locator) {
		return new ExpectedCondition<WebElement>() {

			public ExpectedCondition<WebElement> visibilityOfElementLocated =
					ExpectedConditions.visibilityOfElementLocated(locator);

			@Override
			public WebElement apply(WebDriver driver) {
				WebElement element = visibilityOfElementLocated.apply(driver);
				try {
					if (element != null && element.isEnabled()) {
						return element;
					} else {
						return null;
					}
				} catch (StaleElementReferenceException e) {
					return null;
				}
			}

			@Override
			public String toString() {
				return "element to be clickable: " + locator;
			}
		};
	}

	*//**
	 * Return url of enviornment by passing enviornment type
	 * @param evn Enum Environment
	 * @return
	 * @throws Exception
	 *//*
	public static String getEnvironmentURI(String evn) throws Exception
	{
		//ReadPropertiesFile propFile= new ReadPropertiesFile();
		String url ="";
		try
		{
			logger.info("START OF GENERIC FUNCTION::->getEnvironmentURI");
			dbConnection = Generic_Methods.getDBConnection(DatabaseType.SERVICE_DB);
			String DBQuery = "select KeyValue from RmSoneServiceFramework_Dev.dbo.TestEnvironmentConfig TC join RmSoneServiceFramework_Dev.dbo.TestEnvironments TE on  (TE.EnvironmentId = TC.EnvironmentId) where TE.EnvironmentName = '"+propFile.getEnvironment()+"' and TC.KeyName = 'UI_SERVER'";
			ResultSet dbResult = Generic_Methods.executeDBQuery(DBQuery, dbConnection);
			if(dbResult.next())
			{
				url = dbResult.getString(1);
			}
			dbResult.close();
			dbConnection.close();
			logger.info("URL for Environment->"+evn+" is->"+url);
			if(!url.contains("https:\\")||(!url.contains("http:\\")))
			{
				url = "https:\\"+url;
			}
			
    switch(evn)
    {
    	case "qa1":
    		   url = propFile.getQA1();
    		break;
    	case "dev1":
    		 url = propFile.getDEV1();
    		break;
    	case "dev2":
    		url= propFile.getDEV2();
    		break;
    	case "dev4":
    		url= propFile.getDEV4();
    		break;
    		default:
    			url="";

    }
			logger.info("END OF GENERIC FUNCTION::->getEnvironmentURI");
		}
		catch(Exception e)
		{
			logger.error("An error occurred:::GENERIC ::: getEnvironmentURI->" + e.getMessage());
			throw new Exception("Some error no finding url  Environment->"+evn+" from RmSoneServiceFramework_Dev database" );
		}
		return url;
	}

	public static WebElement getWhenVisible(WebDriver driver,WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public static void setText(WebDriver driver,By by, String sValue){
		try
		{
			WebElement element = driver.findElement(by);
			if(element.isDisplayed())
			{
				//element.clear();
				element.sendKeys(sValue);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	 *//**
	 * Create a file acording the file type
	 * @param fileName
	 * @param fileType
	 *//*
public static void createFile(String fileName,FileType fileType)
{
	try {
        if(fileType.equals(FileType.RESULTOUTPUTEXCEL))
        {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Sheet1");

        }
        else{
        File file = new File(System.getProperty("user.dir") + "\\ExcelSheet\\ResultOutput\\"+fileName);

        if (file.createNewFile()){
          System.out.println("File is created!");
        }else{
          System.out.println("File already exists.");
        }
        }
  } catch (IOException e) {
        e.printStackTrace();
  }

}



	*//**
	 * Converts given time in mm:ss:ms format. used in performance
	 * @param diffTime
	 * @return
	 *//*
	public static String setTimeFormatInmmss(long diffTime){
		System.out.println("TIME >>>>>>>>>>>>>>>>>>>>>>" + diffTime);
		String format = String.format("%%0%dd", 2);
		long diffTime01 = diffTime / 1000;
		String seconds = String.format(format, diffTime01 % 60);
		String minutes = String.format(format, (diffTime01 % 3600) / 60);
		String hrs = String.format(format, (diffTime01 % 216000) / 60);
		String formatMilliSeconds = String.format("%%0%dd", 3);
		String milliSeconds = String.format(formatMilliSeconds,diffTime %1000);
		String timeMinutesSeconds =   hrs+":"+ minutes + ":" + seconds+":"+milliSeconds;
		System.out.println("Time in mm:ss:ms  :  --> "+timeMinutesSeconds);
		return timeMinutesSeconds;
	}

	public static void waitForObjectNotPresent(WebDriver driver, String locator, String locatorType, int maxTime){
		WebElement element = null;
		System.out.println(locator);
		try{
			//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			switch (locatorType.toLowerCase()){
				case "xpath":
					element = driver.findElement(By.xpath(locator));
					break;
				case "id":
					element = driver.findElement(By.id(locator));
					break;
				case "css":
					element = driver.findElement(By.cssSelector(locator));
					break;
			}
		}catch( org.openqa.selenium.NoSuchElementException nse ){
			System.out.println("element is NOT displaying....");

		}
		catch(Exception e){
			System.out.println("got some other exception");
		}

		if(element!=null){
			System.out.println("SEEMS TO BE WORKING FINE");
		}
		for(int counter = maxTime; counter > 0; counter--){
			try{
				//element.isDisplayed();
				if(!element.isDisplayed()){
					break;
				}
				System.out.println(counter);
				Thread.sleep(1000);
			}

			catch(StaleElementReferenceException ser){
				System.out.println("element is NO more detached to dom");
				break;
			}
			catch(Exception e){

				break;
			}
		}





	}

	public static String getCurrentTimeFormat() throws ParseException{
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM_dd_hh_mm_ss");
		String dateString=sdf.format(date);

		return dateString;

	}


	public static void waitForElementLoctedBy(WebDriver driver,String locator, String locatorType, int maxTime){
		WebDriverWait wait = new WebDriverWait(driver,maxTime);
		locatorType.toLowerCase();
		switch (locatorType){
			case "xpath":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
				break;

			case "id":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				break;

		}
	}

	*//**
	 * check if element is not present or present
	 * @param driver
	 * @param element
	 * @param timeOut
	 * @return
	 *//*
	public static boolean isElementPresent(WebDriver driver,By by,String... timeOut) {
		logger.info("INTO THE METHOD->isElementPresent");
		boolean flag=true;

		try{

			if(timeOut.length!=0)
			{
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(timeOut[0]), TimeUnit.SECONDS);
				logger.info("Implicit wait changes as->"+Integer.parseInt(timeOut[0]) +"Sec");
			}
			else
			{
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				logger.info("Implicit wait changes as->1 Sec");
			}
			List<WebElement> elements=driver.findElements(by);
			if(elements.size()!=0)
			{
				flag=true;
				logger.info("Element is present and xpath is ->"+by);
			}
			else
			{
				flag=false;
				logger.info("Element is not present and xpath is ->"+by);
			}
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(new ReadPropertiesFile().getImplicitWait()), TimeUnit.SECONDS);
			logger.info("Implicit wait reset as previous condition");
			logger.info("OUT OF THE METHOD->isElementPresent");
		}
		catch(Exception e)
		{
			logger.error("SOME ERROR CAM IN METHOD->isElementPresent->"+e.getMessage());
		}
		return flag;
	}

	*//**
	 * To be Used when none of the waitmethods works
	 *
	 * @param driver
	 * @param by
	 *//*
	public static void waitForElementToBeClickable(WebDriver driver,By by){
		WebDriverWait wait = new WebDriverWait(driver, 2500);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static void waitTillElementAttributeChange(WebElement webElement,String attribute,String value,int maxSecondTimeout,boolean...isFailOnExcaption)
	{
		// boolean	flag=false;
		try{
			logger.info("INTO METHOD waitTillElementAttributeChange");
			maxSecondTimeout = maxSecondTimeout*20;
			while (webElement.getAttribute(attribute) != null)
			{
				if ((!webElement.getAttribute(attribute.trim()).toLowerCase().contains(value.trim().toLowerCase()))
						&& (maxSecondTimeout > 0)) {
					System.out.println("Loading...CountDown=" + maxSecondTimeout);
					try {
						Thread.sleep(50l);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					maxSecondTimeout--;

				}

			}
			logger.info("OUT OF METHOD waitTillElementAttributeChange");
		}
		catch(Exception e)
		{

			logger.error("SOME ERROR CAME IN METHOD->waitTillElementAttributeChange->"+e.getMessage());
			if(isFailOnExcaption.length!=0)
			{
				if(isFailOnExcaption[0]==true)
				{
					Assert.fail("SOME ERROR IN METHOD waitTillElementAttributeChange METHOD");
				}
			}
		}
	}

	*//**
	 * @author ssachdeva
	 * Gets the text of the selected option from WebList.Works only when HTML is Select Option
	 * @param element
	 * @return
	 *//*
	public static String getTextFromSelectedOption(WebElement element){
		Select select = new Select(element);
		String element_Text = select.getFirstSelectedOption().getText();
		return element_Text;
	}

	*//**
	 * Returns true if checkbox is checked.
	 * @author ssachdeva
	 * @param element
	 * @return
	 *//*

	public static boolean isCheckboxChecked(WebElement element){
		boolean isChecked=false;
		try {
			System.out.println("getting class of received element " + element.getAttribute("class"));
			if (element.getAttribute("class").contains("selected")) {
				System.out.println("check box is checked");
				isChecked = true;
			} else {
				isChecked = false;
			}

		} catch (Exception e)
		{
			logger.error("Some exception ocurred while finding if Region Checkbox is checked or not " + e.getMessage());

		}

		return isChecked;
	}

	*//**
	 * Returns true if disabled attribute is set as disabled in HTML
	 * @param element
	 * @return
	 *//*
	public static boolean isDisabled(WebElement element)
	{
		boolean isDisabled=false;
		System.out.println("getting disabled attribute from the element "+ element.getAttribute("disabled"));
		if(element.getAttribute("disabled").equalsIgnoreCase("disabled")){
			System.out.println("element is in disabled state");
			isDisabled=true;
		}
		else
		{
			System.out.println("No attribute found");
		}
		return isDisabled;

	}





	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement destination) throws Exception
	{
		try {
			logger.info("START OF METHOD dragAndDrop ::::::::::::::::::::::::::::");
			Actions builder = new Actions(driver);
			builder.dragAndDrop(source, destination).build().perform();
			// Action dragAndDrop =
			// builder.clickAndHold(source).moveToElement(destination).release(destination).build();
			// dragAndDrop.perform();
			logger.info("END OF METHOD dragAndDrop ::::::::::::::::::::::::::");
		} catch (Exception e) {
			logger.error("::::::::::::::::::::::::::::::" + e.getMessage());
			throw new Exception("::::::::::::::::::::::::" + e.getMessage());
		}

	}

	public static void dragAndDropByClickHold(WebDriver driver, WebElement source, WebElement destination) throws Exception {
		try {
			logger.info("START OF METHOD dragAndDrop BY Click Hold ::::::::::::::::::::::::::::");
			Actions builder = new Actions(driver);
			builder.clickAndHold(source).build().perform();

			builder.moveToElement(destination).build().perform();

			builder.release(destination).build().perform();

			logger.info("END OF METHOD dragAndDrop BY Click Hold::::::::::::::::::::::::::");
		} catch (Exception e) {
			logger.error("::::::::::::::::::::::::::::::" + e.getMessage());
			throw new Exception("::::::::::::::::::::::::" + e.getMessage());
		}

	}

	*//**
	 * Select hold and release object to destination place.
	 * @param driver
	 * @param source
	 * @param destination
	 * @throws Exception
	 *//*


	public static void dragAndDropByClickHoldRelease(WebDriver driver, WebElement source, WebElement destination) throws Exception {
		try {
			logger.info("START OF METHOD dragAndDropByClickHoldRelease ::::::::::::::::::::::::::::");
			Actions builder = new Actions(driver);
			builder.clickAndHold(source).moveToElement(destination).release(destination).build().perform();

			logger.info("END OF METHOD dragAndDropByClickHoldRelease ::::::::::::::::::::::::::");
		} catch (Exception e) {
			logger.error("::::::::::::::::::::::::::::::" + e.getMessage());
			throw new Exception("::::::::::::::::::::::::" + e.getMessage());
		}

	}


	*//**
	 * Returns selected option in select Drop Down
	 * @param select
	 * @param sValueToBeSelected
	 *//*
	public static String getSelectedOption(WebElement options){
		logger.info("INTO THE METHOD getSelectedOption");
		String sSelectedOption = null;
		try{

			Select selectedOption = new Select(options);
			sSelectedOption=selectedOption.getFirstSelectedOption().getText();
			logger.info("OUT OF METHOD getSelectedOption");
		}
		catch(Exception e)
		{
			logger.error("Some error came on function->select->"+e.getMessage());
		}
		return sSelectedOption;
	}

	public static String dbJobStatus(String db_Server,String db_userid,String db_pwd,String jobid)
	{
		System.out.println("In Job Status========================================"+db_Server+" ="+db_userid+" ="+db_pwd+" ="+jobid);
		String JobReturnStatus =null;
		String JobStatus =null;
		int SleepValue =0;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://"+db_Server+";"+"databaseName=NGJOb",db_userid,db_pwd);
			System.out.println("conn==========="+conn);
			Statement statement = conn.createStatement();
			String queryString = "select JobStatusCode from Job where JobID ="+jobid;
			ResultSet rs = statement.executeQuery(queryString);
			//while (rs.next()) {
			rs.next();
			System.out.println("Is connection closed:"+ conn.isClosed());
			JobStatus =rs.getString(1);
			int JobStatusCode = Integer.parseInt(JobStatus);
			while (!(JobStatusCode == 4) || !(JobStatusCode == 5)){
				rs = statement.executeQuery(queryString);
				rs.next();

				JobStatus =rs.getString(1);
				JobStatusCode = Integer.parseInt(JobStatus);

				if(JobStatusCode ==5){
					System.out.println("Job failed");
					conn.close();
					//System.out.println("connection status:"+ conn.isClosed());
					JobReturnStatus = "Failed";
					break;
				}
				else if(JobStatusCode ==4){
					System.out.println("Job Passed");
					conn.close();
					//System.out.println("connection status:"+ conn.isClosed());
					JobReturnStatus = "Passed";
					break;
				}
				else if (JobStatusCode ==3){

					SleepValue = SleepValue+ 1000;
					System.out.println("Sleep for "+ SleepValue+" milliseconds !!! Waiting for job to complete");
					// JOptionPane.showMessageDialog(null, "Sleep for "+
					// SleepValue+" milliseconds !!! Waiting for job to complete");
					Thread.sleep(SleepValue);
					//JobReturnStatus = "In Progress";

				}
				else if (JobStatusCode ==2){

					SleepValue = SleepValue+ 1000;
					System.out.println("Sleep for "+ SleepValue+" milliseconds !!! Job is in queued Stage");
					// JOptionPane.showMessageDialog(null, "Sleep for "+
					// SleepValue+" milliseconds !!! Job is in queued Stage");
					Thread.sleep(SleepValue);
					//JobReturnStatus = "In Progress";
				}
			}
			//   }
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("============================="+e.getMessage());
			//JobReturnStatus="Failed123";
		}
		return JobReturnStatus;

	}


	public static void getSQEFromMongo(String MGC,String MongoDBServer,String MongoCollection, String Tenant ){

		try{

			MongoClient mc = new MongoClient(MGC);
			DB db = mc.getDB(MongoDBServer);

			DBCollection coll = db.getCollection(MongoCollection);
			BasicDBObject query = new BasicDBObject("_id", "Beta2_ExposureDataService_"+Tenant+"_EDSTenantConfig");
			DBCursor cursor = coll.find(query);
			try {
				while(cursor.hasNext()) {
					System.out.println(cursor.next());
				}
			} finally {
				cursor.close();
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void getSQEServerFromJson(String JsonString) throws org.json.simple.parser.ParseException, JSONException
	{

		JSONParser jsonParser = new JSONParser();

		try {

			FileReader fileReader = new FileReader(JsonString);

			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
			JSONObject obj2;

			obj2= (JSONObject) jsonObject.get("EdmDatasource");
			String name= (String) obj2.get("Server");

			System.out.println(name);


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}


	*//**
	 * Based Upon the Environment and key this method returns the value of the Key
	 * @param SQLServer
	 * @param ServerName
	 * @param UserName
	 * @param Password
	 * @param sEnvironment
	 * @param sKey
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 * @author arai1
	 *//*

	public static String getEnvironmentDetails(String SQLServer, String ServerName, String UserName, String Password,String sEnvironment, String sKey) throws ClassNotFoundException, IOException, SQLException
	{
		String sServer =null;
		Connection conn = Generic_Methods.getConnectionToSQLServer(SQLServer, ServerName, UserName, Password);
		System.out.println("IS Connection closed "+ conn.isClosed());

		String DBQuery = "select KeyValue from dbo.TestEnvironmentConfig TC" +
				" join dbo.TestEnvironments TE on  (TE.EnvironmentId = TC.EnvironmentId)" +
				" where TE.EnvironmentName like '%"+sEnvironment+"%' and TC.KeyName ='"+sKey+"'";


		ResultSet dbResult = Generic_Methods.executeDBQuery(DBQuery, conn);
		while(dbResult.next()){
			sServer=dbResult.getString(1);
		}

		return sServer;
	}



	*//**
	 * This check the existance of a element
	 * @param driver
	 * @param by
	 * @return
	 *//*

	public static boolean isexistsElement(WebDriver driver, final By element,int timeOutInSeconds,int pollingInMilliSeconds) throws Exception {
		System.out.println("isexistsElement=========================");
		try
		{
			return (new WebDriverWait(driver, timeOutInSeconds,pollingInMilliSeconds)).until(new ExpectedCondition<Boolean>()
					{
				@Override
				public Boolean apply(WebDriver driver) {
					logger.info("Waiting for element to be displayed ");
					return driver.findElement(element).isDisplayed();
				}});

		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		catch(Exception e)
		{
			return false;
		}

	}

	public static boolean isexistsElement(WebDriver driver ,By by) {
		System.out.println("isexistsElement=========================");
		try {
			driver.findElement(by);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public static boolean waitForElementToEnable(WebElement element, int maxSecondTimeout) throws Exception {
		try {
			logger.info("INTO waitForElementToEnable METHOD");
			maxSecondTimeout = maxSecondTimeout * 20;
			while (!element.isEnabled() && (maxSecondTimeout > 0)) {
				// logger.info("Loading...CountDown="+maxSecondTimeout);
				Thread.sleep(50l);
				maxSecondTimeout--;
			}
			if ((maxSecondTimeout == 0)) {

				logger.error("Element is not enabled within " + (maxSecondTimeout / 20) + "Sec.");
				throw new Exception("Element is not enabled within " + (maxSecondTimeout / 20) + "Sec.");

			}
			logger.info("OUT OF METHOD waitForElementToEnable");
			return true;
		} catch (NoSuchElementException e) {
			throw new Exception("The element to be enabled is not present in the page->waitForElementToEnable->" + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Some exception in waitForElementToEnable" + e.getMessage());
		}
	}

	public static boolean waitForElementToDisable(WebElement element, int maxSecondTimeout) throws Exception {
		try {
			logger.info("INTO waitForElementToDisable METHOD");
			maxSecondTimeout = maxSecondTimeout * 20;
			while (element.isEnabled() && (maxSecondTimeout > 0)) {
				// logger.info("Loading...CountDown="+maxSecondTimeout);
				Thread.sleep(50l);
				maxSecondTimeout--;
			}
			if ((maxSecondTimeout == 0)) {

				logger.error("Element is not disabled within " + (maxSecondTimeout / 20) + "Sec.");
				throw new Exception("Element is not disabled within " + (maxSecondTimeout / 20) + "Sec.");

			}
			logger.info("OUT OF METHOD waitForElementToDisable");
			return true;
		} catch (NoSuchElementException e) {
			throw new Exception("The element to be disabled is not present in the page->waitForElementToDisable->" + e.getMessage());
		} catch (Exception e) {
			throw new Exception("Some exception in waitForElementToDisable" + e.getMessage());
		}
	}

	public static void doubleClick(WebDriver driver, WebElement element)
			throws Exception {
		try {
			logger.info("START OF METHOD doubleClick ::::::::::::::::::::::::::::");
			Actions builder = new Actions(driver);
			builder.moveToElement(element).doubleClick().build().perform();
			logger.info("OUT OF METHOD doubleClick");
		}
		catch (Exception e) {
			throw new Exception("Some exception in doubleClick"
					+ e.getMessage());

		}
	}

	public static void setCloseAllTab(WebDriver driver) throws Exception
	{
		List<WebElement> list_AllTabs = new ArrayList<>();
		int iTabs = 0;
		try {
			logger.info("Inside CloseALLTab method");
			list_AllTabs = driver.findElements(By.xpath("//div[@id='tabs']//span[contains(@class,'ui-icon-close')]"));
			iTabs = list_AllTabs.size();
			if (iTabs > 0) {
				logger.info("More than 1 tab opened. ALL Tabs will be closed NOW!!!");
				for (WebElement element : list_AllTabs) {
					element.click();
					Thread.sleep(1500);
				}
			}

		}catch(UnhandledAlertException e){
			throw e;
		}
		catch (Exception e) {
			logger.error("Exception in setcloseAllTab " + e.getMessage());
			throw e;

		}

	}

	public String getMethodNameFromStackTrace(String sMethodNameCriteria)
	{

		String methodToOperate = "NA";
		for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
			if ((!ste.isNativeMethod()) && (ste.getMethodName().toLowerCase().contains(sMethodNameCriteria))) {
				methodToOperate = ste.toString();
				break;
			}
		}
		return methodToOperate;
	}
	public static String getRandomNumber() {
		Random r = new Random();
		List<Integer> codes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int x = r.nextInt(9999);
			while (codes.contains(x)) {
				x = r.nextInt(9999);
			}
			codes.add(x);
		}
		String str = String.format("%04d", codes.get(0));
		return str;
	}


	public static boolean  waitForElementToStale(WebDriver driver, int iTimeOutInSeconds, By by) throws NumberFormatException, IOException
	{
		boolean isStale = true;
		int iAttempt = 0;
		try {
			iTimeOutInSeconds = iTimeOutInSeconds * 20;
			while (isStale && iTimeOutInSeconds > 0) {
				iAttempt++;
				logger.info("Waiting for Element to Statle Attempt Number :" + iAttempt);
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
				logger.info("Element :" + driver.findElement(by).isDisplayed());
				if(driver.findElements(by).size()==0){
					isStale=false;
					break;
				}
				Thread.sleep(30l);
				iTimeOutInSeconds--;
			}
		} catch (NoSuchElementException e) {
			logger.error("No Element Found.This Means Loader is no more in HTML. Moving out of waitForElementToStale!!!");
			isStale = false;
		} catch (StaleElementReferenceException s) {
			logger.error("Given Element is stale from DOM Moving out of waitForElementToStale!!!");
			isStale = false;
		} catch (Exception e) {
			logger.error("Some Exception ocurred Please check code!!!");
			} finally {
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(new ReadPropertiesFile().getImplicitWait()), TimeUnit.SECONDS);
		}
		return isStale;

	}


	public static boolean IsElementPresentInList(List<WebElement> lstElementList, String sValueToBeSelected) throws Exception
	{
		logger.info("START OF FUNCTION->IsElementPresentInList");
		boolean flag = false;
		try{

			for(WebElement e: lstElementList){
				if (e.getText().equalsIgnoreCase(sValueToBeSelected)){
					logger.info("Value matched in list as->" + e.getText());
					flag=true;
					break;
				}
			}
			// if(flag==false)
			// {
			// throw new
			// Exception("No match found in the list for value->"+sValueToBeSelected);
			// }
			logger.info("END OF FUNCTION->IsElementPresentInList");
		}
		catch(Exception e)
		{
			throw new Exception("THERE IS AN EXCEPTION ON SELECTING VALUE FROM LIST->"+e.getMessage());
		}
		return flag;
	}


	public static void scrollHorizontally(WebDriver driver,WebElement slider, WebElement target) throws Exception{
		logger.info("START OF FUNCTION->scrollHorizontally");
		try{
			Actions builder = new Actions(driver);
			builder.moveToElement(slider).clickAndHold(slider).dragAndDrop(slider, target).build().perform();

		}catch(Exception e){
			logger.error("Exception IN FUNCTION->scrollHorizontally " + e.getMessage());
			throw new Exception("THERE IS AN EXCEPTION IN HORIZONTAL SCROLLING->"+e.getMessage());
		}

		logger.info("END OF FUNCTION->scrollHorizontally");
	}

	*//**
	 * Get logger file configuration
	 *//*
	public static void getLoggerConfiguration(){
		logger.info("START OF FUNCTION->getLoggerConfiguration");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Config\\log4j.properties");
		logger.info("END OF FUNCTION->getLoggerConfiguration");
	}

	*//**
	 * This Method Save Test Result into TestResult Table
	 * @param getDBServer
	 * @param getDBName
	 * @param getDBUserName
	 * @param getDBPassword
	 * @param IterationNo
	 * @param TestRunGUID
	 * @param environment_ranOn
	 * @param objResult
	 * @throws Exception
	 *//*

	public static void saveTestResult(SaveTestResult objResult) throws Exception
    {
        		String machineName = InetAddress.getLocalHost().getHostName();
                String testStatus;
                Connection conn=null;

	   try{
		   conn = Generic_Methods.getConnectionToSQLServer(objResult.DBServer,objResult.DBName, objResult.DBUserName,objResult.DBPassword);

		   PreparedStatement cs = conn.prepareStatement
				      ("INSERT INTO dbo.TestResult "
									 +"(TestCaseNumber, TestCaseName, WorkFlowId, WorkFlowName, Category,TestStatus, TestDetails,TestIteration, RequestURI,  RequestString, TestCasePriority, TestCaseDescription, WorkFlowOwner,TenantId, ExecutedBy,TestRunGUID,MachineName,EnviormentRanOn,LocationCount,JobID, JobDefinitionID, JobStatusCode, JobTargetReference, SubmitTime, StartTime, EndTime,SeqId, QAOwner,TotalTime)"
									 +"  values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                if (!objResult.DependentTestStatus)
                {
                    testStatus = ConstantElement.TestStatus.Skipped.getTestStatus();
                }
                else
                {
                    testStatus = (objResult.TestStatus) ? (ConstantElement.TestStatus.Success.getTestStatus()): ConstantElement.TestStatus.Failed.getTestStatus();
                }

                cs.setString(1,objResult.TestCaseNumber);
                cs.setString(2,objResult.TestCaseName);
                cs.setInt(3,objResult.WorkflowId);
                cs.setString(4,objResult.Workflowname);
                cs.setString(5,objResult.TestCategory);
                String stringTestStatus = testStatus.toString();
                int intstringTestStatus=Integer.parseInt(stringTestStatus);
                cs.setInt(6,intstringTestStatus);
                cs.setString(7,objResult.Testdetails);
                cs.setString(8,objResult.IterationNo);
                cs.setString(9,objResult.RequestURI);
                cs.setString(10,objResult.RequestString);
                cs.setString(11,objResult.TestCasePriority);
                cs.setString(12,objResult.Description);
                cs.setString(13,objResult.WorkflowOwner);
                cs.setString(14,objResult.TenantId);
                cs.setString(15,System.getProperty("user.name"));
                cs.setString(16,objResult.TestRunGUID);
                cs.setString(17,machineName);
                cs.setString(18, objResult.environment_ranOn);
                cs.setInt(19, objResult.LocationCount);
                cs.setInt(20,objResult.JobID);
                cs.setInt(21, objResult.JobDefinitionID);
                cs.setString(22, objResult.JobStatusCode);
                cs.setInt(23,objResult.JobTargetReference);
                cs.setString(24,objResult.SubmitTime);
                cs.setString(25,objResult.StartTime);
                cs.setString(26, objResult.EndTime);
                cs.setInt(27,objResult.SeqId);
                cs.setString(28, objResult.QAOwner);

                cs.setString(29,objResult.totalTimeSpan);

               cs.execute();
            }
            catch (Exception ex)
            {
                throw new Exception(" --//-- EXCEPTION occured in method SaveTestResult(). Actual message returned is : " + ex.getMessage() + " --//-- ");
            }finally{
            	conn.close();
            }
        }


}




*/