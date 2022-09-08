package UsingGenericutility;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.RestAssuredLibrary;

import crudWithBDD.POJOClassForBDD;
import io.restassured.http.ContentType;

public class BasicAuthUsingGeneric {
	
	@Test
	public void basic() {
		
		 com.crm.genericUtilities.JavaUtility jLib = new com.crm.genericUtilities.JavaUtility();
		 RestAssuredLibrary rLib = new RestAssuredLibrary();

		POJOClassForBDD pObj = new POJOClassForBDD("Ravana","Ramayana"+jLib.getRandomNumber(),"complited",1000);

	     //String uri="http://localhost:8084"+EndPointsLibrary.log;
	     baseURI="http://localhost";
	     port=8084;

		 given()
		 .auth().basic(IConstants.appUserName, IConstants.appPassword)
			.body(pObj)
			.contentType(ContentType.JSON)
			.when()
			.get(EndPointsLibrary.log)
			
		//	  .post("http://localhost:8084/addProject")
		   .then().assertThat().statusCode(202)
			   .and().contentType(ContentType.JSON)
			   .and().log().all();
			
	}
	

}
