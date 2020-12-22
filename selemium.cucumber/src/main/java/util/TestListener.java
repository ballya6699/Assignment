package util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener implements ITestListener
{

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public TestListener()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\report\\TestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Windows 7");
		extent.setSystemInfo("Host Name", "Nikhil");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Nikhil Bhalerao");

		htmlReporter.config().setDocumentTitle("HSBC Demo Report");
		htmlReporter.config().setReportName("HSBC Demo Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestStart(ITestResult result) 
	{
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test = extent.createTest(result.getName(), "Test Case got Passed");
		}
	}

	public void onTestFailure(ITestResult result) 
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test = extent.createTest(result.getName(), "Failed due to following reasons");
			test.fail(result.getThrowable());
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		if(result.getStatus() == ITestResult.SKIP)
		{
			test = extent.createTest(result.getName(), "Test Cased got Skipped");
			test.skip(result.getThrowable());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}


}
