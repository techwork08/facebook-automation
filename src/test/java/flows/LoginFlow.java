package flows;

import com.facebook.generic.Pojo;
import com.facebook.pageFactory.LoginPage;

public class LoginFlow {

	private LoginPage objLoginPage;
	private Pojo objpojo;

	public LoginFlow(Pojo pojo) {
		objLoginPage = new LoginPage(objpojo);
	}
	
	public void loginWithExistingUserDetails(String username, String password) throws InterruptedException {

//		objLoginPage.enterUserName(username);
//		objLoginPage.enterPassword(password);
		objLoginPage.clickOnCreateNewButton();
	}

//	public void forgotPassword() {
//
//		objLoginPage.clickOnForgotPassword();
//	}

	
}
