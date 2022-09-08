package UsingGenericutility;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.genericUtilities.BaseClassAPI;
import com.crm.genericUtilities.DataBaseUtility;
import com.crm.genericUtilities.EndPointsLibrary;
import com.crm.genericUtilities.IConstants;
import com.crm.genericUtilities.RestAssuredLibrary;
import com.mysql.jdbc.Driver;

import crudWithBDD.POJOClassForBDD;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndTesting {
	@Test
	public void chainig() throws SQLException {

		com.crm.genericUtilities.JavaUtility jLib = new com.crm.genericUtilities.JavaUtility();
		 
		POJOClassForBDD pObj = new POJOClassForBDD("Ravana","Ramayana"+jLib.getRandomNumber(),"complited",1000);

		baseURI="http://localhost";
		port=8084;
		Response response = given()
				.body(pObj)
				.contentType(ContentType.JSON)

				.when()
				.post(EndPointsLibrary.createProject);

		//String projectId = response.jsonPath().get("projectId");
		 RestAssuredLibrary rLib = new RestAssuredLibrary();
		 String projectId=rLib.getJsonPath(response, "projectId");
		System.out.println(projectId);


	given()
		.pathParam("pid", projectId)
		.get(EndPointsLibrary.getSingleProject+"{pid}")
		.then().assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();

		POJOClassForBDD pObj11=new POJOClassForBDD("Ramaaaa","Ramayana"+jLib.getRandomNumber(),"complited",3);
	given()
		.pathParam("pid1", projectId)
		.body(pObj11)
		.contentType(ContentType.JSON)

		.when()  
		. put(EndPointsLibrary.getSingleProject+"{pid1}")
		.then().log().all();


	given()
		.pathParam("pid2", projectId)
		.when()
		.delete(EndPointsLibrary.getSingleProject+"{pid2}")
		.then().log().all();



		//Verify in the DataBase
	  BaseClassAPI baseApi = new BaseClassAPI();
	  baseApi.dbConfig();
	  DataBaseUtility dLIb = new DataBaseUtility();
		java.sql.Statement statement = dLIb.connection.createStatement();
		ResultSet result = statement.executeQuery("select * from project");
		boolean flag=false;
		while (result.next()) {
			System.out.println(result.getString(1));
			if ((result.getString(1)).contains(projectId)) {

				flag=true;
				break;
			}
		}
		if (flag==true) {
			System.out.println("Project is not Deleted From Database!");
		}else {
			System.out.println("Project is Deleted From Database !");
		}
		dLIb.connection.close();

		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.get(IConstants.RmgUri);
		driver.findElement(By.id("usernmae")).sendKeys(IConstants.appUserName);
		driver.findElement(By.id("inputPassword")).sendKeys(IConstants.appPassword);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> projectIds = driver.findElements(By.xpath("//tr//td[1]"));
		boolean flag1=false;
		for (WebElement id : projectIds) {

			String proId = id.getText();
			
			if (proId.equalsIgnoreCase(projectId)) {
				flag1=true;
			}
		}
		if (flag1==true) {
			System.out.println("Project is not Deleted From Database!");
		}
		else {
			System.out.println("Project is Deleted From Database!");

		}
	}

}
