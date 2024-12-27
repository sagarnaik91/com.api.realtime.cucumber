package com.api.cucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/cucumberFeatureFiles"},glue = {"com.api.stepDefinition"},plugin = {"html:target/cucumber-reports/cucumber-html-report.html"},tags = {"@stripe"})
public class RunCuke extends AbstractTestNGCucumberTests {
}
