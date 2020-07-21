package com.practiceTestClasses;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RetryAnalyzerPractice extends Base_Practice {
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"browser"})
	public void setup(String browserType) {
		
		if(browserType.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			
		}else if(browserType.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.forevernew.co.in");
		
		System.out.println(driver.getTitle());
		
		
		
		
	}
	

	@Test
	public void testingRetryAnalyzer() {

	
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getTitle(), "Forever New India Offici", "********** FAILED ************ : The title is incorrect");
		System.out.println();
		
		sa.assertAll();
		
		
		
	}
	
	
	@Test
	public void testingRetryAnalyzer2() {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.forevernew.co.in");
		
		System.out.println(driver.getTitle());
		
		
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getTitle(), "Forever New India Offici", "********** FAILED ************ : The title is incorrect");		
		sa.assertAll();
		
		
	

}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
