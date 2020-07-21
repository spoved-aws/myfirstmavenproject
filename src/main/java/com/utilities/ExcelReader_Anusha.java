package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader_Anusha {
	
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static File file;
	public static FileInputStream ip;
	 
	public static Object[][] getData(String sheetName) {
		
		file = new File("C:\\Users\\anush\\eclipse-workspace\\myFirstMavenProject\\src\\main\\java\\com\\testdata\\TestData.xlsx");
		try {
			ip = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book  = new XSSFWorkbook(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object dataArray[][] = new Object[rowCount][colCount];
		
		for (int i=0; i<rowCount; i++) {
			
			for(int j=0; j<colCount; j++) {
				
				dataArray[i][j] = sheet.getRow(i+1).getCell(j).toString();
				
				
			}
		}
		
		return dataArray;
		
		
		
		
		
	}

}
