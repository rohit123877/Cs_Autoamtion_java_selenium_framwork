package com.cs_automation.pageobject;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MyAccount {

	WebDriver ldriver;

	// Constructor
	public MyAccount(WebDriver rdriver) {
		ldriver = rdriver;
		// PageFactory.initElements(new AjaxElementLocatorFactory(rdriver, 15), this);
		PageFactory.initElements(rdriver, this);
	}
	// Identify the elements 
	// Identify elemnets for the new sign up 
	@FindBy(name = "name")
	WebElement NewuserName;

	@FindBy(css = "input[data-qa='signup-email']")
	WebElement RegisternewUserEmeail;

	@FindBy(css = "button[data-qa='signup-button']")
	WebElement ClicksignupButton;

	// Identify method allready available user 


	@FindBy(css = "input[data-qa='login-email']")
	WebElement RegistereduserEmail;
	@FindBy(css = "input[data-qa='login-password']")
	WebElement Enterpassword;

	@FindBy(css = "button[data-qa='signup-button']")
	WebElement signupButton;
	@FindBy(css = "button[data-qa='login-button']")
	WebElement clickloginbutton;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement signOutLink;
	// Actions / Methods
	public void enterName(String name) {
		NewuserName.clear();
		NewuserName.sendKeys(name);
	}
	// In MyAccount.java
	public void enterSignupEmail(String emailValue) {
		RegisternewUserEmeail.clear();
		RegisternewUserEmeail.sendKeys(emailValue);
	}

	public void clickSignupButton() {
		signupButton.click();
	}
	//action method for allready craeted user 
	public void entersignupEmail(String addemail)
	{
		RegistereduserEmail.clear();
		RegistereduserEmail.sendKeys(addemail);
	}
	public void Enterpassword(String psw)
	{
		Enterpassword.clear();
		Enterpassword.sendKeys(psw);
	}
	public void clickloginbutton()
	{
		clickloginbutton.click();
	}
	public void ClickOnSignOut() {
		// 1. Initialize the wait
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

		// 2. Locate the element with the robust XPath we created
		WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]")));

		// 3. Click the element
		logoutLink.click();
	}
	// Combined action (Interview-friendly)
	public void signup(String name, String email1) {
		enterName(name);
		enterSignupEmail(email1);
		clickSignupButton();
	}

}