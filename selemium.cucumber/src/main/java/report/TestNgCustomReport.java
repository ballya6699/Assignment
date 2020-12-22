/*package report;

import java.io.File;
import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNgCustomReport 
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void CustomReport(String file)
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\report\\TestNGReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Windows 7");
		extent.setSystemInfo("Host Name", "Nikhil");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Nikhil Bhalerao");

		//htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
		htmlReporter.config().setReportName("My Report");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	public void createTest(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
	      {
	          test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.INDIGO));
	          test.fail(result.getThrowable());
	      }
	      else if(result.getStatus() == ITestResult.SUCCESS)
	      {
	          test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	      }
	      else
	      {
	          test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.PURPLE));
	          test.skip(result.getThrowable());
	      }
	}
	
	public void writeToReport()
	{
		extent.flush();
	}
}
*/