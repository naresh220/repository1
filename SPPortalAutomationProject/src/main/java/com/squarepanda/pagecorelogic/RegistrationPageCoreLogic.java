package com.squarepanda.pagecorelogic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.squarepanda.pagelocators.RegistrationPageLocators;
import com.squarepanda.seleniumUtility.GenericMethods;
import com.squarepanda.generalUtility.RandomNumberGenerator;
public class RegistrationPageCoreLogic {
	
	RegistrationPageLocators registrationPageLocators;
	GenericMethods generics = new GenericMethods();
	public RegistrationPageCoreLogic() {
		registrationPageLocators = new RegistrationPageLocators();
		PageFactory.initElements(registrationPageLocators.getDriver(), registrationPageLocators);
	}
	public String randomMail() {
	   return "naresh+"+RandomNumberGenerator.generateRandomAlphaNumericString(5)+"@squarepanda.com";
	}
	public void verifySignUpPopup() {
		registrationPageLocators.assertValuesEqual(getPopupTitle(),"Sign up");
		registrationPageLocators.verifyElementVisible(registrationPageLocators.firstName);
		registrationPageLocators.verifyElementVisible(registrationPageLocators.lastName);
		registrationPageLocators.verifyElementVisible(registrationPageLocators.emailAddress);
		registrationPageLocators.verifyElementVisible(registrationPageLocators.passWord);
		registrationPageLocators.verifyElementVisible(registrationPageLocators.createAccountButton);
	}
	public void createParentAccount(String country) {
		registrationPageLocators.sendKeys("naresh", registrationPageLocators.firstName);
		registrationPageLocators.sendKeys("chowdary", registrationPageLocators.lastName);
		registrationPageLocators.sendKeys(randomMail(), registrationPageLocators.emailAddress);
		registrationPageLocators.sendKeys("squarepanda", registrationPageLocators.passWord);
		selectCountry(country);
		javaScript();
		registrationPageLocators.waitFor(5);
		registrationPageLocators.clickElement(registrationPageLocators.createAccountButton);
		if(getPopupTitle().equals("Redirect")) {
			registrationPageLocators.clickElement(registrationPageLocators.okButton);
		}
	}
	public void javaScript() {
		 Actions actions = new Actions(registrationPageLocators.getDriver());
	      actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	}
	public void selectCountry(String country) {
		Select countryDropDown = new Select(registrationPageLocators.countryDropDown);
		countryDropDown.selectByVisibleText(country);
	}
	public String getPopupTitle() {
		return registrationPageLocators.getText(registrationPageLocators.popupTitle);
	}
	public void getCountrySelectionPopup() {
		registrationPageLocators.clickElement(registrationPageLocators.signUpLink);
	}
	public void redirectsToSignUpPopup(String countryregion) {
		if(getPopupTitle().equals("Log in"))
		{
		   getCountrySelectionPopup();
		}
		selectCountry(countryregion);
		registrationPageLocators.clickElement(registrationPageLocators.nextButton);
		if(countryregion.equals("India")||countryregion.equals("Mainland China")||countryregion.equals("Hong Kong, China")
				||countryregion.equals("Macau, China")||countryregion.equals("Taiwan, China")) {
			registrationPageLocators.clickElement(registrationPageLocators.okButton);	
		}else {
			registrationPageLocators.clickElement(registrationPageLocators.parentLink);
		}
		
	}
	
	

}
