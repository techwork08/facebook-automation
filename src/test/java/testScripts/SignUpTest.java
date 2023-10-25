package testScripts;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.generic.BaseTest;
import com.facebook.generic.HTTPUtils;
import com.facebook.pageFactory.LoginPage;

import flows.SignUpFlow;
import io.restassured.response.Response;


public class SignUpTest extends BaseTest {
	private static SignUpFlow objSignUpFlow;
	private static LoginPage objLoginPage;
	String pID = "";
	Response response;
	private HTTPUtils objHTTPUtils ;
	String strFName="" ;
	
	public void initilizeFlowsAndPages() {

		objSignUpFlow = new SignUpFlow(this);
		objLoginPage = new LoginPage(this);
		//objHTTPUtils = new HTTPUtils(this);
	}

	public Hashtable<String, String> getSignUpData() {
		Hashtable<String, String> objHashtable = new Hashtable<String, String>();

		objHashtable.put("firstName", strFirstname + this.getObjFunctionUtilites().getRandomFirstName());
		objHashtable.put("lastName", strLastName + this.getObjFunctionUtilites().getRandomLastName());
		objHashtable.put("Email", this.getObjFunctionUtilites().generateRandomEmail(strFirstname, strLastName));
		objHashtable.put("Password", validPassword);
		objHashtable.put("DOB", this.getObjFunctionUtilites().getRandomDateOfBirth(18, 99, "dd-MM-yyyy"));
		objHashtable.put("Gender", this.getObjFunctionUtilites().randomGender());
		return objHashtable;
	}

	
	  @BeforeClass 
	  public void setUpEnv() {
		  this.initializeBrowser();
		  this.initilizeFlowsAndPages();
		  }
	 
	  
	   
	  @BeforeMethod
	  public void preCondition() {
		  objHTTPUtils = new HTTPUtils(this);
		  String pname =  strFirstname + this.getObjFunctionUtilites().getRandomFirstName();
		  String city = this.getObjFunctionUtilites().getRandomCity();
		  String age = this.getObjFunctionUtilites().getNumber();
			String payload = "{\"patient_name\":\""+pname+"\",\"city\":\""+city+"\",\"age\":"+age+",\"doctor_name\":\"Sandeep\",\"base_fee\":500,\"prescription_fee\":9500,\"discount_in_percent\":10,\"pt_mobile_number\":\"9764943754\"}";
			
			response = objHTTPUtils.doRequest("post", payload,"");
			 System.out.println(response.asPrettyString());
			  pID = response.jsonPath().get("id").toString();
			  //strFName = response.jsonPath().getString("patient_name");
			  strFName = pname;
			  System.out.println("First Name : "+strFName);
			  System.out.println("ID : " + pID);
			  Assert.assertEquals(response.getStatusCode(), 201);
			 
			  
			  System.out.println("****************Get Method****************");
			  response = objHTTPUtils.doRequest("get","",pID);
			  System.out.println(response.asPrettyString());
			  
			  
			  System.out.println("***************Update Method***************");
			  
			  String updatePayload = "{\"age\":"+age+",\"doctor_name\":\"Vinod\",\"patient_name\":\""+strFName+"\",\"fees_payable\":1299}";
			  response = objHTTPUtils.doRequest("put", updatePayload,pID);
			  System.out.println(response.asPrettyString());
			  
			  System.out.println("********************Delete Method**************");
			  
			  String deletePayload = "{\"id\":\""+pID+"\"}";
			  response = objHTTPUtils.doRequest("delete", deletePayload, "");
			  System.out.println(response.asPrettyString());
	  }

	@Test
	public void TC01_001_verifyUserIsAbleToSignUp() throws IOException {

		objLoginPage.clickOnCreateNewButton();
		//objLoginPage.getLoginPageLinks();
		
		Hashtable<String, String> testSignUpData = this.getSignUpData();
		//System.out.println(testSignUpData.toString());
		objSignUpFlow.registerNewUserWithRandomData(strFName, testSignUpData.get("lastName"),
				testSignUpData.get("Email"), testSignUpData.get("Password"), testSignUpData.get("DOB"),
				testSignUpData.get("Gender"));
	}
	
	@AfterClass
	public void tearDownEnv() {
		this.tearDown();
	}

}
