package genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class Utility {
	
	
	
	
  public static String getPropertyValue(String path , String key) {
   String v="";

	try {
		Properties p=new Properties();
		p.load(new FileInputStream(path));
		v=p.getProperty(key);
	} catch (Exception e) {
		System.out.println("---getProperty value FAIL---");
	}

		return v;

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	public static String getXLdata(String path, String sheet, int row, int cel) {
		String v="";
		try {
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			v=w.getSheet(sheet).getRow(row).getCell(cel).getStringCellValue().toString();
		} catch (Exception e) {
			Reporter.log("------------getXLdATA FAIL------------",true);
		}
		
		return v;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public static void writeToXL(String path, String name,String sheet,int r, int c){
		try {
			/*
			Workbook w= WorkbookFactory.create(new FileInputStream(new File(path)));
			w.getSheet(sheet).getRow(r).getCell(c).setCellValue(name);
			w.write(new FileOutputStream(path));
			w.close();*/
			
			File file= new File(path);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(inputStream);
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(name);
			wb.write(new FileOutputStream(path));
			wb.close();
			
			

		} catch (Exception e) {
			System.out.println("------------writeToXL FAIL------------");
		}
	
	}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	public static WebDriver openBrowser(String ip, String browser) {
		WebDriver driver;  
		if(ip.equals("localhost")) {
			if(browser.equals("chrome")) {
				driver= new ChromeDriver();
			    }else{
				driver=new FirefoxDriver();
			    }
			
		}else{
				try {
					URL url= new URL("http://"+ip+":4444/wd/hub");
					DesiredCapabilities dc=new DesiredCapabilities();
					dc.setBrowserName(browser);
					driver=new RemoteWebDriver(url,dc);
					
				} catch (Exception e) {
					driver=new ChromeDriver();
				}
			}
		return driver;	
		}

	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static String getScreenshot(WebDriver driver, String folder) {
		Date d =new Date();
		String dateTime=d.toString().replaceAll(":", "_");
		String path=folder+"/"+dateTime+".png";
		Reporter.log(path,true);
		
	try {
		TakesScreenshot t =(TakesScreenshot)driver;
		File srcFile =t.getScreenshotAs(OutputType.FILE);
		File dstFile= new File(path);
		FileHandler.copy(srcFile, dstFile);
		
	} catch (Exception e) {
		Reporter.log("------getPhoto FAILED-----------",true);
		System.out.println("------------getPhoto FAILED------------");
	}
	
	return path;
	
	
	
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	
	
}
