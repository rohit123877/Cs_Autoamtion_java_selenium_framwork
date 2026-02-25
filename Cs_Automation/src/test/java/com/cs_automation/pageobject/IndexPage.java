package com.cs_automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

//Create webdriver object
 WebDriver ldriver;
 // create constructor
 public IndexPage(WebDriver rdriver)
 {
	 //initlize with remote driver
	 ldriver = rdriver;
	//call init element method
	 PageFactory.initElements(rdriver, this);
	 
 }
 //identify web element
 // WebElement
 @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
 WebElement signupLogin;

 // Action Method
 public void clickSignupLogin() {
     signupLogin.click();
 }
	}


