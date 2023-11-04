package Utilities_P;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Set;

import org.apache.commons.math3.util.Combinations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
public class C_44_TNG_Utilities extends Commons {



@BeforeTest
public void beforeTest() {
	configureReport();
	reports.attachReporter(htmlReporter);
	
	/*extent.attachReporter(spark);
	
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("LubnasReport");
	extent.attachReporter(spark);*/
	
}

@AfterTest
public void afterTest() {
	reports.flush();

}

@Parameters( {"browser","websiteURL"})
  @BeforeClass
public void beforeClass(String browserName, String url)throws InterruptedException, IOException{
	test=reports.createTest("Launch Browser and Go to Website");
	Ibrowsers(browserName, url);
	log.info("User is on the Homepage");
	test.addScreenCaptureFromPath(CapturesScreenshots("er_ss"));
	
}

@AfterClass
public void afterclass()throws InterruptedException{
	Thread.sleep(2000);
	log.warn("browser is closing");
	driver.close();
}

  
  @AfterMethod
  public void aftermethod() throws IOException {
	
}
  
  
  @AfterClass
  public void afterClass() throws IOException {
	  System.out.println("afterclass------closing browser");
	  driver.close();
	  
	  
  }
  
  
  public void Ibrowsers(String NameOfBrowser,String url)throws InterruptedException {
		
		 if(NameOfBrowser.equalsIgnoreCase("chrome")) {
		 System.out.println(ud);
		 WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
	      driver.get(url);
	     log.info("Chrome Browser Initilalized and went to the URL -" + url);
	     
	      driver.manage().window().maximize();
          Thread.sleep(4000);
         log.info("Window Maximized");
	  }

	  else if(NameOfBrowser.equalsIgnoreCase("edge")) {
	   WebDriverManager.edgedriver().setup();
	   
	   driver = new EdgeDriver();
	   driver.get(url);
	  driver.manage().window().maximize();
	  Thread.sleep(4000);
	  
	  }}
	  
	  
  
	  
//Screenshot method
  public void Screenshots(String FolderName) throws IOException {
	  File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destinationFilePath=new File(ud+"\\Pictures\\"+FolderName+"\\Home"+System.currentTimeMillis()+".jpg");
	FileHandler.copy(SS,destinationFilePath);
	log.info("Screenshot Captured")	;
  }
  
  public String CapturesScreenshots(String FolderName) throws IOException {
	  
	  File SS=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destinationFilePath=new File(ud+"\\Pictures\\"+FolderName+"\\Home"+System.currentTimeMillis()+".jpg");
	FileHandler.copy(SS,destinationFilePath);
	log.info("Screenshot Captured for extent Report");
	
	String absolutePathLocation=destinationFilePath.getAbsolutePath();
	return absolutePathLocation;
  }
  
  
  public void tearDown() {
	  driver.close();
	  log.info("Browser Closed");
			
  }
  
  public void switchtoOpenedWindow(String Parent)throws InterruptedException{
	     Set<String> wins=driver.getWindowHandles();
	     
	     for(String sesid:wins) {
	    	 if (sesid!=Parent) {
	    		 driver.switchTo().window(sesid);
	    		 log.info("Window Switched");
	    	 }
	     }
  }
  }
	  
  


