package com.ProjectName.Testclass;

import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Test;


import com.ProjectName.PageObjectModelClass.BaseClass;
import com.ProjectName.PageObjectModelClass.LoginPage_POM;
import com.ProjectName.Utilities.Screenshots;
import com.aventstack.extentreports.Status;

public class LoginTestVerification extends BaseClass
{
	@Test 
	public void Method_LoginTest() throws IOException
	{
		LoginPage_POM login = new LoginPage_POM(driver);
		
		
		login.searchValue(Value);
		test.log(Status.PASS, "Value entered successfully");
		
//		login.clickButton();
		
		String expectedTitle = "Google1";
		
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle))
		{
			test.log(Status.PASS, "Title verification complete");
		}
		else {
			test.log(Status.FAIL, "Title verification Failed");
			
			String ScreenshotPath = Screenshots.CaptureScreenshot();
			test.addScreenCaptureFromPath(ScreenshotPath);
		}
		
		System.out.println("login complete");
	}
	

}
