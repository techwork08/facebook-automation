package com.facebook.generic;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseTest extends Pojo implements ConfigData {

	private WebDriver driver;
	private FunctionUtilites objFunctionUtilites;
	private WrapperFunctions objWrapperFunctions;
	private HTTPUtils objHttpUtils;

	public void initializeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("incognito");

		//options.addArguments("headless");

//		options.addArguments("disable-extensions");// prevents slowing down
//		options.addArguments("make-default-browser");//SessionNotCreatedException
		// Chrome failed to start
//		System.out.println("Version : " + options.addArguments("version"));
//		System.out.println("disable-infobars : " + options.addArguments("disable-infobars"));
		driver = new ChromeDriver(options); // driver set kia

		driver.get("https://www.facebook.com/");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(WebDriverException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Facebook']")));
		System.out.println("Fluent wait ======");
		
		objWrapperFunctions = new WrapperFunctions(this);
		objFunctionUtilites = new FunctionUtilites(this);
		objHttpUtils = new HTTPUtils(this);
		this.setObjWrapperFunctions(objWrapperFunctions);
		this.setObjFunctionUtilites(objFunctionUtilites);
		this.setDriver(driver);
	}

	public void tearDown() {
		String gender = this.getObjFunctionUtilites().randomGender();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[.='" + gender + "']")));
		driver.close();
		System.out.println("Explicit wait --------");
	}

	public void implicitWait() throws InterruptedException {
		driver.manage().wait(WaitTime);
	}
}
