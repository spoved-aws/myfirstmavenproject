package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jsoup.Connection.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TP_Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;

	public TP_Base() {

		prop = new Properties();
		FileInputStream ip;
		String currentDir = System.getProperty("user.dir");
		try {
			ip = new FileInputStream(currentDir + "\\src\\main\\resources\\config.properties");
			prop.load(ip);
		}

		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		logger = Logger.getLogger(TP_Base.class);

	}

	public static void initialization(String browser) {

//		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
//			
////			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			
//		}else if (prop.getProperty("browser").equalsIgnoreCase("FireFox")) {
//			
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}else {
//			
//			System.out.println("Please specify a browser");
//		}

		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	

	}

