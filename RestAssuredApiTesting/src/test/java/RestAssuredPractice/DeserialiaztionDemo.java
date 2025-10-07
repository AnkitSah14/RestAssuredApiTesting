package RestAssuredPractice;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserialiaztionDemo {
	
	
	@Test
	public void CreateUser() {
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("https://reqres.in/");
		
		RS.basePath("/api/users");
		
		RS.header("x-api-key", "reqres-free-v1");
		
		JSONObject jsonobj=new JSONObject();
		
		jsonobj.put("name", "Ankit");
		
		jsonobj.put("job", "QA");
		
		Response response=RS.contentType(ContentType.JSON).body(jsonobj.toJSONString()).post();
		
		ResponseBody responsebody =response.getBody();
				
		System.out.println(responsebody.prettyPrint());
		
		
		// Deserilization ------------------------------------------------------------------------
		
		JSONPostRequestResponse responseclass=responsebody.as(JSONPostRequestResponse.class);
		
		Assert.assertEquals(responseclass.name,"Ankit","Errror");
		
		Assert.assertEquals(responseclass.job,"QA","error");
		
		System.out.println(responseclass.id);
		
	
		
		
		
		
	}

}
