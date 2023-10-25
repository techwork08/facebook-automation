package useOfAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@BeforeSuite(alwaysRun = false)
	public void beforeSuit() {
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuit() {
		System.out.println("After Suite");
	}
	@BeforeGroups
	public void beforeGroup() {  //not getting executed
		System.out.println("Before Group");
	}
	@BeforeTest(description = "Testing Summary")
	public void openBrowser() {
		System.out.println("Before test");
	}
	@AfterTest
	public void closeBrowser() {
		System.out.println("After test");
	}
	@BeforeClass
	public void accountLogin() {
		System.out.println("Before Class");
	}
	@AfterClass
	public void accountLogout() {
		System.out.println("After Class");
	}

	
	@BeforeMethod
	public void initBrowser() {
		System.out.println("Before Method");
	}

	@Test(priority = 0)
	public void updateProfile() {
		System.out.println("Test with priority 0");
	}

	@Test(priority = 1)
	public void bankBalance() {
		System.out.println("Test with priority 1");
	}
	
	@Test(enabled = true)
	public void checkEnable() {
		System.out.println("Check enable");
	}
	
	public void depositAmount() {
		System.out.println("Deposit Amount ");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("After Method");
	}
	
}
