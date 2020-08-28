package com.squarepanda.pagecorelogic;

import org.openqa.selenium.support.PageFactory;

import com.squarepanda.pagelocators.ForgotPasswordPageLocators;

public class ForgotPasswordPageCoreLogic {
	ForgotPasswordPageLocators forgotPasswordPageLocators;
	
	public ForgotPasswordPageCoreLogic() {
		forgotPasswordPageLocators = new ForgotPasswordPageLocators();
		PageFactory.initElements(forgotPasswordPageLocators.getDriver(), forgotPasswordPageLocators);
	}
	public void getForgotPasswordPage() {
		forgotPasswordPageLocators.clickElement(forgotPasswordPageLocators.forgotPasswordLink);
	}
	public void verifyforgotPasswordPage() {
		forgotPasswordPageLocators.assertValuesEqual(popupHeader(),"Forgot password");
		forgotPasswordPageLocators.verifyElementVisible(forgotPasswordPageLocators.forgotPswEmail);
		forgotPasswordPageLocators.verifyElementVisible(forgotPasswordPageLocators.requestPswButton);
		forgotPasswordPageLocators.verifyElementVisible(forgotPasswordPageLocators.backToLogin);
		
	}
	public String popupHeader() {
    	return forgotPasswordPageLocators.getText(forgotPasswordPageLocators.forgotPasswordPopupHeader);	
    }
	public void backToLogin() {
	
		forgotPasswordPageLocators.clickElement(forgotPasswordPageLocators.backToLogin);
		
	}
	public void requestPassword(String email) {
		getForgotPasswordPage();
		forgotPasswordPageLocators.sendKeys(email, forgotPasswordPageLocators.forgotPswEmail);
		forgotPasswordPageLocators.verifyElementVisible(forgotPasswordPageLocators.requestPswButton);
		forgotPasswordPageLocators.clickElement(forgotPasswordPageLocators.requestPswButton);
		
	}
}
