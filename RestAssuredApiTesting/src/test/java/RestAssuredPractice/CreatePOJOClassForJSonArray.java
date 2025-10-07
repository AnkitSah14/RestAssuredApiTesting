package RestAssuredPractice;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreatePOJOClassForJSonArray {
	
	
	@Test
	public void createEmployeeJsonArray() throws JsonProcessingException {
		
		 Employee emp1=new Employee();
		 
		 emp1.setAge(23);
		 
		 emp1.setFirstname("Ankit");
		 
		 emp1.setJob("WQ");
		 
		 emp1.setLastname("Sah");
		 
 Employee emp2=new Employee();
		 
		 emp2.setAge(24);
		 
		 emp2.setFirstname("Ankit66");
		 
		 emp2.setJob("WQ");
		 
		 emp2.setLastname("Sah");
		 
 Employee emp3=new Employee();
		 
		 emp3.setAge(273);
		 
		 emp3.setFirstname("Ankit8899");
		 
		 emp3.setJob("WQ");
		 
		 emp3.setLastname("Sah");
		 
		 ArrayList<Employee> Arraylist=new ArrayList<Employee>();
		 
		 Arraylist.add(emp1);
		 
		 Arraylist.add(emp2);
		 
		 Arraylist.add(emp3);
		 
		 
		 System.out.println("--------------serialize-------------------");
		
		ObjectMapper OM=new ObjectMapper();
		
		String ArrayJsonData=OM.writerWithDefaultPrettyPrinter().writeValueAsString(Arraylist);
		
		System.out.println(ArrayJsonData);
		
		RequestSpecification RS=RestAssured.given();
		
		RS.baseUri("http://httpbin.org/post");
				
		RS.contentType(ContentType.JSON);
		
		RS.body(ArrayJsonData);
		
		Response response=RS.post();
		
		System.out.println("-------------Deserialize---------------");
		
		response.prettyPrint();
		
		ResponseBody responsebody=response.getBody();
		
		JsonPath jsonpath=responsebody.jsonPath();
		
		List<Employee>  listofjsondata= jsonpath.getList("json",Employee.class);
		
		for(Employee x:listofjsondata) {
			
			System.out.println(x.getFirstname());
			
				
		}
		
		
	}
	
	

}
