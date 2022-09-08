package UsingGenericutility;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.genericUtilities.BaseClassAPI;
import com.crm.genericUtilities.DataBaseUtility;
import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.RestAssuredLibrary;

import POM.LoginThenVerifyAndLogoutRMGYantra;
import crudWithBDD.POJOClassForBDD;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndTestCase extends BaseClassAPI {

	com.crm.genericUtilities.JavaUtility jLib = new com.crm.genericUtilities.JavaUtility();
	BaseClassAPI baseApi = new BaseClassAPI();
	DataBaseUtility dLIb = new DataBaseUtility();
	static String projectId;
	static WebDriver driver;

	@Test
	public void created() throws SQLException {

		

		POJOClassForBDD pObj = new POJOClassForBDD("Ravana","Ramayana"+jLib.getRandomNumber(),"complited",1000);

		baseURI="http://localhost";
		port=8084;

		//adding
		Response response = given()
				.body(pObj)
				.contentType(ContentType.JSON)

				.when()
				.post(EndPointsLibrary.createProject);

		
		RestAssuredLibrary rLib = new RestAssuredLibrary();
		projectId=rLib.getJsonPath(response, "projectId");
		System.out.println(projectId);


		given()
		.pathParam("pid", projectId)
		.get(EndPointsLibrary.getSingleProject+"{pid}")
		.then().assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();

		LoginThenVerifyAndLogoutRMGYantra verifyPresentLayer = new LoginThenVerifyAndLogoutRMGYantra();
		verifyPresentLayer.verifyinPresentationLayer(projectId);

		//Verify in the DataBase
		dLIb.execuiteQuery("select * from project", 1, projectId);
		
//		java.sql.Statement statement = dLIb.connection.createStatement();
//		ResultSet result = statement.executeQuery("select * from project");
//		boolean flag=false;
//		while (result.next()) {
//			System.out.println(result.getString(1));
//			if ((result.getString(1)).contains(projectId)) {
//
//				flag=true;
//				break;
//			}
//		}
//		if (flag==true) {
//			System.out.println("Project is not Deleted From Database!");
//		}else {
//			System.out.println("Project is Deleted From Database !");
//		}



	}
	
	
	@Test
	public void deleted() throws SQLException {

		baseURI="http://localhost";
		port=8084;
		//deleting
		given()
		.pathParam("pid2", projectId)
		.when()
		.delete(EndPointsLibrary.getSingleProject+"{pid2}")
		.then().log().all();

		LoginThenVerifyAndLogoutRMGYantra verifyPresentLayer = new LoginThenVerifyAndLogoutRMGYantra();
		verifyPresentLayer.verifyinPresentationLayer(projectId);

		//Verify in the DataBase
		dLIb.execuiteQuery("select * from project", 1, projectId);
//		java.sql.Statement statement1 = dLIb.connection.createStatement();
//		ResultSet result1 = statement1.executeQuery("select * from project");
//		boolean flag3=false;
//		while (result1.next()) {
//			System.out.println(result1.getString(1));
//			if ((result1.getString(1)).contains(projectId)) {
//
//				flag3=true;
//				break;
//			}
//		}
//		if (flag3==true) {
//			System.out.println("Project is not Deleted From Database!");
//		}else {
//			System.out.println("Project is Deleted From Database !");
//		}
//	
	}
}
