package RestAssuredPractice;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NestedJSon {
	
	@Test
	public void testo1() throws JsonProcessingException {
		
		NestedJSonObjectPOJOClass NJ=new NestedJSonObjectPOJOClass();
		
//		NJ.setAge(23);
		
		NJ.setName("Ankit");

		NJ.setJob("QA");
		
		List<String> companiesss=new ArrayList<String>();
		
		companiesss.add("ress");
		
		companiesss.add("ressff");

		companiesss.add("resseeee");
		
		NJ.setCompanies(companiesss);
		
		AnotherNestedData details1=new AnotherNestedData();
		
		details1.setBodycount(23);
		
		details1.setLastname("Sah");
		
		details1.setName1("Ankitttt");
		
		AnotherNestedData details2=new AnotherNestedData();
		
        details2.setBodycount(20);
		
		details2.setLastname("Sahuuuu");
		
		details2.setName1("tt");
		
		AnotherNestedData details3=new AnotherNestedData();
		
        details3.setBodycount(10);
		
		details3.setLastname("huuuu");
		
		details3.setName1("ttWWWWWWWWWWW");
		
		List<AnotherNestedData> details=new ArrayList<AnotherNestedData>();
		
		details.add(details3);
		
		details.add(details2);
		
		details.add(details1);
		
		NJ.setDetails(details);
		
		
		ObjectMapper OM=new ObjectMapper();
		
		
		
		System.out.println(OM.writerWithDefaultPrettyPrinter().writeValueAsString(NJ));
		
		
	}

}
