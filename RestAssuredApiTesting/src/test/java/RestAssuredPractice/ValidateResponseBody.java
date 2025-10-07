package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseBody {
	
	
	@Test
	public void test01() {
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("https://reqres.in");
		
		RS.basePath("/api/users?page=2");
		
		RS.header("x-api-key","reqres-free-v1");
		
		Response response=RS.get();
		
		ResponseBody responsebody=response.getBody();
		
//		String responsebodystring=responsebody.asString();
//		
//		Assert.assertEquals(responsebodystring.contains("Janet"),true,"error");
//		
		
		JsonPath jsonpath= responsebody.jsonPath();
		
		
		
		String lastname=jsonpath.get("data[0].last_name");
		
		Assert.assertEquals(lastname, "Lawson","Error Bhai");
		

	}

}
