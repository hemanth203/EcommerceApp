package com.google.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.gmail.generic.WebActionUtil;

public class LoginPage extends BasePage
{
	@FindBy(partialLinkText="Sign in")
	private WebElement signIn;
	
	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="passwd")
	private WebElement password;
		
	@FindBy(id="SubmitLogin")
	private WebElement login;
	
	public LoginPage(WebDriver driver, WebActionUtil webactionUtil) 
	{
		super(driver,webactionUtil);
	}
	
	public void login(String usernameValue, String passwordValue)
	{
		webactionUtil.click(signIn);
		webactionUtil.enterData(username, usernameValue);
		webactionUtil.enterData(password, passwordValue);
		webactionUtil.click(login);
	}
	
}
