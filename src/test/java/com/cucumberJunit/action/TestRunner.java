package com.cucumberJunit.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;










import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/FeatureFile", tags={"@ScenarioTablemutiplecolumnWithoutColumn"},format = {"pretty","html:target/cucumber-html-report", "json:target/cucumber.json","junit:target/cucumber.xml","usage:target/cucumber-usage.json"}, glue = {"com.cucumberJunit"})

public class TestRunner {

	@BeforeClass
	public static void beforeClass() throws Throwable{
		System.out.println("before class");
		if(System.getProperty("Browser")==null){
	    System.setProperty("Browser", "fireFox");
		}
		if(System.getProperty("platform")==null){
			System.setProperty("platform", "gemini");
				}	
		
	}
	@AfterClass
	public static void afterclass() throws Exception{
		System.out.println("after class");
	}
}
