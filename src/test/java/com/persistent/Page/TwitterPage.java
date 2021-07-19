package com.persistent.Page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TwitterPage extends BasePage {

	private WebDriver driver;
	private WebElement twitterTab;
	private WebElement twitWin;
	private static String pageTitle;
	@FindBy(how = How.ID, using = "search-query")
	WebElement searchTextBox;
	@FindBy(how = How.XPATH, using = "//input[@id='search-query']/parent::form/span/button[@type='submit']")
	WebElement searchLenseIcon;
	
	@FindBy(how=How.XPATH, using ="//div[@role='listbox']")
	WebElement twitterSearchList;
	
	

	/*
	 * @FindBy(how = How.XPATH, using = "id:search-query") WebElement searchObject;
	 */
	public TwitterPage(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		waitForPageLoaded(this.driver);
		this.WaitUntilWindowWithGivenTitleOpened(ApplicationConstant.socialTwitterPageTitle, 2000L);
		/*pageTitle = this.driver.getTitle().toString().trim();
		System.out.println("Page title while creating twitterpage object"+pageTitle);
		Assert.assertEquals("Twitter page is not yet loaded", true,
				pageTitle.equals(ApplicationConstant.socialTwitterPageTitle));*/
	}

	public void searchObject(String searchTerm) {
		waitUntilElementIsClickable(searchTextBox);
		searchTextBox.clear();
		searchTextBox.click();
		searchTextBox.sendKeys(searchTerm.toString());
		waitUntilElementIsVisibile(twitterSearchList);
	}
	public void clickTwitterSearchLenseIcon(String searchTerm) {
		searchLenseIcon.click();
	}

	public void verifyPageTitle() {
		Assert.assertTrue("TwitterPage is not displayed", ApplicationConstant.socialTwitterPageTitle.equals(driver.getTitle()));
		System.out.println("Title page is " +driver.getTitle());
		
	}

}
