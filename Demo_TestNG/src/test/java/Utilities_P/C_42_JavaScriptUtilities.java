package Utilities_P;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C_42_JavaScriptUtilities {
	
	public static void jsclick(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
		
		
	}
	
	
	//scroll upto the elements
	public static void SelectDateByJS(WebDriver driver, WebElement element,String DateValue) {
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].setAttribute('value','"+ DateValue + "')", element);

}

	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollINtoView(true)", element);
		
		
	}
	//scroll bottom of the page
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}
	
	public static void changeColor(String color,WebElement element, WebElement driver) {
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		jsexecutor.executeScript("argument[0].style.backgroundColor='"+color+ "'", element);

	
		
		try {
			Thread.sleep(200);
		} catch(InterruptedException e) {
			//toDo auto-generated catch block
			e.printStackTrace();
		}
			
	}	
		
	public static void flash(WebElement element, WebElement driver) {
	
	String bgcolor=element.getCssValue("backgroundColor");
	
	System.out.println(bgcolor);
	
	for(int i=0;i<50;i++) {
		changeColor("#FF000", element,driver);
		changeColor(bgcolor,element,driver);
	}
	
	
	
	}
 //Drew border
	
public static void drawBorder(WebElement element, WebDriver driver) {	
JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;	
jsexecutor.executeScript("arguments[0].style.border='3px solid green'", element)	;
	
	
}
//Generate alert

	public static void generateAlert(WebDriver driver, String message) {
	JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;	
	jsexecutor.executeScript("alert('"+message+"')");
		

	
}
}
