package com.squarepanda.pagecorelogic;

import org.openqa.selenium.support.PageFactory;

import com.squarepanda.pagelocators.ForgotPasswordPageLocators;
import com.squarepanda.pagelocators.LoginPageLocators;
import com.squarepanda.pagelocators.PlayersPageLocators;
import com.squarepanda.pagelocators.ResendActMailPageLocators;
import com.squarepanda.seleniumUtility.GenericMethods;

public class LoginPageCoreLogic {
	
	LoginPageLocators loginPageLocators;
	PlayersPageLocators playersPageLocators;;
	ForgotPasswordPageLocators forgotPasswordPageLocators;
	ResendActMailPageLocators resendActMailPageLocators;
	GenericMethods generics = new GenericMethods();
	public LoginPageCoreLogic() {
		loginPageLocators = new LoginPageLocators();
		playersPageLocators = new PlayersPageLocators();
		forgotPasswordPageLocators=new ForgotPasswordPageLocators();
		resendActMailPageLocators=new ResendActMailPageLocators();
		PageFactory.initElements(loginPageLocators.getDriver(), loginPageLocators);
		PageFactory.initElements(playersPageLocators.getDriver(), playersPageLocators);
		PageFactory.initElements(forgotPasswordPageLocators.getDriver(), forgotPasswordPageLocators);
	}
	
	public void verifyLoginPage() {
		loginPageLocators.verifyElementVisible(loginPageLocators.emailTextBox);
		loginPageLocators.verifyElementVisible(loginPageLocators.pswTextBox);
		loginPageLocators.verifyElementVisible(loginPageLocators.loginButton);
		forgotPasswordPageLocators.verifyElementVisible(forgotPasswordPageLocators.forgotPasswordLink);
		loginPageLocators.assertValuesEqual(loginPageTitle(), "Square Panda - Sign In");
		}
	public void performlogin(String username , String password) {
		loginPageLocators.sendKeys(username, loginPageLocators.emailTextBox);
		loginPageLocators.sendKeys(password,loginPageLocators.pswTextBox);
		loginPageLocators.clickElement(loginPageLocators.loginButton);
		acceptPrivacyPolicyTermsConditions();
		
		}
	
	public void acceptPrivacyPolicyTermsConditions() {
		if (loginPageTitle().equals("Square Panda - Sign In"))
		{
			loginPageLocators.clickElement(loginPageLocators.privacySaveButton);
			if (loginPageTitle().equals("Square Panda - Sign In")) 
			{
			   loginPageLocators.clickElement(loginPageLocators.privacySaveButton);
			  }
		}
	}
	public String loginPageTitle() {
		return loginPageLocators.getPageTitle();
		
	}
	
	public void performLogout() {
		if(forgotPasswordPageLocators.isElementVisible(forgotPasswordPageLocators.forgotPasswordPopup)==true) {
			forgotPasswordPageLocators.clickElement(forgotPasswordPageLocators.backToLogin);
		}
		playersPageLocators.waitFor(50);
		playersPageLocators.clickElement(playersPageLocators.logoutDropDown);
		playersPageLocators.clickElement(playersPageLocators.logout);
	}
	

}
