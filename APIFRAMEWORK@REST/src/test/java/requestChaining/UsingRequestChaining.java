package requestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import crudWithBDD.POJOClassForBDD;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsingRequestChaining {
	
	@Test
	public void request() {
		
		 com.crm.genericUtilities.JavaUtility jLib = new com.crm.genericUtilities.JavaUtility();
		POJOClassForBDD pObj = new POJOClassForBDD("Modi","India"+jLib.getRandomNumber(),"complited",999);

		Response response = given()
				.body(pObj)
				.contentType(ContentType.JSON)

				.when()
				.post("http://localhost:8084/addProject");

		String projectId = response.jsonPath().get("projectId");
		System.out.println(projectId);
		
		Response res = given()
				.pathParam("pid3", projectId)

				.when()
				.get("http://localhost:8084/{pid3}");
				
				Object projectsIdddd = res.jsonPath().get("projectId");
				
				POJOClassForBDD pObj00=new POJOClassForBDD("Newton","Law"+jLib.getRandomNumber(),"Investigation",420);
				given()
				.pathParam("pid1", projectId)
				   .body(pObj00)
				   .contentType(ContentType.JSON)
				   
				.when()  
				 . put("http://localhost:8084/projects/{pid1}")
				  .then().log().all();
	}

}
