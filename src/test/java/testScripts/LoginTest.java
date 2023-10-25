package testScripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.facebook.generic.BaseTest;
import com.facebook.pageFactory.LoginPage;

public class LoginTest extends BaseTest {

	private static LoginPage objLoginPage;
	
	public void initilizeFlowsAndPages() {

		objLoginPage = new LoginPage(this);
	}
	
	@BeforeClass public void setUpEnv() {
		  this.initializeBrowser();
		  this.initilizeFlowsAndPages();
		  }
	
	@Test
	public void login() throws IOException {
		
		objLoginPage.enterCredentils();
	}
	
	@AfterClass
	public void tearDownEnv() {
		this.tearDown();
	}
	
	
}
