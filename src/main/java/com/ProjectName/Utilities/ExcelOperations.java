package com.ProjectName.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations 
{
	
	static public FileInputStream fileIn;
	static public FileOutputStream fileOut;
	static public XSSFWorkbook workbook;
	static public XSSFSheet sheet;
	static public XSSFRow row;
	static public XSSFCell cell;
	static public CellStyle style;
//	static String path = null;
	
	
//	ExcelOperations(String path)				//used of this constructor is to assign the path of sheet to the local variable (i.e. path) after creating the object
//	{
//		this.path = path;
//	}

	
	public static int getRowCount(String filepath, String xlsheet) throws IOException 
	{
		fileIn = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheet(xlsheet);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fileIn.close();
		return rowCount;
	}
	
	
	public static int getCellCount(String filepath, String xlsheet, int rownum) throws IOException
	{
		fileIn = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fileIn.close();
		return cellCount;
	}
	
	
	public static String getCellData(String filepath, String xlsheet, int rownum, int colnum) throws IOException 
	{
		fileIn = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try 
		{
			data = formatter.formatCellValue(cell);		// Returns the formatted value of a cell as a String regardless of the cell type
		}
		catch (Exception e) 							// If data is not available in cell then throws exception so thats why we added catch block with 'No Data' exception
		{
			data = " No Data";							// Or we take it as a blank also
		}
		workbook.close();
		fileIn.close();
		return data;
	}
	
		
	public static void setCellData(String filepath, String xlsheet, int rownum, int colnum, String data) throws IOException			//If we want to write result into excel used this method 
	{						
		fileIn = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheet(xlsheet);
		
		row = sheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);						// Here set the data or pass the data
		
		fileOut = new FileOutputStream(filepath);			// we update this data so we used this 
		workbook.write(fileOut);
		workbook.close();
		fileIn.close();
		fileOut.close();
	}
	
	
	public static void fillRedColor(String filepath, String xlsheet,  int rownum, int colnum) throws IOException			//used for failed value to show in Red color
	{
		fileIn = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheet(xlsheet);
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();							//applying foreground color used this method return CellStyle object (from line no.25)
		
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);		//fill pattern & IndexedColors are the enumeration values, indicating the style of being used for a cell format.
		
		cell.setCellStyle(style);									//giving the color and patter to selected cell
		workbook.write(fileOut);
		workbook.close();
		fileIn.close();
		fileOut.close();
	}
	
	
	public static void fillGreenColor(String filepath, String xlsheet, int rownum, int colnum) throws IOException			//used for passed value to show in Green color
	{
		fileIn = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fileIn);
		sheet = workbook.getSheet(xlsheet);
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workbook.createCellStyle();							
		
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);		
		
		cell.setCellStyle(style);									
		workbook.write(fileOut);
		workbook.close();
		fileIn.close();
		fileOut.close();
	}
	
}
