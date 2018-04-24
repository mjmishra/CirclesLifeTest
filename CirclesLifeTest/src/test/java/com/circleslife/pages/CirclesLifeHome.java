package com.circleslife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CirclesLifeHome {
	private WebDriver driver;
	By profileTab= By.xpath(".//*[@id='st-container']/div/div/div[1]/div/div/div[2]/div/a[3]/div");
	
	public CirclesLifeHome(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void checkEmailUnderAccount()
	{
		driver.findElement(profileTab).click();
		driver.getPageSource().contains("mishramj007@gmail.com");
		
	}

}
