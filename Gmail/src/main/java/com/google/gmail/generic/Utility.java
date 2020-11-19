package com.google.gmail.generic;

public class Utility
{
	public static void sleepInSeconds(long seconds)
	{
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String[] splitString(String s, String regex)
	{
		return s.split("\\"+regex);
	}
}
