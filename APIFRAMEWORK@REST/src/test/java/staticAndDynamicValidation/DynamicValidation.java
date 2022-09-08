package staticAndDynamicValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DynamicValidation {

@Test
public void dynamic() {
	String expectedProjectId="TY_PROJ_1002";
	baseURI="http://localhost";
	port=8084;
	
	Response response = get("/projects");
	 java.util.List<String>  object = response.jsonPath().get("projectId");
		 boolean flag=false;
		 for (String one : object) {
			 
			 if (one.equalsIgnoreCase(expectedProjectId)) {
				flag=true;
			}
						
		}// 
	
		 Assert.assertTrue(flag);
		 
		 response.then().log().all();

}
}
