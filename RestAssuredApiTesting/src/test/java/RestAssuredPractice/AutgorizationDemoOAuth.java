package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AutgorizationDemoOAuth {
	
	static String accrestoken;
	
	
	@Test
	public void oAuth2() {
		
//		https://api-m.sandbox.paypal.com/v1/oauth2/token
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("https://api-m.sandbox.paypal.com");
		
		RS.basePath("/v1/oauth2/token");
		
		
		Response response =RS.auth().preemptive().basic("AUVGNtkCuVo9U0NEzcE2Tj4AP9A4e-s5ErOIgXSRNHoYc6SR2IXN8sF8N9fYU90a8z1rpiaW2aPKw3ci", "EGemvJSy6K6GWAUU7TKWDlS2JTtOYOiVgQ4tuUpk7n1wvflU_QeWB9284zB3eJ3DJN4QHQ_NfmO4T7mT")
		.param("grant_type", "client_credentials").post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200);
		
		accrestoken=response.getBody().path("access_token");
		
		System.out.println(accrestoken);
		
		
	}
	
	@Test(dependsOnMethods ="oAuth2" )
	public void invoice() {
		
		Response res=RestAssured.given().auth().oauth2(accrestoken).queryParam("page",3).queryParam("page_size", 4).queryParam("total_count_required", true).when().get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");
		
		System.out.println("-----------------------------------------------------");
		
        System.out.println(res.getBody().asString()); // Display in normal line way
        
        res.prettyPrint();// Display in beautiful or align way
        
		System.out.println(res.getStatusCode());
		
		System.out.println(res.getStatusLine());
		
		
	}

}
