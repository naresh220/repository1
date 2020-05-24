package com.squarepanda.stepdefinitions;

import com.squarepanda.pagecorelogic.ForgotPasswordPageCoreLogic;
import com.squarepanda.reporting.ErrorReporter;
import com.squarepanda.testrunners.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



 
public class LoginPageStepDefinitions extends BaseClass {
	public static Scenario scenario;
	@Before
	public void readScenario(Scenario scenario) throws Exception {
		LoginPageStepDefinitions.scenario = scenario;
		System.out.println(
				"*********************** Executing scenario:: " + scenario.getName() + " ***********************");
			}
	
	@Given("^User is on login page of website$")
	public void verify_user_is_on_login_page_of_website() throws Throwable {
		try {
//		loginPageCoreLogic.verifyLoginPage();
			System.out.println("uuieruyfiuby");
		
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^Verify default language is (.+)$")
	public void verify_default_language_is(String language) throws Throwable {
		try {
			System.out.println("uuieruyfiuby");
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}

	@Then("^Verify login page$")
	public void verify_login_page() throws Throwable {
		try {
//			forgotPasswordPageCoreLogic.test();
			System.out.println("uuieruyfiuby");
			
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	
	
	}

	@When("^User performs login with existing account that has players in the account with (.+) and (.+)$")
	public void user_performs_login_with_existing_account_that_has_players_in_the_account_with_naresh_squarepanda_com_and_squarepanda(String username, String password)throws Throwable {
	   try {
//			loginPageCoreLogic.performlogin(username,  password);
		   System.out.println("uuieruyfiuby");
			
	   } catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
		
	}
	
	
}

