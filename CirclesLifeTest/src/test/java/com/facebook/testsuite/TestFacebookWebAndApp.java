package com.facebook.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.facebook.pages.FacebookApp;
import com.facebook.pages.FacebookHome;
import com.facebook.pages.FacebookLogin;

public class TestFacebookWebAndApp {
	
	protected FacebookLogin FacebookLoginPage;
	protected FacebookHome FacebookHomePage;
	protected FacebookApp FacebookAppPage;
	
	WebDriver driver=null;
	@BeforeTest
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mmishra\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 
		// Initialize browser
		driver=new ChromeDriver();
		 
		// Open facebook
		driver.get("http://www.facebook.com");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void postFacebookMessageOnWeb() throws Exception

	{
		
		FacebookLoginPage=new FacebookLogin(driver);
		FacebookHomePage=new FacebookHome(driver);
		
		FacebookLoginPage.loginToFacebook("mishramj007@gmail.com", "test@12345");
		
		
		FacebookHomePage.clickHomeTab();
		FacebookHomePage.postMessage("Test message");	    
	    
	}
	
	@Test(dependsOnMethods="postFacebookMessageOnWeb")
	// Will be executed only when test case of posting comment on web will pass
	public void verifyMessageOnApp() throws Exception
	{
		FacebookAppPage = new FacebookApp(driver);
		FacebookAppPage.appiumStart();
		FacebookAppPage.launchFacebookApp();
		FacebookAppPage.loginToFacebookApp("mishramj007@gmail.com", "test@12345");
		FacebookAppPage.verifyPostedComment();
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
