package reqresAssignments;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ReadReqres {
@Test
public void read() {
	get("https://reqres.in/api/users?page=2")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.and()
	.assertThat().statusCode(200)
	.and()
	.log().all();
	
}

}
