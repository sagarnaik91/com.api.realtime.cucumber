package com.api.cucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/cucumberFeatureFiles/StripeCreateCustomer.feature"},glue = {"com.api.stepDefinition"},plugin = {"html:target/cucumber-reports/cucumber-html-report.html"},tags = {"@outTest"})
public class RunCuke extends AbstractTestNGCucumberTests {
}
