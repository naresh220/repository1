package com.squarepanda.pagecorelogic;

import org.openqa.selenium.support.PageFactory;

import com.squarepanda.pagelocators.PlayersPageLocators;
import com.squarepanda.seleniumUtility.GenericMethods;
import com.squarepanda.seleniumUtility.SeleniumDriver;

public class PlayersPageCoreLogic {
	
	PlayersPageLocators playersPageLocators;
	GenericMethods generics = new GenericMethods();
	public PlayersPageCoreLogic() {
		playersPageLocators = new PlayersPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), playersPageLocators);
	}
	
	public String playersPageTitle() {
		return playersPageLocators.getPageTitle();
	}
	public void verifyPlayersPageTitle() {
		playersPageLocators.waitFor(70);
		System.out.println(playersPageTitle());
		playersPageLocators.assertValuesEqual(playersPageTitle(), "Panda Parent", "Login Failed");
		System.out.println(playersPageLocators.getPlayersCount());
		System.out.println(playersPageLocators.getPlayersNames());
		
	}

}
