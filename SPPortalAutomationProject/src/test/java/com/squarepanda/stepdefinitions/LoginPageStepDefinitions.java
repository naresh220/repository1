package com.squarepanda.stepdefinitions;

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
        	loginPageCoreLogic.performLogout();
		
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^Verify the selected language is (.+)$")
	public void verify_the_selected_language_is(String language) throws Throwable {
		try {
			loginPageCoreLogic.verifySelectedLanguage(language);
			loginPageCoreLogic.selectLanguage("English");
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	@Then("^User selects the (.+) language$")
	public void User_selects_language(String language)throws Throwable {
		try {
			loginPageCoreLogic.selectLanguage(language);
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}
	}
	@Then("^Verify login page$")
	public void verify_login_page() throws Throwable {
		try {
			loginPageCoreLogic.verifyLoginPage();
			
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
    @When("^User performs login with (.+) and (.+)$")
	public void user_performs_login_with(String username, String password)throws Throwable {
	   try {
			loginPageCoreLogic.performlogin(username,password);
	   } catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
    }
	@Then("^Verify user gets error notification (.+)$")
	public void verify_user_gets_error_message(String notification) throws Throwable {
		try {
			loginPageCoreLogic.verifyErrorNotificationMessage(notification);
			
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^Verify user gets success notification (.+)$")
	public void verify_user_gets_success_message(String notification) throws Throwable {
		try {
			loginPageCoreLogic.verifySuccessNotificationMessage(notification);			
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^Verify the class button and contact us popup$")
	public void verify_the_class_button_and_contact_us_popup() throws Throwable {
		try {
			loginPageCoreLogic.verifySchoolButtonAndContactUsPopup();
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^User provides the information to contact$")
	public void user_provides_the_information_to_contact() throws Throwable {
		try {
			loginPageCoreLogic.submitUserInformation();
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^User selects the region is (.+)$")
	public void User_selects_the_region_is(String region) throws Throwable {
		try {
			loginPageCoreLogic.selectRegion(region);
			} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^Verify the selected region (.+)$")
	public void verify_the_selected_region(String url) throws Throwable {
		try {
			loginPageCoreLogic.verifyRegion(url);
			loginPageCoreLogic.selectRegion("United States / Global");
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	@Then("^User accepts privacy policy and terms and conditions$")
	public void accept_privacypolicy_termsand_conditions() throws Throwable {
		try {
			loginPageCoreLogic.acceptPrivacyPolicyTermsConditions();
		} catch (Exception e) {
			ErrorReporter.reportError(e);
		}  
	}
	
	
}

