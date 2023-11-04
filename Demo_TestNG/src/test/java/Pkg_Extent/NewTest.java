package Pkg_Extent;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeTest;

import javax.swing.text.Utilities;

import org.testng.annotations.AfterTest;

public class NewTest extends Utilities{
	 ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("LubnaMojumderExtenReport.html");
	  ExtentTest test;
  @Test

 public void test1() {
ExtentTest test=extent.createTest("Luncwait Browser and go to website").assignAuthor("Lubna").assignCategory("Smoke Test").assignDevice("Windows and Chrome");
//Browserinitialized
//implicit wait given
//maximize the screen
//cleared cookies

//test.log(Status.PASS, "User Launched Website Successfully");
test.pass("User Launched Website Successfully");
  }
	  
	  @Test
	  public void test2() {
		  ExtentTest test=	extent.createTest("Verified login").assignAuthor("Lubna").assignCategory("Regression Test").assignDevice("Windows and Chrome");
		  //clicked on login button
		  //alert generated
		  test.info("alerts displaying");
		  
		  //accepted the alert
		  //verified homepage after login successfully
		  
		  test.pass("user logged in ti the application successfully");
		  
		  //wait for password reset alert
		  //password reset alert generated . verify it
		  
		  test.warning("Reset Password Alert displayed");
		  
  }
	  
	  @Test
	  public void test3() {
		  ExtentTest test=	extent.createTest("Verified dashboard").assignAuthor("Lubna").assignCategory("Sanity Test").assignDevice("Windows and Chrome");
		  //#verify the dasboard title
		  //verify dasboard
		  //verification failed in soft assert
		  test.skip("Verify dashboard Skipped");
	  }
	  
	  @Test
	  public void test4() {
		  ExtentTest test=	extent.createTest("Verified user Send email from Test Application").assignAuthor("Lubna").assignCategory("Sanity Test").assignDevice("Windows and Chrome");
		  //verify email
		  //verification failed with server down pop up
		test.fail("unable to email, due to server down time");
	  }
	  
	  @Test
	  public void test5() {
		  ExtentTest test=	extent.createTest("Verify Logout Feature") ; 
		  
		  //click on logout button
		  //verify logout page
		 test.pass("user logged out from application");
		 test.info("user is redirected to login page again");
		  
	  }
	  
	  
  @BeforeTest
  public void beforeTest() {
	  
	  extent.attachReporter(spark);

  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
