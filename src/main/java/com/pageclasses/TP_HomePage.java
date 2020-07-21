package com.pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TP_Base;

public class TP_HomePage extends TP_Base{
	
	/* PageFactory */
	
	@FindBy(xpath = "//div[@class='title']")
	WebElement myAccountBtn;
	
	public TP_HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement  getMyAccountBtn() {
		
		return myAccountBtn;
		
		
	}

	
	
}
