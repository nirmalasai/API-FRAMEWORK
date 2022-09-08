package authenticationANDauthorization;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oath2Authentication {
	@Test
	public void Oath2() {
		
		Response response = given()
				.formParam("client_id", "SDET31-REST")
				 .formParam("client_secret", "85d61609bd07fee754bda67379005474")
				 .formParam("grant_type", "client_credentials")
				 .formParam("redirect_uri", "http://example.com")
				 .formParam("code", "authorization_code")
		
		.when()
		    .post("http://coop.apps.symfonycasts.com/token");
		
		String token = response.jsonPath().get("access_token");
		System.out.println(token);
	
		
		given()
		.auth().oauth2(token)
		//.pathParam("USER_ID", 3739)
		.get("http://coop.apps.symfonycasts.com/api/me")
		.then().log().all();
		
		
	}

}
