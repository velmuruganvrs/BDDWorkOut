package com.vmetry.crmapp.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vmetry.crmapp.initializer.DriverFunction;
import com.vmetry.crmapp.initializer.Initializer;
import com.vmetry.crmapp.pages.CRMCompanieTestPage;
import com.vmetry.crmapp.pages.CRMContactTestPage;
import com.vmetry.crmapp.pages.CRMLoginTestPage;
import com.vmetry.crmapp.util.GetDataWithExcellSource;
import com.vmetry.crmapp.util.GetScreenShot;

public class CRMAppwebPageTest extends Initializer{
	
	
	
	//@Parameters({"Browser","UserName","Password"})
	@BeforeTest
	
	//public void loginCRMPage(String BrowserName,String UserName,String Password) throws Exception
	public void loginCRMPage() throws Exception
	{
		openBrowser("Chrome");
		DriverFunction.loadURL("URL_NAME");
		CRMLoginTestPage.enterUserName("velmurugan");
		CRMLoginTestPage.enterPassword("9789679298");
		CRMLoginTestPage.clickLoginButton();
		
		
		
		
	}
	
	
	
	@Test(priority=1,dataProvider="CompanyPageData",enabled=true)
	public void companyPageTest(String data,String companyname,String Phoneno,String Comstatus) throws Exception
	{
		
		driver.switchTo().frame("mainpanel");
		CRMCompanieTestPage.navigateTocompqanyPage();
		CRMCompanieTestPage.enterCompanyName(companyname);
		CRMCompanieTestPage.enterPhoneNO(Phoneno);
		CRMCompanieTestPage.selectCompanyStatus(Comstatus);
		CRMCompanieTestPage.clickSaveButton();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	
	@Test(priority=1,dataProvider="ContactPageData")
	public void contactPageTest(String data,String FirstName,String LastName,String Constatus,String E_MaiID) throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		CRMContactTestPage.navigateTocontactPage();
		CRMContactTestPage.enterFirstName(FirstName);
		CRMContactTestPage.enterLastName(LastName);
		CRMContactTestPage.selectContactStatus(Constatus);
		CRMContactTestPage.enterEmailID(E_MaiID);
		CRMContactTestPage.clickContactpageSaveButton();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	
	public void tearDown(ITestResult result) throws Exception
	{
		GetScreenShot.generatorExtentReports(result);
		
		Report.flush();
	}

	@DataProvider(name="CompanyPageData")
	
	public static Object[][] getCompantPageData() throws Exception
	{
		 Object[][] data = GetDataWithExcellSource.getDataset("CompanyPage");
		
		 return data;
	}
	
@DataProvider(name="ContactPageData")
	
	public static Object[][] getContactPageData() throws Exception
	{
		 Object[][] data = GetDataWithExcellSource.getDataset("ContactPage");
		
		 return data;
	}
}



