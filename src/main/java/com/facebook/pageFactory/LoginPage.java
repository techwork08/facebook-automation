package com.facebook.pageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.facebook.generic.Pojo;

public class LoginPage {

	private Pojo objPojo;
	By locbtn_createNewAccount = By.xpath("//a[text()='Create new account']");
	By loc_txtUseName = By.xpath("//input[@id='email']");
	By loc_txtPassword = By.xpath("//input[@id='pass']");
	
	public LoginPage(Pojo pojo) {
		this.objPojo=pojo;
	}
	
	

	public void clickOnCreateNewButton() {
		objPojo.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		objPojo.getDriver().findElement(By.xpath("//a[text()='Create new account']")).click();
		//boolean webElement = objPojo.getObjWrapperFunctions().clickUsingJavaScript(locbtn_createNewAccount);
		boolean webElement = objPojo.getObjWrapperFunctions().clickUsingAction(locbtn_createNewAccount);
		
		Assert.assertTrue(webElement);
		Reporter.log("Create new Account ", webElement);
		objPojo.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	public void enterCredentils() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("testData\\ReadDataFromExcel.xlsx").getFile());
		FileInputStream fs = new FileInputStream(file);
		int randomRowNumber = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		Workbook workbook = new XSSFWorkbook(fs);
		Sheet sheet1 = workbook.getSheetAt(0);
		Row row = sheet1.getRow(randomRowNumber);
		String userName = row.getCell(0).getStringCellValue();
		String password = row.getCell(1).getStringCellValue();
		objPojo.getDriver().findElement(loc_txtUseName).sendKeys(userName);
		objPojo.getDriver().findElement(loc_txtPassword).sendKeys(password);
		workbook.close();
		fs.close();
		System.out.println("Username  : " + userName+ " , Password : "+password);
		
	}
	
	
	public void enterPassword(String strPassword) {
		System.out.println("Password : " + strPassword);
	}
	public void clickOnLoginButton() {
		String xpath = "//input[@name='']";
		System.out.println("Click on Login Button");
		//WrapperFunctions.clickButton(Constants.XPATH_LOCATOR, xpath);
	}
	public void clickOnForgotPassword() {
		System.out.println("Click on Forgotton Password Link");
	}
	
	
	public void getLoginPageLinks() throws IOException {
		//List<String> listOfUrl = new ArrayList<>();
		List<WebElement> list = objPojo.getDriver().findElements(By.tagName("a"));
		System.out.println(" size : "+ list.size());
		
		for (WebElement webElement : list) {
			String urls = webElement.getAttribute("href");
			//listOfUrl.add(urls);
			validateLinks(urls);
			System.out.println(urls);
			
		}
		
	}
	
	public static void validateLinks(String listOfUrl) throws IOException {
		URL obj= new URL(listOfUrl);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);
		if(responseCode == HttpURLConnection.HTTP_OK) {
			System.out.println(obj + " - " + "Valid link");
		}else
			System.out.println("Broken link");
	}
	
}
