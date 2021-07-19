package fileReader;

import org.openqa.selenium.remote.BrowserType;

import enums.BrowserDriver;

public class QAEnvironment {
	
	String browserName;
	String browserPath;
	Boolean windowmaximize;
	String URL;
	Long implecitWait;
	String environment;
	
	public String getEnvironment() {
		return environment;
		
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public BrowserDriver getBrowserName() {
		if(browserName.equalsIgnoreCase("Chrom"))
		       return BrowserDriver.CHROME;
		else if(browserName.equalsIgnoreCase("firefox"))
		       return BrowserDriver.FIREFOX;
		else if(browserName.equalsIgnoreCase("ie"))
		       return BrowserDriver.INTERNETEXPLORER;
		
		return BrowserDriver.CHROME;
	}
	public void setBrowwserName(String browwserName) {
		this.browserName = browwserName;
	}
	public String getBrowserPath() {
		return browserPath;
	}
	public void setBrowserPath(String browserPath) {
		this.browserPath = browserPath;
	}
	public Boolean getWindowmaximize() {
		return windowmaximize;
	}
	public void setWindowmaximize(Boolean windowmaximize) {
		this.windowmaximize = windowmaximize;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public Long getImplecitWait() {
		return implecitWait;
	}
	public void setImplecitWait(Long implecitWait) {
		this.implecitWait = implecitWait;
	}
    
	
	


}
