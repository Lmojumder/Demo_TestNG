package TestNG_Classes;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Utilities_P.C_44_TNG_Utilities;

public class SearchTest extends C_44_TNG_Utilities{
  

@Test(priority=1)
  public void land_into_the_website() throws IOException {
	  test=reports.createTest("Land_onthe_Homepage_verify page_Title").assignAuthor("Lubna").assignCategory("functionalTest").assignDevice("windows");
	  
	  
	  
	  String Expected_Titile="Ggoogle";
	  
	  test.info("capturing Page Title");
	  log.info("capturing Page Title");
	  
	  String Actual_Title=driver.getTitle();
	  
	  test.info("Captured page Title as :"+ Actual_Title);
	  log.info("Captured page Title as :"+ Actual_Title);
	  
	  if(Actual_Title.equals(Expected_Titile)) {
		  test.pass("page title is verified");
		  log.info("Page Title is verified");
	  }
	  else {
		  test.fail("page title expeted:"+ Actual_Title+ "But found:"+Actual_Title);
		  log.info("Page titile expeted:"+ Actual_Title+ "But found:"+Actual_Title);
		 test.addScreenCaptureFromPath(CapturesScreenshots("er_ss"),"Test Failed");
		 
  }
	  
}  	  
@Test(priority=2)

	  public void click_on_About_Button() throws IOException, InterruptedException{
	 test=reports.createTest("Land_onthe_Homepage_Verify page_Title").assignAuthor("Lubna").assignCategory("functionalTest").assignDevice("windows");
	 test.info("Navigate to about page");
	 try {
	
		 
		 driver.findElement(By.linkText("about")).click();
	 test.pass("licked on about button");
 }
	 catch(Exception e) {
		 test.fail("Unexpected erro in application : "+ e.getMessage());
		 test.addScreenCaptureFromPath("er_ss", "failed to Click about button");
	 }	
}


}
	

