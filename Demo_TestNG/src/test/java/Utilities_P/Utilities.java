package Utilities_P;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import jdk.internal.org.jline.utils.Log;

public class Utilities {
	
 static WebDriver driver;	

 
 public static void Ibrowsers(String NameOfBrowser,String url)throws InterruptedException {
	
	 String ud=System.getProperty("user.dir");
	 
	 
	 //ud=D:\Eclipse workspace\my all Eclipse\batch31\ealproject2
	 
	 if(NameOfBrowser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", ud+"Driver\\chromedriver.exe");
	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	
	 }
	 
	 else if(NameOfBrowser.equalsIgnoreCase("Edge")) {
		 System.setProperty("webdriver.edge.driver", ud+"Driver\\msedgedriver.exe");
		 
		 driver = new EdgeDriver();
     		driver.manage().window().maximize();
           driver.get(url);
           	

}
}
 public static void Screenshot()throws IOException {
	 String ud=System.clearProperty("user.dir");
	 Date dateinDateFormat= new Date(0);
	 String Date =dateinDateFormat.toString().replace(" ","_").replace(":", "_");
	 File ScreenshotFile=(File)((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 FileHandler.copy(ScreenshotFile, new File(ud+"\\Screenshot\\Amazon\\"+Date+"myss.jpg"));
 }
 
 
 
 
 
 
 
 
 
 
}