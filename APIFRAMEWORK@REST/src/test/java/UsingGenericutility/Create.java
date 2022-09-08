package UsingGenericutility;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.crm.genericUtilities.EndPointsLibrary;

import crudWithBDD.POJOClassForBDD;
import io.restassured.http.ContentType;

public class Create {
	
	@Test
	public void create() {
		
     POJOClassForBDD jobj = new POJOClassForBDD("sita","ram51","created",2);
		
     String uri="http://localhost:8084"+EndPointsLibrary.createProject;
		
      given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		
		  .post(uri)
	   .then().assertThat().statusCode(201)
		   .and().contentType(ContentType.JSON)
		   .and().log().all();
		
	}


}
