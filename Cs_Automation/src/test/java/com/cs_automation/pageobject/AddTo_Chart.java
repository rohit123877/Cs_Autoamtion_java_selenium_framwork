package com.cs_automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTo_Chart {
	WebDriver ldriver;
	public void addChart(WebDriver  rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	//identify the elements 
	@FindBy(id="1")
	WebElement addToChart;
	//@FindBy(xpath  = "//button[text()='Continue Shopping']")
	//WebElement continueSgoping;
	@FindBy(css = "a[href='/view_cart']")
	private WebElement viewCartLink;
	@FindBy(className = "check_out")
	private WebElement proceedToCheckoutBtn;
	@FindBy(name = "message")
	private WebElement messageTextArea;
	@FindBy(xpath = "//a[text()='Place Order']")
	private WebElement placeOrderBtn;
	@FindBy(className = "form-control")
	WebElement EnterClassName;
	@FindBy(className="form-control card-number")
	WebElement EnterCardNumber;
	@FindBy(className = "form-control card-cvc")
	WebElement EnterCvv;
	@FindBy(name = "expiry_month")
	WebElement EnterMonth;
	@FindBy(name = "expiry_year")
	WebElement EnterYear;
	@FindBy(id ="submit")
	WebElement ClickSubmoit;
	//Action method 
	public void ClickAddToChart()
	{
		addToChart.click();
	}
	public void viewCartLink()
	{
		viewCartLink.click();
	}
	public void proceedToCheckoutBtn()
	{
		proceedToCheckoutBtn.click();
	}
	public void messageTextArea()
	{
		messageTextArea.sendKeys("This is for test");
	}
	public void placeOrderBtn()
	{
		placeOrderBtn.click();
	}
	public void EnterClassName()
	{
		EnterClassName.sendKeys("Text");
	}
	public void EnterCardNumber()
	{
		EnterCardNumber.sendKeys("123445");
	}
	public void EnterCvv()
	{
		EnterCvv.sendKeys("445");
	}
	public void EnterMonth()
	{
		EnterMonth.sendKeys("12");
	}
	public void EnterYear()
	{
		EnterYear.sendKeys("2022");
	}
	public void ClickSubmoit()
	{
		ClickSubmoit.click();
	}

}
