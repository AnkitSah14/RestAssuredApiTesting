package TestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderss {
	
	
	@Test(dataProvider = "TestData")
	void add(int x,int y) {
		
		int sum=x+y;
		
		System.out.println(sum);
	
		
	}
	
	@DataProvider(name="TestData")
	
	public Object[][] data() {
		
		return new Object[][] {{3,5},{6,8},{3,3},{1,2}};
		
	}

	

}
