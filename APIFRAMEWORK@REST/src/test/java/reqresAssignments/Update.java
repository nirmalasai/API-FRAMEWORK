package reqresAssignments;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Update {

	@Test
	public void update() {
		
		Random ran = new Random();
		int randomNumber = ran.nextInt(100);
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Nothing"+randomNumber);
		jobj.put("job", "anything");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("https://reqres.in/api/users/2")
		
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.assertThat().statusCode(200)
		.and()
		.log().all();
	} 
}
