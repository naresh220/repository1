package com.squarepanda.pagelocators;

import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import com.squarepanda.seleniumUtility.GenericMethods;



public class PlayersPageLocators extends GenericMethods {
	
//	@FindBy(how=How.ID,using="email")
//	public WebElement emailTextBox;
	@FindBy(how=How.XPATH,using="//i[@class='sqp-caret-down dropMenu']")
	public WebElement logoutDropDown;
	@FindBy(how=How.XPATH,using="//p[@class='menuItem']")
	public WebElement logout;
	@FindBy(how=How.XPATH,using="//sqp-button[@class='addPlayer']")
	public WebElement addPlayerButton;
	@FindBys(@FindBy(how=How.XPATH,using="//div[@class='studentName']"))
	public List<WebElement>listOfPlayerNames;

	
	public int getPlayersCount() {
	
		return listOfPlayerNames.size();
	}
	@SuppressWarnings("unchecked")
	public JSONObject getPlayersNames() {
		JSONObject playerNames = new JSONObject();
	
		List<WebElement> names = listOfPlayerNames;
		for (int i = 0; i < names.size(); i++) {
			playerNames.put("player" + (i + 1), names.get(i).getText().toString().trim());
		}
		System.out.println("playerNames ::" + playerNames);
		return playerNames;
	}

}
