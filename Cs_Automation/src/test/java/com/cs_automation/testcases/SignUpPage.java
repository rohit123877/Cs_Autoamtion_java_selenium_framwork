package com.cs_automation.testcases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

	WebDriver ldriver;

	public SignUpPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	//identify the elements
	@FindBy(id="id_gender1")
	WebElement mrRadio;
	// @FindBy(id="name")
	//   WebElement name;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id="first_name")
	WebElement addfirstname;
	@FindBy(id="last_name")
	WebElement addlast_name;
	@FindBy(id="company")
	WebElement addcompany;
	@FindBy(id="address1")
	WebElement adaddress1;
	@FindBy(id="address2")
	WebElement addaddress2;
	@FindBy(id = "country")
	WebElement addcountryDropdown;
	@FindBy(id="state")
	WebElement addstate;
	@FindBy(id="city")
	WebElement addcity;
	@FindBy(id="zipcode")
	WebElement addzipcode;
	@FindBy(id="mobile_number")
	WebElement addmobile_number ;  
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/div[1]/form/button")
	WebElement clickcratebutton;
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement continuebuttton;
	//Identify actions 
	public void mrRadio()
	{
		mrRadio.click();
	}
	//  public String getName() {
	//     return name.getAttribute("value");
	// }

	public void enterpassword(String pass) {
		password.sendKeys(pass);
	}
	public void addfirtname(String first)
	{
		addfirstname.sendKeys(first);
	}
	public void addlastname(String lname)
	{
		addlast_name.sendKeys(lname);
	}
	public void addcompanyname(String test)
	{
		addcompany.clear();
		addcompany.sendKeys(test);
	}
	public void addaddress(String address)
	{
		adaddress1.clear();
		adaddress1.sendKeys(address);
	}

	public void addaddress3(String addr1)
	{
		addaddress2.clear();
		addaddress2.sendKeys(addr1);
	}
	public void selectCountry(String countryName) {
		Select select = new Select(addcountryDropdown);
		select.selectByVisibleText(countryName);
	}

	public void state(String state1)
	{
		addstate.sendKeys(state1);
	}
	public void addcity(String city1)
	{

		addcity.sendKeys(city1);
	}
	public void Zipcode(String zip)
	{
		addzipcode.sendKeys(zip);
	}
	public void addmobile_number(String mobile_number)
	{
		addmobile_number.sendKeys(mobile_number);
	}
	public void cratebutton()
	{
		clickcratebutton.click();
	}
	public void clickcontinuebutton()
	{
		continuebuttton.click();
	}
}

