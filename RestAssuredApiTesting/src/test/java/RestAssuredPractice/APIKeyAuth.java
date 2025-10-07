package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIKeyAuth {
	
	
	@Test
	public void APIKEY() {
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("https://api.openweathermap.org");
		
		RS.basePath("/data/2.5/weather");
		
		RS.queryParam("q", "Patna").queryParam("appid", "ed9997485c5aebf644ef046becfceb6e");
		
		Response rs=RS.get();
		
		Assert.assertEquals(rs.getStatusCode(), 200);
		
		
	}

}
