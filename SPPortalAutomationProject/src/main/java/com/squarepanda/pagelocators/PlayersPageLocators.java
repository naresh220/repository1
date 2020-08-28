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
	@FindBy(how=How.XPATH,using="//button[@class='sqpButton primary full teacher']")
	public WebElement finalAddPlayerButton;
	@FindBys(@FindBy(how=How.XPATH,using="//i[@class='sqp-edit']"))
	public WebElement editButton;
	@FindBy(how=How.XPATH,using="//button[@class='sqpButton danger full teacher']")
	public WebElement deleteButton;
	@FindBy(how=How.XPATH,using="//button[@class='sqpButton primary full teacher']")
	public WebElement confirmDelete;
	@FindBy(how=How.XPATH,using="//input[@formcontrolname='firstName']")
	public WebElement playerName;
	@FindBy(how=How.XPATH,using="//input[@class='ngx-datepicker-input ng-untouched ng-pristine ng-valid']")
	public WebElement selectBirthDate;
	@FindBy(how=How.XPATH,using="//div[@class='main-calendar-days']")
	public WebElement selectDate1;
	@FindBy(how=How.XPATH,using="//div[@class='addPlayer']")
	public WebElement addMorePlayers;
	@FindBy(how=How.ID,using="inputStudentGender")
	public WebElement genderDropDown;
	@FindBys(@FindBy(how=How.XPATH,using="//span[@class='day-unit']"))
	public List<WebElement>selectDate;
	
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
		return playerNames;
	}
	

}
