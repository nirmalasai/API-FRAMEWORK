package staticAndDynamicValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class TimeValidation {
	@Test
	public void timeValidation() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
