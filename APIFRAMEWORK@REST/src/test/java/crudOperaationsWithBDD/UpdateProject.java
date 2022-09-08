package crudOperaationsWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class UpdateProject {
	
	@Test
	public void create() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "sachin01");
		jobj.put("projectName", "India188");
		jobj.put("status", "playing");
		jobj.put("teamSize", 111);

		//preconditions
	given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		//execution
		.put("http://localhost:8084/projects/TY_PROJ_2202")
		
		//validation
		.then().assertThat().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().log().all();
		
	}

}
