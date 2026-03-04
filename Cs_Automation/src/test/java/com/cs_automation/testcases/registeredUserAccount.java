package com.cs_automation.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registeredUserAccount {

	//1. create object of webdriver
	WebDriver ldriver;

	//constructor
	public registeredUserAccount(WebDriver rdriver)
	{
		ldriver = rdriver;


		PageFactory.initElements(rdriver, this);
	}


	//identify webelements
	@FindBy(xpath = "//i[@class='fa fa-user']/following::b[1]") 
	WebElement userName;
	public String getUserName()
	{
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(userName));

		return userName.getText();
	}

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement signOutLink;

	/*		@FindBy(name ="search_query")
	WebElement searchBox;

	@FindBy(name ="submit_search")
	WebElement submit_search;

	@FindBy(linkText = "Women")
	WebElement WomenMenu;

	@FindBy(linkText="T-shirts")
	WebElement TShirtMenu;*/


	public void ClickOnSignOut() {
		// 1. Initialize the wait
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

		// 2. Locate the element with the robust XPath we created
		WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]")));

		// 3. Click the element
		logoutLink.click();
	}


	/*public String getUserName()
	{
		String text = userName.getText();

		return text;
	}*/


	/*
	public void EnterDataInSearchBox(String searchKey)
	{
		searchBox.sendKeys(searchKey);
	}

	public void ClickOnSearchButton()
	{
		submit_search.click();

	}


	public void MouseOverTShirtMenu()
	{
		Actions actions=new Actions(ldriver);
		actions.moveToElement(WomenMenu).moveToElement(TShirtMenu).click().perform();
	}	*/
}
