package RestAssuredPractice;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadDemo {
	
	
	@Test
	public void uploadFile() {
		
		File filedata=new File("C:\\Users\\ankit\\OneDrive\\Pictures\\Screenshots\\Screenshot (1).png");
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("https://petstore.swagger.io/v2/pet/1/uploadImage");
		
		RS.multiPart("file",filedata);
		
		RS.contentType("multipart/form-data");
		
		Response response=	RS.post();
		
		response.prettyPrint();
				
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}

}
