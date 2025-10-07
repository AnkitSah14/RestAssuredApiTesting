package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetMethod {
	
	
	@Test
	public void test01(){
		
		Response rs=RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(rs.getStatusCode());
		
		System.out.println(rs.getBody().asString());
		
		System.out.println(rs.getTime());
		
		System.out.println(rs.getHeader("Content-Type"));
		
		int StatusCode=200;
		
		int actualcode=rs.statusCode();
		
		Assert.assertEquals(StatusCode, actualcode);

		
	}
	
	
	@Test
	public void test02() {
		
		//given,when,then
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RestAssured.given().queryParam("page", "2").when().get().then().statusCode(200);
		
		
	}

}
