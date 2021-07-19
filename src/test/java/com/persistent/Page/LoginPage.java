package com.persistent.Page;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	WebDriver driver;
	@FindBy(how = How.ID, using = "SubmitLogin")
	WebElement signInBttn;
	@FindBy(how = How.ID, using = "email")
	WebElement emailAddress;
	@FindBy(how = How.ID, using = "passwd")
	WebElement password;

	public LoginPage(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		waitForPageLoaded(this.driver);
		PageFactory.initElements(driver, this);
		waitForPageLoaded(this.driver);
		/*
		 * if(signInBttn.isDisplayed()&&emailAddress.isDisplayed()) throw new
		 * Exception("Possibly Login page is not displayed completly");
		 */

	}

	public Boolean isSignInBttnDisplaye() {
		return signInBttn.isDisplayed();
	}

	/*
	 * private boolean isLoginPageDisplayed() { if() }
	 */

	/*
	 * public WebElement getSignInBttn() { return signInBttn; }
	 * 
	 * public void setSignInBttn(By signInBttn) { this.signInBttn =
	 * driver.findElement(signInBttn); }
	 * 
	 * public WebElement getEmailAddress() { return emailAddress; }
	 * 
	 * public void setEmailAddress(By emailAddress) { this.emailAddress =
	 * driver.findElement(emailAddress); }
	 * 
	 * public WebElement getPassword() { return password; }
	 * 
	 * public void setPassword(By password) { this.password =
	 * driver.findElement(password); }
	 * 
	 * 
	 */

	/*
	 * public LoginPage performSignIn() {
	 * 
	 * putEmailAddress(); putPassword(); ClicksignInButton(); //add assert here.
	 * assert.assertEquals(True, actual);
	 * 
	 * 
	 * return new LoginPage(this.driver); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void ClicksignInButton() {
	 * setSignInBttn(getLocatory("xpath://button[@id = 'SubmitLogin']"));
	 * getSignInBttn().click();
	 * 
	 * }
	 * 
	 * public void putEmailAddress() {
	 * setEmailAddress(getLocatory("xpath://input[@id='email']"));
	 * getEmailAddress().sendKeys("abcd@efgh.com"); }
	 * 
	 * public void putPassword() {
	 * setPassword(getLocatory("xpath://input[@id=\"passwd\"]"));
	 * getPassword().sendKeys("123456789");;
	 * 
	 * }
	 */

	public void ClicksignInButton() {
		signInBttn.click();
	}

	public void putEmailAddress(String username) {
		emailAddress.clear();
		emailAddress.sendKeys(username);
	}

	public void putPassword(String password2) {
		password.clear();
		password.sendKeys(password2);

	}

	public MyAccountPage performSignIn(String username, String password2) throws Exception {

		putEmailAddress(username);
		putPassword(password2);
		ClicksignInButton();

		return new MyAccountPage(this.driver);
	}

}
