package TestNG;

import org.testng.annotations.DataProvider;

public class Dataclass {
	
	
	@DataProvider(name="TestData")
	
	public Object[][] data() {
		
		return new Object[][] {{3,5},{6,8},{3,3},{1,2}};
		
	}

}
