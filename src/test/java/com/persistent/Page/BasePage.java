package com.persistent.Page;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends CommanWebActions {

	private WebDriver driver;
	private Actions actions;

	@FindBy(how = How.XPATH, using = "//a[@title='Log in to your customer account']")
	private WebElement signInLink;
	@FindBy(how = How.XPATH, using = "//a[@title='Log me out']")
	private WebElement signOutLink;
	@FindBy(how = How.XPATH, using = ".//a[@title=\"Women\"]")
	private WebElement womenFromTopMenu;
	@FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	private WebElement tshirtFromWomenMenu;

	public BasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(this.driver);
	}

	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public LoginPage clickSignInLink() throws Exception {
		signInLink.click();
		return new LoginPage(this.driver);
	}

	public HomePage clickSignOutLink() {
		this.pageScrollToTop();
		signOutLink.click();
		return new HomePage(this.driver);
	}

	public WebElement getTopMenuElementLocator(String firstCategory, String secondCategory, String thridCategory) {
		String firstCategoryLocator = "//div[@id='block_top_menu']/ul/li/a[@title='firstCategory']";
		String secondCategoryLocator = "/parent::li/ul/li/a[@title='secondCategory']";
		String thirdCategoryLocator = "/parent::li/ul/li/a[@title='thridCategory']";

		if (!firstCategory.isEmpty()) {

			if (secondCategory != null) {

				if (thridCategory != null) {
					firstCategoryLocator = firstCategoryLocator.concat(secondCategoryLocator)
							.concat(thirdCategoryLocator).replace("firstCategory", firstCategory)
							.replace("secondCategory", secondCategory).replace("thridCategory", thridCategory);

					return driver.findElement(By.xpath(firstCategoryLocator));

				} else {
					firstCategoryLocator = firstCategoryLocator.concat(secondCategoryLocator)
							.replace("firstCategory", firstCategory).replace("secondCategory", secondCategory);

					return driver.findElement(By.xpath(firstCategoryLocator));
				}
			} else {
				firstCategoryLocator = firstCategoryLocator.replace("firstCategory", firstCategory);
				return driver.findElement(By.xpath(firstCategoryLocator));

			}

		}

		return null;
	}

	public By getLocatory(String locatoyIdentifier) {

		switch (getLocatorType(locatoyIdentifier)) {
		case "xpath":
			return By.xpath(getLocatorValue(locatoyIdentifier));
		case "id":
			return By.id(getLocatorValue(locatoyIdentifier));
		default:
			return null;
		}

	}

	public String getLocatorValue(String locatoyIdentifier) {
		return locatoyIdentifier.split(":")[1];
	}

	public String getLocatorType(String locatoyIdentifier) {
		return locatoyIdentifier.split(":")[0];
	}

	public ProductPage clickTopMenuCategory(String categoryHirerchy) {
		WebElement element;

		String[] category = categoryHirerchy.split(">");
		if (category.length == 1) {
			element = getTopMenuElementLocator(category[0].trim(), null, null);
			waitUntilElementIsVisibile(element);
			element.click();
		} else if (category.length == 2) {
			element = getTopMenuElementLocator(category[0].trim(), category[1].trim(), null);
			waitUntilElementIsVisibile(element);
			element.click();
		} else if (category.length == 3) {
			moveMouseToElement(getTopMenuElementLocator(category[0].trim(), null, null));
			moveMouseToElement(getTopMenuElementLocator(category[0].trim(), category[1].trim(), null));
			element = getTopMenuElementLocator(category[0].trim(), category[1].trim(), category[2].trim());
			waitUntilElementIsVisibile(element);
			element.click();
		}

		return new ProductPage(driver);

	}

}
