package com.ProjectName.Testclass;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ProjectName.PageObjectModelClass.BaseClass;
import com.ProjectName.PageObjectModelClass.LoginPageLinkdin_POM;
import com.ProjectName.Utilities.ExcelOperations;
import com.aventstack.extentreports.Status;


public class DataFromExcelSheet extends BaseClass
{
	
	@Test(dataProvider ="logindata") 
	public void enterData(String id, String name, String eg)
	{
		test = extent.createTest("Verify Application login");					//title for verification
		
		LoginPageLinkdin_POM lpl = new LoginPageLinkdin_POM(driver);
		
		lpl.setUsername(id);
		test.log(Status.PASS, "username entered");
		
		lpl.setPassword(name);
		test.log(Status.PASS, "password entered");
		
		lpl.clickSign();
		test.log(Status.PASS, "button clicked");
		
		String expectedres = "The password you provided must have at least 6 characters";
		
		String actualres = lpl.errormessage();
		
		if(expectedres.equals(actualres))
		{
			driver.navigate().refresh();
			driver.switchTo().defaultContent();
			test.log(Status.PASS, "data Invalid so login failed");
		}
		
		
	}
	
	

	
	
	
	@DataProvider(name ="logindata")
	public String[][] getData() throws IOException
	{
		String path = "C:\\Users\\Om Computers\\eclipse-workspace\\TestProject\\Report\\empdata.xlsx";
		
		int rownum = ExcelOperations.getRowCount (path, "data");
		int colcount = ExcelOperations.getCellCount(path, "data", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j] = ExcelOperations.getCellData(path, "data", i, j);
			}
		}
		System.out.println("file submitted");
		return logindata;
		
		
	}
	
	
	
	

}
