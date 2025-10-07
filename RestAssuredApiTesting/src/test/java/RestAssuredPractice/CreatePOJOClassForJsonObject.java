package RestAssuredPractice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreatePOJOClassForJsonObject {
	
	
	
	@Test
	public void serialization() throws JsonProcessingException {
		
	Employee Javaclass=new Employee();
		
		Javaclass.setFirstname("Ankit");
		
		Javaclass.setLastname("Sah");
		
		Javaclass.setAge(29);
		
		Javaclass.setJob("QA");
		
		
		ObjectMapper OM=new ObjectMapper();
		
		String JsonClass=OM.writerWithDefaultPrettyPrinter().writeValueAsString(Javaclass);
		
	    System.out.println(JsonClass);
	    
	    Employee emp2=OM.readValue(JsonClass, Employee.class);
	    
	    System.out.println(emp2.getAge());
	    
	    System.out.println(emp2.getFirstname());

	    System.out.println(emp2.getJob());

	    System.out.println(emp2.getLastname());
	    
	    System.out.println(emp2);


	 
	    
	
		
		
		
		
	}

}
