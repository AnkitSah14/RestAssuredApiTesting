package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class TryTestSuite {
	
	
	 WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	public void Browserchoose(String browsername) {
		
		
		if(browsername.equals("Chrome")) {
			
		
		  driver=new ChromeDriver();
		  
		  driver.get("https://www.wwe.com/");
		  
		  driver.manage().window().maximize();
		 
		
		}
		
		else if(browsername.equals("FireFox")) {
			
			driver=new FirefoxDriver();
			
			driver.get("www.google.com");
			  
		    driver.manage().window().maximize();
			 
			
		}
		
		else if(browsername.equals("Edge")) {
			
			driver=new EdgeDriver();
		
			driver.get("www.google.com");
			  
			driver.manage().window().maximize();
			 
			
		}	
		
		
	}
	
	@Test(groups = "Sanity")
	public void  test1() {
		
		System.out.println("anothertest1..........");
		
		Assert.assertTrue(false);
		
		
	}
	
	@Test
	public void  test2() {
		
		System.out.println("anothertest2..........");
		

	}
	
	@Test(dependsOnGroups = "Sanity",alwaysRun = true)
	public void  test3() {
		
		System.out.println("anothertest3..........");

	}
	
	@Test(groups = "Sanity")
	public void  test4() {
		
		System.out.println("anothertest4..........");

	}

}
