package com.squarepanda.generalUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtility {

	public static void main(String argv[]) {
		getDeviceSpecificDetails();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> devicesInExecution() {
		List deviceExecutionList = new ArrayList<String>();
		String executionDevice = LoadProperties.getProjectProperities("executionOn");
		if (executionDevice.contains(",")) {
			String devices[] = executionDevice.split(",");
			deviceExecutionList.add(0, devices[0]);
			deviceExecutionList.add(1, devices[1]);
		} else {
			deviceExecutionList.add(executionDevice);
		}
		return (ArrayList<String>) deviceExecutionList;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject getDeviceSpecificDetails() {
		JSONObject details = new JSONObject();
		ArrayList<String> devices = devicesInExecution();
		System.out.println("Automation is executing on device(s): " + devices.toString());
		if (devices.size() == 1) {
			details.put(devices.get(0).toString().toLowerCase(), getDeviceInformation(devices.get(0).toString()));
			System.out.println("Device information is:: \n" + details.toJSONString());
			return (JSONObject) details;
		} else if (devices.size() > 1) {
			if (devices.get(0).equalsIgnoreCase("ios")) {
				details.put("ios", getDeviceInformation("ios"));
			}
			if (devices.get(1).equalsIgnoreCase("android")) {
				details.put("android", getDeviceInformation("android"));
			}
			System.out.println("Device information is:: " + details.toJSONString());
			return details;

		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject getDeviceInformation(String whichPlatform) {
		JSONObject deviceDetails = new JSONObject();
		JSONObject keyValues = new JSONObject();
		File xmlFile = null;

		try {
			if (whichPlatform.equalsIgnoreCase("ios")) {
				xmlFile = new File(System.getProperty("user.dir") + "//execute_ios_test.xml");
			} else if (whichPlatform.equalsIgnoreCase("android")) {
				xmlFile = new File(System.getProperty("user.dir") + "//execute_android_test.xml");
			}

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("test");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					NodeList parameters = eElement.getElementsByTagName("parameter");
					for (int j = 0; j < parameters.getLength(); j++) {
						Node parameterNode = parameters.item(j);
						keyValues.put(((Element) parameterNode).getAttribute("name"),
								((Element) parameterNode).getAttribute("value"));
					}

				}
				deviceDetails.put("device" + (i + 1), keyValues);
				keyValues = new JSONObject();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return deviceDetails;
		
	}
	
}
