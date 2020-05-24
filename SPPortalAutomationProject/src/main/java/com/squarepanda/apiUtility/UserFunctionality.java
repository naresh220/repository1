package com.squarepanda.apiUtility;

import org.json.simple.JSONObject;
import com.squarepanda.generalUtility.JsonUtility;
import com.squarepanda.generalUtility.LoadProperties;

import io.restassured.response.Response;

public class UserFunctionality {
	static String baseUri;

	@SuppressWarnings("unchecked")
	public static JSONObject performUserLogin(String userEmail, String userPassword) throws Exception {
		baseUri = LoadProperties.getRestServiceEndpoints("BASE_URI");
		String userLoginEndpoint = LoadProperties.getRestServiceEndpoints("USER_LOGIN");
		JSONObject body = new JSONObject();
		body.put("emailAddress", userEmail);
		body.put("password", userPassword);
		Response response = RestAssuredUtility.postWithFormParameters(body.toJSONString(), baseUri + userLoginEndpoint);
		RestAssuredUtility.verifyStatusCode(202);
		System.out.println("Successfully logged in.");
		return JsonUtility.convertResponseToJsonObject(response);
	}

	@SuppressWarnings("unchecked")
	public static JSONObject performPortalLogin(String userEmail, String userPassword) throws Exception {
		baseUri = LoadProperties.getRestServiceEndpoints("BASE_URI");
		String portalLoginEndpoint = LoadProperties.getRestServiceEndpoints("PORTAL_USER_LOGIN");
		JSONObject body = new JSONObject();
		body.put("identifier", userEmail);
		body.put("password", userPassword);
		Response response = RestAssuredUtility.postWithFormParameters(body.toJSONString(),
				baseUri + portalLoginEndpoint);
		RestAssuredUtility.verifyStatusCode(200);
		System.out.println("Successfully logged in to the portal.");
		return JsonUtility.convertResponseToJsonObject(response);
	}

	@SuppressWarnings("unchecked")
	public static JSONObject getJWTTokenAndParentIdFromPortalLogin(String userEmail, String userPassword)
			throws Exception {
		JSONObject fetchedData = new JSONObject();
		JSONObject portalLoginResponse = performPortalLogin(userEmail, userPassword);
		fetchedData.put("jwtToken", portalLoginResponse.get("tokenId").toString());
		fetchedData.put("parentId", portalLoginResponse.get("id").toString());
		System.out.println("Successfully obtained the jwtToken and the parentId.");
		return fetchedData;
	}
}

