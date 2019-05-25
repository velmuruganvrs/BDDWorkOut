package com.vmetry.crmapp.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Initializer {
	/*
	 * Webdriver Initializer
	 */
	public static WebDriver driver;
	/*
	 * envProperties File Initializer
	 */
	public static FileInputStream envsrc;
	public static Properties envpro;

	/*
	 * LocatorProperties File Initializer
	 */
	public static FileInputStream locsrc;
	public static Properties locpro;

	/*
	 * ExtentReport Initializer
	 */

	public static ExtentHtmlReporter Htmlpath;
	public static ExtentReports Report;
	public static ExtentTest Test;

	/*
	 * 
	 * Browserstack initializer
	 */
	public static DesiredCapabilities cap;
	public static String URL = "https://velmurugan13:Hfs4EykgyomHcQyrqMkR@hub.browserstack.com/wd/hub";

	public static boolean isreport=true;
	public static void openBrowser(String BrowserName) throws Exception

	{
		if(isreport){
		Htmlpath = new ExtentHtmlReporter(
				"D:\\WrokOutSelenium Wrokphase\\CRMAppDDDFrameWorkTest\\ExtenntReports_Output_File\\CRMAPPExtenetreport.html");
		isreport=false;
		}
		Report = new ExtentReports();
		Report.attachReporter(Htmlpath);

		// Report.createTest(testName);

		envsrc = new FileInputStream(new File(
				"D:\\WrokOutSelenium Wrokphase\\CRMAppDDDFrameWorkTest\\src\\test\\resources\\com\\vmetry\\crmapp\\Properties_Files\\env.properties"));

		envpro = new Properties();

		envpro.load(envsrc);

		locsrc = new FileInputStream(new File(
				"D:\\WrokOutSelenium Wrokphase\\CRMAppDDDFrameWorkTest\\src\\test\\resources\\com\\vmetry\\crmapp\\Properties_Files\\locator.properties"));

		locpro = new Properties();

		locpro.load(locsrc);

//		cap = new DesiredCapabilities();
//
//		/*
//		 * cap.setPlatform(Platform.WINDOWS); cap.setBrowserName(BrowserName);
//		 */
//		cap.setCapability("browser", BrowserName);
//		// cap.setCapability("browser_version", "62.0");
//		cap.setCapability("os", "Windows");
//
//		cap.setCapability("browserstack.debug", true);
//		URL url = new URL(URL);
//
//		// driver = new RemoteWebDriver(url, cap);
//
//		driver = new RemoteWebDriver(url, cap);

		 if(BrowserName.equalsIgnoreCase("Chrome"))
		 {
		 System.setProperty("webdriver.chrome.driver",
		 "D:\\rivers\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		 }
		
		 if(BrowserName.equalsIgnoreCase("ie"))
		 {
		 System.setProperty("webdriver.ie.driver",
		 "D:\\rivers\\IEDriverServer.exe");
		
		 driver = new InternetExplorerDriver();
		 }
		
		 if(BrowserName.equalsIgnoreCase("FireFox"))
		 {
		 System.setProperty("webdriver.gecko.driver",
		 "D:\\rivers\\geckodriver.exe");
		
		 driver = new FirefoxDriver();
		 }
		

		 driver.manage().window().maximize();

		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static WebElement getElement(String XpathName) {
		return driver.findElement(By.xpath(locpro.getProperty(XpathName)));
	}

}
