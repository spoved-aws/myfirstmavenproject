package com.testclasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TP_Base;
import com.utilities.ExcelReader_Anusha;

public class DataProviderTest extends TP_Base {
	
	public DataProviderTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization("chrome");
		
		
	}
	
	@Test(dataProvider = "getData")
	public void loginTest(String fName, String lName, String email, String pwd) {
		
//		System.out.println(fName +" "+  lName +" "+  email +" "+  pwd);
		logger.info("This is the first row --->" + fName +" "+  lName +" "+  email +" "+  pwd);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] excelData=ExcelReader_Anusha.getData("Information");
		return excelData;
		
		
	}
	
	
}
