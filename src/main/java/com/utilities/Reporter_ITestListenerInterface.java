package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.TP_Base;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter_ITestListenerInterface extends TP_Base implements ITestListener, ISuiteListener {

	public static ExtentReports extent;
	public static Log logger;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Started>>Suite Name: " + suite.getName());
		

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + "AnushaVenkatesanExtent.html";
		extent = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\" + repName);

		extent.loadConfig(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\extent-config.xml"));
				

	}

	public void onStart(ITestContext context) {
		System.out.println("Started>>Test Name: " + context.getName());

		test = extent.startTest(context.getName(), "Test Name " + context.getName());

	}

	public void onTestStart(ITestResult result) {

//		test = extent.startTest(result.getName(), "Test Name " + result.getName());
		System.out.println("Method Started-->Test Method Name: " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Method Success--> Test Method Name : " + result.getName());

		test.log(LogStatus.PASS, result.getName(), "This method passed");
		extent.flush();

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Method Failure---> Test Method Name: " + result.getName());

		test.log(LogStatus.FAIL, result.getName(), result.getThrowable());
		takeScreenshot(result.getName());

		extent.flush();

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Method Skipped---> Test Method Name: " + result.getName());

		test.log(LogStatus.SKIP, result.getName(), "This method was skipped");
		extent.flush();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		System.out.println("Finished>>Test Name: " + context.getName());

		extent.endTest(test);

	}

	public void onFinish(ISuite suite) {
		System.out.println("Finished>>Suite Name: " + suite.getName());

//		extent.close();

	}

	public static void takeScreenshot(String methodName) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String pathName = System.getProperty("user.dir") + "\\Screenshots\\" + methodName + "_" + timeStamp + ".jpg";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(pathName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
