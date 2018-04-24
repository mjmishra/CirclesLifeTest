package com.facebook.pages;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class FacebookApp {
	
private static WebDriver driver;
static AppiumDriverLocalService service;
By username=By.id("com.facebook.katana:id/email");
By password=By.id("com.facebook.katana:id/pass");
By loginButton=By.xpath("com.facebook.katana:id/loginbutton");
By menuIcon= By.xpath("//android.widget.FrameLayout[@index='4']");
By profileTab= By.xpath("//android.widget.ImageView[@index='1']");


	
	
	public FacebookApp(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public static void launchFacebookApp() throws Exception {
		
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "Samsung Galaxy J7");
		  capabilities.setCapability("CapabilityType.BrowserName", "chrome");
		  capabilities.setCapability(CapabilityType.VERSION, "7.0");
		  capabilities.setCapability("platformName", "android");
		  capabilities.setCapability("appPackage", "com.facebook.katana");
		  capabilities.setCapability("appActivity", "com.facebook.katana.dbl.activity.FacebookLoginActivity");
		  capabilities.setCapability("fullReset", false);
		  capabilities.setCapability("NoReset", true);
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		 
		  }
	
	public void appiumStart()
	{
		service = AppiumDriverLocalService
				  .buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/Applications/Appium.App/Contents/Resources/node/bin/node"))
				   .withAppiumJS(new File(
						   "/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js"))
				   .withIPAddress("127.0.0.1").usingPort(4723));
		service.start();
		System.out.println("Appium server started successfully");
	}
	public void appiumStop()
	{
		service.stop();
		System.out.println("Appium server stopped successfully");
	}
	
	public void loginToFacebookApp(String userid, String pass) 
	{
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
	public void verifyPostedComment()
	{
		driver.findElement(menuIcon).click();
		driver.findElement(profileTab).click();
		((AndroidDriver) driver).scrollTo("MANAGE POSTS");
		Assert.assertTrue(driver.getPageSource().contains("Test message"));
	}
	
	

}
