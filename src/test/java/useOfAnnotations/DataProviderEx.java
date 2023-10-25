package useOfAnnotations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderEx {
	WebDriver driver;
	
	@DataProvider(name="FullName")
	public void sampleTest(String fName, String lname) {
		System.out.println(fName + " " + lname);
	}
	
	@Test(dataProvider = "FullName")
	public Object[][] dataProviderMethod(){
		Object[][] data={ {"Kayra" , "Mehta"},{"urvashi","Kalwani"} };
		return data;
		
	}
//	@Test(priority = 0)
//	public void updateProfile() {
//		System.out.println("Test with priority 0");
//	}
//	
//	

}
