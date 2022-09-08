package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProject {
	
	@Test
	public void Create() {
		
		//json body created
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Jai");
		jobj.put("projectName", "Ram");
		jobj.put("status", "comming");
		jobj.put("teamSize", 2);
		
		//request body and content type
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jobj);
		reqSpec.contentType(ContentType.JSON);
		
		//post action
		Response response = reqSpec.post("http://localhost:8084/addProject");
        
		//validation
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
		
		
		
	}

}
