package com.facebook.generic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HTTPUtils {
	String baseUri = "http://localhost:8080";
	Response response = null;
	//String pID = "";
	
	private static Pojo objpojo;

	public HTTPUtils(Pojo pojo) {
		objpojo = pojo;
		
	}
	
	private Response postMethod(String payload) {
		
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.baseUri(baseUri + "/addPatient" )
				.body(payload).post();
		return response;
		
	}
	private Response getMethod(String pid) {
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.baseUri(baseUri + "/getPatient/"+pid ).get();
		return response;
		
	}
	private Response updateMethod(String pid, String payload) {
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.baseUri(baseUri + "/updatePatient/"+pid )
				.body(payload).put();
		return response;
	}
	private Response deleteMethod(String payload) {
		response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.baseUri(baseUri + "/deletePatient" )
				.body(payload).delete();
		return response;
	}
	
	public Response doRequest(String requestType, String payload, String pid) {
		
		if(requestType.equalsIgnoreCase("post")) {
			return postMethod(payload);
		}else if(requestType.equalsIgnoreCase("get")) {
			return getMethod(pid);
		}else if(requestType.equalsIgnoreCase("put")) {
			return updateMethod(pid, payload);
		}else if(requestType.equalsIgnoreCase("delete")) {
			return deleteMethod(payload);
		}
		return response;
		
	}

}
