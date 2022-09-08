package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import crudWithBDD.POJOClassForBDD;


import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PathParm {
	@Test
	public void Path() {
		 com.crm.genericUtilities.JavaUtility jLib = new com.crm.genericUtilities.JavaUtility();

		POJOClassForBDD pObj = new POJOClassForBDD("Ravana","Ramayana"+jLib.getRandomNumber(),"complited",1000);

		given()
		.pathParam("pid1", "TY_PROJ_404")
		.body(pObj)
		.contentType(ContentType.JSON)

		.when()  
		. put("http://localhost:8084/projects/{pid1}")
		.then().log().all();
	}

}
