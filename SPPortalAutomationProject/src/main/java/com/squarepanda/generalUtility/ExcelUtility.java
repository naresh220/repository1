package com.squarepanda.generalUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ExcelUtility(String xlFilePath) throws Exception {
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	public ExcelUtility() {
		// TODO Auto-generated constructor stub
	}

	public int getTotalCountOfRowsInExcelFile(String sheetName) throws IOException {
		if (!sheetName.isEmpty()) {
			sheet = workbook.getSheet(sheetName);
		} else {
			sheet = workbook.getSheetAt(0);
		}

		return sheet.getPhysicalNumberOfRows() - 1;
	}

	public HashMap<String, String> getRowsContent(String sheetName, int rowNumber) throws IOException {
		HashMap<String, String> rowContents = new HashMap<>();
		try {
			if (!sheetName.isEmpty()) {
				sheet = workbook.getSheet(sheetName);
			} else {
				sheet = workbook.getSheetAt(0);
			}
			row = sheet.getRow(rowNumber);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				String header = sheet.getRow(0).getCell(i).getStringCellValue();
				String value = row.getCell(i).getStringCellValue();

				rowContents.put(header, value);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("\n Contents of row " + rowNumber + " ==>" + rowContents);
		return rowContents;
	}
}
