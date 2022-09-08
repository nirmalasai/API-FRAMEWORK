package authenticationANDauthorization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CooopsOath2 {
	@Test
	public void Oath2ToCreate() {
		
		Response response = given()
				.formParam("client_id", "RestAssurded")
				 .formParam("client_secret", "a91f2ab4137e1e7c2f762301aa23a6bb")
				 .formParam("grant_type", "client_credentials")
				 .formParam("redirect_uri", "http://myntra.com")
				 .formParam("code", "authorization_code")
		
		.when()
		    .post("http://coop.apps.symfonycasts.com/token");
		
		String token = response.jsonPath().get("access_token");
		System.out.println("Token    "+token);
	
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3739)
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
		.then().log().all();
		
		
	}


}
