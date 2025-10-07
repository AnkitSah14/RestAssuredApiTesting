package RestAssuredPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutMethod {
	

	@Test
	public void test01() {
	
	JSONObject js=new JSONObject();
	
    js.put("name","Nargish");
    
    js.put("job","Teacher");
    
    
    RestAssured.baseURI="https://reqres.in/api/users/56";
    
    RestAssured.given().header("x-api-key", "reqres-free-v1").contentType(ContentType.JSON).
    body(js.toJSONString()).when().put().then().statusCode(200).log().all();
    
}
	
}
