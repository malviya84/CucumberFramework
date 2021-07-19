package com.persistent.StepDef;

import org.junit.Assert;

import com.persistent.Page.ApplicationConstant;
import com.persistent.Page.BasePage;
import com.persistent.Page.HomePage;
import com.persistent.Page.TwitterPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SocialNetworkingStepDef {

	private HomePage homePage;
	private TwitterPage twitterPage;

	@When("User click on twitter icon")
	public void user_click_on_twitter_icon() throws Exception {
		homePage = (HomePage) ApplicationConstant.featureContext.get("homePage");
		twitterPage = homePage.twitterIconClick();

	}

	@When("New twitter page is displayed")
	public void new_twitter_page_is_displayed() throws InterruptedException {

		twitterPage.WaitUntilWindowWithGivenTitleOpened(ApplicationConstant.socialTwitterPageTitle, 2000L);
		twitterPage.switchToWindowByTitle(ApplicationConstant.socialTwitterPageTitle);
		twitterPage.verifyPageTitle();
	}

	
	@Then("User should be able to perform search on twitter page with search Term as \"(.*)\"")
	public void user_should_be_able_to_perform_search_on_twitter_page_with_search_Term_as(String searchTerm)
			{
		twitterPage.searchObject(searchTerm);
	}

	@Then("switch back to parent window after closing twitter page")
	public void switch_back_to_parent_window_after_closing_twitter_page() {
		twitterPage.closeCurrentWindow();
		twitterPage.switchToHomePage(ApplicationConstant.homePageTitle);
	
		twitterPage.closeCurrentWindow();	
	}

}
