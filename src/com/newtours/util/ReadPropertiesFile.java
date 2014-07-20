package com.newtours.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ReadPropertiesFile {
	private HashMap<String,String> hashMap =new HashMap<String, String>();
	public static String excelWorkingPath=null;
	public static String excelDesPath=null;
	public static String excelPath=null;
	
public  ReadPropertiesFile() throws IOException
{
	//HashMap hashMap=new HashMap();	
	try{
System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>In Common Prperty");

FileInputStream propFile =
new FileInputStream( "E:\\WorkSpace\\src\\com\\newtours\\util\\Config.properties");
Properties prop =
new Properties(System.getProperties());
prop.load(propFile);


/*Properties prop = new Properties();
System.out.println("Test==> "+System.getProperty("D:\\RMSWorkSpace\\UIAutomation\\src\\com\\newtours\\util\\Config.properties"));
FileInputStream f = new FileInputStream(System.getProperty("D:\\RMSWorkSpace\\UIAutomation\\src\\com\\newtours\\util\\Config.properties"));
prop.load(f);*/
System.out.println("File Path ==> "+prop.getProperty("Site"));
System.out.println(prop.getProperty("Site"));
System.out.println(prop.getProperty("Browser"));
System.out.println(prop.getProperty("Username"));
System.out.println(prop.getProperty("Password"));
System.out.println(prop.getProperty("Environment"));
System.out.println(prop.getProperty("Iteration"));
System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<");
excelPath=prop.getProperty("ExcelPath");
excelWorkingPath=prop.getProperty("ExcelWorkingExcelPath");
excelDesPath=prop.getProperty("ExcelDesPath");

hashMap.put("Site",prop.getProperty("Site"));
hashMap.put("Browser",prop.getProperty("Browser"));
hashMap.put("Username",prop.getProperty("Username"));
hashMap.put("Password",prop.getProperty("Password"));
hashMap.put("Environment", prop.getProperty("Environment"));
hashMap.put("Iteration",prop.getProperty("Iteration"));
hashMap.put("DBServerName", prop.getProperty("DBServerName"));
hashMap.put("DBUserId", prop.getProperty("DBUserId"));
hashMap.put("DBPassword", prop.getProperty("DBPassword"));
hashMap.put("DBName", prop.getProperty("DBName"));
hashMap.put("ImplicitWait", prop.getProperty("ImplicitWait"));
hashMap.put("HighlightElement", prop.getProperty("HighlightElement"));


  }catch(Exception e){
	  e.printStackTrace();
  }
	
}


public String getRecordVideo() throws  IOException   {
	return  hashMap.get("RecordVideo");
}
public String getUserName() throws  IOException   {
	return  hashMap.get("Username");
}
public String getPassword() throws  IOException   {
	return  hashMap.get("Password");
}
public String getSite() throws  IOException   {
	return  hashMap.get("Site");
}
public String getBrowser() throws  IOException   {
	return hashMap.get("Browser");
}
public String getEnvironment() throws IOException {
	return hashMap.get("Environment");
}
public String getIteration() throws IOException{
	return hashMap.get("Iteration");
}
public String getExcelPath() throws  IOException   {
	return excelPath ;
}


public String getImplicitWait() {
	// TODO Auto-generated method stub
	return hashMap.get("ImplicitWait");	
}


public String getHighlightElement() {
	// TODO Auto-generated method stub
	return hashMap.get("HighlightElement");	
}


public String getTakeSnapshot() {
	// TODO Auto-generated method stub
	return hashMap.get("TakeSnapshot");	
}


public String getDBName() {
	// TODO Auto-generated method stub
	return hashMap.get("DBName");	
}
public String getDBServerName() {
	// TODO Auto-generated method stub
	return hashMap.get("DBServerName");	
}

public String getDBUserId() {
	// TODO Auto-generated method stub
	return hashMap.get("DBUserId");	
}


public String getDBPassword() {
	// TODO Auto-generated method stub
	return hashMap.get("DBPassword");
}



}