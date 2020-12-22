package stepDefination;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import report.CustomReport;
import util.TestBase;

public class UIStepDefination extends TestBase
{
	
	HomePage hp1;
	public UIStepDefination() 
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		init();
		hp1 = new HomePage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	private static CustomReport customReport;
	private static boolean isReporterRunning;
	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		if(!isReporterRunning)
		{
			customReport = new CustomReport(System.getProperty("user.dir") +"\\report\\TestReport.html");
			isReporterRunning = true;
		}
	}
	
	@After
	public void afterScenario(Scenario scenario) throws IOException
	{
		String screenShotFileName = System.getProperty("user.dir") +"\\screenshots\\" + scenario.getName().replaceAll(" ", "") + ".png";
		if(scenario.isFailed())
		{
			captureScreenShot(screenShotFileName);
		}
		customReport.createTest(scenario, screenShotFileName);
		customReport.writeToReport();
		driver.quit();
	}
	
	
	HomePage hp;
	@Given("Open browser and goto home page")
	public void open_Browser_and_goto_homePage() 
	{
		init();
		hp1 = new HomePage();
		String header = hp1.header.getText();
		String amount = hp1.textPrice.getText();
		Assert.assertEquals(header, "Midtrans Pillow");
		Assert.assertEquals(amount, "Rp 20,000");
	}
	
	@Then("Click on Buy Now button")
	public void click_on_Buy_Now_button() {
		hp1.buttonBuyNow.click();
	    waitForPresent(hp1.textShoppingCart);
	}

	@Then("Click on CheckOut button")
	public void click_on_CheckOut_button() 
	{
		hp1.textCheckOut.click();
	}

	@Then("Check Sample Store pop-up opens")
	public void check_Sample_Store_pop_up_opens() throws InterruptedException 
	{
		//Thread.sleep(5000);
		waitForPresent(hp1.popUpFrame);
		driver.switchTo().frame(hp1.popUpFrame);
		waitForPresent(hp1.textSampleStore);
	}

	@Then("On Order Summary pop-up opens check iteams and Amount and click on continue")
	public void on_Order_Summary_pop_up_opens_check_iteams_and_Amount_and_click_on_continue() 
	{
		String iteamName = hp1.textSampleStoreIteamName.getText();
		String iteamPrice = hp1.textSampleStoreAmount.getText();
		Assert.assertEquals("Midtrans Pillow", iteamName);
		Assert.assertEquals("20,000", iteamPrice);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", hp1.buttonContinue);
	}

	@Then("On Select Payment pop-up select credit card as a payment mode")
	public void on_Select_Payment_pop_up_select_credit_card_as_a_payment_mode() 
	{
		waitForPresent(hp1.textSelectPayment);
		hp1.paymentOptionsCreditCard.click();
	}

	@Then("On Credit Card pop-up right card number for Successful Payment")
	public void on_Credit_Card_pop_up_right_card_number_for_successful_payment()
	{
		waitForPresent(hp1.textCreditCard);
		hp1.textBoxCardnumber.sendKeys("4811111111111114");
	}
	
	@Then("On Credit Card pop-up enter card details and click on pay now button")
	public void on_Credit_Card_pop_up_enter_card_details_and_click_on_pay_now_button() 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/yy");
		Date date = new Date();
		String currentDate = formatter.format(date).toString();
		
		//hp1.textBoxExpiryDate.click();
		hp1.textBoxExpiryDate.sendKeys(currentDate);
		
		//hp1.textBoxCVV.click();
		hp1.textBoxCVV.sendKeys("123");
		
		hp1.selectPromo.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()",hp1.buttonPayNow);
		
		/*if(hp1.textPromoIsNotAvailable.isDisplayed())
		{
			hp1.selectPromo.click();
		}
		executor.executeScript("arguments[0].click()",hp1.buttonPayNow);*/
	}
	
	@Then("Check Issuing Bank pop-up is loaded and proceed with OTP")
	public void check_Issuing_Bank_pop_up_is_loaded_and_proceed_with_OTP() 
	{
		waitForPresent(hp1.iframeIssuingBank);
		driver.switchTo().frame(hp1.iframeIssuingBank);
		waitForPresent(hp1.textIssuingBank);
		hp1.textBoxPasword.sendKeys("112233");
		hp1.buttonOk.click();
		
		driver.switchTo().parentFrame();
	}
	
	@Then("Verify for the Success Message")
	public void verify_for_the_Success_Message() 
	{
		waitForPresent(hp1.textTransactionSuccessful);
		String success = hp1.textTransactionSuccessful.getText();
		Assert.assertEquals("Transaction successful", success);
	}
	
	@Then("On Credit Card pop-up wrong card number for Successful Payment")
	public void on_Credit_Card_pop_up_wrong_card_number_for_Successful_Payment() 
	{
		waitForPresent(hp1.textCreditCard);
		hp1.textBoxCardnumber.sendKeys("4911111111111113");
	}

	@Then("Verify for the Failuar Message")
	public void verify_for_the_Failuar_Message() 
	{
		waitForPresent(hp1.textTransactionFailed);
		String failed = hp1.textTransactionFailed.getText();
		Assert.assertEquals("Transaction failed", failed);
	}

}
