package com.uswebsite.stepdefinitions;

import com.squarepanda.reporting.ErrorReporter;
import com.squarepanda.testrunners.UsWebsiteBaseClass;

import cucumber.api.java.en.Given;

public class WebsiteStepDefinitions extends UsWebsiteBaseClass {
	
	@Given("^User click on schools link$")
	public void user_click_on_schools_link() throws Throwable {
		try {
			  websiteCoreLogic.clickSchool();
			
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
}
