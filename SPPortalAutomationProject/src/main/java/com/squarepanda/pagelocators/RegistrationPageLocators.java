package com.squarepanda.pagelocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.squarepanda.seleniumUtility.GenericMethods;

public class RegistrationPageLocators extends GenericMethods{
	
	@FindBy(how=How.ID,using="registerLink")
	public WebElement signUpLink;
	@FindBy(how=How.XPATH,using="//select[@formcontrolname='country']")
	public WebElement countryDropDown;
	@FindBy(how=How.XPATH,using="//i[@class='sqp-arrow-left']")
	public WebElement backArrow;
	@FindBy(how=How.ID,using="nextButton")
	public WebElement nextButton;
	@FindBy(how=How.ID,using="okButton")
	public WebElement okButton;
	@FindBy(how=How.ID,using="register")
	public WebElement parentLink;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='firstName']")
	public WebElement firstName;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='lastName']")
	public WebElement lastName;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='emailAddress']")
	public WebElement emailAddress;
	@FindBy(how=How.XPATH,using="//input[@class='sqpInputBox']")
	public WebElement passWord;
	@FindBy(how=How.XPATH,using="//button[@class='sqpButton primary full teacher']")
	public WebElement createAccountButton;
	@FindBy(how=How.XPATH,using="//h1[@class='authTitle']")
	public WebElement popupTitle;

	
	

	
	

}
