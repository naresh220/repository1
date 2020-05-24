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
//		   playersPageCoreLogic.verifyPlayersPageTitle();
			System.out.println("uuieruyfiuby");
		} catch (Exception e) {
		ErrorReporter.reportError(e);
	   } 
	}
	@Then("^Verify if three players are added and delete one on add player screen$")
	public void verify_is_three_players_and_added_and_delete_one_on_add_player_screen() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify user can add maximum of three players on add player screen$")
	public void verify_user_can_add_maximum_of_three_players_on_add_player_screen() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks add player button on player page$")
	public void user_clicks_add_player_button_on_player_page() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("User creates a player \"([^\"]*)\" information on add player page")
	public void user_adds_a_player_on_add_player_screen_on_add_player_page(String missingInput) throws Throwable {
		try {
			
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^Verify player added on add player screen$")
	public void verify_player_added_on_add_player_screen() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks on newly created player on add player page$")
	public void user_clicks_on_newly_created_player_on_add_player_page() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User clicks on a player on add player screen$")
	public void user_clicks_on_a_player_on_add_player_screen() throws Throwable {
		try {
			
		} catch (Exception e) {
			ErrorReporter.reportError(e, true);
		}
	}

	@Then("^User edits the player \"([^\"]*)\" information on add player page$")
	public void user_edits_the_player_on_add_player_page(String missingInformation) throws Throwable {
		try {
			
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
