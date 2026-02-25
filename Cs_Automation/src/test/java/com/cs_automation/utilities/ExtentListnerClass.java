package com.cs_automation.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//use  Interface 

public class ExtentListnerClass implements ITestListener{
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void ConfigureReport()
	{
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "Cs_Automation" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		//add system information 
		reports.setSystemInfo("machine" ,"test");
		reports.setSystemInfo("OS", "Wnodows");
		reports.setSystemInfo("browser", "Chrome");
		reports.setSystemInfo("test", "Rohit");
		// Configure to change the look of extent reports 
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("my first project");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onStart(ITestContext Result)
	{
		ConfigureReport();
		System.out.println("On stsrt method invoke....");
	}
	public void onFinish(ITestContext Result)
	{
		System.out.println("On finish this method invoke...");
		reports.flush();
	}
	public void onTestFailure(ITestContext Result)
	{
		System.out.println("name of the test method failed:"+ Result.getName() );
		test = reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
		//When the test case is get skipped 
		String screenshotpath = System.getProperty("user.dir")+ "\\screenshot\\" + Result.getName() + ".png";
		File  screenShotFile = new File (screenshotpath);
		if(screenShotFile.exists())
		{
			test.fail("capture screenshot is below: " + test.addScreenCaptureFromPath(screenshotpath));
		}
	}
	public void onTestSkipped(ITestContext Result )
	{
		System.out.println("name of the metho is skipped:' " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("name of the skipped test case is " + Result.getName(),ExtentColor.YELLOW));
	}

	public void onTestStart(ITestResult Result)					
	{		
		System.out.println("Name of test method started:" + Result.getName() );  		

	}		

	// When Test case get passed, this method is called.		

	public void onTestSuccess(ITestResult Result)					
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}	}