package com.squarepanda.generalUtility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The class the required file operation methods.
 * 
 * @author Zaid Momin
 * @since 08-04-2019
 */
public class FileUtility {

	public static JSONObject fetchJsonObjectFromJSONFile(String filePathToReadFrom) {
		Object object = null;
		try {
			JSONParser jsonParser = new JSONParser();
			File file = new File(filePathToReadFrom);
			object = jsonParser.parse(new FileReader(file));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return (JSONObject) object;
	}

	public static void insertJSONObjectInJSONFile(String filePathToWriteTo, JSONObject jsonObjectToWrite) {
		try (FileWriter file = new FileWriter(filePathToWriteTo)) {

			file.write(jsonObjectToWrite.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
