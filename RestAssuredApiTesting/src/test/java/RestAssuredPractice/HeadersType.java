package RestAssuredPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

public class HeadersType {
	
	@Test
	public void header() {
		
		RequestSpecification RS=RestAssured.given();
		
		RS.header("header1","value1");
		
		RS.log().headers();
		
		RS.baseUri("https://reqres.in/api/users?page=1");
		
		RS.get();
		
		
	}
	
	
	@Test
	public void headers() {
		
		Map<String,String> mapheader=new HashMap<String,String>();
		
		mapheader.put("Ankit", "12345");
		
		mapheader.put("Sah", "122222");
		
        RequestSpecification RS=RestAssured.given();
		
		RS.headers(mapheader);
		
		RS.log().headers();
		
		RS.baseUri("https://reqres.in/api/users?page=1");
		
		RS.get();
	

	}
	
	@Test
	public void headerclass() {
		
		Header headerclass=new Header("Annn", "ase3334");
		
        RequestSpecification RS=RestAssured.given();
		
		RS.header(headerclass);
		
		RS.log().headers();
		
		RS.baseUri("https://reqres.in/api/users?page=1");
		
		RS.get();
		
	}
	
	
	@Test
	public void headersclass() {
		
		
		Header h1=new Header("Ankitttt","1235");
		
		Header h2=new Header("sssss","99898");
		
		Header h3=new Header("wwww","44555");
		
		List<Header> listheader=new ArrayList<Header>();
		
		listheader.add(h3);
		
		listheader.add(h2);
		
		listheader.add(h1);
		
		Headers headersclass=new Headers(listheader);
		
        RequestSpecification RS=RestAssured.given();
		
		RS.headers(headersclass);
		
		RS.log().headers();
		
		RS.baseUri("https://reqres.in/api/users?page=1");
		
		RS.get();

		
	}

}
