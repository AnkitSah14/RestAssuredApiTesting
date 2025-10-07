package TestNG;

import org.testng.annotations.Test;

public class CreateTestNGClass {
	
	
	@Test(priority=2)
	public void test1() {
		
		System.out.println("test1............");
		
	}
	
	@Test(priority=1,enabled = false)
	public void test2() {
		
		System.out.println("test2.............");
		
	}

}
