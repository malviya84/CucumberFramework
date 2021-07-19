package com.persistent.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browserDriverConfiguration.DriverManagerFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import enums.BrowserDriver;

public class ProductPage  extends BasePage {

	
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		waitForPageLoaded(this.driver);
		PageFactory.initElements(driver, this);
		waitForPageLoaded(this.driver);
	}
	
	@FindBy(xpath=".//img[@alt=\"Faded Short Sleeve T-shirts\"][@title=\"Faded Short Sleeve T-shirts\"]") 
	WebElement productName; 
	
	@FindBy(xpath=".//*[@id=\"add_to_cart\"]/button/span") 
	WebElement btnAddToCart; 
	
	@FindBy(xpath="//iframe[starts-with(@id,'fancybox-frame')]")
	WebElement btnAddToCartFrm; 
	
	@FindBy(xpath="//div[@id='layer_cart']/div/child::div[2]//a[@title='Proceed to checkout']")
	WebElement btnProceedToCheckOut; 
	
	/*@FindBy(xpath=".//a[@title='Proceed to checkout'][@rel='nofollow']")
	WebElement btnProceedToCheckOut_SummaryPge; */

	@FindBy(xpath="//*[@id='center_column']/p[2]/a[1]/span")
	WebElement btnProceedToCheckOut_SummaryPge; 
	
	WebElement productByTitleValue;
	@FindBy(xpath="//*[@id=\"address_invoice\"]/li[7]/a/span")
	WebElement btnupdate; 
	
	@FindBy(xpath=".//input[@id='address2']")
	WebElement addr2; 
	
	
	@FindBy(xpath="//button[@id='submitAddress']")
	WebElement btnSaveAddr; 
	
	@FindBy(xpath="//button[@name='processAddress']")
	WebElement btnProceedToCheckOut_AddrPge; 
	
	@FindBy(xpath="//input[@type='checkbox'][@name='cgv']")
	WebElement checkBox; 
	
		
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement btnProceedToCheckOut_ShippingPge;
	
	@FindBy(xpath=".//a[@title='Pay by bank wire']")
	WebElement paymentMethod;
	
	@FindBy(how= How.XPATH, using = "//*[@id=\"cart_navigation\"]/button/span")
	WebElement btnConfirmOrder;
	
	

	public void setProductByTitleValue(By by) {
		
		this.productByTitleValue = driver.findElement(by);
		
	}
    public WebElement getProductByTitleValue() {
		
    	return productByTitleValue;
	}

	public void clickOnProduct()
	{
		productName.click();
	}
	
	public void clickOnProductByName(String productName)
	{
		setProductByTitleValue(getLocatory("xpath:.//img[@alt=\""+productName+"\"][@title=\""+productName+"\"]"));
		//.//img[@alt=\"Faded Short Sleeve T-shirts"][@title="Faded Short Sleeve T-shirts"]
		pageScrollTillElement(getProductByTitleValue());
		getProductByTitleValue().click();
	}
	
	
	
	public void clickOnAddToCart()
	{
		driver.switchTo().frame(0);
		btnAddToCart.click();
		driver.switchTo().defaultContent();
	}
	
	
	public void clickOnProceedToCheckOut() throws InterruptedException
	{
		waitUntilElementIsVisibile(btnProceedToCheckOut);
		Thread.sleep(5000L);
		WebDriverWait wait  = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable((btnProceedToCheckOut))).click();
		
		
	}
	
	
	public void clickOnProceedToCheckOut_SummaryPge() throws InterruptedException
	{
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		WebDriverWait wait  = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(btnProceedToCheckOut_SummaryPge)).click();
	/*	
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		btnProceedToCheckOut_SummaryPge.click();
		*/
		
	}
	public void updateBillingAddr() {
		
		btnupdate.click();
		addr2.clear();
		addr2.sendKeys("Flipkart square, Myntra road"); 
		btnSaveAddr.click();
		btnProceedToCheckOut_AddrPge.click();
			
	}
	
	public void checkTermsOfServices() {
		
		if(!checkBox.isSelected())
		{
			checkBox.click();
		}
	}
	
	
	public void clickOnProceedToCheckOut_ShippingPge() {
		
		btnProceedToCheckOut_ShippingPge.click();
			
	}
	
	public void clickOnPaymentMethod() {
		paymentMethod.click();
	}
	
	public void clickOnConfirmPayment() {
			
		btnConfirmOrder.click();
	}
	
	
	
	
	
	
	
	
}
