package com.squarepanda.pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.squarepanda.seleniumUtility.GenericMethods;

public class ResendActMailPageLocators extends GenericMethods{
	
	@FindBy(how=How.ID,using="resendLink")
	public WebElement resendActEmailLink;
	@FindBy(how=How.XPATH,using="//h1[@class='authHeader']")
	public WebElement resendActMailPopup;
	@FindBy(how=How.XPATH,using="//p[@class='textLink']")
	public WebElement backToLogin;
	@FindBy(how=How.ID,using="//input[@class='sqpInputBox ng-untouched ng-pristine ng-invalid']")
	public WebElement resendEmailTextBox;
	@FindBy(how=How.XPATH,using="//h1[@class='sqpButton primary full teacher']")
	public WebElement recoverAccountButton;

	
	

}
