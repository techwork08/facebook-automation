package flows;

import com.facebook.generic.Pojo;
import com.facebook.pageFactory.SignUpPage;

public class SignUpFlow {
	private SignUpPage objSignUpPage;
	private Pojo objpojo;
	
	public SignUpFlow(Pojo pojo) {
		this.objpojo = pojo;
		objSignUpPage = new SignUpPage(objpojo);
	}
	public String registerNewUserWithRandomData(String strfirstName, String strlastName, String email,String pwd,String DOB,String gender) {
		String firstName = strfirstName;
		String lastName = strlastName;
		//objSignUpPage.clickOnCreateNewButton();
		//objSignUpPage.getFirstName(firstName);
		
		if(!strfirstName.equals(""))
			objSignUpPage.getFirstName(firstName);
		if(!strlastName.equals(""))
			objSignUpPage.getLastName(lastName);
		if(!email.equals(""))
			objSignUpPage.getemail(email);
		if(!pwd.equals(""))
			objSignUpPage.getPassword();
		if(!DOB.equals(""))
			objSignUpPage.dateOfBirth(DOB);
		if(!gender.equals(""))
			objSignUpPage.getGender(gender);
		return "User" + " " + "Admin@123";
		
	}

}
