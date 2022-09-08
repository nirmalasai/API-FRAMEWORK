package crudOperaationsWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteProject {
	@Test
	public void Read() {
		delete("http://localhost:8084/projects/TY_PROJ_001")
		.then().assertThat().statusCode(204)
		.contentType(ContentType.JSON)
		.and().log().all();

	}


}
