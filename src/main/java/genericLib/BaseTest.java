package genericLib;

import org.openqa.selenium.WebDriver;

public  class BaseTest implements IAutoConstants {
	
public WebDriver driver;
	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
}
