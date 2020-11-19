package com.google.gmail.generic;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileLibrary
{
	public static String getData(String filePath, String key)
	{
		try
		{
			FileInputStream fin = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fin);
			return prop.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
