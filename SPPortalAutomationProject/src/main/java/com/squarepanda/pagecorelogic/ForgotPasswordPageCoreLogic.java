package com.squarepanda.pagecorelogic;

import org.openqa.selenium.support.PageFactory;

import com.squarepanda.pagelocators.ForgotPasswordPageLocators;

public class ForgotPasswordPageCoreLogic {
	ForgotPasswordPageLocators forgotPasswordPageLocators;
	
	public ForgotPasswordPageCoreLogic() {
		forgotPasswordPageLocators = new ForgotPasswordPageLocators();
		PageFactory.initElements(forgotPasswordPageLocators.getDriver(), forgotPasswordPageLocators);
	}
	public void test() {
		forgotPasswordPageLocators.clickElement(forgotPasswordPageLocators.forgotPasswordLink);
		System.out.println(forgotPasswordPageLocators.getText(forgotPasswordPageLocators.forgotPasswordPopup));
		
	}
}
