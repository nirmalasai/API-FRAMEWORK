package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadAll {
	
	@Test
	public void readAllProject() {
		//get all project
		Response response = RestAssured.get("http://localhost:8084/projects");
		response.then().log().all();
		
		
	}

}
