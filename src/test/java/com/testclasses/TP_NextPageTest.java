package com.testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.TP_Base;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(Reporter_ITestListenerInterface.class)
public class TP_NextPageTest extends TP_Base {



	@Parameters({ "browser" })
	@BeforeMethod
	public void invokeBrowser(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

//		if (browser.equalsIgnoreCase("chrome")) {
////				WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
//			driver = new ChromeDriver();
//
//		} else if (browser.equalsIgnoreCase("firefox")) {
////				WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
//			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.flipkart.com");

	}

	@Test()
	public void addToCart() {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[text()='✕']"))).click().build().perform();

		WebElement womenBtn = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
		womenBtn.click();

//		WebElement womenSportsShoes = driver
//				.findElement(By.xpath("//li[@class='Wbt_B2 _3mmoXN']//a[contains(text(),'Sports Shoes')]"));
//		womenSportsShoes.click();
//		
//		WebElement pumaShoes = driver.findElement(By.xpath("//a[contains(text(),\"Emergence Wn's Running Shoes For Women\")]"));
//		pumaShoes.click();
//		
//		driver.switchTo().defaultContent();
//		
//		WebElement shoes2 = driver.findElement(By.xpath("//a[contains(text(),\"NRGY Neko Sport Wn's Running Shoes For Women\")]"));
//		shoes2.click();
//		
//		driver.switchTo().defaultContent();

//		WebElement shoes3 = driver.findElement(By.xpath("//a[contains(text(),'WMNS CITY TRAINER 2 Running Shoes For Women')]"));
//		shoes3.click();
//		
//		
//		Set<String> handler = driver.getWindowHandles();
//		Iterator<String> itr = handler.iterator();
//		
////		String parentWindowId = itr.next();
////		String childWindowId = itr.next();
//		
////		driver.switchTo().window(childWindowId);
//		
//		String windowHandleArray[] = new String[handler.size()];
//		
//		for(int i=0; i<handler.size(); i++) {
//			
//			windowHandleArray[i] = itr.next();
//		}
//		
//		driver.switchTo().window(windowHandleArray[2]);
//		WebElement clickBtn = driver.findElement(By.xpath("//a[@class='_1TJldG _3c2Xi9 _2I_hq9 _2UBURg']"));
		System.out.println("test case complete");
//		clickBtn.click();
//		WebElement addToCart = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		addToCart.click();

	}
	
	@Test
	public void deliberateFailureTest() {
		

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//button[text()='✕']"))).click().build().perform();

		WebElement womenBtn = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
		womenBtn.click();
		
		Assert.assertEquals(false, true);
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
}