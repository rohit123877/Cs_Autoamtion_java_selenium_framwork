package com.cs_automation.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cs_automation.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getURL();
	String browser = readConfig.getBrowser();

	public static Logger logger;
	public static WebDriver driver;

	@BeforeClass
	public void setup() {

		logger = LogManager.getLogger("Cs_Automation");

		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			throw new RuntimeException("Browser not supported");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		logger = LogManager.getLogger("Cs_Automation");
		// Open URL
		driver.get(url);
		logger.info("URL opened successfully");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);

		//step2: call getScreenshotAs method to create image file

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

		//step3: copy image file to destination
		FileUtils.copyFile(src, dest);

	}}
