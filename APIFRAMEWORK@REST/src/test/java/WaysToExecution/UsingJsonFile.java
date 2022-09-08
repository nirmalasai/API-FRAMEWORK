package WaysToExecution;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingJsonFile {
	@Test
	public void create() throws FileNotFoundException {
		 FileInputStream path = new FileInputStream("./src/test/resources/shubham.json");
		
        baseURI="http://localhost";
        port=8084;

		given()
		  .body(path)
		  .contentType(ContentType.JSON)
		.when()
		   .post("/addProject")
		   .then().assertThat().statusCode(201)
		   .and().contentType(ContentType.JSON)
		   .and().log().all();
	}

}
