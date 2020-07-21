package com.base;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Base_Practice {

	public static WebDriver driver;
	public static Logger logger;
	
	
	public Base_Practice() {
		
		System.out.println("I'm in the Base Class Constructor");
	}
	
	public void initialization() {
		
		System.out.println("I'm in the Base class initialization method");
		
	}

	

	
}
