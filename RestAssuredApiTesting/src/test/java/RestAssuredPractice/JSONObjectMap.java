package RestAssuredPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class JSONObjectMap {
	
	@Test
	public void testo1() {
		
		Map<String,String> authtoken=new HashMap<String,String>();
		
		authtoken.put("username", "admin");
		
		authtoken.put("password", "password123");
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("http://restful-booker.herokuapp.com/auth");
		
		RS.contentType(ContentType.JSON);
		
		RS.body(authtoken);
		
		Response response=RS.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}
	
	@Test
	public void test02() {
		
		/*{
			  "name": "John Doe",
			  "age": 30,
			  "salary": 75000.5,
			  "isMarried": false,
			  "spouse": null,
			  "skills": ["Java", "Selenium", "RestAssured"],
			  "address": {
			    "city": "Delhi",
			    "zip": 110001
			  }
			}*/
		
		HashMap<String,Object> data=new HashMap<String,Object>();
		
		data.put("name", "John Doe");
		
		data.put("age",30);
		
		data.put("salary",75000.5);
		
		data.put("spouse",null);
		
		ArrayList<String> arraydata=new ArrayList<String>();
		
		arraydata.add("Java");
		
		arraydata.add("Selenium");
		
		arraydata.add("RestAssured");
		
		data.put("skills", arraydata);
		
		HashMap<String,Object> objectdata=new HashMap<String, Object>();
		
		objectdata.put("city", "Delhi");
		
		objectdata.put("zip", 110001);
		
		data.put("address", objectdata);
		
		Response response=RestAssured.given().baseUri("https://reqres.in").basePath("/api/users").header("x-api-key", "reqres-free-v1").contentType(ContentType.JSON).body(data).post();
		
		Assert.assertEquals(response.statusCode(),201);

		
	}

}
