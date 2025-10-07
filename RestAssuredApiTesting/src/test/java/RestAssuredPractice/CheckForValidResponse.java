package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
	
	
	@Test
	public void GetSingleUser() {
		
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification request=RestAssured.given();
		
		Response res=request.get("/api/users/2");
		
		ValidatableResponse r=res.then();
		
		r.statusCode(200);
		
		r.statusLine("HTTP/1.1 200 OK");
		
//		int StatucCode=res.getStatusCode();
//		
//        Assert.assertEquals(StatucCode, 200,"Error");		
//        
//        String Statusline=res.getStatusLine();
//        
//        Assert.assertEquals(Statusline, "HTTP/1.1 200 OK" ,"Incorrect");
//		
		
		
	}
	
	@Test
	public void Test02_BDD() {
		
		RestAssured.baseURI="https://reqres.in";
		
		RestAssured.given().when().get("/api/users/2").then().statusCode(200).statusLine("HTTP/1.1 200 OK");
		
	}

}
