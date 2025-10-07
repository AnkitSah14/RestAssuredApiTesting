package RestAssuredPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken_Authorization {
	
	
	@Test
	public void test01() {
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("https://gorest.co.in");
		
		RS.basePath("/public/v2/user");
		
		JSONObject body=new JSONObject();
		
		body.put("name", "Ankit");
		
		body.put("age", 29);
		
		String Beartoke="dhdkdghbdhshk";
		
		RS.headers("Authorization",Beartoke).contentType(ContentType.JSON).body(body.toJSONString());
		
		Response rs=RS.post();
		
		System.out.println();//Then do according to the need as token is wrong and not availbale
		
	
	}

}
