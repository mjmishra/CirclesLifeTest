package com.circleslife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CirclesLifeLoginScreen {
	
private WebDriver driver;
By username= By.xpath(".//*[@id='st-container']/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/form/div[1]/div/div/div[2]/input");
By password= By.xpath(".//*[@id='st-container']/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/form/div[2]/div/div/div[2]/input");
By signinbutton= By.xpath(".//*[@id='st-container']/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/form/div[4]/div/div/button");


	public CirclesLifeLoginScreen(WebDriver driver)
	{
		this.driver=driver;
	}
	public void doLogin()

	{
        driver.findElement(username).sendKeys("mishramj007@gmail.com");
        driver.findElement(password).sendKeys("test@12345");
        driver.findElement(signinbutton).click();
      
	}
	
}
