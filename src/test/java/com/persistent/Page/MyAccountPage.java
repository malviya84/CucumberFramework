package com.persistent.Page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

	private WebDriver driver;

	private static String pageTitle;

	@FindBy(how = How.XPATH, using = "//a[@title='Orders']")
	private WebElement myAccountOrderHistoryTab;
	@FindBy(how = How.XPATH, using = "//a[@title='Credit slips']")
	private WebElement myAccountMyCreditSlipTab;
	@FindBy(how = How.XPATH, using = "//a[@title='Addresses']")
	private WebElement myAccountMyAddressTab;
	@FindBy(how = How.XPATH, using = "//a[@title='Information']")
	private WebElement myAccountMyPersonalInfoTab;
	@FindBy(how = How.XPATH, using = "//a[@title='My wishlists']")
	private WebElement myAccountMyWishListsTab;

	public MyAccountPage(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		waitForPageLoaded(this.driver);
		PageFactory.initElements(driver, this);
		waitForPageLoaded(this.driver);

		pageTitle = this.driver.getTitle().toString().trim();
		Assert.assertEquals("MyAccount page is not yet loaded", true,
				pageTitle.equals(ApplicationConstant.myAccountPageTitle));

	}

	public String getPageTitle() {
		return pageTitle;
	}

	public WebElement getMyAccountOrderHistoryTab() {
		return myAccountOrderHistoryTab;
	}

	public WebElement getMyAccountMyCreditSlipTab() {
		return myAccountMyCreditSlipTab;
	}

	public WebElement getMyAccountMyAddressTab() {
		return myAccountMyAddressTab;
	}

	public WebElement getMyAccountMyPersonalInfoTab() {
		return myAccountMyPersonalInfoTab;
	}

	public WebElement getMyAccountMyWishListsTab() {
		return myAccountMyWishListsTab;
	}

	public WebDriver getDriver() {
		return driver;
	}

}
