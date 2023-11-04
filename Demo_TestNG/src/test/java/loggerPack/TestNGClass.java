package loggerPack;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGClass {
	WebDriver driver;
	Logger log = (Logger)LogManager.getLogger(TestNGClass.class);
	
	
  @Test
  public void f() {WebDriverManager.chromedriver().setup();
  log.info("chromedriver Setup is complete");
  
  driver=new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  log.info("implicitlyWait of 10 Second");
  
  driver.get("https://www.myntra.com");  
  log.info("Logged into Myntra");
  
  try  {
	  boolean text=driver.findElement(By.xpath("//a[contains(text(),'Women')]")).isDisplayed();              
	  System.out.println(text);  
	  
	  }
  catch (Exception e) {
		  System.out.println(e.getMessage());
	  log.error("Exceptioin Occured",new Exception("element Not Found")); 
	  
	  }
  finally {
	  driver.quit();
  log.info("Quitting the Driver");
  }}

  }

