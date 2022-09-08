package dataProviderAPI;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtilities.ExcelUtility;

import crudWithBDD.POJOClassForBDD;
import io.restassured.http.ContentType;

public class UsingDataProviderFromExcel extends ExcelUtility{


	@Test(dataProvider = "dataProvider3")
	public void createS(String createdBy,String projectName,String status,int teamSize ) {

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
	public Object[][] dataProvider3() {

		Random random = new Random();
		int randomNum = random.nextInt();
		
		Object[][] objArr = new Object [4][4];
		objArr[0][0]=readDataFromExcel("Api", 1, 0);
		objArr[0][1]=readDataFromExcel("Api", 1, 1)+randomNum;
		objArr[0][2]=readDataFromExcel("Api", 1, 2);
		objArr[0][3]=readDataFromExcel("Api", 1, 3);

		objArr[1][0]=readDataFromExcel("Api", 2, 0);
		objArr[1][1]=readDataFromExcel("Api", 2, 1)+randomNum;
		objArr[1][2]=readDataFromExcel("Api", 2, 2);
		objArr[1][3]=readDataFromExcel("Api", 2,3);

		objArr[2][0]=readDataFromExcel("Api", 3,0);
		objArr[2][1]=readDataFromExcel("Api", 3, 1)+randomNum;
		objArr[2][2]=readDataFromExcel("Api", 3, 2);
		objArr[2][3]=readDataFromExcel("Api",3, 3);

		objArr[3][0]=readDataFromExcel("Api", 4,0);
		objArr[3][1]=readDataFromExcel("Api", 4, 1)+randomNum;
		objArr[3][2]=readDataFromExcel("Api", 4, 2);
		objArr[3][3]=readDataFromExcel("Api", 4 ,3);
		return objArr;


	}

}
