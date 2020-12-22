package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.RestAssured;

public class TestBase 
{
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop = new Properties();
		try 
		{
			FileInputStream fip = new FileInputStream(System.getProperty("user.dir") +"//src//main//java//config//config.properties");
			prop.load(fip);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void init()
	{
		/*String browser = prop.getProperty("browser");
		
		if(browser.equals("CC"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));*/
		
		//FOR API 
		RestAssured.baseURI = "https://api.ratesapi.io/api";
	}
	
	public void waitForPresent(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.IMPLICITLY);
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static String captureScreenShot(String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = new String(screenshotName);
		File destination = new File(dest);
		FileUtils.copyFile(src, destination);
		
		return dest;
	}
	
	/*@SuppressWarnings("deprecation")
	public void waitForPresentByFluent(WebElement element)
	{
			Wait wait = new FluentWait(driver)
			.withTimeout(120, TimeUnit.SECONDS)
			.pollingEvery(10, TimeUnit.SECONDS)
			.ignoring(Exception.class);

			WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
			public WebElement applyy(WebDriver driver) {
			return driver.findElement(By.id("foo"));
			}
			});
	}*/
	
}
