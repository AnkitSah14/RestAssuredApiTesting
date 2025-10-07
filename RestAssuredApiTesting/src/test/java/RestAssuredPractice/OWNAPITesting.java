package RestAssuredPractice;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OWNAPITesting {
	
	
	@Test
	public void getuserData() {
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("http://localhost:3000/");
		
		RS.basePath("/users");
		
		Response response=RS.get();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test
	public void creatuserData() {
		

		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("http://localhost:3000/");
		
		RS.basePath("/users");
		
         JSONObject jsonobj=new JSONObject();
		
		jsonobj.put("name","Ankit");
		
		jsonobj.put("job","QA");
		
		RS.contentType(ContentType.JSON).
		body(jsonobj.toJSONString()).
		when().post().
		then().statusCode(201).log().all();
	
		
		
	}
	
	@Test
	public void DeleteData() {
		
        RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("http://localhost:3000/");
		
		RS.basePath("/users");
	
		RS.when().delete("/a1cc").
		
		then().statusCode(200).log().all();
	
		
		
		
		
	}

}
