package com.ProjectName.PageObjectModelClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLinkdin_POM 
{

	WebDriver ldriver;
	
	
	
	@FindBy (xpath = "//input[@id='session_key']")
	WebElement username;
	
	@FindBy (xpath = "//input[@id='session_password']")
	WebElement password;
	
	@FindBy (xpath = "//button[contains(@data-id,'sign-in-form__submit-btn')]")
	WebElement signBtn;
	
	@FindBy (xpath = "//p[text()='The password you provided must have at least 6 characters']")
	WebElement errormsg;
	
	
	public LoginPageLinkdin_POM(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements( rdriver, this);
	}
	
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickSign()
	{
		signBtn.click();
	}
	
	public String errormessage()
	{
		String text = errormsg.getText();
		return text;
	}
	
	
	
}
