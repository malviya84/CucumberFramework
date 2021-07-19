package com.persistent.StepDef;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import browserDriverConfiguration.DriverManagerFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import fileReader.QAEnvironmentReader;

public class Hooks {
	private WebDriver driver;
	@Before("@EnvironmentSetup")
	public void beforeFeature() {
		QAEnvironmentReader.getInstanceOfEnviornmentList();
	}

	@After("@CloseBroser")
	public void afterFeature() {
		System.out.println("Hook afterFeaturemethod");
		this.driver= DriverManagerFactory.getManager(QAEnvironmentReader.getInstanceOfEnviornmentList().get(0).getBrowserName()).getDriver();
		driver.close();
	}
	
	/*@After
	public void closeBrowser()
	{
		driver.close();
	}
	*/
	//@Before("@closeBroser")
		@After(order=1)
		public void afterFeature(Scenario scenario ) {
			
			driver = DriverManagerFactory
					.getManager(QAEnvironmentReader.getInstanceOfEnviornmentList().get(0).getBrowserName()).getDriver();
		//	DriverManagerFactory.getManager(QAEnvironmentReader.getInstanceOfEnviornmentList().get(0).getBrowserName()).closeDriver();
		
			if (scenario.isFailed()) {
				 String screenshotName = scenario.getName().replaceAll(" ", "_");
				 try {
				 //This takes a screenshot from the driver at save it to the specified location
				 File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 
				 //Building up the destination path for the screenshot to save
				 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				 
				// File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/" + screenshotName + ".png");

				 //Copy taken screenshot from source location to destination location
				// FileUtils.copy(sourcePath, destinationPath); 
				 
				 FileUtils.copyFile(sourcePath, destinationPath);
				 
				 //This attach the specified screenshot to the test
				 Reporter.addScreenCaptureFromPath(destinationPath.toString());
				 
	
				 Reporter.addScreenCaptureFromPath( System.getProperty("user.dir")+"/target/cucumber-reports/"+screenshotName+".png");
				 Reporter.addScreenCaptureFromPath("./screenshots/"+screenshotName+".png");
				 } catch (IOException e) {
				 } 
				 }
		
		}

		/*@After(order=0)
		public void tearDown() {
			DriverManagerFactory.getManager(QAEnvironmentReader.getInstanceOfEnviornmentList().get(0).getBrowserName()).closeDriver();
		}*/


}
