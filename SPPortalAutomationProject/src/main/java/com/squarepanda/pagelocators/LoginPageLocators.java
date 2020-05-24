
package com.squarepanda.pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.squarepanda.seleniumUtility.GenericMethods;

public class LoginPageLocators  extends GenericMethods{
	@FindBy(how=How.ID,using="email")
	public WebElement emailTextBox;
	
	@FindBy(how=How.XPATH,using="//input[@type='password']")
	public WebElement pswTextBox;
	
	@FindBy(how=How.ID,using="loginButton")
	public WebElement loginButton;
	
	@FindBy(how=How.ID,using="forgotPassword")
	public WebElement forgotPasswordLink;
	
	@FindBy(how=How.ID,using="resendLink")
	public WebElement resendActMailLink;
	
	@FindBy(how=How.XPATH,using="//button[@class='sqpButton primary full teacher']")
	public WebElement privacySaveButton;
	
	
	
} 
