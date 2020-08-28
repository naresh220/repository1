package com.squarepanda.testrunners;

import java.text.ParseException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.squarepanda.reporting.GenerateReport;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/ForgotPasswordPage.feature",
		glue = "com.squarepanda.stepdefinitions",
        plugin =  {
        		"pretty:target/executionReport/cucumber-pretty.txt",
        		"html:target/executionReport/cucumber.html",
        		"json:target/executionReport/cucumber.json"},
//        tags= {"@forgot"},
        monochrome=true,
        dryRun=false
        )

public class TestRunner1{
	private static String featureName = null;
	private static TestNGCucumberRunner testNGCucumberRunner;
	static BaseClass baseClass = new BaseClass();

	@BeforeClass
	public static void setUpClass() {
		baseClass.setup();
		}
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public static void feature(CucumberFeatureWrapper cucumberFeature) throws ParseException {
		 featureName = cucumberFeature.getCucumberFeature().getPath();
		System.out.println("*********************** Executing feature:: " + featureName + " ***********************");
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
//	@AfterClass(alwaysRun = true)
//	public void tearDownClass() throws Exception {
//		testNGCucumberRunner.finish();
//		GenerateReport.generateReport(com.squarepanda.generalUtility.LoadProperties.getProjectProperities("projectName"), "target/executionReport");
//		TestRailIntegrator.updateResultToTestRail("target/executionReport", "cucumber.json");
//
//	}
	@AfterTest(alwaysRun = true)
	public void terminateApp() {
		baseClass.tearDown();
	}

	public static String getFeatureName() {
		return featureName;
	}
	
	
}
	
	

	



