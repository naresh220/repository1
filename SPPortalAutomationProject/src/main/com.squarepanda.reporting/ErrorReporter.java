package com.squarepanda.reporting;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.squarepanda.appiumUtility.GenericMethods;

/**
 * @author Zaid.Momin
 * 
 */
public class ErrorReporter {
	GenericMethods genericMethods = new GenericMethods();

	// main method for test purpose only
	public static void main(String[] args) throws Exception {
		reportError(new ExceptionInfo(new Exception(), "this is custom message"));
	}

	public static void reportError(Exception e, boolean showFullStackTrace) throws Exception {
		createErrorMapAndThrowException(e, showFullStackTrace);
	}

	public static void reportError(Exception e) throws Exception {
		createErrorMapAndThrowException(e, false);
	}

	private static void createErrorMapAndThrowException(Exception e, boolean showFullStackTrace) throws Exception {
		Map<String, String> errors;
		errors = new LinkedHashMap<String, String>();
		// errors.put("", "");
		errors.put("Page Name", GenericMethods.getPageName());

		if (e instanceof ExceptionInfo) {
			ExceptionInfo info = (ExceptionInfo) e;
			if (!info.getException().getClass().getSimpleName().toLowerCase().contains("null")) {
				if (info.getException().getClass().getSimpleName().toLowerCase().equalsIgnoreCase("ExceptionInfo")) {
					errors.put("Failure Reason", "Assertion Failure");
				} else {
					errors.put("Failure Reason", info.getException().getClass().getSimpleName());
				}
			}
			if (info.getCustomMessage() != null) {
				errors.put("Custom Message", info.getCustomMessage());
			}
			if (info.getUiElement() != null) {
				errors.put("Locator", info.getUiElement().toString());
			}
			if (info.getAssertionType() != null)
				errors.put("Assertion Type", info.getAssertionType());
			if (info.getActualValue() != null)
				errors.put("Actual Value", info.getActualValue().toString());
			if (info.getExpectedValue() != null)
				errors.put("Expected Value", info.getExpectedValue().toString());
			errors.put("Timeout", GenericMethods.defaultWaitForTimeout + "");
			String configurations = "";
			configurations += "Configurations: " + new GenericMethods().getDriver().getCapabilities().toString();

			errors.put("Configurations", configurations);

		}

		else if (e instanceof ExceptionInfoApi) {
			ExceptionInfoApi info = (ExceptionInfoApi) e;

			if (!info.getException().getClass().getSimpleName().toLowerCase().contains("null")) {
				if (info.getException().getClass().getSimpleName().toLowerCase().equalsIgnoreCase("ExceptionInfoApi")) {
					errors.put("Failure Reason", "Assertion Failure");
				} else {
					errors.put("Failure Reason", info.getException().getClass().getSimpleName());
				}
			}
			if (info.getCustomMessage() != null) {
				errors.put("Custom Message", info.getCustomMessage());
			}

			if (info.getUri() != null) {
				errors.put("URI for api", info.getUri().toString());
			}

			if (info.getResponseMessage() != null) {
				errors.put("Status Message", info.getResponseMessage().toString());
			}

			if (info.getPayLoad() != null) {
				errors.put("Payload provided is ", info.getPayLoad().toString());
			}

			if (info.getResponseStatusCode() != null) {
				errors.put("Status Code", info.getResponseStatusCode().toString());
			}
			if (info.getResponseBody() != null) {
				errors.put("Response Body", info.getResponseBody().toString());
			}
			if (info.getActualValue() != null)
				errors.put("Actual Value", info.getActualValue().toString());
			if (info.getExpectedValue() != null)
				errors.put("Expected Value", info.getExpectedValue().toString());
		}

		if (e instanceof ExceptionInfo) {
			ExceptionInfo info = (ExceptionInfo) e;
			if (!info.getException().getClass().getSimpleName().toLowerCase().contains("null")) {
				errors.put("WebDriver Exception Trace",
						"<xmp>" + getStackTraceAsString(info.getException(), showFullStackTrace) + "</xmp>");
			}
		}

		errors.put("Exception Stack Trace", getStackTraceAsString(e, showFullStackTrace));
		String formattedErrorString = generateFormattedErrorString(errors);
		throw new Exception(formattedErrorString);

	}

	/**
	 * Generated formatted string using error's map.
	 * 
	 * @param errors
	 * @return
	 */
	private static String generateFormattedErrorString(Map<String, String> errors) {
		String formattedErrors = new String();
		Set<String> keys = errors.keySet();
		for (String key : keys) {
			if (errors.get(key) != null)
				formattedErrors = formattedErrors + String.format("\n%-25s%-3s%s", key, ":", errors.get(key));
		}
		return formattedErrors.toString();
	}

	/**
	 * Convert stack trace to string and return full stack trace if
	 * showFullStackTrace is true otherwise 1300 character.
	 * 
	 * @param e
	 * @return
	 * @throws IOException
	 */
	private static String getStackTraceAsString(Exception e, boolean showFullStackTrace) throws IOException {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		sw.close();
		String trace = sw.toString();
		if (showFullStackTrace) {
			return trace;
		}
		if (trace.length() >= 1300) {
			trace = trace.substring(0, 1300);
		}
		return trace;
	}
}
