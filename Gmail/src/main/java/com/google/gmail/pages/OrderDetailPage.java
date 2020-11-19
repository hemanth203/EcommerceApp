package com.google.gmail.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.gmail.generic.WebActionUtil;

public class OrderDetailPage extends BasePage 
{
	
	@FindBy(xpath="//tbody/tr")
	private List<WebElement> productsList;
	
	public OrderDetailPage(WebDriver driver, WebActionUtil webactionUtil) 
	{
		super(driver,webactionUtil);
	}
	
	public boolean isProductDisplayed(String productId)
	{
		productId="product_"+productId;
		for(WebElement product:productsList)
		{
			if(product.getAttribute("id").contains(productId))
			{
				return true;
			}
		}
		return false;
	}
}
