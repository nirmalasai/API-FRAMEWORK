package swaggerPetstore;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Delete {

	@Test
	public void delete() {
		
		when()
		  .delete("https://petstore.swagger.io/v2/store/order/121")
		  
		  .then()
		    .log().all();
		
	}
}
