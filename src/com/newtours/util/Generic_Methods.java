package com.newtours.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic_Methods {

	static WebDriver driver;
	
	static ReadPropertiesFile	 propFile ;
	


	/**
	 * To launch browser based on user requirement passed from property file.
	 * @param sBrowserType
	 * @return
	 * @throws Exception
	 */
	public static WebDriver launchBrowser(String sBrowserType) throws Exception {

		WebDriver driver = null;
		try {
			if (sBrowserType.equalsIgnoreCase("firefox") || sBrowserType.equalsIgnoreCase("Firefox")) {
				System.out.println("Lunching FireFox driver");
				driver = new FirefoxDriver();
			} else if (sBrowserType.equalsIgnoreCase("chrome") || sBrowserType.equalsIgnoreCase("Chrome")) {
				System.out.println("Lunching Chrome driver");
				//System.setProperty("webdriver.chrome.driver",".\\Resources\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver","D:\\Software\\SeleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if(sBrowserType.equalsIgnoreCase("IE")||sBrowserType.equalsIgnoreCase("InternetExplorer")){
				System.out.println("Lunching Internet Explore driver");
				
				//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				System.setProperty("webdriver.ie.driver", "D:\\Softwares\\Selenium\\IEDriver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}else if(sBrowserType.equalsIgnoreCase("remote")){
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName("chrome");
				//driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);
			} 
			else {
				System.out.println("provided browser type is not correct. Please check config property file.");
			}
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	return driver;
	}

	public static void highlightElement(WebDriver driver, WebElement element) {
		try{
			System.out.println("INTO METHOD highlightElement");
			propFile = new ReadPropertiesFile();
			System.out.println("highlight Element Started");
				for (int i = 0; i < 1; i++) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "background: yellow; border: 4px solid red;");
					Thread.sleep(400L);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
				}
	
		}catch(Exception e){
			System.out.println("SOME ERROR IN METHOD highlightElement->"+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("OUT OF METHOD highlightElement");

	}

	public static void WaitforElementVisible(WebDriver driver,WebElement e) throws Exception
	{
		System.out.println("Start of WaitforElementVisible" );
		try {
			(new WebDriverWait(driver, 500))
			.until(ExpectedConditions.visibilityOf(e));
			System.out.println("END of WaitforElementVisible" );

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex);
		}

	}

	public static String getSelectedOption(WebElement options,String sValueToSelect) throws Exception {

		String isSelectedText = null;
		System.out.println("Start of getSelectedOption method.");
		
		try {

			Select selectedOption = new Select(options);
			selectedOption.selectByVisibleText(sValueToSelect);
			isSelectedText = selectedOption.getFirstSelectedOption().getText();
			System.out.println("Selected value is == > "+isSelectedText);

		} catch (Exception ex) {
			throw new Exception("Error in  getSelectedOption");
		}
		
		System.out.println("END of getSelectedOption method.");
		return isSelectedText;

	}
	
	/**
	 * To read data from XLS file 
	 * @param WorkbookPath
	 * @param SheetName
	 * @param coloumnCount
	 * @return
	 * @throws IOException
	 */
	public static  Object[][] getData_XLS(String WorkbookPath, String SheetName, int coloumnCount) throws IOException{
		int ColmCount = 0;
		System.out.println("WorkbookPath============================="+WorkbookPath);
		FileInputStream fisObj=new FileInputStream(WorkbookPath);
		System.out.println("fisObj=========================================="+fisObj);
		Workbook WBookObj=new XSSFWorkbook(fisObj);
		Sheet WSheetObj= (Sheet) WBookObj.getSheetAt(0);
		//Sheet WSheetObj=WBookObj.getSheet(SheetName);
		int RowCount= ((org.apache.poi.ss.usermodel.Sheet) WSheetObj).getLastRowNum();
		if(coloumnCount == 0){
			ColmCount= ((org.apache.poi.ss.usermodel.Sheet) WSheetObj).getRow(1).getLastCellNum();
		}else{
			ColmCount = coloumnCount;
		}
		System.out.println("rowcount=============================================="+RowCount);
		System.out.println("ColmCount====================================="+ColmCount);
		Object CellVal="";
		Object[][] ArrObj=new Object[RowCount][ColmCount];
		//for(int i=1; i<=RowCount-1; i++){
		//	Row RowObject=WSheetObj.getRow(i+1);
		for(int i=0; i<RowCount; i++){
			Row RowObject=((org.apache.poi.ss.usermodel.Sheet) WSheetObj).getRow(i+1);
			//int CellCount=RowObject.getLastCellNum();
			for(int j=0; j<ColmCount; j++){
				int CellType=RowObject.getCell(j).getCellType();
				if(CellType==Cell.CELL_TYPE_STRING){
					CellVal=RowObject.getCell(j, Row.CREATE_NULL_AS_BLANK).getStringCellValue();
				}else if(CellType==Cell.CELL_TYPE_NUMERIC){
					Double RowCellvalue=RowObject.getCell(j, Row.CREATE_NULL_AS_BLANK).getNumericCellValue();
					Integer CellVal1=BigDecimal.valueOf(RowCellvalue).intValue();
					CellVal=CellVal1.toString();
					//CellVal = BigDecimal.valueOf(RowObject.getCell(j, Row.CREATE_NULL_AS_BLANK).getNumericCellValue()).toPlainString();
				}else if(CellType==Cell.CELL_TYPE_BLANK){
					CellVal="";
				}else if(CellType==Cell.CELL_TYPE_BOOLEAN){
					CellVal =RowObject.getCell(j,Row.CREATE_NULL_AS_BLANK).getBooleanCellValue();
						
					}

				System.out.println("CellVal================================="+CellVal);
				ArrObj[i][j] =  CellVal;
			}
		}
		return ArrObj;
	}
	

	/**
	 * Below three methods are different ways to get objects.
	 */
	
	/*public WebElement getObjectName(WebDriver driver, By by ) {
		
		WebElement ObjectId = driver.findElement(by);
		
		return ObjectId;
	}
	
	public List<WebElement> getObjectNames(WebDriver driver, By by ) {
		
		List<WebElement>  ObjectId = driver.findElements(by);
		
		return ObjectId;
	}
	
	public void waitforload(WebDriver driver, By by ,int waitTime) {
		
		(new WebDriverWait(driver, waitTime))
		.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
	
	}*/
	
}
