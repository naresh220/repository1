package com.squarepanda.pagecorelogic;

import org.openqa.selenium.support.PageFactory;
import com.squarepanda.pagelocators.ResendActivationMailPageLocators;

public class ResendActivationMailPageCoreLogic {
	
	ResendActivationMailPageLocators resendActivationMailPageLocators;
	
	public ResendActivationMailPageCoreLogic() {
		resendActivationMailPageLocators = new ResendActivationMailPageLocators();
		PageFactory.initElements(resendActivationMailPageLocators.getDriver(), resendActivationMailPageLocators);
	}
	public void getResendActMailPage() {
		resendActivationMailPageLocators.clickElement(resendActivationMailPageLocators.resendActEmailLink);
	}
	public void verifyResendActMailPage() {
		resendActivationMailPageLocators.assertValuesEqual(popupHeader(),"Re-send activation email");
		resendActivationMailPageLocators.verifyElementVisible(resendActivationMailPageLocators.resendEmailTextBox);
		resendActivationMailPageLocators.verifyElementVisible(resendActivationMailPageLocators.recoverAccountButton);
		resendActivationMailPageLocators.verifyElementVisible(resendActivationMailPageLocators.backToLogin);
		
	}
	public String popupHeader() {
    	return resendActivationMailPageLocators.getText(resendActivationMailPageLocators.resendActMailPopupHeader);	
    }
	public void backToLogin() {
	
		resendActivationMailPageLocators.clickElement(resendActivationMailPageLocators.backToLogin);
		
	}
	public void recoverAccount(String email) {
		getResendActMailPage();
		resendActivationMailPageLocators.sendKeys(email, resendActivationMailPageLocators.resendEmailTextBox);
		resendActivationMailPageLocators.verifyElementVisible(resendActivationMailPageLocators.recoverAccountButton);
		resendActivationMailPageLocators.clickElement(resendActivationMailPageLocators.recoverAccountButton);
		
	}

}
