package com.persistent.webPages.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",glue="com.persistent.StepDef",plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json", "junit:target/Cucumber.xml"})
public class RunnerClass {

		
}
