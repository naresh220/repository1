package com.squarepanda.apiUtility;


	
	import static io.restassured.RestAssured.*;
	import java.util.Map;
	import java.util.concurrent.TimeUnit;

	import org.json.simple.JSONObject;
	import org.testng.Reporter;

	import com.squarepanda.seleniumUtility.GenericMethods;
	import com.squarepanda.constants.WebDriverGlobalVariables;
	import com.squarepanda.generalUtility.JsonUtility;
	import com.squarepanda.reporting.ExceptionInfoApi;

	import io.restassured.RestAssured;
	import io.restassured.config.ConnectionConfig;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	/**
	 * The class includes all the generic functions required dealing with REST
	 * services.
	 * 
	 * @author Zaid Momin
	 * @since 26-03-2019
	 */

	public class RestAssuredUtility {
		static GenericMethods genericMethods = new GenericMethods();
		public static JSONObject REQUEST_DETAILS = new JSONObject();
		public static JSONObject RESPONSE_DETAILS = new JSONObject();

		/***
		 * 
		 * The method performs a post request with query parameters.
		 * 
		 * @param authToken       authentication token.
		 * @param queryParameters query parameters.
		 * @param URI             URI required to perform the post operation.
		 * @return a response of type {@link Response}.
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static Response postWithQueryParameters(String authToken, Map queryParameters, String URI) {
			Response res = setAuthToken(authToken).params(queryParameters).when().post(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/***
		 * The method generates the entire URI required to perform any request- PUT,
		 * POST, GET, DELETE etc.
		 * 
		 * @param URI   URI with {pathParameter}.
		 * 
		 * @param param the path parameters to generate the complete URI.
		 * 
		 * @return URI with {pathParameter} replaced by params supplied.
		 */
		public static String generateURIWithPathParameter(String URI, Object param) {
			String s1 = URI;
			String s2 = s1.replace("{pathParameter}", param.toString());
			return s2;
		}

		/***
		 * The method constructs the entire URL required to perform any request- PUT,
		 * POST, GET, DELETE etc.
		 * 
		 * @param URI        URI with {pathParameter}.
		 * 
		 * @param parameters the path parameters to generate the complete URI which are
		 *                   comma separated.
		 * 
		 * @return url with {pathParameter} replaced by parameters supplied.
		 */
		public static String constructURL(String uri, String parameters) {
			String[] replacements = parameters.split(",");
			String url = uri;
			for (int i = 0; i < replacements.length; i++) {
				url = url.replace(("{PARAM" + i + "}"), replacements[i].trim());
			}
			return url;
		}

		/***
		 * The method sets the authorization token.
		 * 
		 * @param authToken authorization token required in headers.
		 * 
		 * @return the request specification with authorization set in the headers.
		 */
		public static RequestSpecification setAuthToken(String authToken) {
			return RestAssured.with().given().log().all().header("Authorization", "Bearer " + authToken);
		}

		/***
		 * The method verifies the status code is expected or not. That is it internal
		 * fetches the actual status code and check it with the supplied expected status
		 * code.
		 * 
		 * @param expectedStatusCode expected status code to assert with actual status
		 *                           code.
		 * @throws Exception
		 * 
		 */
		public static void verifyStatusCode(int expectedStatusCode) throws Exception {
			setCurrentMillseconds();
			while (true) {
				try {
					if (Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()) == expectedStatusCode)
						break;
					else {
						throwErrorOnDefaultTimeout(REQUEST_DETAILS.get("url").toString(),
								Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
								REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
								RESPONSE_DETAILS.get("body").toString(),
								Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()), expectedStatusCode,
								"This is an assertion failure");
					}
				} catch (Exception e) {
					throwErrorOnDefaultTimeout(e, REQUEST_DETAILS.get("url").toString(),
							Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
							REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
							RESPONSE_DETAILS.get("body").toString(),
							Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()), expectedStatusCode,
							"This is a failure. Please check your request details...!");
				}
			}
		}

		/**
		 * The method sets the form parameters of the api request: the Body and the
		 * Content-Type. The content-type is set to JSON.
		 * 
		 * @param formParametersJson the request body.
		 * 
		 * @return the return is of type {@link RequestSpecification}
		 */
		public static RequestSpecification setFormParameters(String formParametersJson) {
			return RestAssured.with().log().all().body(JsonUtility.convertStringToJson(formParametersJson))
					.contentType(ContentType.JSON);
		}

		/**
		 * The method performs a post request with the body and the auth-token. The
		 * method intakes the auth-token, the request body and the uri.
		 * 
		 * @param authToken          the authorization token.
		 * 
		 * @param formParametersJson the request body in String format.
		 * 
		 * @param URI                the api url.
		 * 
		 * @return response of type {@link Response}
		 */
		public static Response postWithFormParameters(String authToken, String formParametersJson, String URI) {
			Response res = setAuthToken(authToken).spec(setFormParameters(formParametersJson)).when().post(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, formParametersJson);
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a post request with the body and the auth-token. The
		 * method intakes the request body and the uri.
		 * 
		 * @param formParametersJson the request body in String format.
		 * 
		 * @param URI                the api url.
		 * 
		 * @return response of type {@link Response}
		 */
		public static Response postWithFormParameters(String formParametersJson, String URI) {
			Response res = setFormParameters(formParametersJson).when().post(URI);
			REQUEST_DETAILS = requestDetails("", URI, formParametersJson);
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a get request with the body. The method intakes th
		 * request body and the uri.
		 * 
		 * @param formParametersJson the request body in String format.
		 * 
		 * @param URI                the api url.
		 * 
		 * @return response of type {@link Response}
		 */
		public static Response getWithBody(JSONObject formParametersJson, String URI) {
			ConnectionConfig connectionConfig = new ConnectionConfig();
			connectionConfig.closeIdleConnectionsAfterEachResponseAfter(5, TimeUnit.MINUTES);
			Response res = given().contentType(ContentType.JSON).body(formParametersJson).when().get(URI);
			REQUEST_DETAILS = requestDetails("", URI, formParametersJson.toJSONString());
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a post request without the body and without the
		 * auth-token. The method intakes uri.
		 * 
		 * @param URI the api url.
		 * 
		 * @return response of type {@link Response}
		 */
		public static Response postWithNoBody(String URI) {
			Response res = given().log().all().contentType(ContentType.JSON).log().all().when().post(URI);
			REQUEST_DETAILS = requestDetails("", URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a post request without the body and with the auth-token.
		 * The method intakes the auth-token and the uri.
		 * 
		 * @param authToken the authorization token.
		 * @param URI       the api url.
		 * 
		 * @return response of type {@link Response}
		 */
		public static Response postWithNoBody(String URI, String authToken) {
			Response res = setAuthToken(authToken).contentType(ContentType.JSON).when().post(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a get request with only the query-parameters. The method
		 * intakes uri and the query-parameters in form on {@link Map}
		 * 
		 * @param queryParameters the query parameters in form of {@link Map}.
		 * 
		 * @param URI             the api url.
		 * 
		 * @return the get response of type {@link Response}
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static Response getWithQueryparameters(String URI, Map queryParameters) {
			Response res = given().log().all().params(queryParameters).when().get(URI);
			REQUEST_DETAILS = requestDetails("", URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a get request with the query-parameters and the
		 * auth-token. The method intakes uri, the auth-token and the query-parameters
		 * in form on {@link Map}
		 * 
		 * @param queryParameters the query parameters in form of {@link Map}.
		 * 
		 * @param URI             the api url.
		 * 
		 * @param authToken       the authorization token.
		 * 
		 * @return the get response of type {@link Response}
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static Response getWithQueryparameters(String URI, String authToken, Map queryParameters) {
			Response res = setAuthToken(authToken).params(queryParameters).when().get(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a put request with the query-parameters and the
		 * auth-token. The method intakes uri, the auth-token and the query-parameters
		 * in form on {@link Map}
		 * 
		 * @param queryParameters the query parameters in form of {@link Map}.
		 * 
		 * @param URI             the api url.
		 * 
		 * @param authToken       the authorization token.
		 * 
		 * @return the put response of type {@link Response}
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static Response putWithQueryparameters(String authToken, Map queryParameters, String URI) {
			Response res = setAuthToken(authToken).params(queryParameters).when().put(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a get request with path parameters. The method intakes
		 * uri and the authToken. Note the path parameters are replace when the complete
		 * url is formed.
		 * 
		 * @param authToken the authorization token.
		 * 
		 * @param URI       the api url.
		 * 
		 * @return the get response of type {@link Response}
		 */
		public static Response getWithPathParameters(String authToken, String URI) {
			Response res = setAuthToken(authToken).when().get(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a plain get request. The method intakes uri.
		 * 
		 * @param URI the api url.
		 * 
		 * @return the get response of type {@link Response}
		 */
		public static Response getWithNoParameters(String URI) {
			Response res = given().log().all().when().get(URI);
			REQUEST_DETAILS = requestDetails("", URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a plain get request. The method intakes uri and the
		 * auth-token.
		 * 
		 * @param authToken the authorization token.
		 * 
		 * @param URI       the api url.
		 * 
		 * @return the get response of type {@link Response}
		 */
		public static Response getWithNoParameters(String URI, String authToken) {
			Response res = setAuthToken(authToken).when().get(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a put request with the body and the auth-token. The
		 * method intakes the auth-token, the request body and the uri.
		 * 
		 * @param authToken          the authorization token.
		 * 
		 * @param formParametersJson the request body in String format.
		 * 
		 * @param URI                the api url.
		 * 
		 * @return the put response of type {@link Response}
		 */
		public static Response putWithFormParameters(String authToken, String formParametersJson, String URI) {
			Response res = setAuthToken(authToken).spec(setFormParameters(formParametersJson)).when().put(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, formParametersJson);
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a put request with path parameters. The method intakes
		 * the auth-token and the uri.
		 * 
		 * Note: the path parameters are replaced when the completed uri is formed using
		 * method generateURIWithPathParameter.
		 * 
		 * @param authToken the authorization token.
		 *
		 * @param URI       the api url.
		 * 
		 * @return the put response of type {@link Response}
		 */
		public static Response putWithPathParameters(String authToken, String URI) {
			Response res = setAuthToken(authToken).when().put(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a delete request with path parameters. The method intakes
		 * the auth-token and the uri.
		 * 
		 * Note: the path parameters are replaced when the completed uri is formed using
		 * method generateURIWithPathParameter.
		 * 
		 * @param authToken the authorization token.
		 *
		 * @param URI       the api url.
		 * 
		 * @return the delete response of type {@link Response}
		 */
		public static Response deleteWithPathParameters(String authToken, String URI) {
			Response res = setAuthToken(authToken).when().delete(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method sets the form parameters of the api request: Content-Type. The
		 * content-type is set to JSON.
		 * 
		 * @return the return is of type {@link RequestSpecification}
		 */
		public static RequestSpecification setFormParameters() {
			return RestAssured.with().contentType(ContentType.JSON);
		}

		/**
		 * The method performs a post request with path parameters. The method intakes
		 * the auth-token and the uri.
		 * 
		 * Note: the path parameters are replaced when the completed uri is formed using
		 * method generateURIWithPathParameter.
		 * 
		 * @param authToken the authorization token.
		 *
		 * @param URI       the api url.
		 * 
		 * @return the post response of type {@link Response}
		 */
		public static Response postWithPathParameters(String authToken, String URI) {
			Response res = setAuthToken(authToken).spec(setFormParameters()).when().post(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method performs a delete request with the query-parameters and the
		 * auth-token. The method intakes uri, the auth-token and the query-parameters
		 * in form on {@link Map}
		 * 
		 * @param queryParameters the query parameters in form of {@link Map}.
		 * 
		 * @param URI             the api url.
		 * 
		 * @param authToken       the authorization token.
		 * 
		 * @return the delete response of type {@link Response}
		 */
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public static Response deleteWithQueryParameters(String authToken, Map queryParameters, String URI) {
			Response res = setAuthToken(authToken).params(queryParameters).when().delete(URI);
			REQUEST_DETAILS = requestDetails(authToken, URI, "");
			RESPONSE_DETAILS = responseDetails(res);
			return res;
		}

		/**
		 * The method wait for the specified number of seconds.
		 * 
		 * @param timeInSec time in seconds.
		 * 
		 * @throws InterruptedException if any error.
		 */
		public static void wait(int timeInSec) throws InterruptedException {
			Thread.sleep(TimeUnit.SECONDS.toSeconds(timeInSec));
		}

		private static final int defaultWaitForTimeout = WebDriverGlobalVariables.defaultWaitTimeOutApi;
		private static long currentMills;

		private static void setCurrentMillseconds() {
			currentMills = System.currentTimeMillis();
		}

		public static void throwErrorOnDefaultTimeout(Exception e) {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				throw new ExceptionInfoApi(e);
			}
		}

		public static void throwErrorOnDefaultTimeout(Exception e, String uri, Integer responseStatusCode, String payLoad,
				String responseMessage, Object actualValue, Object expectedValue, String customMessage) {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				throw new ExceptionInfoApi(e, uri, responseStatusCode, payLoad, responseMessage, actualValue, expectedValue,
						customMessage);
			}
		}

		public static void throwErrorOnDefaultTimeout(Exception e, String uri, Integer responseStatusCode, String payLoad,
				String responseMessage, String responseBody, Object actualValue, Object expectedValue,
				String customMessage) {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				throw new ExceptionInfoApi(e, uri, responseStatusCode, payLoad, responseMessage, responseBody, actualValue,
						expectedValue, customMessage);
			}
		}

		public static void throwErrorOnDefaultTimeout(String uri, Integer responseStatusCode, String payLoad,
				String responseMessage, String responseBody, Object actualValue, Object expectedValue,
				String customMessage) {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				throw new ExceptionInfoApi(uri, responseStatusCode, payLoad, responseMessage, responseBody, actualValue,
						expectedValue, customMessage);
			}
		}

		public static void throwErrorOnDefaultTimeout(String uri, Integer responseStatusCode, String payLoad,
				String responseMessage, Object actualValue, Object expectedValue, String customMessage) {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				throw new ExceptionInfoApi(uri, responseStatusCode, payLoad, responseMessage, actualValue, expectedValue,
						customMessage);
			}
		}

		public static void throwErrorOnDefaultTimeout(Exception e, String uri, Integer responseStatusCode,
				String responseMessage) {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				throw new ExceptionInfoApi(e, uri, responseStatusCode, responseMessage);
			}
		}

		public static void throwErrorOnDefaultTimeout(Exception e, String customMessage, Object actualValue,
				Object expectedValue) {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				throw new ExceptionInfoApi(e, customMessage, actualValue, expectedValue);
			}
		}

		public static void throwErrorOnMinimumTimeout(Exception e, String customMessage) {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				throw new ExceptionInfoApi(e, customMessage);
			}
		}

		public static void throwErrorOnMinimumTimeout(Exception e) {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				throw new ExceptionInfoApi(e);
			}
		}

		public boolean isDefaultMinimumTimeoutOver() {
			if (System.currentTimeMillis() - currentMills > (defaultWaitForTimeout * 1000)) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isGivenTimeoutOver(int timeout) {
			if (System.currentTimeMillis() - currentMills > (timeout * 1000)) {
				return true;
			} else {
				return false;
			}
		}

		@SuppressWarnings("unchecked")
		public static JSONObject requestDetails(String authToken, String url, String body) {
			JSONObject requestDetails = new JSONObject();
			requestDetails.put("url", url);
			if (!body.isEmpty())
				requestDetails.put("body", body);
			else
				requestDetails.put("body", "There no request body associated with the request.");

			if (!authToken.isEmpty())
				requestDetails.put("authToken", "Bearer " + authToken);
			else
				requestDetails.put("authToken", "There no auth token associated with the request.");
			return requestDetails;
		}

		@SuppressWarnings("unchecked")
		public static JSONObject responseDetails(Response response) {
			JSONObject responseDetails = new JSONObject();
			responseDetails.put("statusCode", response.getStatusCode());
			responseDetails.put("statusMessage", response.getStatusLine());
			if (response.getBody().asString().isEmpty() || response.getBody().asString() == null)
				responseDetails.put("body", "");
			else
				responseDetails.put("body", response.getBody().asString());
			return responseDetails;
		}

		/***
		 * The method asserts the the actual and expected values are equal.
		 * 
		 * @param actualValue     actual value to assert.
		 * 
		 * @param expectedValue   expected value to assert.
		 * 
		 * @param optionalMessage optional message .
		 * 
		 * @throws Exception
		 * 
		 */
		public static void assertValuesEqual(Object actualValue, Object expectedValue, String... optionalMessage)
				throws Exception {
			String message = "";
			if (optionalMessage.length != 0) {
				Reporter.log("Asserting " + optionalMessage[0].trim());
				message = optionalMessage[0].trim();
			} else {
				message = "Actual and Expected values do not match.\nActual value: " + actualValue + "\nExpected value: "
						+ expectedValue;
			}
			setCurrentMillseconds();
			try {
				if (actualValue instanceof String) {
					if (actualValue.equals(expectedValue)) {
					} else {
						throwErrorOnDefaultTimeout(REQUEST_DETAILS.get("url").toString(),
								Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
								REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
								RESPONSE_DETAILS.get("body").toString(), actualValue, expectedValue, message);
					}
				} else {
					if (actualValue == expectedValue) {
					} else
						throwErrorOnDefaultTimeout(REQUEST_DETAILS.get("url").toString(),
								Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
								REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
								RESPONSE_DETAILS.get("body").toString(), actualValue, expectedValue, message);
				}
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(e, REQUEST_DETAILS.get("url").toString(),
						Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
						REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
						RESPONSE_DETAILS.get("body").toString(), actualValue, expectedValue,
						"This is a failure. Please check your request details...!");
			}
		}

		/***
		 * The method asserts the given condition evaluates to true.
		 * 
		 * @param condition       value to assert to true.
		 * 
		 * @param optionalMessage optional message .
		 * 
		 * @throws Exception
		 * 
		 */
		public static void assertTrue(boolean condition, String... optionalMessage) throws Exception {
			String message = "";
			if (optionalMessage.length != 0) {
				Reporter.log("Asserting " + optionalMessage[0].trim());
				message = optionalMessage[0].trim();
			} else {
				message = "Condition evaluated to False";
			}
			setCurrentMillseconds();
			try {
				if (!condition) {
					throwErrorOnDefaultTimeout(REQUEST_DETAILS.get("url").toString(),
							Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
							REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
							RESPONSE_DETAILS.get("body").toString(), false, true, message);
				}
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(e, REQUEST_DETAILS.get("url").toString(),
						Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
						REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
						RESPONSE_DETAILS.get("body").toString(), false, true,
						"This is a failure. Please check your request details...!");
			}
		}

		/***
		 * The method asserts the given condition evaluates to false.
		 * 
		 * @param condition       value to assert to false.
		 * 
		 * @param optionalMessage optional message .
		 * 
		 * @throws Exception
		 * 
		 */
		public static void assertFalse(boolean condition, String... optionalMessage) throws Exception {
			String message = "";
			if (optionalMessage.length != 0) {
				Reporter.log("Asserting " + optionalMessage[0].trim());
				message = optionalMessage[0].trim();
			} else {
				message = "Condition evaluated to True";
			}

			setCurrentMillseconds();
			try {
				if (condition) {
					throwErrorOnDefaultTimeout(REQUEST_DETAILS.get("url").toString(),
							Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
							REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
							RESPONSE_DETAILS.get("body").toString(), true, false, message);
				}
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(e, REQUEST_DETAILS.get("url").toString(),
						Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
						REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
						RESPONSE_DETAILS.get("body").toString(), true, false,
						"This is a failure. Please check your request details...!");
			}
		}

		/***
		 * The method asserts the given value is null.
		 * 
		 * @param value           value to assert to null.
		 * 
		 * @param optionalMessage optional message .
		 * 
		 * @throws Exception
		 * 
		 */
		public static void assertNull(Object value, String... optionalMessage) throws Exception {
			String message = "";
			if (optionalMessage.length != 0) {
				Reporter.log("Asserting " + optionalMessage[0].trim());
				message = optionalMessage[0].trim();
			} else {
				message = "Condition evaluated to Not NUll. Value: " + value + " should be null";
			}
			setCurrentMillseconds();
			try {
				if (value != null) {
					throwErrorOnDefaultTimeout(REQUEST_DETAILS.get("url").toString(),
							Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
							REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
							RESPONSE_DETAILS.get("body").toString(), value, "Value: " + value + " should be null.",
							message);
				}
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(e, REQUEST_DETAILS.get("url").toString(),
						Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
						REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
						RESPONSE_DETAILS.get("body").toString(), value, "Value: " + value + " should be null.",
						"This is a failure. Please check your request details...!");
			}
		}

		/***
		 * The method asserts the given value is not null.
		 * 
		 * @param value           value to assert to not null.
		 * 
		 * @param optionalMessage optional message .
		 * 
		 * @throws Exception
		 * 
		 */
		public static void assertNotNull(Object value, String... optionalMessage) throws Exception {
			String message = "";
			if (optionalMessage.length != 0) {
				Reporter.log("Asserting " + optionalMessage[0].trim());
				message = optionalMessage[0].trim();
			} else {
				message = "Condition evaluated to NUll. Value: " + value + " should be not Null";
			}
			setCurrentMillseconds();
			try {
				if (value == null) {
					throwErrorOnDefaultTimeout(REQUEST_DETAILS.get("url").toString(),
							Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
							REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
							RESPONSE_DETAILS.get("body").toString(), value, "Value: " + value + " should be not null.",
							message);
				}
			} catch (Exception e) {
				throwErrorOnDefaultTimeout(e, REQUEST_DETAILS.get("url").toString(),
						Integer.parseInt(RESPONSE_DETAILS.get("statusCode").toString()),
						REQUEST_DETAILS.get("body").toString(), RESPONSE_DETAILS.get("statusMessage").toString(),
						RESPONSE_DETAILS.get("body").toString(), value, "Value: " + value + " should be not null.",
						"This is a failure. Please check your request details...!");
			}
		}

	}



