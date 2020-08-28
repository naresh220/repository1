package com.squarepanda.generalUtility;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.skyscreamer.jsonassert.JSONAssert;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import io.restassured.response.Response;

/**
 * The class includes all the generic functions required for JSON parsing.
 * 
 *
 */
public class JsonUtility {

	/***
	 * <li>The method gets the value of key from the json object where the given key
	 * matches the given value. It recursively search for the key value match and if
	 * there are multiple key values of the same kind, first match is returned. <br>
	 * <br>
	 * <li>Example: Give the below response:<br>
	 * 
	 * {@code Object: {
	 * 		.....
	 *  	Students:
	 *  	[
	 *  			{ 
	 *  				firstName: "automation", lastName: "testing", project:
	 * "core-framework" }, { firstName: "automation-1", lastName: "testing-1",
	 * project: "core-framework-1" },{ firstName: "automation-2", lastName:
	 * "testing-2", project: "core-framework-2" } ] ..... }} <br>
	 * <br>
	 * <li>If user wants to fetch the object from the json where the key is project
	 * and value is core-framework. The user will call the method and get only the
	 * json object whose key is project and value is core-framework. <br>
	 * <br>
	 * <li>Function call: getValueOfKeyFromJson(Object, "project",
	 * "core-framework")<br>
	 * <br>
	 * <li>If nothing matches Null is returned. So its advisable to perform a null
	 * check whenever required. <br>
	 * <br>
	 * 
	 * @param jsonObject the json object of type {@link JSONObject}.
	 * 
	 * @param searchKey  the key to search in the json.
	 * 
	 * @param value      the value to search in the json of the requested key.
	 * 
	 * @return the object which could be a string or a json object.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getValueOfKeyFromJson(JSONObject jsonObject, String searchKey, String value) throws ParseException {
		Object gotValue = null;
		Set<Object> set = jsonObject.keySet();
		Iterator iterator = set.iterator();
		// try {
		while (iterator.hasNext()) {

			Object key = iterator.next();
			if (searchKey.equals(key) && jsonObject.get(key).toString().equalsIgnoreCase(value)) {
				gotValue = jsonObject;
				break;
			} else if (jsonObject.get(key) instanceof JSONObject) {
				getValueOfKeyFromJson((JSONObject) jsonObject.get(key), searchKey, value);
			} else if (jsonObject.get(key) instanceof JSONArray) {
				getArray(jsonObject.get(key), searchKey, value);
			}
		}
		return gotValue;
//		} finally {
//			gotValue = new Object();
//		}

	}

	/**
	 * The method is the supporting function to the other functions hence private is
	 * nature.
	 * 
	 **/
	private Object getArray(Object object, String searchkey, String value) throws ParseException {
		JSONArray jsonArr = (JSONArray) object;
		for (int k = 0; k < jsonArr.size(); k++) {
			if (jsonArr.get(k) instanceof JSONObject) {
				if (value.isEmpty()) {
					return getValueOfKeyFromJson((JSONObject) jsonArr.get(k), searchkey);
				} else {
					return getValueOfKeyFromJson((JSONObject) jsonArr.get(k), searchkey, value);
				}
			}
		}
		return null;
	}

	/**
	 * <li>The method performs a deep search for the given key. <br>
	 * <li>If there are multiple keys of the same name , the first match is
	 * returned.<br>
	 * <li>If the key is not found, null is returned.<br>
	 * 
	 * @param jsonObject the json object of type {@link JSONObject}.
	 * 
	 * @param searchKey  the key to search in the json.
	 * 
	 * @return the object which could be a string or a json object.
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getValueOfKeyFromJson(JSONObject jsonObject, String searchKey) throws ParseException {
		Object valueofKey = null;
		Set<Object> set = jsonObject.keySet();
		Iterator iterator = set.iterator();
		// try {
		while (iterator.hasNext()) {
			Object key = iterator.next();
			if (searchKey.equals(key)) {
				valueofKey = jsonObject.get(key);
				break;
			} else if (jsonObject.get(key) instanceof JSONObject) {
				getValueOfKeyFromJson((JSONObject) jsonObject.get(key), searchKey);
			} else if (jsonObject.get(key) instanceof JSONArray) {
				getArray(jsonObject.get(key), searchKey, "");
			}
		}
		return valueofKey;
//		} finally {
//			valueofKey = null;
//		}
	}

	/**
	 * <li>The method performs a deep search for the given key and value pair over
	 * the given JSONArray object. It takes {@link JSONArray} and not
	 * {@link JSONObject} as the parameter. <br>
	 * <li>If there are multiple key-value pair of the same kind , the first match
	 * is returned.<br>
	 * <li>If the key-value is not found, null is returned.<br>
	 * 
	 * @param jsonArr   the json object of type {@link JSONArray}.
	 * 
	 * @param searchKey the key to search in the json.
	 * 
	 * @param value     the value to search in the json of the requested key.
	 * 
	 * @return the JSONObject of type {@link JSONObject}.
	 * 
	 **/
	public JSONObject iterateOverJSONArray(JSONArray jsonArr, String searchKey, String value) throws ParseException {
		JSONObject jsonObj = null;
		for (int k = 0; k < jsonArr.size(); k++) {
			if (jsonArr.get(k) instanceof JSONObject) {
				if (value.isEmpty()) {
					jsonObj = (JSONObject) getValueOfKeyFromJson((JSONObject) jsonArr.get(k), searchKey);
					if (jsonObj != null)
						break;
				} else {
					jsonObj = (JSONObject) getValueOfKeyFromJson((JSONObject) jsonArr.get(k), searchKey, value);
					if (jsonObj != null)
						break;
				}
			}
		}
		return jsonObj;
	}

	/**
	 * The method converts the Response object of the rest api to the JSONObject.
	 * 
	 * @param res response of the rest api of type {@link Response}.
	 * 
	 * @return the converted object of type {@link JSONObject}.
	 */
	public static JSONObject convertResponseToJsonObject(Response res) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(res.asString());
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * The method converts the Response object of the rest api to the JSONArray.
	 * 
	 * @param res response of the rest api of type {@link Response}.
	 * 
	 * @return the converted object of type {@link JSONArray}.
	 */
	public static JSONArray convertResponseToJsonArray(Response res) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONArray obj = null;
		try {
			obj = (JSONArray) parser.parse(res.asString());
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * The method asserts two json objects are equal. It also matches the json if
	 * the order of the key value in one json differs from that in the other.
	 * 
	 * @param expectedJsonString expected json object string.
	 * 
	 * @param actualJsonString   actual json object string.
	 **/
	public static void assertJsonsEquality(String expectedJsonString, String actualJsonString) throws JSONException {
		JSONAssert.assertEquals(actualJsonString.toString(), expectedJsonString.toString(), false);
	}

	/**
	 * The method formats the json in a proper format.
	 * 
	 * @param json json object to format.
	 * 
	 * @return formatted json string.
	 **/
	public static String getFormattedJson(Object json) {
		Gson jsonObj = new GsonBuilder().setPrettyPrinting().create();
		return jsonObj.toJson(json);
	}

	/**
	 * The method gets the device information from the device_information.json file.
	 * 
	 * @param deviceName the device name whose information needs to be fetched
	 * 
	 * @return a json object of type {@link JSONObject} which contains the fetched
	 *         device information.
	 **/
	public static JSONObject getDeviceInformation(String deviceName) throws ParseException {
		JSONObject deviceDetails = FileUtility.fetchJsonObjectFromJSONFile("device_information.json");
		JsonUtility jsonUtil = new JsonUtility();
		JSONObject data = new JSONObject();
		JSONArray iosDetails;
		JSONArray androidDetails;
		if (LoadProperties.getProjectProperities("executionOn").toString().equalsIgnoreCase("ios")) {
			iosDetails = (JSONArray) deviceDetails.get("ios");
			data = jsonUtil.iterateOverJSONArray(iosDetails, "deviceName", deviceName);
			System.out.println(
					"Information fetched for device '" + deviceName + "' is: " + JsonUtility.getFormattedJson(data));
			return data;
		} else {
			androidDetails = (JSONArray) deviceDetails.get("android");
			data = jsonUtil.iterateOverJSONArray(androidDetails, "deviceName", deviceName);
			System.out.println(
					"Information fetched for device '" + deviceName + "' is: " + JsonUtility.getFormattedJson(data));
			return data;
		}
	}

	/**
	 * The method converts the {@link String} object to {@link JSONObject} object.
	 * 
	 * @param stringValue string value to convert to {@link JSONObject} object.
	 * 
	 * @return the converted object of type {@link JSONObject}.
	 */
	public static JSONObject convertStringToJson(String stringValue) {
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(stringValue);
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return json;
	}
}
