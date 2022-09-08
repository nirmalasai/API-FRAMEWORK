package crudOperaationsWithBDD;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Then;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class ReadAll {
	@Test
	public void Read() {


		ValidatableResponse djkfh = get("http://localhost:8084/projects")
				.then().assertThat().statusCode(200)
				.and().contentType(ContentType.JSON)
				.and().log().all();

	}

}
