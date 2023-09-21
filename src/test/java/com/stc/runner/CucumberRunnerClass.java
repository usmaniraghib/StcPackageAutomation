package com.stc.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"./features"},
    glue = {"com.stc.stepdefination"},
    monochrome=true,
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class CucumberRunnerClass extends AbstractTestNGCucumberTests {

}
