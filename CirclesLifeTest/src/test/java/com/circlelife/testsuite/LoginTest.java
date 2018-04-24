package com.circlelife.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.circleslife.pages.CirclesLifeHome;
import com.circleslife.pages.CirclesLifeLoginScreen;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest {
	WebDriver driver=null;
	protected CirclesLifeLoginScreen loginpage;
	protected CirclesLifeHome homepage;
	@BeforeTest
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mmishra\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 
		// Initialize browser
		driver=new ChromeDriver();
		 
		// Open URL
		driver.get("https://shop.circles.life/login");
		 
		// Maximize browser
		 
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	public void testLoginSuccess()

	{
		loginpage= new CirclesLifeLoginScreen(driver);
		homepage= new CirclesLifeHome(driver);
		loginpage.doLogin();
		homepage.checkEmailUnderAccount();
		
	    
	    
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
