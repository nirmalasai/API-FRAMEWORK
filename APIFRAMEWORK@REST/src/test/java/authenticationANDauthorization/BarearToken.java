package authenticationANDauthorization;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import crudWithBDD.POJOClassForBDD;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class BarearToken {

	@Test
	public void basic() {

		 com.crm.genericUtilities.JavaUtility jLib = new com.crm.genericUtilities.JavaUtility();
		JSONObject jObj=new JSONObject();
		jObj.put("name", "RestAssuredApi"+jLib.getRandomNumber());
	 Response response = given()
		.auth().oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		.when()
		.post("https://api.github.com/user/repos");
	

	 response.then().assertThat().statusCode(201)
		.and().contentType(ContentType.JSON);
	
	System.out.println(response.getTime());
	System.out.println(response.getStatusCode());

		
		//.and().log().all();

	}
}
