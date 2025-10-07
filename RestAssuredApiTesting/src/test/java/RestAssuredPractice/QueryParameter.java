package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameter {
	
	@Test
	public void Test01() {
	
	RequestSpecification RS=RestAssured.given();
	
	RS.baseUri("https://reqres.in/");
	
	RS.basePath("/api/users");
	
	RS.header("x-api-key","reqres-free-v1");
	
	RS.queryParam("page",2).queryParam("id", 10);
	
	Response response=RS.get();
	
	//Get the particular data from JSON
	
	JsonPath jsonpath=response.jsonPath();
	
	String firstname=jsonpath.get("data.first_name");
	
	Assert.assertEquals(firstname, "Byron","Error Bhaiya");
	
	
	//Get the body
	
	String getBody=response.getBody().asString();
	
	System.out.println(getBody);
	
	
	
	
	
	
	

	
	}

}
