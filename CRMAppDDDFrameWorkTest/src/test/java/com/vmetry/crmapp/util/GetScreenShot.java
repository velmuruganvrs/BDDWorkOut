package com.vmetry.crmapp.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.vmetry.crmapp.initializer.Initializer;

public class GetScreenShot extends  Initializer{
	
	public static void generatorExtentReports(ITestResult result) throws Exception
	{
		Object[] data=result.getParameters();
		
		String testName=result.getMethod().getMethodName();
		
		Test=Report.createTest(testName+"-"+data[0].toString());
		if(result.isSuccess())
		{
			Test.log(Status.PASS, result.getName());
			Test.log(Status.PASS, "This TestCase is Verified ");
			String path=takeScreenShot(testName+"-"+data[0].toString());
			
			Test.addScreenCaptureFromPath(path);
			
		}
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Test.log(Status.FAIL, result.getName());
			Test.log(Status.FAIL, "This TestCase is Failed");
			Test.log(Status.FAIL, result.getThrowable());
			String path=takeScreenShot(testName+"-"+data[0].toString());
			
			Test.addScreenCaptureFromPath(path);
			
		}
	}
	
	public static String takeScreenShot(String MethodName) throws Exception
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Dst= new File("D:\\WrokOutSelenium Wrokphase\\CRMAppDDDFrameWorkTest\\screenshots\\"+MethodName+".png");
		
		FileUtils.copyFile(src, Dst);
		
		return Dst.toString();
		
	}

}
