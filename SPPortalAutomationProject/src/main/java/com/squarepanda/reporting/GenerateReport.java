package com.squarepanda.reporting;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

//import org.json.simple.JSONObject;
//
//import com.squarepanda.generalUtility.JsonUtility;
//import com.squarepanda.generalUtility.LoadProperties;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/*********
 * Utility to to generate cucumber report
 * 
 * @author Zaid Momin
 *
 */
public class GenerateReport {

	public static void generateReport(String projectName, String reportFolderName) {
		try {
			generateCucumberReport(projectName, reportFolderName);
		} catch (Exception e) {
			System.out.println("Not able to create cucumber reports:: " + e.getMessage());
		}
	}

	public static void generateCucumberReport(String projectName, String reportFolderName)
			throws ParseException {
		File reportOutputDirectory = new File(reportFolderName);
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add(System.getProperty("user.dir") + "/" + reportFolderName + "/cucumber.json");
//		if (!LoadProperties.getProjectProperities("singleDevice").equalsIgnoreCase("true")) {
//			jsonFiles.add(System.getProperty("user.dir") + "/" + reportFolderName + "/cucumber-1.json");
//		}
		String buildNumber = "Version 1";
		String projName = projectName + " Automation Report";
		boolean runWithJenkins = false;
		Configuration configuration = new Configuration(reportOutputDirectory, projName);
		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);
//		String deviceNames = "", platformVersions = "", deviceUdids = "";
//		JSONObject deviceOneDetails;
//		JSONObject deviceTwoDetails;

//		if (executionPlatform.equalsIgnoreCase("android")) {
//			deviceOneDetails = JsonUtility
//					.getDeviceInformation(LoadProperties.getProjectProperities("androidDeviceName1"));
//			if (!LoadProperties.getProjectProperities("singleDevice").equalsIgnoreCase("true")) {
//				deviceTwoDetails = JsonUtility
//						.getDeviceInformation(LoadProperties.getProjectProperities("androidDeviceName2"));
//				deviceNames = deviceOneDetails.get("deviceName").toString() + ", "
//						+ deviceTwoDetails.get("deviceName").toString();
//				platformVersions = deviceOneDetails.get("platformVersion").toString() + ", "
//						+ deviceTwoDetails.get("platformVersion").toString();
//				deviceUdids = deviceOneDetails.get("deviceUdid").toString() + ", "
//						+ deviceTwoDetails.get("deviceUdid").toString();
//			} else {
//				deviceNames = deviceOneDetails.get("deviceName").toString();
//				platformVersions = deviceOneDetails.get("platformVersion").toString();
//				deviceUdids = deviceOneDetails.get("deviceUdid").toString();
//
//			}
//			configuration.addClassifications("Platform Name", "Android");
//			configuration.addClassifications("Device Name", deviceNames);
//			configuration.addClassifications("Platform Version", platformVersions);
//			configuration.addClassifications("Device UDID", deviceUdids);
//		} else if (executionPlatform.equalsIgnoreCase("ios")) {
//			deviceOneDetails = JsonUtility.getDeviceInformation(LoadProperties.getProjectProperities("iosDeviceName1"));
//			if (!LoadProperties.getProjectProperities("singleDevice").equalsIgnoreCase("true")) {
//				deviceTwoDetails = JsonUtility
//						.getDeviceInformation(LoadProperties.getProjectProperities("iosDeviceName2"));
//				deviceNames = deviceOneDetails.get("deviceName").toString() + ", "
//						+ deviceTwoDetails.get("deviceName").toString();
//				platformVersions = deviceOneDetails.get("platformVersion").toString() + ", "
//						+ deviceTwoDetails.get("platformVersion").toString();
//				deviceUdids = deviceOneDetails.get("deviceUdid").toString() + ", "
//						+ deviceTwoDetails.get("deviceUdid").toString();
//			} else {
//				deviceNames = deviceOneDetails.get("deviceName").toString();
//				platformVersions = deviceOneDetails.get("platformVersion").toString();
//				deviceUdids = deviceOneDetails.get("deviceUdid").toString();
//			}
//			configuration.addClassifications("Platform Name", "iOS");
//			configuration.addClassifications("Device Name", deviceNames);
//			configuration.addClassifications("Platform Version", platformVersions);
//			configuration.addClassifications("Device UDID", deviceUdids);
//		 if (executionPlatform.equalsIgnoreCase("api")) {
//			configuration.addClassifications("Platform Name", "API");
//		}

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
	}
}
