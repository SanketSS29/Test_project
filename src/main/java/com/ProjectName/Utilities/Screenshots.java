package com.ProjectName.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ProjectName.PageObjectModelClass.BaseClass;

public class Screenshots extends BaseClass
{
	public static String CaptureScreenshot() throws IOException
	{
		TakesScreenshot tss =  (TakesScreenshot)driver;
		
		File source = tss.getScreenshotAs(OutputType.FILE);
		
		String destination = "C:\\Users\\Om Computers\\eclipse-workspace\\TestProject\\Screenshots\\fail_cases"+LocalDate.now()+" "+number+".png";
		
		FileUtils.copyFile(source, new File(destination));
		
		return destination;
		
		
	}

}
