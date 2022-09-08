package authenticationANDauthorization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PremitiveAndDigestive {

	@Test
	public void premitiveAuth() {

		 given()
		 .auth().preemptive().basic("rmgyantra", "rmgy@9999")
			
			.when()
			.get("http://localhost:8084/login")
			
		   .then()
			 .log().all();
	}
	
	@Test 
	public void digestive() {
		 given()
		 .auth().digest("rmgyantra", "rmgy@9999")
			
			.when()
			.get("http://localhost:8084/login")
			
		   .then()
			 .log().all();
	}
	
}
