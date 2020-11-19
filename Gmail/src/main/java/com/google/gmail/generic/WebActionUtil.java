package com.google.gmail.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil
{
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;
	public WebActionUtil(WebDriver driver, long eto)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, eto);
		js= (JavascriptExecutor)driver;
		actions = new Actions(driver);
	}
	
	public void closeWindow()
	{
		try
		{
			driver.quit();
		}
		catch(Exception e)
		{
			Robot robot;
			try
			{
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_F4);
				robot.keyRelease(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_F4);
			} 
			catch(AWTException e2) 
			{
				e2.printStackTrace();
			}
		}
		
		
	}
	
	public void enterData(WebElement targetElement, String TextToEnter)
	{
		try
		{
			targetElement.clear();
			targetElement.sendKeys(TextToEnter);
		}
		catch(Exception e)
		{
			js.executeScript("arguments[0].value='';", targetElement);
			js.executeScript("arguments[0].value='"+TextToEnter+"';", targetElement);
		}
	}
	
	public void click(WebElement targetElement)
	{
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(targetElement));
			targetElement.click();
		}
		catch(Exception e)
		{
			js.executeScript("arguments[0].click();", targetElement);
		}
	}
	
	public void jsClick(WebElement targetElement)
	{
		js.executeScript("arguments[0].click();", targetElement);
	}
	
	public void clickImage(WebElement targetElement)
	{
		wait.until(ExpectedConditions.visibilityOf(targetElement));
		targetElement.click();
	}
	
	public void scrollUp(int pixels)
	{
		js.executeScript("window.scrollBy(0,"+pixels+");");
	}
	
	public void scrollDown(int pixels)
	{
		js.executeScript("window.scrollBy(0,-"+pixels+");");
	}
	
	public void scrollToElement(WebElement targetElement)
	{
		js.executeScript("arguments[0].scrollIntoView();", targetElement);
	}
	
	public void contextClick(WebElement targetElement)
	{
		actions.contextClick(targetElement).perform();
	}
	
	public void doubleClick(WebElement targetElement)
	{
		actions.doubleClick(targetElement).perform();
	}
	
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement)
	{
		actions.dragAndDrop(sourceElement,targetElement).perform();
	}

	public void selectVisibleText(WebElement listbox, String size) 
	{
		Select select = new Select(listbox);
		select.selectByVisibleText(size);
	}
}
