package com.persistent.webPages.runner;

import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.*;
//import com.vimalselvam.cucumber.listener.*;

@RunWith(Cucumber.class)
// @CucumberOptions(features="src/test/resources",glue="com.persistent.StepDef",plugin
// = {"html:target/cucumber-html-report",
// "json:target/cucumber-json-report.json" })
// ~@Purchase,~@MyAccount,@login,~@SocialNetworkin
@CucumberOptions(features = "src/test/resources", glue = "com.persistent.StepDef", plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, tags = {
				"@Purchase,@MyAccount,@login,@SocialNetworking" }, monochrome = true)
public class RunnerTest {

	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(System.getProperty("user.dir") + "\\configs\\extent-config.xml");
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Mac OSX");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}

}
