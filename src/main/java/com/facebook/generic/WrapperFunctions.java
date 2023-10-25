package com.facebook.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WrapperFunctions {
	
	
	private Pojo objPojo;
	
	public WrapperFunctions(Pojo pojo) {
		this.objPojo=pojo;
	}
	
	public boolean clickUsingJavaScript(By locator) {
		try {
		WebElement objWebElement = objPojo.getDriver().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
		js.executeScript("return arguments[0].click();", objWebElement);
		return true;
		}catch(Exception e) {
			System.out.println("exception " + e.getMessage());
			return false;
		}
	}
	
	public boolean clickUsingAction(By locator) {
		WebElement objWebElement = objPojo.getDriver().findElement(locator);
		Actions action = new Actions(objPojo.getDriver());
		action.click(objWebElement).perform();
		return true;
	}
	
	public boolean sendKeysUsingJavaScript(By locator,String strLname) {
		JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
		WebElement element =  objPojo.getDriver().findElement(locator);
		//js.executeScript("arguments[0].value=' ';",element );
		js.executeScript("arguments[0].setAttribute('value','strLname')",element );
		return true;
	}
	
	public boolean sendKeysUsingAction(By locator, String fname) {
		WebElement element = objPojo.getDriver().findElement(locator);
		Actions actions = new Actions(objPojo.getDriver());
		actions.sendKeys(element, fname).perform();
		return true;
	}
	
	public boolean selectDOBUsingAction(By locator, String arrDOB) {
		WebElement element = objPojo.getDriver().findElement(locator);
		Actions action = new Actions(objPojo.getDriver());
		action.sendKeys(element, arrDOB).perform();
		return true;
	}

	public boolean selectDOBByJavaScript(By locator) {
		WebElement select = objPojo.getDriver().findElement(locator);

		((JavascriptExecutor)objPojo.getDriver()).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++)"
				+ "{ if(select.options[i].text == arguments[1])"
				+ "{ select.options[i].selected = true; } }", select, "Date");
		return true;
	}
	
	public boolean useBySelect(By locator, String value) {
		
		WebElement element = objPojo.getDriver().findElement(locator);
		Select select = new Select(element);
		select.selectByValue(value);
		return true;
	}



	
	
//	public static void clickButton(String locatorType, String value) {
//		switch (locatorType) {
//		case Constants.XPATH_LOCATOR: {
//			System.out.println("Clicking");
//			break;
//		}
//		case Constants.TAG_NAME:{
//			System.out.println("Clicking");
//			break;
//		}
//		case Constants.ID_LOCATOR:{
//			System.out.println("Clicking");
//			break;
//		}
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + locatorType);
//		}
//	}
//	
//	public interface Constants{
//		String XPATH_LOCATOR = "XPATH";
//		String TAG_NAME = "TAG_NAME";
//		String CSS_LOCATOR = "CSS";
//		String ID_LOCATOR = "ID";
//	}
	
}
