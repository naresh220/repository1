package com.squarepanda.apiUtility;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.squarepanda.generalUtility.JsonUtility;
import com.squarepanda.generalUtility.LoadProperties;

import io.restassured.response.Response;

public class PlayerFunctionality {
	JsonUtility jsonUtility = new JsonUtility();
	static String baseUri;

	@SuppressWarnings("unchecked")
	public static JSONObject getListOfPlayersIds(String jwtTokenFromPortalLogin, String parentId) throws Exception {
		JSONObject playerIds = new JSONObject();
		baseUri = LoadProperties.getRestServiceEndpoints("BASE_URI");
		String portalGetListOfPlayersEndpoint = LoadProperties.getRestServiceEndpoints("PORTAL_GET_LIST_OF_PLAYERS");
		Response response = RestAssuredUtility.getWithNoParameters(
				RestAssuredUtility.constructURL(baseUri + portalGetListOfPlayersEndpoint, parentId),
				jwtTokenFromPortalLogin);
		RestAssuredUtility.verifyStatusCode(200);
		JSONArray getListOfPlayersJsonResponse = JsonUtility.convertResponseToJsonArray(response);
		if (getListOfPlayersJsonResponse.size() > 0) {
			for (int i = 0; i < getListOfPlayersJsonResponse.size(); i++) {
				JSONObject playerSpecificObject = (JSONObject) getListOfPlayersJsonResponse.get(i);
				playerIds.put("player" + (i + 1), playerSpecificObject.get("id").toString());
			}
			playerIds.put("count", getListOfPlayersJsonResponse.size());
		} else {
			playerIds.put("count", (int) 0);
		}
		System.out.println("Successfully obtained the list of player ids:\n" + JsonUtility.getFormattedJson(playerIds)
				+ "\nfor parent with parent-id: " + parentId);
		return playerIds;
	}

	public static void deleteAPlayer(String jwtTokenFromPortalLogin, String parentId, String playerIdToDelete)
			throws Exception {
		baseUri = LoadProperties.getRestServiceEndpoints("BASE_URI");
		String portalDeletePlayer = LoadProperties.getRestServiceEndpoints("PORTAL_DELETE_PLAYER");
		Response response = RestAssuredUtility.deleteWithPathParameters(jwtTokenFromPortalLogin,
				RestAssuredUtility.constructURL(baseUri + portalDeletePlayer, parentId + "," + playerIdToDelete));
		RestAssuredUtility.verifyStatusCode(200);
		JSONObject deletePlayerJsonResponse = JsonUtility.convertResponseToJsonObject(response);
		assertEquals(deletePlayerJsonResponse.get("message").toString(), "successfully deleted!");
		System.out.println("Successfully deleted player with player-id: " + playerIdToDelete
				+ " for parent with parent-id: " + parentId);
	}

	public static void deleteAllPlayers(String jwtTokenFromPortalLogin, String parentId) throws Exception {
		JSONObject playerIds = getListOfPlayersIds(jwtTokenFromPortalLogin, parentId);
		int count = (int) playerIds.get("count");
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				String playerId = playerIds.get("player" + (i + 1)).toString();
				deleteAPlayer(jwtTokenFromPortalLogin, parentId, playerId);
			}
		} else {
			System.out.println("There are no players to delete for parent with parent-id: " + parentId);
		}
	}
}
