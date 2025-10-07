package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {
	
	@Test
	public void BasicAuth() {
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("http://postman-echo.com/");
		
		RS.basePath("/basic-auth");
		
		Response rs= RS.auth().basic("postman", "password").get();
		
		String Statusline=rs.getStatusLine();
		
		System.out.println(Statusline);
		
		System.out.println(rs.getBody().asString());
	
		
	}

	@Test
	public void digestAuth() {
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("http://httpbin.org");
		
		RS.basePath("/digest-auth/underfined/prachi/prachi");
		
		Response response=RS.auth().digest("prachi", "prachi").get();
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getBody().asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
}
