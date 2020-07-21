package com.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class AnushaReporterClass implements ITestListener{
	
	public static ExtentReports extent;
	public static Log logger;
	public static ExtentTest test;
	
	
	
	public void onStart(ISuite suite) {
		
//		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		String repName="Test-Report-"+timeStamp+"AnushaExtent.html";
//		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\" +repName);
//
//		extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\extent-config.xml"));
//		 System.out.println("The suite has started ");
		
	}
	
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+"AnushaExtent.html";
		extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\" +repName);

		extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\extent-config.xml"));
		
		
		test = extent.startTest(context.getName(), "This is the test "+context.getName());
		logger.info("****************** "+context.getName()+" has started ***********************");
		System.out.println("****************** "+context.getName()+" has started ***********************");
		
	
	}


	public void onTestSuccess(ITestResult result) {
		ExtentTest test2;
		test2 = extent.startTest(result.getName());
		test2.log(LogStatus.PASS, result.getName());
		extent.endTest(test2);
		
		
	}

	public void onTestFailure(ITestResult result) {
		ExtentTest test2;
		test2 = extent.startTest(result.getName());
		test2.log(LogStatus.FAIL, result.getThrowable());
		extent.endTest(test2);
		
	}

	public void onTestSkipped(ITestResult result) {
		ExtentTest test2;
		test2 = extent.startTest(result.getName());
		test2.log(LogStatus.SKIP, result.getName()+" has been skipped");
		extent.endTest(test2);
		
	}




	public void onFinish(ITestContext context) {
		
		logger.info("****************** "+context.getName()+" has finished ***********************");
		System.out.println("****************** "+context.getName()+" has finished ***********************");
		extent.flush();
		extent.endTest(test);
		extent.close();
		
	}
	
	public void onFinish(ISuite suite) {
		
		System.out.println("The test suite has completed running");
		extent.close();


	
	}
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	
	
}
