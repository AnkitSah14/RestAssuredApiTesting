package RestAssuredPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteMethod {
	
	@Test
	public void testo1() {
		
	RestAssured.baseURI="https://reqres.in/api/users/56";
	
	RestAssured.given().header("x-api-key", "reqres-free-v1")
	.when().delete().then().statusCode(204).log().all();
		
		
	}

}
