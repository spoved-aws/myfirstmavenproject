package com.testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.TP_Base;
import com.pageclasses.TP_HomePage;
import com.pageclasses.TP_LoginPage;
import com.utilities.PavanReportingClass;


@Listeners(PavanReportingClass.class)
public class TP_LoginPageTest extends TP_Base {
	
	
	TP_LoginPage lp;
	TP_HomePage hp;
	
	public TP_LoginPageTest(){
		
		super();
	}

	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browserType) {
		logger.info("Initializing Browser");
		initialization(browserType);
		logger.info("Browser has been initialized");
		lp = new TP_LoginPage(driver);

	}
	
	@Test
	public void LoginTest() {
		logger.info("************************* Starting the test case - LoginTest ***************************************************");
		logger.info("Entering the username");
		lp.enterUserName(prop.getProperty("username"));
		logger.info("Entering the password");
		lp.enterPassword(prop.getProperty("password"));
		logger.info("Clicking on the Login button");
		hp = lp.clickLoginButton();

		Assert.assertEquals(hp.getMyAccountBtn().getText(),"dhee@g.com", "Login Not Successful");
		logger.info("The Login was successful");
		logger.info("LoginTest passed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
