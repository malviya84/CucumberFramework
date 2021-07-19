package com.persistent.StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.persistent.Page.ApplicationConstant;
import com.persistent.Page.MyAccountPage;
import com.persistent.Page.ProductPage;

import browserDriverConfiguration.DriverManagerFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.BrowserDriver;
import fileReader.QAEnvironmentReader;

public class ProductCheckoutStepDef {

	WebDriver driver;
	ProductPage productPge;
	MyAccountPage myAccountPage;

	public ProductCheckoutStepDef() {

		this.driver = DriverManagerFactory
				.getManager(QAEnvironmentReader.getInstanceOfEnviornmentList().get(0).getBrowserName()).getDriver();
		this.driver.manage().window().maximize();
	}
	/*
	 * @Given("User is logged in") public void user_is_logged_in() { // Write code
	 * here that turns the phrase above into concrete actions
	 * 
	 * 
	 * Actions action = new Actions(driver);
	 * action.moveToElement(driver.findElement(By.xpath(".//a[@title=\"Women\"]")));
	 * action.build().perform();
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 5);
	 * wait.until(ExpectedConditions .visibilityOfElementLocated(By.xpath(
	 * ".//a[@title=\"T-shirts\"]/preceding::a[@title=\"Blouses\"]")));
	 * action.moveToElement( driver.findElement(By.xpath(
	 * ".//a[@title=\"T-shirts\"]/preceding::a[@title=\"Blouses\"]")));
	 * action.click().build().perform();
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * @When("User select a product to buy") public void
	 * user_select_a_product_to_buy() { // Write code here that turns the phrase
	 * above into concrete actions
	 * 
	 * productPge.clickOnProduct();
	 * 
	 * }
	 * 
	 * @Then("User would buy a good") public void user_would_buy_a_good() throws
	 * InterruptedException { // Write code here that turns the phrase above into
	 * concrete actions
	 * 
	 * productPge.clickOnAddToCart(); productPge.clickOnProceedToCheckOut();
	 * productPge.clickOnProceedToCheckOut_SummaryPge();
	 * 
	 * }
	 */

	/*@Given("^User is logged in$")
	public void user_is_logged_in() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(".//a[@title=\"Women\"]"))).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")));
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")));
		action.click().build().perform();
	}

	@When("^User select a product to buy$")
	public void user_select_a_product_to_buy() {

		productPge.clickOnProduct();

	}
*/
	@Then("^User would buy a good$")
	public void user_would_buy_a_good() throws InterruptedException {
		productPge.clickOnAddToCart();
		productPge.clickOnProceedToCheckOut();
		productPge.clickOnProceedToCheckOut_SummaryPge();

	}

	@When("^User Select category as \"([^\"]*)\"$")
	public void user_Select_category_as(String categoryString) throws InterruptedException {
		
		
		System.out.println("user_Select_category_as"+ categoryString);
		this.myAccountPage=(MyAccountPage) ApplicationConstant.featureContext.get("myAccountPage");
		if(this.myAccountPage.equals(null))
			System.out.println("myAccount Object is not initialized");
		else
			System.out.println("MyAccount object is not null");
		
		productPge =this.myAccountPage.clickTopMenuCategory(categoryString.trim());
	}

	/*@When("^Add product a product to cart$")
	public void add_product_a_product_to_cart() {
		productPge.clickOnAddToCart();
	}*/
	@When("^Add product a product \"([^\"]*)\" to cart$")
	public void add_product_a_product_to_cart(String productName) {
		productPge.clickOnProductByName(productName);
	}

	@Then("^User should be able to complete checkout process$")
	public void user_should_be_able_to_complete_checkout_process() throws InterruptedException {
		productPge.clickOnAddToCart();
		productPge.clickOnProceedToCheckOut();
		productPge.clickOnProceedToCheckOut_SummaryPge();
		productPge.updateBillingAddr();
		productPge.checkTermsOfServices();
		productPge.clickOnProceedToCheckOut_ShippingPge();
		productPge.clickOnPaymentMethod();
		productPge.clickOnConfirmPayment();
	}

}
