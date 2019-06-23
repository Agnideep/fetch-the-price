package genericLib;

/*
 * Interface containing all the constants containing the paths of executables
 * and folders 
 */

public interface IAutoConstants {
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VALUE="./driver/chromedriver.exe";
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VALUE="./driver/geckodriver.exe";
	String RES_PATH="./result/testResult.xlsx";
	String CONFIG_PATH="./input/configuration.properties";
	String FAIL_PHOTO_PATH="./screenshot/fail";
	String SKIP_PHOTO_PATH="./screenshot/skip";
	String DATA_PATH="./input/dataInput.xlsx";
	
}

