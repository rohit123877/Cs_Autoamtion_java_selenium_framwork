package com.cs_automation.testcases;
import java.io.IOException;
import java.util.logging.Logger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cs_automation.pageobject.IndexPage;
import com.cs_automation.pageobject.MyAccount;
import com.cs_automation.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPageTestDataDrivenTesting extends Baseclass {

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
	@Test(dataProvider = "LoginDataProvider")

	public void verifylogin(String userEmail, String UserPass, String expectedUsername)throws IOException
	{
		driver.get(url);
		logger.info("verify login execution started for:" + userEmail);
		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickSignupLogin();
		logger.info("Click on sign in link");
		
		MyAccount myap = new MyAccount(driver);
		myap.entersignupEmail(userEmail);
		logger.info("username enterd successfully" +userEmail);
		
		myap.Enterpassword(UserPass);
		logger.info("Password enter sucessfully");
		
		myap.clickloginbutton();
		logger.info("Login button click ");
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();
		String actualName = regUser.getUserName();
		if(actualName.trim().equals(expectedUsername.trim())){
			logger.info("login success fot  " + userEmail);
		
		//	logger.info("Verify login passed");
			Assert.assertTrue(true);
			regUser.ClickOnSignOut();
		}
		else
		{
			logger.info("Verify login failed for" +userEmail);

			captureScreenShot(driver, "verifylogin" +userEmail);
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			Assert.fail("Login failed: Expected " + expectedUsername + "but found" +userName);
		}
		logger.info("***************TestCase Verify login ends*****************"); 
	}
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\data driven\\DataDRiven.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
		// 1. ADD THIS VALIDATION CHECK
	    if (ttlRows <= 1) {
	        System.out.println("ERROR: Excel sheet 'LoginTestData' is empty or only has headers. Row count: " + ttlRows);
	        return new String[0][0]; // Return an empty array so TestNG skips gracefully instead of crashing
	    }

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}
