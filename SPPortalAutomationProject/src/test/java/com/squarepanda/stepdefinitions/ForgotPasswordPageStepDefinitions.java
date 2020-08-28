package com.squarepanda.stepdefinitions;

import com.squarepanda.reporting.ErrorReporter;
import com.squarepanda.testrunners.BaseClass;

import cucumber.api.java.en.Then;

public class ForgotPasswordPageStepDefinitions extends BaseClass{
	
	@Then("^User redirects to forgot password page$")
	public void user_redirects_to_forgot_password_page()throws Throwable {
	   try {
		   forgotPasswordPageCoreLogic.getForgotPasswordPage();
		
	   } catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
    }
	
	@Then("^Verify Forgot password page$")
	public void verify_Forgot_password_page()throws Throwable {
	   try {
		   forgotPasswordPageCoreLogic.verifyforgotPasswordPage();
	   } catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
    }
	@Then("^User clicks on back to login link$")
	public void user_clicks_on_back_to_login_link() throws Throwable {
		try {
			forgotPasswordPageCoreLogic.backToLogin();
			
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^User requests password for (.+)$")
	public void user_requests_password_for_email(String email) throws Throwable {
		try {
			forgotPasswordPageCoreLogic.requestPassword(email);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}

}
