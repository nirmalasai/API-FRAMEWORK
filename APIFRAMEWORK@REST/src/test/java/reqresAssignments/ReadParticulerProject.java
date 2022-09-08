package reqresAssignments;

import static io.restassured.RestAssured.get;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadParticulerProject {
	@Test
	public void readOneProject() {
		get("https://reqres.in/api/users/2")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.assertThat().statusCode(200)
		.and()
		.log().all();
	}

}
