package WaysToExecution;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UsingHashMap {

	@Test
	public void create() {
		
		Random ran = new Random();
		int randomNo = ran.nextInt(100);
		HashMap hs = new HashMap();
		hs.put("createdBy", "sachin001");
		hs.put("projectName", "India1"+randomNo);
		hs.put("status", "playing");
		hs.put("teamSize", 110);
		
		
		
        baseURI="http://localhost";
        port=8084;
			 given()
			.body(hs)
			.contentType(ContentType.JSON)
			.when()
			  .post("/addProject")
		   .then().assertThat().statusCode(201)
			   .and().contentType(ContentType.JSON)
			   .and().log().all();
			
	}
}
