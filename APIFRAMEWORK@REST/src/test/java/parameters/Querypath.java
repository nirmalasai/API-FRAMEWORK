package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import crudWithBDD.POJOClassForBDD;

import io.restassured.http.ContentType;

public class Querypath {
	@Test
	public void query() {


		given()
		.queryParam("page", "3")
		.contentType(ContentType.JSON)

		.when()  
		. get("https://reqres.in/api/users")
		.then().log().all();
	}


	

}
