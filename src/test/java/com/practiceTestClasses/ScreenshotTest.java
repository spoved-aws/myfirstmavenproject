package com.practiceTestClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.Base_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotTest extends Base_Practice {

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(String browserType) {

		if (browserType.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@Test
	public void anushaMethod1() {

		SoftAssert sa = new SoftAssert();
		String title = driver.getTitle();
		System.out.println(title);
		sa.assertEquals("Forever New", driver.getTitle());
		
		sa.assertAll();
		
		

	}

	@Test
	public void anushaMethod2() {
		SoftAssert sa = new SoftAssert();
		String title = driver.getTitle();
		System.out.println(title);
		sa.assertEquals("Forever New", driver.getTitle());
	
		sa.assertAll();

		
	}

	@Test
	public void anushaMethod3() {
		SoftAssert sa = new SoftAssert();
		String title = driver.getTitle();
		System.out.println(title);
		sa.assertEquals("Forever New", driver.getTitle());

		sa.assertAll();
		
	}

}
