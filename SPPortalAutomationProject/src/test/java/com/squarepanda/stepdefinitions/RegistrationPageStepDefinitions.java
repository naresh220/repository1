package com.squarepanda.stepdefinitions;

import com.squarepanda.reporting.ErrorReporter;
import com.squarepanda.testrunners.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationPageStepDefinitions extends BaseClass{
	@When("^User redirects to the signup popup of (.+) region$")
	public void user_redirects_to_the_signup_popup(String countryregion) throws Throwable {
		try {
			registrationPageCoreLogic.redirectsToSignUpPopup(countryregion);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		} 
	}
	@Then("^Verify the selected country region is (.+)$")
	public void verify_the_selected_country_region_is(String countryregion) throws Throwable {
		try {
		
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	
	@When("^User is on country selection popup$")
	public void user_is_on_country_selection_popup() throws Throwable {
		try {
			registrationPageCoreLogic.getCountrySelectionPopup();
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		} 
		
	}
	@Then("^User selects the country region of (.+)$")
	public void user_selects_the_country_region_of(String countryregion) throws Throwable {
		try {
			registrationPageCoreLogic.selectCountry(countryregion);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^Verify all elements on signup popup$")
	public void verify_all_elements_on_signup_popup() throws Throwable {
		try {
			registrationPageCoreLogic.verifySignUpPopup();
		
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^User creates parent account with country of (.+)$")
	public void user_creates_parent_account_with_country_of(String country) throws Throwable {
		try {
        registrationPageCoreLogic.createParentAccount(country);
		
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}

}
