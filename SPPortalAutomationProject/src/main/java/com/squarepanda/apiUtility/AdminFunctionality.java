package com.squarepanda.apiUtility;

import org.json.simple.JSONObject;
import com.squarepanda.generalUtility.JsonUtility;
import com.squarepanda.generalUtility.LoadProperties;

import io.restassured.response.Response;

public class AdminFunctionality {
	static String baseUri;

	@SuppressWarnings("unchecked")
	public static JSONObject performAdminLoginAndGetAcessToken(String adminEmail, String adminPassword)
			throws Exception {
		baseUri = LoadProperties.getRestServiceEndpoints("BASE_URI");
		String adminLoginEndpoint = LoadProperties.getRestServiceEndpoints("ADMIN_LOGIN");
		JSONObject body = new JSONObject();
		body.put("emailAddress", adminEmail);
		body.put("password", adminPassword);
		Response response = RestAssuredUtility.postWithFormParameters(body.toJSONString(),
				baseUri + adminLoginEndpoint);
		RestAssuredUtility.verifyStatusCode(200);
		return JsonUtility.convertResponseToJsonObject(response);
	}

	@SuppressWarnings("unchecked")
	private static void clearPhoneNumberOfAUser(String authToken, String userId) throws Exception {
		baseUri = LoadProperties.getRestServiceEndpoints("BASE_URI");
		JSONObject body = new JSONObject();
		body.put("phoneNumber", null);
		Response response = RestAssuredUtility.postWithFormParameters(authToken, body.toJSONString(), RestAssuredUtility
				.constructURL(baseUri + LoadProperties.getRestServiceEndpoints("ADMIN_UPDATE"), userId));
		RestAssuredUtility.verifyStatusCode(200);
		System.out.println("Phone number successfully cleared.!");
	}

	public static void clearPhoneNumberUsingAdminRights(String adminEmail, String adminPassword, String userEmail,
			String userPassword) throws Exception {
		String userId = UserFunctionality.performUserLogin(userEmail, userPassword).get("id").toString().trim();
		System.out.println("User id for user-email: " + userEmail + " is: " + userId);
		String accessToken = performAdminLoginAndGetAcessToken(adminEmail, adminPassword).get("access_token").toString()
				.trim();
		clearPhoneNumberOfAUser(accessToken, userId);
	}

	@SuppressWarnings("unchecked")
	public static void activateAnUserUsingAdminRights(String adminEmail, String adminPassword, String userEmail,
			String userPassword) throws Exception {
		String userId = UserFunctionality.performUserLogin(userEmail, userPassword).get("id").toString().trim();
		System.out.println("User id for user-email: " + userEmail + " is: " + userId);
		String accessToken = performAdminLoginAndGetAcessToken(adminEmail, adminPassword).get("access_token").toString()
				.trim();
		baseUri = LoadProperties.getRestServiceEndpoints("BASE_URI");
		String adminUserActivateEndpoint = LoadProperties.getRestServiceEndpoints("ADMIN_USER_ACTIVATE");
		JSONObject body = new JSONObject();
		body.put("adultId", userId);
		Response response = RestAssuredUtility.postWithFormParameters(accessToken, body.toJSONString(),
				baseUri + adminUserActivateEndpoint);
		RestAssuredUtility.verifyStatusCode(200);
		System.out.println("User successfully activated.!");
	}

}
