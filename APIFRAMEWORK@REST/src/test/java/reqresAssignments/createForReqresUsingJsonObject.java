package reqresAssignments;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class createForReqresUsingJsonObject {

	@Test
	public void create() {
		//json body created
		JSONObject jobj=new JSONObject();
		jobj.put("name", "wastefellow");
		jobj.put("job", "trying");


		//request body and content type
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jobj);
		reqSpec.contentType(ContentType.JSON);

		//post action
		Response response = reqSpec.post("https://reqres.in/api/users");

		//validation
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();



	}

}


