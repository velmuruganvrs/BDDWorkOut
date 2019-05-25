package com.vmetry.crmapp.retryanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryAnnotation implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(com.vmetry.crmapp.retryanalyzer.Retry.class);
		
	}

}
