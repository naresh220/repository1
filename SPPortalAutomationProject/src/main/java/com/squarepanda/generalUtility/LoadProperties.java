package com.squarepanda.generalUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * The class includes all the generic functions required to load the properties
 * from properties files.
 * 
 * @author Zaid Momin
 * @since 06-11-2018
 */

public class LoadProperties {

//	public static String getPlatformSpecificProperities(String key, String invokeDriver) {
//		Properties platformSpecificProperties = new Properties();
//		InputStream input = null;
//		String platform = null;
//		if (invokeDriver.equalsIgnoreCase("android"))
//			platform = "android";
//		else if (invokeDriver.equalsIgnoreCase("ios"))
//			platform = "iOS";
//
//		try {
//			input = new FileInputStream(new File(
//					System.getProperty("user.dir") + "//src//test//java//config//" + platform + "_config.properties"));
//			platformSpecificProperties.load(input);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return platformSpecificProperties.getProperty(key);
//	}

	public static String getProjectProperities(String key) {
		Properties projectProperties = new Properties();
		FileInputStream input = null;

		/***
		 * First check if the property value is supplied from jenkins or command line.
		 * If yes then pick up the supplied property's value else pick the value from
		 * Project.properties file.
		 **/
		if (System.getProperty(key) == null || System.getProperty(key).isEmpty()) {
			try {
				input = new FileInputStream(
						new File(System.getProperty("user.dir") + "//src//test//resources//Project.properties"));
				projectProperties.load(input);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return projectProperties.getProperty(key);
		} else {
			return System.getProperty(key);
		}

	}

	public static String getConstantsBasedOnLanguage(String key) {
		Properties languageSpecificProperties = new Properties();
		InputStream input = null;
		String language = getProjectProperities("language");

		try {
			input = new FileInputStream(new File(System.getProperty("user.dir") + "//src//test//java//config//"
					+ language.toLowerCase() + "_constants.properties"));
			languageSpecificProperties.load(input);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return languageSpecificProperties.getProperty(key);

	}

	public static void updateProjectProperties(String keyToUpdate, String valueToUpdate) throws ConfigurationException {
		File file = new File(System.getProperty("user.dir") + "//src//test//resources//Project.properties");
		PropertiesConfiguration props = new PropertiesConfiguration(file);
		props.setProperty(keyToUpdate, valueToUpdate);
		props.save();
		System.out.println("Successfully updated key: " + keyToUpdate + " with value: " + valueToUpdate + " in file: "
				+ file.getName());
	}

	public static String getEnvironment() {
		return getProjectProperities("environment").toString().trim();
	}

	public static String getRestServiceEndpoints(String endpointKey) {
		Properties restServiceEndPoints = new Properties();
		try {
			String fileName = null;
			String environment = getEnvironment();
			if (environment.equalsIgnoreCase("dev")) {
				fileName = "dev_api_urls.properties";
			} else if (environment.equalsIgnoreCase("qa")) {
				fileName = "qa_api_urls.properties";
			} else if (environment.equalsIgnoreCase("prod")) {
				fileName = "prod_api_urls.properties";
			}
			restServiceEndPoints.load(new FileInputStream(new File(System.getProperty("user.dir") + "//" + fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return restServiceEndPoints.getProperty(endpointKey);
	}
}
