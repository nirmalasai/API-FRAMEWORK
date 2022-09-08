package dataProviderAPI;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crudWithBDD.POJOClassForBDD;
import io.restassured.http.ContentType;

public class UsingDataproviderCreateProject {
	@Test(dataProvider = "dataProvider")
	public void create(String createdBy,String projectName,String status,int teamSize ) {
		
	     POJOClassForBDD jobj = new POJOClassForBDD(createdBy,projectName,status,teamSize);
			
			
			
	      given()
			.body(jobj)   
			.contentType(ContentType.JSON)
			.when()
			  .post("http://localhost:8084/addProject")
		   .then().assertThat().statusCode(201)
			   .and().contentType(ContentType.JSON)
			   .and().log().all();
			
		}
	@DataProvider
	public Object[][] dataProvider() {
		Random ran = new Random();
		int randomNo = ran.nextInt(100);
		 Object[][] objArr = new Object [4][4];
		 objArr[0][0]="san";
		 objArr[0][1]="hii12"+randomNo;
		 objArr[0][2]="complited";
		 objArr[0][3]=10;
		 objArr[1][0]="san1223";
		 objArr[1][1]="hii166"+randomNo;
		 objArr[1][2]="complited";
		 objArr[1][3]=20;
		 objArr[2][0]="san420";
		 objArr[2][1]="hello"+randomNo;
		 objArr[2][2]="complited";
		 objArr[2][3]=420;
		 objArr[3][0]="san220";
		 objArr[3][1]="hello bro"+randomNo;
		 objArr[3][2]="Running";
		 objArr[3][3]=520;
		 
		 return objArr;
		 
		 
	}

}
