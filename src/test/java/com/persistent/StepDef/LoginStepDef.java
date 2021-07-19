package com.persistent.StepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.persistent.Hook.Hooks;
import com.persistent.Page.ApplicationConstant;
import com.persistent.Page.HomePage;
import com.persistent.Page.LoginPage;
import com.persistent.Page.MyAccountPage;

import browserDriverConfiguration.DriverManagerFactory;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fileReader.QAEnvironmentReader;

public class LoginStepDef {

	private WebDriver driver;
	private HomePage homePage = null;
	private LoginPage loginPage = null;
	private MyAccountPage myAccountPage = null;

	public LoginStepDef() {
		this.driver = DriverManagerFactory
				.getManager(QAEnvironmentReader.getInstanceOfEnviornmentList().get(0).getBrowserName()).getDriver();
		this.driver.manage().window().maximize();

	}

	/*
	 * @Given("User is on application Login page and perform login as user {string} and password {string}"
	 * ) public void
	 * user_is_on_application_Login_page_and_perform_login_as_user_and_password(
	 * String string, String string2) throws Exception {
	 * 
	 * homePage = new HomePage(this.driver); loginPage = homePage.clickSignInLink();
	 * 
	 * }
	 */

	/*
	 * @When("^User is on application Login page and perform login as user \"([^\"]*)\" and password as \"([^\"]*)\"$"
	 * ) public void
	 * user_is_on_application_Login_page_and_perform_login_as_user_and_password(
	 * String string, String string2) throws Exception {
	 * 
	 * homePage = new HomePage(this.driver); loginPage = homePage.clickSignInLink();
	 * 
	 * }
	 */

	@When("authorized user login is performed")
	public void authorized_user_login_is_performed() {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("user would navigated to application home page")
	public void user_would_navigated_to_application_home_page() {
		homePage = new HomePage(this.driver);
	}

	@Given("User has opened application on browser and application home page is loaded")
	public void user_has_opened_application_on_browser_and_application_home_page_is_loaded() {
		homePage = new HomePage(this.driver);
		ApplicationConstant.featureContext.put("homePage", homePage);
	}

	@When("Perform click on signIn page")
	public void perform_click_on_signIn_page() throws Exception {
		loginPage = homePage.clickSignInLink();
	}

	@When("application Login page is displayed")
	public void application_Login_page_is_displayed() {

		Assert.assertTrue("Possibly Login Page is not displayed OR Sign Button is not displayed",
				loginPage.isSignInBttnDisplaye());

	}

	@When("^User attempt login with valid username as \"(.*)\" and password as \"(.*)\"$")
	public void user_attempt_login_with_valid_username_and_password(String username, String password) throws Exception {
		myAccountPage = loginPage.performSignIn(username, password);
		ApplicationConstant.featureContext.put("myAccountPage", myAccountPage);
	}

	@Then("User should navigated to My account Page")
	public void user_should_navigated_to_My_account_Page() {
		Assert.assertEquals("MyAccount page is not yet loaded", true,
				myAccountPage.getPageTitle().equals(ApplicationConstant.myAccountPageTitle));
	}

	@Then("able to verify below tabs are displayed")
	public void able_to_verify_below_tabs_are_displayed() {
		Assert.assertEquals("Order tab is loaded", true, myAccountPage.getMyAccountOrderHistoryTab().isDisplayed());

	}

	@Then("User may perform Logout from application")
	public void user_may_perform_Logout_from_application() throws Exception {

		myAccountPage.clickSignOutLink();
		myAccountPage.closeCurrentWindow();

	}

	@After(order = 1)
	public void afterFeature(Scenario scenario) {

		Hooks hk = new Hooks();

		hk.afterFeature(scenario);
	}

}
