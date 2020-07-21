package com.practiceTestClasses;

import java.awt.Point;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in");
	}

	@Test()
	public void findLinks() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

//		WebElement crossBtn = driver.findElement(By.xpath("//div[@class='cross-icon']"));
//		wait.until(ExpectedConditions.elementToBeClickable(crossBtn));
//		crossBtn.click();//////

		int listSize;

		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));

		listSize = listOfLinks.size();
		System.out.println("The number of links on the page is : " + listSize);

		for (int i = 0; i < listSize; i++) {

			try {
				URL url = new URL(listOfLinks.get(i).getAttribute("href"));
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				if (connection.getResponseCode() == 200)
					System.out.println(
							i + ") " + connection.getResponseCode() + "--->" + connection.getResponseMessage());
				else
					System.out.println(i + ")" + listOfLinks.get(i).getAttribute("href") + "--->"
							+ connection.getResponseCode() + "--->" + connection.getResponseMessage());
			} catch (MalformedURLException e) {
				System.out.println(i + ") " + "**Exception**  Link:" + listOfLinks.get(i).getAttribute("href") + "  Link Text: "
						+ listOfLinks.get(i).getText() + "  Class Name  " + listOfLinks.get(i).getAttribute("class") +" Location"+ listOfLinks.get(i).getLocation());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	

		
		
		
		
		
	}


