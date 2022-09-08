package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject() {
		//json body created
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "JaiSriRam");
		jobj.put("projectName", "Ramsita");
		jobj.put("status", "commingSoon");
		jobj.put("teamSize", 200);
		
		//request body and content type
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jobj);
		reqSpec.contentType(ContentType.JSON);
		
		//post action
		Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_2002");
        
		//validation
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		System.out.println(validate.assertThat().statusCode(201));
		validate.log().all();
	}

}
