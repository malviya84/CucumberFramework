package com.persistent.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage  extends BasePage{
	
	WebElement signInLink;
	WebElement cartIcon;
	WebElement searchTextBox;
	WebElement searchIcon;
	
	@FindBy(how=How.XPATH,using="//section[@id='social_block']/ul/li[2]/a")
	WebElement twitterSocialIcon;
	
	WebDriver driver; 
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		this.driver.get("http://automationpractice.com/index.php");
	}
	
	public WebElement getSignInLink() {
		return signInLink;
	}
	public void setSignInLink(By signInLink) {
		this.signInLink = driver.findElement(signInLink);
		
	}
	public WebElement getCartIcon() {
		return cartIcon;
	}
	public void setCartIcon(By cartIcon) {
		this.cartIcon = driver.findElement(cartIcon);;
	}
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}
	public void setSearchTextBox(By searchTextBox) {
		this.searchTextBox = driver.findElement(searchTextBox);;
	}
	public WebElement getSearchIcon() {
		return searchIcon;
	}
	public void setSearchIcon(By searchIcon) {
		this.searchIcon = driver.findElement(searchIcon);;
	}
	
	/*public LoginPage clickSignInLink() throws Exception
	{
		setSignInLink(getLocatory("xpath://a[@title='Log in to your customer account']"));
		getSignInLink().click();
		*//**
		 * @throws Exception 
		 * 
		 * 
		 * 
		 * 
		 * **//*
		return new LoginPage(this.driver);
		
	}
	*/
	
	public TwitterPage twitterIconClick() throws Exception {
		twitterSocialIcon.click();
		return new TwitterPage(this.driver);
		
} 
	
	
	
	
	
	
	

}
