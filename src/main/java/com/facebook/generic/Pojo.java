package com.facebook.generic;

import org.openqa.selenium.WebDriver;

public class Pojo {
	private String browser;
	private String baseUrl;
	private int waitTime;
	private FunctionUtilites objFunctionUtilites;
	private WebDriver driver;
	private WrapperFunctions objWrapperFunctions;
	private HTTPUtils objHttpUtils;
	
	

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public HTTPUtils getObjHttpUtils() {
		return objHttpUtils;
	}

	public void setObjHttpUtils(HTTPUtils objHttpUtils) {
		this.objHttpUtils = objHttpUtils;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public FunctionUtilites getObjFunctionUtilites() {
		return objFunctionUtilites;
	}

	public void setObjFunctionUtilites(FunctionUtilites objFunctionUtilites) {
		this.objFunctionUtilites = objFunctionUtilites;
	}

//	public Pojo() {
//		objFunctionUtilites = new FunctionUtilites();
//	}

	public String getBrowser() {
		return browser;
	}

	public void setBroswer(String broswer) {
		this.browser = broswer;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	public WrapperFunctions getObjWrapperFunctions() {
		return objWrapperFunctions;
	}

	public void setObjWrapperFunctions(WrapperFunctions objWrapperFunctions) {
		this.objWrapperFunctions = objWrapperFunctions;
	}

}
