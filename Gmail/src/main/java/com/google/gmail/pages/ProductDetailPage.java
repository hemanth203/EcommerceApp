package com.google.gmail.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.gmail.generic.WebActionUtil;

public class ProductDetailPage extends BasePage
{	
	@FindBy(className="icon-plus")
	private WebElement plusIcon;
	
	@FindBy(className="icon-minus")
	private WebElement minusIcon;
	
	@FindBy(id="group_1")
	private WebElement sizeListBox;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']//a")
	private List<WebElement> colorPickerList;
	
	@FindBy(name="Submit")
	private WebElement addToKart;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	private WebElement continueShopping;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckout;
	
	@FindBy(className="cross")
	private WebElement closeButton;
	
	
	public ProductDetailPage(WebDriver driver, WebActionUtil webactionUtil) 
	{
		super(driver,webactionUtil);
	}
	
	public void increaseQuantity(int num)
	{
		for(int i=1;i<=num;i++)
		{
			webactionUtil.click(plusIcon);
		}
	}
	
	public void decreaseQuantity(int num)//2
	{
		for(int i=1;i<=num;i++)
		{
			webactionUtil.click(minusIcon);
		}
	}
	
	public void selectSize(String size)
	{
		webactionUtil.selectVisibleText(sizeListBox,size);
	}
	
	public void selectColor(String name)
	{
		for(WebElement color:colorPickerList)
		{
			if(color.getAttribute("name").equalsIgnoreCase(name))
			{
				webactionUtil.click(color);
				break;
			}
		}
	}
	
	public void clickOnAddToKart()
	{
		webactionUtil.jsClick(addToKart);
	}
	
	public OrderDetailPage clickOnProceedToCheckout()
	{
		webactionUtil.click(proceedToCheckout);
		return new OrderDetailPage(driver, webactionUtil);
	}
	
	public void clickOnContinueToShopping()
	{
		webactionUtil.click(continueShopping);
	}
	
	public void clickOnClose()
	{
		webactionUtil.click(closeButton);
	}
}
