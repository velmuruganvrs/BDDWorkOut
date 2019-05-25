package com.vmetry.crmapp.pages;

import com.vmetry.crmapp.initializer.Initializer;

public class CRMLoginTestPage extends Initializer{
	
	
	public static void enterUserName(String UserName)
	{
		getElement("USERNAME_XAPTH").sendKeys(UserName);
	}
	
	public static void enterPassword(String Password)
	{
		getElement("PASSWORD_XPATH").sendKeys(Password);
	}
	
	public static void clickLoginButton()
	{
		getElement("LOGIN_BUTTON_XPATH").click();
	}

}
