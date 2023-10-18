package com.ProjectName.Utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreatingExcelFile 
{
	
	public void CreateExcelFile() throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("data");
		
		Object empdata [][] = { {"id", "name", "pw"},
								{101, "abc", 123},
								{102, "pqr", 456},
								{103, "xyz", 789},
								{111, "asd", 1235}
							  };
		
		
		int rows = empdata.length;
		int cols =  empdata[0].length;
		
		System.out.println(rows);
		System.out.println(cols);
		
//		for(int r=0; r<rows; r++)									//using for loop
//		{
//			XSSFRow row = sheet.createRow(r);
//			
//			for(int c=0; c<cols; c++)
//			{
//				XSSFCell cell=  row.createCell(c);
//				Object value = empdata[r][c];
//				
//				if (value instanceof String)
//				{
//					cell.setCellValue((String) value);
//				}
//				if (value instanceof Integer)
//				{
//					cell.setCellValue((Integer) value);
//				}
//				if (value instanceof Boolean)
//				{
//					cell.setCellValue((Boolean) value);
//				}
//			}	
//		}
		
		
		int rowCount = 0;											//using for each loop
		
		for(Object emp[] : empdata)
		{
			XSSFRow row = sheet.createRow(rowCount++);
			int columnCount = 0;
			
			for(Object value : emp)
			{
				XSSFCell cell = row.createCell(columnCount++);
				
				if (value instanceof String)
				{
					cell.setCellValue((String) value);
				}
				if (value instanceof Integer)
				{
					cell.setCellValue((Integer) value);
				}
				if (value instanceof Boolean)
				{
					cell.setCellValue((Boolean) value);
				}
				
			}
		}
		
		
		
		String filePath = "C:\\Users\\Om Computers\\eclipse-workspace\\TestProject\\Report\\empdata.xlsx";
		FileOutputStream outputStram = new FileOutputStream(filePath);
		workbook.write(outputStram);
		
		outputStram.close();
		System.out.println("file created");
	}
	
	
	

}
