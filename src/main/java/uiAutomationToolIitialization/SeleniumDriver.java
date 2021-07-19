package uiAutomationToolIitialization;

import org.openqa.selenium.WebDriver;

public class SeleniumDriver implements UIDriver{
	
	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public ElementFactory getElementFactory(String toolType) {
		// TODO Auto-generated method stub
		return (ElementFactory) new SeleniumElementFactory();
	}

	
}
