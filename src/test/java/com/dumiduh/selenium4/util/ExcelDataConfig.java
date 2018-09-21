package com.dumiduh.selenium4.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

private XSSFWorkbook wb;
private XSSFSheet sheet;

	public ExcelDataConfig(String filePath) {
		
		try {
			File f = new File(filePath);
			FileInputStream stream = new FileInputStream(f);
			wb = new XSSFWorkbook(stream);
			
		}catch(Exception f){
			
		}
	}
	
	public String getData(int a, int b, int c) {
		sheet = wb.getSheetAt(a);
		String r = sheet.getRow(b).getCell(c).getStringCellValue();
		
		return r;
	}
	
	public int getRowCount(int sheetIndex) {
		
		int r = wb.getSheetAt(sheetIndex).getLastRowNum();
		r = r+1;
		
		return r;
	}
	
	public int getColumnCount(int sheetIndex) {
		int r = wb.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
		
		return r;
	}
}
