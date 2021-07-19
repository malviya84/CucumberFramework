package com.persistent.StepDef;

import org.openqa.selenium.WebDriver;

import com.persistent.Hook.Hooks;
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

public class MyAccountStepDef {
	private WebDriver driver;
	private HomePage homePage = null;
	private LoginPage loginPage = null;
	private MyAccountPage myAccountPage = null;

	public MyAccountStepDef() {
		this.driver = DriverManagerFactory
				.getManager(QAEnvironmentReader.getInstanceOfEnviornmentList().get(0).getBrowserName()).getDriver();
		this.driver.manage().window().maximize();

	}
	
	@When("Click on UPdate Address button")
	public void click_on_UPdate_Address_button() {
	   
	}

	@When("^Update City as \"([^\"]*)\" and Click on Save button$")
	public void update_City_as_and_Click_on_Save_button(String string) {
	   
	}

	@Then("Verify that Updated Changes are saved")
	public void verify_that_Updated_Changes_are_saved() {
	  
	}

	@Then("User is still on MyAccount Page")
	public void user_is_still_on_MyAccount_Page() {
		
		
	   
	}
	/*@After(order=1)
	public void afterFeature(Scenario scenario ) {
		
		Hooks hk = new Hooks();
		
		hk.afterFeature(scenario);
	}*/

}
