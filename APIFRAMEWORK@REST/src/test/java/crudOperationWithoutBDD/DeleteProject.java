package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteProject {
	
	@Test
	public void deleteProject() {
		RestAssured.delete("http://localhost:8084/projects/TY_PROJ_2002");
		
	}

}
