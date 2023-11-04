package loggerPack;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestLogger {

	public static WebDriver driver;
	public static Logger Log;
	 
	 
	 public static void main(String[] args) {
	 Log = LogManager.getLogger(TestLogger.class);
	 
	 WebDriverManager.chromedriver().setup();
	 Log.info("chromedriver Setup is complete");
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 Log.info("implicitlywait of 10 Second");
	 driver.get("https://www.myntra.com");
	 Log.info("Logged into Myntra");
	 
	 try {
	 boolean text=driver.findElement(By.xpath("//a[contains(text(),'Women111')]")).isDisplayed();
	 }
	 catch (Exception e) {
	 System.out.println(e.getMessage());
	 Log.error("Exceptioin Occured",new Exception("element Not Found"));
	 }
	 finally {
	 driver.quit();
	 Log.info("Quitting the Driver");
	 }				
}
}