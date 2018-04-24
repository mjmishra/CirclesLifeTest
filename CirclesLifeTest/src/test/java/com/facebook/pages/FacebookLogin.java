package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLogin {
	
    private WebDriver driver;
    By username=By.id("email");
    By password=By.id("pass");
    By loginButton=By.xpath(".//*[@id='u_0_2']");
	
	
	public FacebookLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void loginToFacebook(String userid, String pass) 
	{
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
	
}
