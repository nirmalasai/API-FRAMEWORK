package swaggerPetstore;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Read {
	@Test
	public void create() {
		
		given()
		 
		  .pathParam("orderId", 121)
		  
		  .when()
		     .get("https://petstore.swagger.io/v2/store/order/{orderId}")
		     
		    .then()
		       .log().all();
		
	}

}
