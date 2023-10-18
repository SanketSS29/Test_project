package com.ProjectName.PageObjectModelClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ProjectName.Utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;

public class BaseClass
{
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseUrl = readconfig.getApplicationURL();
	
	public String Value = readconfig.getSearchValue();
	
	
	public static WebDriver driver;
	
	public ExtentSparkReporter sparkreport;
	public ExtentReports extent;
	
	public ExtentTest test;									//used in LoginTestVerification class
	
	static Random random = new Random();
	public static int number = random.nextInt(10) ;
	

	
	@BeforeSuite
	public void setReport()
	{
		
//		LocalDateTime ldt = LocalDateTime;
		
		sparkreport = new  ExtentSparkReporter("C:\\Users\\Om Computers\\eclipse-workspace\\TestProject\\Report\\htmlreport"+LocalDate.now()+" "+number+".html");
	
		extent = new ExtentReports();
		
		extent.attachReporter(sparkreport);
		extent.setSystemInfo("Project Name", "Ramdom");
		extent.setSystemInfo("Operating System", "Windows");
		extent.setSystemInfo("Environment", "QA");
		
		sparkreport.config().setReportName("Test Execution");
		sparkreport.config().setDocumentTitle("QA Automation Testing Report");
		sparkreport.config().setTheme(Theme.STANDARD);
		
		test = extent.createTest("Verify Application opening");					//title for verification
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void SetupMethod(String str)
	{
		if(str.equals("chrome"))
		{
			driver = new ChromeDriver();
			test.log(Status.PASS, "Tetsting perform on CHROME browser");
		}
		
		else if(str.equals("firefox"))
		{
			driver = new FirefoxDriver();
			test.log(Status.PASS, "Tetsting perform on FIREFOX browser");
		}
		
		else if(str.equals("edge"))
		{
			driver = new EdgeDriver();
			test.log(Status.PASS, "Tetsting perform on EDGE browser");
		}
		
		
		driver.get(BaseUrl);
		test.log(Status.PASS, "Application URL open successfully");
		
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass
	public void ClosedBrowserMethod()
	{
		driver.quit();
	}

	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}
	
	
	
}
