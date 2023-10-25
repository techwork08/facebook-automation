package com.facebook.pageFactory;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.facebook.generic.Pojo;

public class SignUpPage {
	private Pojo objPojo;

	public SignUpPage(Pojo pojo) {
		this.objPojo = pojo;
	}
	By loc_txt_lName = By.xpath("//input[@name='lastname']");
	By loc_txt_fName = By.xpath("//input[@name='firstname']");
	By loc_sel_day = By.xpath("//select[@id='day']");
	By loc_sel_month = By.xpath("//select[@id='month']");
	By loc_sel_year = By.xpath("//select[@id='year']");
	
 	
	public void getFirstName(String firstName) {
		
		WebDriverWait wait = new WebDriverWait(objPojo.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Sign Up']")));
		//System.out.println("Explicit wait==========");
		
//		firstName = objPojo.getObjFunctionUtilites().getRandomFirstName();
		boolean flag=	objPojo.getObjWrapperFunctions().sendKeysUsingAction(loc_txt_fName, firstName);
		Assert.assertTrue(flag);
		System.out.println("First Name : "+firstName);
	}

	public void getLastName(String lastName) {
		boolean flag =  objPojo.getObjWrapperFunctions().sendKeysUsingJavaScript(loc_txt_lName, lastName);
		 Assert.assertTrue(flag); 
		 System.out.println("Last Name : "+lastName);
	}

	public void getemail(String email) {
		//String email = objPojo.getObjFunctionUtilites().generateRandomEmail(firstName, lastName);
		objPojo.getDriver().findElement(By.xpath("//div[contains(.,'email address')]/following-sibling::input[@name='reg_email__']")).sendKeys(email);
		objPojo.getDriver().findElement(By.xpath("//input[contains(@name,'email_confirmation')]")).sendKeys(email);
		System.out.println("Email : " + email);
	}

	public void getPassword() {
		String pwd = "KayraMehta@1993";
		objPojo.getDriver().findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys(pwd);
		System.out.println("Password : " + pwd);
	}

	public void dateOfBirth(String DOB) {
		//String DOB = objPojo.getObjFunctionUtilites().getRandomDateOfBirth(18, 99, "dd-MM-yyyy");
		String[] arrDOB = DOB.split("-");
		arrDOB[0] = StringUtils.stripStart(arrDOB[0],"0");
		arrDOB[1] = StringUtils.stripStart(arrDOB[1],"0");
				
		Assert.assertTrue(objPojo.getObjWrapperFunctions().useBySelect(loc_sel_day, arrDOB[0] ));
		Assert.assertTrue(objPojo.getObjWrapperFunctions().useBySelect(loc_sel_month, arrDOB[1]));
		Assert.assertTrue(objPojo.getObjWrapperFunctions().useBySelect(loc_sel_year, arrDOB[2]));
		System.out.println("DOB : " + arrDOB);
		
	}

	public void getGender(String gender) {
		//String gender = objPojo.getObjFunctionUtilites().randomGender();
		objPojo.getDriver().findElement(By.xpath("//label[.='"+gender+"']")).click();
		System.out.println("Gender : " + gender);
	}

}
