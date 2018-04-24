package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class FacebookHome {
	
	private WebDriver driver;
	By messageBox=By.xpath(".//*[@id='js_1nd']/div[1]/div/div[1]/div[2]/div/div/div");
    By postButton=By.xpath(".//*[@id='js_1nd']/div[2]/div[3]/div/div[2]/div/span[2]/button");
	
	
	public FacebookHome(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void clickHomeTab()
	{
		driver.findElement(By.xpath(".//*[@id='u_0_c']")).click();
	}
	
	public void postMessage(String message) 
	{
		driver.findElement(messageBox).click();
		driver.findElement(messageBox).sendKeys(message);
		driver.findElement(postButton).click();
		
	}
	
	
	
}
