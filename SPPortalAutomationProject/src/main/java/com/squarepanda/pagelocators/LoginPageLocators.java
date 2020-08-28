
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
	@FindBy(how=How.ID,using="registerLink")
	public WebElement signUpLink;
	@FindBy(how=How.XPATH,using="//p[@class='textLink']")
	public WebElement backToLogin;
	@FindBy(how=How.ID,using="resendLink")
	public WebElement resendActMailLink;
	@FindBy(how=How.ID,using="loginAnotherWayLink")
	public WebElement loginAnotherWayLink;
	@FindBy(how=How.ID,using="submit")
	public WebElement submitButton;
	@FindBy(how=How.XPATH,using="//button[@class='sqpButton primary full teacher']")
	public WebElement privacySaveButton;
	@FindBy(how = How.XPATH, using = "//select[@formcontrolname='locale']")
	public WebElement languageDropDown;
	@FindBy(how = How.XPATH, using = "//p[@class='notificationMessage fail']//span[1]")
	public WebElement errorNotification;
	@FindBy(how = How.XPATH, using = "//p[@class='notificationMessage success']")
	public WebElement successNotification;
	@FindBy(how = How.XPATH, using = "//button[@class='sqpButton primary teacher']")
	public WebElement schoolButton;
	@FindBy(how = How.XPATH, using = "//h1[@class='authTitle']")
	public WebElement popupTitle;
	@FindBy(how = How.XPATH, using = "//h1[@class='authHeader']")
	public WebElement popupHeader;
	@FindBy(how = How.XPATH, using = "//h1[@class='userTitle']")
	public WebElement privacyPopup;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='firstName']")
	public WebElement firstName;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='lastName']")
	public WebElement lastName;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='emailAddress']")
	public WebElement email;
	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname='message']")
	public WebElement message;
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='school']")
	public WebElement school;
	@FindBy(how = How.XPATH, using = "//i[@class='sqp-arrow-left']")
	public WebElement backArrow;
	@FindBy(how = How.XPATH, using = "//select[@formcontrolname='region']")
	public WebElement regionDropdown;
	
} 
