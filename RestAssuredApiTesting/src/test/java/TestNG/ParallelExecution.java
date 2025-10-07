package TestNG;

import org.testng.annotations.Test;

public class ParallelExecution {
	
	@Test
	void test1() {
		
		System.out.println("test1..........");
		
		System.out.println(Thread.currentThread());
	}
    
	@Test
	void test2() {
		
		System.out.println("test2...........");
		System.out.println(Thread.currentThread());

	}
}
