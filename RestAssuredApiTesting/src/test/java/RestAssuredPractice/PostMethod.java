package RestAssuredPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostMethod {
	
	
	@Test
	public void Test01() {
		
		JSONObject jsonobj=new JSONObject();
		
		jsonobj.put("name","Ankit");
		
		jsonobj.put("job","QA");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		RestAssured.given().header("x-api-key", "reqres-free-v1").
		contentType(ContentType.JSON).
		body(jsonobj.toJSONString()).
		when().post().
		then().statusCode(201).log().all();
	
		
	}

}
