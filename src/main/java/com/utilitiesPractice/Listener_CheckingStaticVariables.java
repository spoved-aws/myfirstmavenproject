package com.utilitiesPractice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.Base_Practice;

public class Listener_CheckingStaticVariables extends Base_Practice implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("***************** On Test Method Start ******************");
		System.out.println("The value of static variable 'i' is : "+i);
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("***************** On Test Method Completion ******************");
		System.out.println("The value of static variable 'i' is : "+i);
		
		System.out.println("************** Calling update 'i' utility *********************");
		int j=Utility_TestTheValueOfStaticVariable.returnUpdated_i_value();
		System.out.println("*************** Printing updated 'i' value ********************");
		System.out.println("The updated value of 'i' is : "+j);
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
