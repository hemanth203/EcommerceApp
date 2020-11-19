package com.google.gmail.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetPicture
{
	public static String getSnapshot(WebDriver driver, String imagePath, String testCaseName)
	{
		String date = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String path = imagePath+date+testCaseName+".png";
		File destFile=new File(path);
		try 
		{
			FileUtils.copyFile(srcFile, destFile);
			return path;
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
