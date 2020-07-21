package com.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {

	public static int retryLimit = 2;
	public int count = 0;
	
//	  private static final int MAX_RETRY_COUNT = 2;
//	  private int count = MAX_RETRY_COUNT;

	public boolean retry(ITestResult result) {

		if (count < retryLimit) {

			++count;
			return true;

		} else
			count = 0;
			return false;
		
//		 boolean retryAgain = false;
//		    if (count > 0) {
//		      System.out.println("Going to retry test case: " + result.getMethod() + ", " + ((
//		          (MAX_RETRY_COUNT - count) + 1)) + " out of " + MAX_RETRY_COUNT);
//		      retryAgain = true;
//		      --count;
//		    }
//		    return retryAgain;
	}

}
