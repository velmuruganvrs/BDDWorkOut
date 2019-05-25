package com.vmetry.crmapp.pages;

import org.openqa.selenium.WebElement;

import com.vmetry.crmapp.initializer.DriverFunction;
import com.vmetry.crmapp.initializer.Initializer;

public class CRMCompanieTestPage extends Initializer{
	
	
	
	
	public static void navigateTocompqanyPage()
	{
		WebElement target=getElement("COMPANIES_BUTTON_XPATH");
		WebElement Dst=getElement("NEWCOMPANIES_BUTTON_XPATH");
		
		DriverFunction.actionClassFunction(target, Dst);
	}
	
	public static void enterCompanyName(String CompanyName)
	{
		getElement("COMPANY_TEXTBOX_XPATH").sendKeys(CompanyName);
	}
	
	public static void enterPhoneNO(String PhoneNo)
	{
		getElement("PHONENO_TEXTBOX_XPATH").sendKeys(PhoneNo);
	}

	
	public static void selectCompanyStatus(String comStatus)
	{
		
		WebElement element=getElement("STATUS_BUTTON_XPATH");
		
		DriverFunction.selectFunction(element, comStatus);
	}
	
	public static void clickSaveButton()
	{
		
		getElement("SAVE_BUTTON_XPATH").click();
		
		
	}
	
}
