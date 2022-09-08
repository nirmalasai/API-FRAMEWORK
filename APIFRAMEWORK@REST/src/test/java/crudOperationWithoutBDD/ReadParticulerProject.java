package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadParticulerProject {

	@Test
	public void readSingleProject() {
		//get particular 
				Response response =RestAssured.get("http://localhost:8084/projects/TY_PROJ_001");
				//response.then().log().all();
				response.prettyPrint();
	}
}
