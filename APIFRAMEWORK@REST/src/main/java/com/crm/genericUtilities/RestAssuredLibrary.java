package com.crm.genericUtilities;


import io.restassured.response.Response;


/**
 * It will provide jsonpath
 * @author hi
 *
 */
public class RestAssuredLibrary {
	
	public String getJsonPath(Response response,String path) {
		String project = response.jsonPath().get(path);
		return project;
	}
	
	/*public String getJson() {
		String data = RestAssured.get("/projects").jsonPath().get("projectId");
		return data;
	}*/

}
