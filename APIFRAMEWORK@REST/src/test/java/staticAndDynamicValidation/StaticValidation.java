package staticAndDynamicValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticValidation {

	@Test
	public void validation() {
		String expectedProjectId="TY_PROJ_1002";
		baseURI="http://localhost";
		port=8084;
		
		Response response = get("/projects/TY_PROJ_1002");
		     String actualProjectId = response.jsonPath().get("[3].projectId");
		
		     System.out.println(actualProjectId);
		expectedProjectId.equalsIgnoreCase(actualProjectId);
		
		//     Assert.assertEquals(expectedProjectId, actualProjectId);
		     
		//response.prettyPrint();
		response.then().log().all();
		
	}
}
