package RestAssuredPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.util.ListHashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JOSONArrayDemo {
	
	
	@Test
	public void test01() { 
		
		/*
		 * 
		 * {
  "employees": [
    {
      "name": "John",
      "age": 30,
      "skills": ["Java", "Selenium"]
    },
    {
      "name": "Alice",
      "age": 28,
      "skills": ["Python", "API Testing"]
    },
    {
      "name": "Bob",
      "age": 35,
      "skills": ["C#", "Azure"]
    } */
		
		
	JSONObject jsondata=new JSONObject();
		
		jsondata.put("name","John");
		
		jsondata.put("age",30);
		
		JSONArray jsonarraydata=new JSONArray();
		
		jsonarraydata.add("Java");
		
		jsonarraydata.add("Selenium");
		
		jsondata.put("skills", jsonarraydata);
		
	JSONObject jsondata1=new JSONObject();
		
		jsondata1.put("name","John");
		
		jsondata1.put("age",30);
		
		JSONArray jsonarraydata1=new JSONArray();
		
		jsonarraydata1.add("Java");
		
		jsonarraydata1.add("Selenium");
		
		jsondata1.put("skills", jsonarraydata1);
		
	JSONObject jsondata2=new JSONObject();
		
		jsondata2.put("name","John");
		
		jsondata2.put("age",30);
		
		JSONArray jsonarraydata2=new JSONArray();
		
		jsonarraydata2.add("Java");
		
		jsonarraydata2.add("Selenium");
		
		jsondata2.put("skills", jsonarraydata2);
		
		
		JSONArray loadalldata=new JSONArray();
		
		loadalldata.add(jsondata);
		
		loadalldata.add(jsondata1);

		loadalldata.add(jsondata2);
		
		Response resposne=RestAssured.given().baseUri("https://reqres.in/api/users").header("x-api-key", "reqres-free-v1").contentType(ContentType.JSON).body(loadalldata).post();
		
		resposne.prettyPrint();
		
		Assert.assertEquals(resposne.statusCode(),201);
		
	}
	
	
	@Test
	public void test() {
		
      Map<String,Object> data=new HashMap<String,Object>();
		
		data.put("name", "John Doe");
		
		data.put("age",30);
		
		data.put("salary",75000.5);
		
		data.put("spouse",null);
		
	  Map<String,Object> data1=new HashMap<String,Object>();
			
			data1.put("name", "John Doe");
			
			data1.put("age",30);
			
			data1.put("salary",75000.5);
			
			data1.put("spouse",null);
			
	   Map<String,Object> data2=new HashMap<String,Object>();
				
				data2.put("name", "John Doe");
				
				data2.put("age",30);
				
				data2.put("salary",75000.5);
				
				data2.put("spouse",null);
			
				
		List<Map<String,Object>> listdata=new ArrayList<>();
		
		listdata.add(data2);
		
		listdata.add(data1);

		listdata.add(data);
		
      Response resposne=RestAssured.given().baseUri("https://reqres.in/api/users").header("x-api-key", "reqres-free-v1").contentType(ContentType.JSON).body(listdata).post();
		
		resposne.prettyPrint();
		
		Assert.assertEquals(resposne.statusCode(),201);
		
		
		

		
		
		
		
		
		
	
		
		
		
		
		
	}

}
