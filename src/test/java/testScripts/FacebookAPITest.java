//package testScripts;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.facebook.generic.BaseTest;
//import com.facebook.generic.HTTPUtils;
//
//import io.restassured.response.Response;
//
//public class FacebookAPITest extends BaseTest {
//	
//	private HTTPUtils objHTTPUtils ;
//	Response response = null;
//	String pID = "";
//	
//	
//
//	@Test
//	public void TC_001_createPatient() {
//		objHTTPUtils = new HTTPUtils(this);
//		String payload = "{\"patient_name\":\"Nikhil\",\"city\":\"Aurangabad\",\"age\":31,\"doctor_name\":\"Sandeep\",\"base_fee\":500,\"prescription_fee\":9500,\"discount_in_percent\":10,\"pt_mobile_number\":\"9764943754\"}";
//		response = objHTTPUtils.doRequest("post", payload);
//		 System.out.println(response.asPrettyString());
//		  pID = response.jsonPath().get("id").toString();
////		  response.jsonPath().getString(payload);
//		  System.out.println("ID : " + pID);
//		  Assert.assertEquals(response.getStatusCode(), 201);
//	}
//
//	@Test
//	public void TC_002_getPatient(String id) {
//		objHTTPUtils = new HTTPUtils(this);
//		//id = response.jsonPath().get("pID").toString();
//		response = objHTTPUtils.doRequest("get", id);
//		System.out.println("ID : " + id);
//	}
//
//	@Test
//	public void TC_003_updatePatient() {
//
//	}
//
//	@Test
//	public void TC_004_deletePatient() {
//
//	}
//}
