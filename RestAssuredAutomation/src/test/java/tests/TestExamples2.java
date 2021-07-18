package tests;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TestExamples2 {

	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
			log().all();
	}
	
}
