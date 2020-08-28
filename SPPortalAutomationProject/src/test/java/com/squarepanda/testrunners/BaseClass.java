package com.squarepanda.testrunners;

import org.openqa.selenium.WebDriver;
import com.squarepanda.generalUtility.LoadProperties;
import com.squarepanda.pagecorelogic.ForgotPasswordPageCoreLogic;
import com.squarepanda.pagecorelogic.LoginPageCoreLogic;
import com.squarepanda.pagecorelogic.PlayersPageCoreLogic;
import com.squarepanda.pagecorelogic.RegistrationPageCoreLogic;
import com.squarepanda.seleniumUtility.SeleniumDriver;

public class BaseClass {
	
	public static WebDriver driver = null;
	public static LoginPageCoreLogic loginPageCoreLogic;
	public static PlayersPageCoreLogic playersPageCoreLogic;
	public static ForgotPasswordPageCoreLogic forgotPasswordPageCoreLogic;
	public static RegistrationPageCoreLogic registrationPageCoreLogic;
	public void setup() {
		SeleniumDriver.openPage(LoadProperties.getProjectProperities("url"));
		instantiateHelpers();
		}
		
	
	public void instantiateHelpers() {
		
		loginPageCoreLogic=	new LoginPageCoreLogic();
		playersPageCoreLogic= new PlayersPageCoreLogic();
		forgotPasswordPageCoreLogic= new ForgotPasswordPageCoreLogic();
		registrationPageCoreLogic = new RegistrationPageCoreLogic();
	
	}
	

	public void tearDown() {
		SeleniumDriver.tearDown();
	}

}
