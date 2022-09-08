package WaysToExecution;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import crudWithBDD.POJOClassForBDD;
import io.restassured.http.ContentType;

public class UsingPojoClass {
	@Test
	public void create() {
		
     POJOClassForBDD jobj = new POJOClassForBDD("sita","ram","created",2);
		
		
		
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
