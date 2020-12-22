package report;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.core.api.Scenario;

public class CustomReport 
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public CustomReport(String file)
	{
		htmlReporter = new ExtentHtmlReporter(new File(file));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	public void createTest(Scenario scenario, String screenShot) throws IOException
	{
		if(scenario!=null)
		{
			String testName = getTitleOfTheScenario(scenario);
			switch (scenario.getStatus()) 
			{
			case PASSED:
				extent.createTest(testName).pass("PASSED").addScreenCaptureFromPath(screenShot);
				
				break;
			case FAILED:
				extent.createTest(testName).fail("FAILED").addScreenCaptureFromPath(screenShot);
				
				break;

			default:
				extent.createTest(testName).skip("SKIPPED").addScreenCaptureFromPath(screenShot);
				break;
			}
			scenario.getStatus();
		}
	}
	
	public void writeToReport()
	{
		if(extent!=null)
		{
			extent.flush();
		}
	}
	
	private String getTitleOfTheScenario(Scenario scenario)
	{
		return scenario.getName().replace(" ", "");
	}
}
