package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath = "//div[text()='Midtrans Pillow']")
	public WebElement header;
	
	@FindBy(xpath = "//a[text()='BUY NOW']")
	public WebElement buttonBuyNow;
	
	@FindBy(xpath = "//div[contains(@class,'price')]")
	public WebElement textPrice;
	
	@FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
	public WebElement textShoppingCart;
	
	@FindBy(xpath = "//iframe[@id='snap-midtrans']")
	public WebElement popUpFrame;
	
	@FindBy(xpath = "//td[contains(@class,'amount')]")
	public WebElement textPriceOnShoppingCart;
	
	@FindBy(xpath = "//div[contains(text(),'CHECKOUT')]")
	public WebElement textCheckOut;
	
	@FindBy(xpath = "//h1[contains(text(),'Sample Store')]")
	public WebElement textSampleStore;
	
	@FindBy(xpath = "//div[@id='application']//span[@class='text-amount-amount']")
	public WebElement textSampleStoreAmount;
	
	@FindBy(xpath = "//span[@class='item-name']")
	public WebElement textSampleStoreIteamName;
	
	@FindBy(xpath = "//td[@class='table-amount text-body']")
	public WebElement textSampleStoreTotalAmount;
	
	@FindBy(xpath = "//span[contains(text(),'Continue')]//parent::div")
	public WebElement buttonContinue;
	
	@FindBy(xpath = "//p[contains(text(),'Select Payment')]")
	public WebElement textSelectPayment;
	
	@FindBy(xpath = "//p[text()='Credit Card']")
	public WebElement textCreditCard;
	
	@FindBy(xpath = "//a[@class='list with-promo']")
	public WebElement paymentOptionsCreditCard;
	
	@FindBy(xpath = "//input[@name='cardnumber']")
	public WebElement textBoxCardnumber;
	
	@FindBy(xpath = "//input[@placeholder='MM / YY']")
	public WebElement textBoxExpiryDate;
	
	@FindBy(xpath = "//input[@placeholder='123']")
	public WebElement textBoxCVV;
	
	@FindBy(xpath = "//label[text()='Midtrans Promo']//parent::div")
	public WebElement selectPromo;
	
	@FindBy(xpath = "//span[text()='Pay Now']//parent::div")
	public WebElement buttonPayNow;
	
	@FindBy(xpath = "//span[text()='Promo is not available']")
	public WebElement textPromoIsNotAvailable;
	
	@FindBy(xpath = "//input[@id='PaRes']")
	public WebElement textBoxPasword;
	
	@FindBy(xpath = "//iframe[contains(@src,'https://api.sandbox.veritrans.co.id/v2/token/rba/redirect/')]")
	public WebElement iframeIssuingBank;
	
	@FindBy(xpath = "//h1[text()='Issuing Bank']")
	public WebElement textIssuingBank;
	
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement buttonOk;
	
	@FindBy(xpath = "//div[text()='Transaction successful']")
	public WebElement textTransactionSuccessful;
	
	@FindBy(xpath = "//span[text()='Transaction failed']")
	public WebElement textTransactionFailed;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
}
