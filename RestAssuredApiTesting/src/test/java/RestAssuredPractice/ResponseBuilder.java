package RestAssuredPractice;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseBuilder {
	
	ResponseSpecification RS=null;
	
	@BeforeClass
	public void commonresponse() {
		
		ResponseSpecBuilder commonresponsee=new ResponseSpecBuilder();
		
		commonresponsee.expectStatusCode(200).expectStatusLine("HTTP/1.1 200 OK").expectResponseTime(Matchers.lessThan(5000L));
		
		RS=commonresponsee.build();
		
	}
	
	
	@Test
	public void withoutresponsebuilder() {
		
		RestAssured.given().baseUri("http://restful-booker.herokuapp.com/booking").when().get().then().statusCode(200).statusLine("HTTP/1.1 200 OK")
		
		.time(Matchers.lessThan(5900L));
		
		
		
	}
	
	
	@Test
   public void withresponsebuilder() {
	   
		
		RestAssured.given().baseUri("http://restful-booker.herokuapp.com/booking").when().get().then().spec(RS).body("size()",Matchers.greaterThan(0));
		
	}
	
	

}
