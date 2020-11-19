package com.google.gmail.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.gmail.generic.WebActionUtil;

public class ProductsPage extends BasePage 
{
	@FindBy(xpath="//ul[@class='product_list grid row']//a[@class='product_img_link']")
	private List<WebElement> productsList;
	
	public ProductsPage(WebDriver driver, WebActionUtil webactionUtil) 
	{
		super(driver,webactionUtil);
	}
	
	public ProductDetailPage selectProduct(String productId)
	{
		productId = "id_product="+productId;
		for(WebElement product:productsList)
		{
			if(product.getAttribute("href").contains(productId))
			{
				webactionUtil.jsClick(product);
				break;
			}
		}
		return new ProductDetailPage(driver, webactionUtil);
	}
}
