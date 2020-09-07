package com.squarepanda.stepdefinitions;

import com.squarepanda.reporting.ErrorReporter;
import com.squarepanda.testrunners.BaseClass;

import cucumber.api.java.en.Then;

public class ResendActivationMailPageStepDefinitions extends BaseClass {
	
	@Then("^User redirects to resend activation email page$")
	public void user_redirects_to_resend_activation_email_page()throws Throwable {
	   try {
		  resendActivationMailPageCoreLogic.getResendActMailPage();
		
	   } catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
    }
	
	@Then("^Verify resend activation email page$")
	public void verify_resend_activation_email_page()throws Throwable {
	   try {
		   resendActivationMailPageCoreLogic.verifyResendActMailPage();
	   } catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
    }
	@Then("^User clicks on back to login link on resend activation email$")
	public void user_clicks_on_back_to_login_link() throws Throwable {
		try {
			resendActivationMailPageCoreLogic.backToLogin();
			
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^User recovers account (.+)$")
	public void user_recovers_account(String email) throws Throwable {
		try {
			resendActivationMailPageCoreLogic.recoverAccount(email);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}


}
