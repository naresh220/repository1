package com.squarepanda.stepdefinitions;

import org.json.simple.JSONObject;
import com.squarepanda.reporting.ErrorReporter;
import com.squarepanda.testrunners.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PlayersPageStepDefinitions extends BaseClass {
	public static Scenario scenario;
	@When("^Verify user is on players page$")
	public void verify_user_is_on_players_page() throws Throwable{
		try {
		   playersPageCoreLogic.verifyPlayersPageTitle();	
		} catch (Exception e) {
		ErrorReporter.reportError(e);
	   } 
	}
	@Then("^Delete all the players on players page$")
	public void Delete_all_the_players_on_players_page() throws Throwable {
		try {
			playersPageCoreLogic.deleteAllPlayers();
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks on add player button on players page$")
	public void user_clicks_on_add_player_button_on_players_page() throws Throwable {
		try {
			playersPageCoreLogic.clickOnAddPlayerButton();
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify user creates a player on players page$")
	public void user_creates_a_player_on_players_page() throws Throwable {
		try {
			playersPageCoreLogic.addPlayer("createPlayer", "18", "Male");
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("User delete the player on players page")
	public void user_delete_the_player_on_players_page() throws Throwable {
		try {
			playersPageCoreLogic.deletePlayer();
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks on edit player button on players page$")
	public void user_clicks_on_edit_player_button_on_players_page() throws Throwable {
		try {
			playersPageCoreLogic.clickOnEditButton();
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User edits the player on players page$")
	public void user_edits_the_player_on_players_page() throws Throwable {
		try {
			playersPageCoreLogic.editPlayer("upDatePlayer", "10", "Female");
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify player updated on players page$")
	public void verify_player_updated_on_players_page() throws Throwable {
		try {
			playersPageCoreLogic.verifyPlayerAdded("upDatePlayer");
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify user can creates three players on players page")
	public void verify_user_can_creates_three_players_on_players_page() throws Throwable {
		try {
			playersPageCoreLogic.verifyMaxThreePlayersCanBeAdded("playerName", "10", "Male");
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		} 
	}

	@Then("^Verify player updated on add player page$")
	public void verify_player_updated_on_add_player_page() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks on updated player on add player page$")
	public void user_clicks_on_updated_player_on_add_player_page() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks delete icon on edit player popup on add player page$")
	public void user_clicks_delete_icon_on_edit_player_popup_on_add_player_page() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks delete button on delete popup on add player page$")
	public void user_clicks_delete_button_on_delete_popup_on_add_player_page() throws Throwable {
		try {
		
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify player deleted on add player page$")
	public void verify_user_deleted_on_add_player_page() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify add player popup on player page$")
	public void verify_add_player_popup_on_add_player_page() throws Throwable {
		try {

		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify edit player popup on add player page$")
	public void verify_edit_player_popup_on_add_player_page() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks on a existing player on add player screen$")
	public void user_clicks_on_a_existing_player_on_add_player_screen() throws Throwable {
		try {
			} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify delete popup on add player page$")
	public void verify_delete_popup_on_add_player_page() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Delete the player of its was added on add player screen$")
	public void delete_the_player_of_its_was_added_on_add_player_screen() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify add picture popup from \"([^\"]*)\" screen on add player screen$")
	public void verify_add_picture_popup_on_add_player_screen_on_add_player_screen(String fromWhichScreen)
			throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks image icon on add player screen$")
	public void user_clicks_image_icon_on_add_player_screen() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify player \"([^\"]*)\" missing error popup on add player screen$")
	public void verify_player_information_missing_error_popup_on_add_player_screen(String missingInformation)
			throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks cancel button on add player popup on add player screen$")
	public void user_clicks_cancel_button_on_add_player_popup_on_add_player_screen() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks cancel button on edit player popup on add player screen$")
	public void user_clicks_cancel_button_on_edit_player_popup_on_add_player_screen() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks cancel button on delete player popup on add player screen$")
	public void user_clicks_cancel_button_on_delete_player_popup_on_add_player_screen() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify turn on your internet error popup on add player screen$")
	public void verify_turn_on_your_internet_error_popup_on_add_player_screen() throws Throwable {
		try {
	
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks continue button on add player screen$")
	public void user_clicks_continue_button_on_add_player_screen_on_add_player_screen() throws Throwable {
		try {
		
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Delete the player added from backend for account with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void wipe_off_the_player_added_from_backend(String email, String password) throws Throwable {
		System.out.println("Deleting players from the account if any...");
		JSONObject data = com.squarepanda.apiUtility.UserFunctionality.getJWTTokenAndParentIdFromPortalLogin(email, password);
		String jwtTokenFromPortalLogin = (String) data.get("jwtToken");
		String parentId = (String) data.get("parentId");
		com.squarepanda.apiUtility.PlayerFunctionality.deleteAllPlayers(jwtTokenFromPortalLogin, parentId);
	}

}
