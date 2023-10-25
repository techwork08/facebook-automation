package useOfAnnotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersEx {
	WebDriver driver;
	
//	@Test(priority = 0)
//	public void login() {
//		System.out.println("Test with priority 0");
//	}
//	
//	@Test
//	public void logout() {
//		System.out.println("logout");
//	}
//	
//	
//	
	@Parameters({"browser","url"})
	@Test(priority=0)
	public void launchUrl(String browser, String url) {
	      System.out.println("sampleParamName = " + browser);
	      
	      if(browser.equalsIgnoreCase("Chrome")) {
	    	  driver=new ChromeDriver();
	    	  
	      }else if(browser.equals("Edge")) {
	    	  driver=new EdgeDriver();
	    	  
	      }
	      driver.get(url);
	   }

}
