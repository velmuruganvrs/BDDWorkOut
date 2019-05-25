package com.vmetry.crmapp.pages;

import org.openqa.selenium.WebElement;

import com.vmetry.crmapp.initializer.DriverFunction;
import com.vmetry.crmapp.initializer.Initializer;

public class CRMContactTestPage extends Initializer{

	public static void navigateTocontactPage()
	{
		WebElement target=getElement("CONTACTS_BUTTON_XPATH");
		WebElement Dst=getElement("NEWCONTACT_BUTTON_XPATH");
		
		DriverFunction.actionClassFunction(target, Dst);
	}
	
	public static void enterFirstName(String FistName)
	{
		getElement("FIRSTNAME_TEXT_XPATH").sendKeys(FistName);
	}
	
	public static void enterLastName(String LastName)
	{
		getElement("LASTNAME_TEXT_XPATH").sendKeys(LastName);
	}
	
	public static void selectContactStatus(String value)
	{
		WebElement element=getElement("SELECT_BUTTON_XPATH");
		
		DriverFunction.selectFunction(element, value);
	}
	
	public static void enterEmailID(String E_MailID)
	{
		getElement("EMAILID_XPATH").sendKeys(E_MailID);
	}
	
	
	public static void clickContactpageSaveButton()
	{
		getElement("CONTACT_SAVE_BUTTON_XPATH").click();
	}
}
