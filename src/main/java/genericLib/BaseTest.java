package genericLib;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/*
 * BaseTest class which is extended by all other classes 
 * Sets the property of driver executables
 * Sets the url,timeouts variables from the property file
 * Implements testng annotations to open applications,close application and take screenshot using generic methods
 * Listener class is implemented with the Basetest class
 * 
 */


@Listeners(Result.class)	
public  abstract class BaseTest implements IAutoConstants {


public WebDriver driver;
	
	/*
	 * Static block sets the path of the driver executables	
	 */

	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	
	
	public String URL=Utility.getPropertyValue(CONFIG_PATH, "url");
	public String ITO=Utility.getPropertyValue(CONFIG_PATH, "ito");
	public long lngITO=Long.parseLong(ITO);
	
	
	public String ETO=Utility.getPropertyValue(CONFIG_PATH, "eto");
	public long lngETO=Long.parseLong(ETO);
	
	
	/*
	 *Parameters annotation used to pass ip, browser values from testng.xml file 
	 *Before method executes before every @test method
	 */
	
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)

	public void openAPP(@Optional("localhost")String ip,@Optional("chrome")String browser) {
		
		
		driver=Utility.openBrowser(ip, browser);
		driver.manage().timeouts().implicitlyWait(lngITO, TimeUnit.SECONDS);
		driver.get(URL);
		
	}
	
	/*
	 * Aftermethod exectues after every @test method
	 */
	
	@AfterMethod(alwaysRun=true)
	public void closeAPP(ITestResult result) {
		String name= result.getName();
		int status=result.getStatus();
		if(status==2) {
			String fp= Utility.getScreenshot(driver, FAIL_PHOTO_PATH);
			Reporter.log("Testname : "+name+ "Status :"+ "FAIL" + status, true);
			Reporter.log("PHOTO :"+fp);
		}else if (status==3) {
			String sp=Utility.getScreenshot(driver, SKIP_PHOTO_PATH);
			Reporter.log("Testname : "+name+ "Status :"+ "SKIP" + status, true);
			Reporter.log("PHOTO :"+sp);
		}else {
			Reporter.log("Testname : "+name+ "Status :"+ "PASS" + status, true);
		}
		
		driver.quit();
	}
	
	
}
