package com.google.gmail.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.gmail.generic.WebActionUtil;

public class HomePage extends BasePage
{
	@FindBy(linkText="Women")
	private WebElement womenMenu;
	
	@FindBy(xpath="(//a[.='Dresses'])[2]")
	private WebElement dressesMenu;
	
	@FindBy(xpath="(//a[.='T-shirts'])[2]")
	private WebElement tShirtsMenu;
	
	@FindBy(partialLinkText="Sign out")
	private WebElement logoutLink;
	
	@FindBy(xpath="	//a[@title='View my shopping cart']")
	private WebElement viewKart;
	
	public HomePage(WebDriver driver, WebActionUtil webactionUtil) 
	{
		super(driver,webactionUtil);
	}
	
	public ProductsPage clickMenuItem(String menuName)
	{
		switch(menuName)
		{
			case "women":webactionUtil.click(womenMenu);
						 break;
			case "dresses":webactionUtil.click(dressesMenu);
						   break;
			case "tshirts":webactionUtil.click(tShirtsMenu);
						   break;
		}
		return new ProductsPage(driver,webactionUtil);
	}
	
	public OrderDetailPage clickOnViewKart()
	{
		webactionUtil.click(viewKart);
		return new OrderDetailPage(driver, webactionUtil);
	}
	
	public void logout()
	{
		webactionUtil.click(logoutLink);
	}
}
