package authenticationANDauthorization;

import static io.restassured.RestAssured.*;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.testng.annotations.Test;

import crudWithBDD.POJOClassForBDD;

import io.restassured.http.ContentType;

public class BasicAuth {
	
	@Test
	public void basic() {
		
		 com.crm.genericUtilities.JavaUtility jLib = new com.crm.genericUtilities.JavaUtility();

		POJOClassForBDD pObj = new POJOClassForBDD("Ravana","Ramayana"+jLib.getRandomNumber(),"complited",1000);

		 given()
		 .auth().basic("rmgyantra", "rmgy@9999")
			.body(pObj)
			.contentType(ContentType.JSON)
			.when()
			.get("http://localhost:8084/login")
			
		//	  .post("http://localhost:8084/addProject")
		   .then().assertThat().statusCode(202)
			   .and().contentType(ContentType.JSON)
			   .and().log().all();
			
	}
	

}
