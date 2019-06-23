package genericLib;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Webgeneric {
	
	/*
	 * generic method for the project for providing implementation for ExplicitWait
	 */
	
	public static void waitForVisibiltyAndClick(WebDriver driver,Long time, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("ELEMENT"+ element+"is VISIBLE",true);
		}catch(Exception e){
			Reporter.log("ELEMENT"+ element+"is NOT visible",true);
			Assert.fail();
		}
		element.click();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	///////
	
}
