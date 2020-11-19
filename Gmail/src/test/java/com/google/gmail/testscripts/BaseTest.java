package com.google.gmail.testscripts;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.gmail.generic.AutoConstants;
import com.google.gmail.generic.GetPicture;
import com.google.gmail.generic.WebActionUtil;
import com.google.gmail.pages.HomePage;
import com.google.gmail.pages.LoginPage;

public class BaseTest implements AutoConstants
{
	WebDriver driver;
	WebActionUtil webactionUtil;
	@Parameters({"browserName", "appURL", "ITO", "ETO"})
	@BeforeClass
	public void openApp(@Optional(DEFAULT_BROWSER)String browserName,
						@Optional(APP_URL)String appURL,
						@Optional(ITO)String implicit,
						@Optional(ETO)String explicit)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_PATH);
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
		}
		else
		{
			throw new IllegalArgumentException("Only Chrome and Firefox is supported by this project");
		}
		driver.manage().window().maximize();
		long ito = Long.parseLong(implicit);
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS);
		driver.get(appURL);
		long eto = Long.parseLong(explicit);
		webactionUtil = new WebActionUtil(driver,eto);
	}
	
	@Parameters({"usernameValue", "passwordValue"})
	@BeforeMethod
	public void loginToApp(@Optional(DEFAULT_USERNAME)String usernameValue,
						   @Optional(DEFAULT_PASSWORD)String passwordValue)
	{
		LoginPage lp = new LoginPage(driver, webactionUtil);
		lp.login(usernameValue, passwordValue);
	}
	
	@AfterMethod
	public void logout(ITestResult result)
	{
		String testCaseName = result.getName();
		switch(result.getStatus())
		{
			case ITestResult.FAILURE:String path = GetPicture.getSnapshot(driver, IMAGE_PATH, testCaseName);
									 Reporter.log("Screenshot Path="+path);
									 break;
			case ITestResult.SKIP:Reporter.log("TestCase "+testCaseName+" is Skipped");
		}
		
		HomePage hp = new HomePage(driver, webactionUtil);
		try
		{
			hp.logout();
		}
		catch(Exception e)
		{
			
		}		
	}
	
	@AfterClass
	public void closeApp()
	{
		webactionUtil.closeWindow();
	}
}
