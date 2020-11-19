package com.google.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.google.gmail.generic.WebActionUtil;

public class BasePage
{
	WebDriver driver;
	WebActionUtil webactionUtil;
	public BasePage(WebDriver driver, WebActionUtil webactionUtil) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.webactionUtil=webactionUtil;
	}
}
