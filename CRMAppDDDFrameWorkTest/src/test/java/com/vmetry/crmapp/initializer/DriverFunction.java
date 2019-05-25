package com.vmetry.crmapp.initializer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DriverFunction extends Initializer{
	
	public static void loadURL(String URL)
	{
		driver.get(envpro.getProperty(URL));
	}
	
	public static void selectFunction(WebElement element,String Value)
	{
		
		Select s = new Select(element);
		
		s.selectByVisibleText(Value);
	}
	
	public static void actionClassFunction(WebElement target, WebElement dest)
	{
		Actions a = new Actions(driver);
		
		a.moveToElement(target).moveToElement(dest).click().build().perform();
	}

}
