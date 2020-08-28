package com.squarepanda.pagecorelogic;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
		playersPageLocators.waitFor(10);
		playersPageLocators.assertValuesEqual(playersPageTitle(), "Panda Parent");
		}
	public void addPlayer(String playerName, String birthDate, String gender) {
		playersPageLocators.sendKeys(playerName,playersPageLocators.playerName);
		playersPageLocators.clickElement(playersPageLocators.selectBirthDate);
		playersPageLocators.scanThroughTheListOfElementsAndClick(playersPageLocators.selectDate,birthDate);
		selectGender(gender);
		playersPageLocators.clickElement(playersPageLocators.finalAddPlayerButton);
		verifyPlayerAdded(playerName);
	}
	public void editPlayer(String playerName, String birthDate, String gender) {
		playersPageLocators.clearElement(playersPageLocators.playerName);
		playersPageLocators.sendKeys(playerName,playersPageLocators.playerName);
		playersPageLocators.clickElement(playersPageLocators.selectBirthDate);
		playersPageLocators.scanThroughTheListOfElementsAndClick(playersPageLocators.selectDate,birthDate);
		selectGender(gender);
		playersPageLocators.clickElement(playersPageLocators.finalAddPlayerButton);
		
	}
	public void deleteAllPlayers() {
		for(int i=playersPageLocators.getPlayersCount();i>0;i--)
		 {
			deletePlayer();
		 }
	}
	public void deletePlayer()  {
		playersPageLocators.waitFor(5);
		clickOnEditButton();
		playersPageLocators.clickElement(playersPageLocators.deleteButton);
		playersPageLocators.waitFor(5);
	    Point p =	playersPageLocators.confirmDelete.getLocation();
	    int x=p.getX();
	    int y=p.getY();
	    Actions action = new Actions(playersPageLocators.getDriver());
	    action.moveByOffset(x, y).click().build().perform();
	    action.moveByOffset(-x, -y).build().perform();
//		playersPageLocators.clickElement(playersPageLocators.confirmDelete);
	}
	public void verifyPlayerAdded(String playerName) {
		playersPageLocators.waitFor(8);
		JSONObject playerNames = playersPageLocators.getPlayersNames();
		List<Object> listOfPlayerNames = new ArrayList<>();
		for (int i = 0; i < playerNames.size(); i++) {
			listOfPlayerNames.add(playerNames.get("player" + (i + 1)).toString());
		}
		playersPageLocators.assertListContainsValue(listOfPlayerNames, playerName);
	}
	public void verifyPlayerDeleted(String playerName) {
		playersPageLocators.waitFor(6);
		JSONObject playerNames = playersPageLocators.getPlayersNames();
		List<Object> listOfPlayerNames = new ArrayList<>();
		for (int i = 0; i < playerNames.size(); i++) {
			listOfPlayerNames.add(playerNames.get("player" + (i + 1)).toString());
		}
		playersPageLocators.assertListDoesntContainValue(listOfPlayerNames, playerName);
	}
	public void verifyMaxThreePlayersCanBeAdded(String playerName, String birthDate, String gender) {
		int actualPlayersCount = playersPageLocators.getPlayersCount();
		if (actualPlayersCount == 3) {
			playersPageLocators.assertElementNotPresent(playersPageLocators.addMorePlayers);
		} else {
			for (int i = 1; i <= 3 - actualPlayersCount; i++) {
				clickOnAddPlayerButton();
				addPlayer(playerName + i, birthDate, gender);
				playersPageLocators.waitFor(6);
				verifyPlayerAdded(playerName + i);
			}
			if (playersPageLocators.getPlayersCount() == 3) {
				playersPageLocators.assertElementNotPresent(playersPageLocators.addMorePlayers);
			}
		}
	}
	public void clickOnEditButton() {
		playersPageLocators.clickElement(playersPageLocators.editButton);
      
	}
	public void clickOnAddPlayerButton() {
		if(playersPageLocators.getPlayersCount()==0) {
			   playersPageLocators.clickElement(playersPageLocators.addPlayerButton);
			}else {
				playersPageLocators.clickElement(playersPageLocators.addMorePlayers);
			}
		
	}
	
	public void selectPlayer(String playerName) {
		playersPageLocators.scanThroughTheListOfElementsAndClick(playersPageLocators.listOfPlayerNames,playerName);
	}
	public void selectGender(String gender) {
		Select genderDropDown = new Select(playersPageLocators.genderDropDown);
		genderDropDown.selectByVisibleText(gender);
	}

}
