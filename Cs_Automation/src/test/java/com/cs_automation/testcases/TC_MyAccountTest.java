package com.cs_automation.testcases;
import java.io.IOException;

import org.testng.annotations.Test;

import com.cs_automation.pageobject.IndexPage;
import com.cs_automation.pageobject.MyAccount;

import junit.framework.Assert;

public class TC_MyAccountTest extends Baseclass {

	@Test(enabled=false)
	public void verifyRegistrationAndLogin() {



		// Click Signup / Login
		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickSignupLogin();

		// Signup form
		MyAccount myAccount = new MyAccount(driver);
		myAccount.enterName("TESTER1");
		myAccount.enterSignupEmail("Tester9@yopmail.com");
		myAccount.clickSignupButton();

		//   logger.info("create button cliked");
		SignUpPage SignUpPage1 = new SignUpPage(driver);
		SignUpPage1.mrRadio();

		//  Assert.assertEquals(SignUpPage1.getName(), "Rohit kumar");
		SignUpPage1.enterpassword("test123");
		SignUpPage1.addfirtname("Rohit");
		SignUpPage1.addlastname("kumar");
		SignUpPage1.addcompanyname("test");
		SignUpPage1.addaddress("test1");
		SignUpPage1.addaddress3("test2");
		SignUpPage1.selectCountry("India");
		SignUpPage1.state("haryana");
		SignUpPage1.addcity("ynr");
		SignUpPage1.Zipcode("55656");
		SignUpPage1.addmobile_number("87686867");
		SignUpPage1.cratebutton();
		logger.info("entered user details on account creation page.");
		SignUpPage1.clickcontinuebutton();
		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();

		Assert.assertEquals("TESTER1", userName);
	}
	@Test

	public void verifylogin()throws IOException
	{
		logger.info("verify login execution started");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickSignupLogin();
		logger.info("Click on sign in link");
		MyAccount myap = new MyAccount(driver);
		myap.entersignupEmail("Tester9@yopmail.com");
		logger.info("username enterd successfully");
		myap.Enterpassword("test123");
		logger.info("Password enter sucessfully");
		myap.clickloginbutton();
		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();

		if(userName.equals("TESTER")) 
		{
			logger.info("Verify login passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Verify login failed");

			captureScreenShot(driver, "verifylogin");
			Assert.assertFalse(false);
		}
	}
}
