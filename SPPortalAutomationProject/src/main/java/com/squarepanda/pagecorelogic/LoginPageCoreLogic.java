package com.squarepanda.pagecorelogic;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.squarepanda.pagelocators.LoginPageLocators;
import com.squarepanda.pagelocators.PlayersPageLocators;
import com.squarepanda.pagelocators.RegistrationPageLocators;
import com.squarepanda.seleniumUtility.GenericMethods;

public class LoginPageCoreLogic {
	
	LoginPageLocators loginPageLocators;
	PlayersPageLocators playersPageLocators;
	RegistrationPageLocators registrationPageLocators;
	GenericMethods generics = new GenericMethods();
	public LoginPageCoreLogic() {
		loginPageLocators = new LoginPageLocators();
		playersPageLocators = new PlayersPageLocators();
		registrationPageLocators = new RegistrationPageLocators();
		PageFactory.initElements(loginPageLocators.getDriver(), loginPageLocators);
		PageFactory.initElements(playersPageLocators.getDriver(), playersPageLocators);
		PageFactory.initElements(loginPageLocators.getDriver(), registrationPageLocators);
	}
	
	public void verifyLoginPage() {
		loginPageLocators.verifyElementVisible(loginPageLocators.emailTextBox);
		loginPageLocators.verifyElementVisible(loginPageLocators.pswTextBox);
		loginPageLocators.verifyElementVisible(loginPageLocators.loginButton);
		loginPageLocators.verifyElementVisible(loginPageLocators.forgotPasswordLink);
		loginPageLocators.verifyElementVisible(loginPageLocators.resendActMailLink);
		loginPageLocators.verifyElementVisible(loginPageLocators.signUpLink);
		loginPageLocators.verifyElementVisible(loginPageLocators.loginAnotherWayLink);
		loginPageLocators.assertValuesEqual(loginPageTitle(), "Square Panda - Sign In");
		loginPageLocators.assertValuesEqual(popupTitle(), "Log in");  
		}
	public void performlogin(String username , String password) {
		loginPageLocators.sendKeys(username, loginPageLocators.emailTextBox);
		loginPageLocators.sendKeys(password,loginPageLocators.pswTextBox);
		loginPageLocators.clickElement(loginPageLocators.loginButton);
//		acceptPrivacyPolicyTermsConditions();
		
		}
	
	public void acceptPrivacyPolicyTermsConditions() {
		if (privacyPopupTitle().equals("Privacy policy")) {
			loginPageLocators.clickElement(loginPageLocators.privacySaveButton);
			loginPageLocators.waitFor(30);
		}
		if (privacyPopupTitle().equals("Terms of service")) {
			   loginPageLocators.clickElement(loginPageLocators.privacySaveButton);
			   loginPageLocators.waitFor(30);
		 }
		if(loginPageLocators.getText(loginPageLocators.privacySaveButton).equals("Back to log in")) {
			loginPageLocators.clickElement(loginPageLocators.privacySaveButton);
		}
	}
	public String privacyPopupTitle() {
		return loginPageLocators.getText(loginPageLocators.privacyPopup);
	}
	public String loginPageTitle() {
		return loginPageLocators.getPageTitle();
		
	}
	
	public void performLogout() {
		if(playersPageLocators.getPageTitle().equals("Panda Parent")) {
		    playersPageLocators.clickElement(playersPageLocators.logoutDropDown);
		    playersPageLocators.clickElement(playersPageLocators.logout);
		}
		if(playersPageLocators.getPageTitle().equals("Square Panda - Sign In")) {
			if(loginPageLocators.isElementPresent(loginPageLocators.popupHeader)==true) {
				while(popupHeader().equals("Forgot password")||popupHeader().equals("Recover account"))
				{
				loginPageLocators.clickElement(loginPageLocators.backToLogin);
	            break;
				}
				
			} else {
				while(popupTitle().equals("Sign up")||popupTitle().equals("Redirect")||popupTitle().equals("Contact us"))
				{
				loginPageLocators.clickElement(loginPageLocators.backArrow);
	
				}
			}
		}
	}
	
	public String selectedLanguage() {
        Select language = new Select(loginPageLocators.languageDropDown); 
		return	language.getFirstSelectedOption().getText();
        }
	
    public void verifySelectedLanguage(String language) {
    	loginPageLocators.assertValuesEqual(selectedLanguage(), language);
    	}
    public void selectLanguage(String language) {
        Select languageDropDown = new Select(loginPageLocators.languageDropDown); 
        languageDropDown.selectByVisibleText(language);
			playersPageLocators.waitFor(5);
    }	
    public void verifyErrorNotificationMessage(String message) {
    	playersPageLocators.assertValuesEqual(errorNotificationMessage(), message);
    }
    public void verifySuccessNotificationMessage(String message) {
    	playersPageLocators.assertValuesEqual(successNotificationMessage(), message);
    }
    public String errorNotificationMessage() {
    	loginPageLocators.waitForElement(30,loginPageLocators.errorNotification);
    	return loginPageLocators.errorNotification.getText();
    	
    }
    public String successNotificationMessage() {
    	loginPageLocators.waitForElement(30,loginPageLocators.successNotification);
    	return loginPageLocators.successNotification.getText();
    	
    }
    public String popupTitle() {
    	return loginPageLocators.getText(loginPageLocators.popupTitle);	
    }
    public String popupHeader() {
    	return loginPageLocators.getText(loginPageLocators.popupHeader);	
    }
    public void verifySchoolButtonAndContactUsPopup() {
    	loginPageLocators.verifyElementVisible(loginPageLocators.schoolButton);
    	loginPageLocators.clickElement(loginPageLocators.schoolButton);
    	loginPageLocators.assertValuesEqual(popupTitle(), "Contact us");
    	loginPageLocators.verifyElementVisible(loginPageLocators.firstName);
    	loginPageLocators.verifyElementVisible(loginPageLocators.lastName);
    	loginPageLocators.verifyElementVisible(loginPageLocators.email);
    	loginPageLocators.verifyElementVisible(loginPageLocators.school);
    	loginPageLocators.verifyElementVisible(loginPageLocators.message);
     }
    public void submitUserInformation() {
    	loginPageLocators.sendKeys("naresh", loginPageLocators.firstName);
    	loginPageLocators.sendKeys("chowdary", loginPageLocators.lastName);
    	loginPageLocators.sendKeys("naresh@squarepanda.com", loginPageLocators.email);
    	loginPageLocators.sendKeys("Conossa school", loginPageLocators.school);
    	loginPageLocators.sendKeys("random message", loginPageLocators.message);
    	loginPageLocators.clickElement(loginPageLocators.submitButton);
    	loginPageLocators.waitForElement(10, loginPageLocators.backArrow);
    	loginPageLocators.clickElement(loginPageLocators.backArrow);
    }
    public void selectRegion(String region) {
    	loginPageLocators.clickElement(loginPageLocators.regionDropdown);
    	Select regionDropDown = new Select(loginPageLocators.regionDropdown);
    	regionDropDown.selectByVisibleText(region);
    }
    public void verifyRegion(String url) {
    	String actualUrl = loginPageLocators.getDriver().getCurrentUrl();
    	System.out.println(actualUrl);
    	loginPageLocators.assertValuesEqual(actualUrl, url, "user is not redirected to"+url);
    	
    }

}
