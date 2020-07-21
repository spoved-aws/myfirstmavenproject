package com.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TP_LoginPage  {

    public static WebDriverWait wait;
	
	/* Page Factory */

	@FindBy(id = "LoginForm_username")
	WebElement uName;

	@FindBy(id = "LoginForm_password")
	WebElement pwd;

	@FindBy(xpath = "//input[@value='Log In']")
	WebElement loginBtn;

	public TP_LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		 wait = new WebDriverWait(driver, 10);

	}

	public void enterUserName(String s) {
		
		wait.until(ExpectedConditions.elementToBeClickable(uName));
		uName.clear();
		uName.sendKeys(s);

	}

	public void enterPassword(String p) {
		pwd.clear();
		pwd.sendKeys(p);
	}

	public TP_HomePage clickLoginButton() {
		loginBtn.click();
		return new TP_HomePage();
	}

}
