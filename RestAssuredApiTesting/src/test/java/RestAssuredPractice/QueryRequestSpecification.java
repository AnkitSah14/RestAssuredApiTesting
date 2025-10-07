package RestAssuredPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {
	
	
	@Test
	public void createUser() {
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("https://reqres.in/");
		
		RS.basePath("/api/users");
		
		RS.header("x-api-key", "reqres-free-v1");
		
		JSONObject jsonobject=new JSONObject();
		
		jsonobject.put("name","nargish");
		
		jsonobject.put("job", "QA");
		
		RS.contentType(ContentType.JSON).body(jsonobject.toJSONString());
		
		QueryableRequestSpecification QueryRS=SpecificationQuerier.query(RS);
		
		System.out.println(QueryRS.getBaseUri());
		
		System.out.println(QueryRS.getBasePath());
		
		String body=QueryRS.getBody();
		
		System.out.println(body);
		
		Headers allheaders=QueryRS.getHeaders();
		
		for(Header listheader: allheaders) {
			
			System.out.println(listheader.getName());
			
			System.out.println(listheader.getValue());
			
			
		}
		
		
		
	}
	
	

}
