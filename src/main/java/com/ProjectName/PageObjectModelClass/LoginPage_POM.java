package com.ProjectName.PageObjectModelClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_POM 
{
	WebDriver ldriver;
	
	
	@FindBy(xpath = "//textarea[@class='gLFyf'] ")								//elements
	WebElement Search;

	@FindBy(xpath = "(//input[@value='Google Search'])[1]")
	WebElement Searchbtn;
	
	
	public LoginPage_POM(WebDriver rdriver)					//constructor
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	public void searchValue(String name)
	{
		Search.sendKeys(name);
	}
	
	public void clickButton()
	{
		Searchbtn.click();
	}
	
	
	
}


