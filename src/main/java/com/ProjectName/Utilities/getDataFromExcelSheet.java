package com.ProjectName.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getDataFromExcelSheet 
{
	
	public static String getDataFromExcel(int i, int j) throws IOException
	{
//	give excel sheet path here
	
	File file = new File("C:\\Users\\Om Computers\\eclipse-workspace\\TestProject\\Report\\htmlreport2023-10-118.html");
	
	FileInputStream inputstream = new FileInputStream(file);	//Excel file convert into InputStream
	
//	WorkbookFactory method supports only one format of excel file
//	XSSFWorkbook method supports all formats of excel file
	
	XSSFWorkbook wb = new XSSFWorkbook(inputstream);			//Excel application open
	
	XSSFSheet sheet = wb.getSheet("Sheet1");					//taking 1st Excel Sheet (enter Sheet Name)
	
	XSSFRow row =  sheet.getRow(i);								//taking 'i' row
	
	XSSFCell cell = row.getCell(j);								//taking 'j' column
	
	String data = cell.getStringCellValue();					//getting value of row and cell in string value
	
	return data;
	
	}

}
