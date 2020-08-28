package com.squarepanda.pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.squarepanda.seleniumUtility.GenericMethods;

public class ForgotPasswordPageLocators extends GenericMethods {
	
	@FindBy(how=How.ID,using="forgotPassword")
	public WebElement forgotPasswordLink;
	@FindBy(how=How.XPATH,using="//h1[@class='authHeader']")
	public WebElement forgotPasswordPopupHeader;
	@FindBy(how=How.XPATH,using="//p[@class='textLink']")
	public WebElement backToLogin;
	@FindBy(how=How.ID,using="emailAddress")
	public WebElement forgotPswEmail;
	@FindBy(how=How.XPATH,using="//button[@class='sqpButton primary full teacher']")
	public WebElement requestPswButton;


}
