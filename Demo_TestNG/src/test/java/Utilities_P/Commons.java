package Utilities_P;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commons {
public	WebDriver driver;
public String ud=System.getProperty("user.dir");
public	Logger log = (Logger)LogManager.getLogger(Commons.class);

public ExtentReports reports = new ExtentReports();
//public ExtentSparkReporter htmlReporter= new ExtentSparkReporter("Results/LubnaMojumderExtentRep_"+System.currentTimeMillis()+".html");
public ExtentSparkReporter htmlReporter=new ExtentSparkReporter("Results/jenkins_extentReport.html");
public ExtentTest test;	


		
/* String Parent=driver.getWindowHandle();
 Actions act=new Actions(driver);
 act.keyDown(Keys.SHIFT).click(fgPass).build().perform();
 act.keyDown(Keys.SHIFT).build().perform();
 
 *********************************
 
 switchtoOpenedWeindow(parent);
 
 *****************************
 
 driver.findElement(By.linkText("Forgot Account?")).clear();
 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 WebElement fgPass=driver.findElement(By.linkText("Forgot Password?"));
 waitforelementclickable(fgPass);
	

*/

public void switchoOpenedWindow(String Parent)throws InterruptedException{
	Set<String>	wins= driver.getWindowHandles();
	for(String sesid:wins) {
	if(sesid!=Parent) {
		driver.switchTo().window(sesid);
		log.info("Window switched- Driver is present in the new Window/Tab");
	
	}}}

		public void waitforelementclickable(WebElement elementvairable) {
			log.info("waitting for element to be clickable");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.elementToBeClickable(elementvairable));	
			
		
}
		
	public void waitforpageTitle(String pagetitle) {
		log.info("Waithing for page Title");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.titleContains(pagetitle));	
	}


		public void Ibrowser(String BrowserName,String URL) throws InterruptedException {
		 if (BrowserName.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.get(URL);
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			 driver.manage().window().maximize();
			 Thread.sleep(4000);
		 }
		 
		 
		 else if (BrowserName.equalsIgnoreCase("edge")) {
			 
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			 driver.get(URL);
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			 driver.manage().window().maximize();
			 Thread.sleep(4000);
		 }
		}
		

		
		  
		public void configureReport() {
			//add system information/environment information to report
		reports.setSystemInfo("Machine", "TestPC1");
		reports.setSystemInfo("OS", "Windows11");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("userName", "lubna");
		
		
	//configuration to change look and feel of report:
		htmlReporter.config().setDocumentTitle("Lubna's report");
		htmlReporter.config().setReportName("Myntra Test report");
		htmlReporter.config().setTheme(Theme.DARK);
		}
		
	

	
		
	}

	

	
	
			

