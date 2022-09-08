package crudOperaationsWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class AddProject {
	@Test
	public void create() {
		
		Random ran = new Random();
		int randomNo = ran.nextInt(100);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "sachin11");
		jobj.put("projectName", "India1"+randomNo);
		jobj.put("status", "playing");
		jobj.put("teamSize", 11);
		
		
		
      given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		  .post("http://localhost:8084/addProject")
	   .then().assertThat().statusCode(201)
		   .and().contentType(ContentType.JSON)
		   .and().log().all();
		
	}

}
