package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class ValidateResponseHeader {
	
	
	@Test
	public void Test01() {
		
		
		RequestSpecification rs=RestAssured.given();
		
//		rs.baseUri("https://reqres.in/");
//		
//		rs.basePath("/api/users/2");
		
		Response response= rs.get("https://reqres.in/api/users/2");
		
		String contenttype=response.getHeader("Content-Type");
		
		Assert.assertEquals(contenttype, "application/json; charset=utf-8","Error");
		
		System.out.println(contenttype);
		
		
		Headers headerlist=response.getHeaders();
		
		for(Header listheader:headerlist) {
			
			System.out.println(listheader.getName());
			
			System.out.println(listheader.getValue());
		}
		
		
		
		
		
		
		
		
		
		
	}

}
