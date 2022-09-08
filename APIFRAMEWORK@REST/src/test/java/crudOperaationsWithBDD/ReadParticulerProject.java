package crudOperaationsWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ReadParticulerProject {

	@Test
	public void Read() {
		get("http://localhost:8084/projects/TY_PROJ_001")
		.then().assertThat().statusCode(200)
		.and().log().all();

	}

}
