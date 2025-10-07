package RestAssuredPractice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(value= {"age","job"})
public class NestedJSonObjectPOJOClass {
	
	
	
	private String name;
	
	private int age;
	
	private String job;
	
	private List<String> companies;
	
	private List<AnotherNestedData> details;
	

	public List<AnotherNestedData> getDetails() {
		return details;
	}

	public void setDetails(List<AnotherNestedData> details) {
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int i) {
		this.age = i;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public List<String> getCompanies() {
		return companies;
	}

	public void setCompanies(List<String> companies) {
		this.companies = companies;
	}
	
	
	
	

}
