package swaggerPetstore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Create {
	
	@Test
	public void create() {
		JSONObject jObj = new JSONObject();
		jObj.put("id", 121);
		jObj.put("petId", 212);
		jObj.put("quantity", 20);
		jObj.put("shipDate", "2022-09-06T10:55:17.727Z");
		jObj.put("status", "complited");
		jObj.put("complete", true);
		
		given()
		  .body(jObj)
		  .contentType(ContentType.JSON)
		  
		  .when()
		     .post("https://petstore.swagger.io/v2/store/order")
		     
		    .then()
		       .log().all();
		
	}

}
