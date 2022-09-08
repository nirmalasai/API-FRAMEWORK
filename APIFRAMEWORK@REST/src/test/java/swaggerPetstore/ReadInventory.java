package swaggerPetstore;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadInventory {
	
	@Test
	public void getInventory() {
		
		
	
		  when()
		     .get("https://petstore.swagger.io/v2/store/inventory")
		     
		    .then()
		       .log().all();
		
	}

}
