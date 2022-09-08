package reqresAssignments;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class createForReqresUsingJsonObjectwithBDD {
	
	@Test
	public void create() {
		
		Random ran = new Random();
		int randomNumber = ran.nextInt(100);
		
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Nothing"+randomNumber);
		jobj.put("job", "anything");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.assertThat().statusCode(201)
		.and()
		.log().all();
	}

}
