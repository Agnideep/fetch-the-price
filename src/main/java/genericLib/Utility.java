package genericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

/*
 * Utility class contains generic reusable methods.
 */


public class Utility {
	
	
  /*
   * Method to fetch value from property file	
   */
	
	
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
  /*
   * Method to fetch data from excel sheet
   */
	
	
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
	/*
	 * Method to write data into excel in one single row
	 */

	
	public static void writeToXL(String path, String name,String sheet,int r, int c){
		try {
			
			Workbook w= WorkbookFactory.create(new FileInputStream(new File(path)));
			w.getSheet(sheet).getRow(r).getCell(c).setCellValue(name);
			w.write(new FileOutputStream(path));
			((FileInputStream) w).close();
		
		} catch (Exception e) {
			System.out.println("------------writeToXL FAIL------------");
		}
	
	}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * Method to open a perticular browser and set url
	 */

	
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
	
	/*
	 * Method to take a screenshot and store it in specified folder with unique date and timestamp
	 */
	
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

//////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Unused Method to set data in excel. Code used for trials . contains errors
	 */
	
	
	public static void writeDataToXL(String filepath,String value ,int r ,int col)  {
		
		HSSFWorkbook workbook;
		HSSFSheet sheet;
		HSSFCell cell;
		HSSFRow row;
			   
		
	try {
		
			//Importing the excel file
			
			File src=new File(filepath);
			Reporter.log("--"+src+"---",true);
			//Loading the file
			
			FileInputStream finput = new FileInputStream(src);
			
			Reporter.log("--"+finput+"---",true);
			//Loading the workbook
			
			workbook = new HSSFWorkbook(finput);
			
			
			//Loading the sheet
			
			sheet= workbook.getSheetAt(0);
			
			Reporter.log("-----"+sheet+"-----",true);
			
			
			for(int i=r; i<=sheet.getLastRowNum(); i++) { 
				cell = sheet.getRow(i).getCell(col);
				Reporter.log("-----"+cell+"-----",true);
				row=sheet.getRow(r);
				Reporter.log("-----"+row+"-----",true);
				
				if(cell== null) {
					
					cell=row.createCell(col);
					Reporter.log("-----"+row+"-----",true);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(value);
					Reporter.log("-----"+cell+"-----",true);
				}
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue(value);
				
				//write data into excel
				//Specifying the file in which data needs to be written
				FileOutputStream fileOutput = new FileOutputStream(src);
				Reporter.log("----------Data improted successfully--------",true);
				
				//Content output
				workbook.write(fileOutput);
				
				//closing the file
				fileOutput.close();
				
			}
		
		} catch (Exception e) {
			Reporter.log("-------writeDataToXL FAILED--------",true);
		
		}	
		
	}

	
//////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * Generic Method to set a batch of data into excel sheet
	 * accepts five parameters> 
	 * filepath
	 * Value of the webElement
	 * sheetname -"Sheet1"
	 * row value
	 * column value
	 * 
	 */
	
	public static void setXLData(String filepath,String value,String sheet, int RowNum, int ColNum) {
		XSSFWorkbook w;
		XSSFSheet sh;
		XSSFCell cell;
		XSSFRow row;
		
		
        try {
        	
        	FileInputStream fis = new FileInputStream(filepath);
        	
        	//Workbook w= WorkbookFactory.create(new FileInputStream(new File(filepath)));
        	
        	w= new XSSFWorkbook(fis);
        	
    		sh=w.getSheet(sheet);
    		
    	for(int i=RowNum;i<=sh.getLastRowNum();i++) {
    		
        	row=sh.getRow(i);
        	if(row==null) {
                row = sh.createRow(i);
        	}
        	
        	cell=row.getCell(ColNum);
        	if(cell == null) {
                cell = row.createCell(ColNum);
        	}
        	cell.setCellValue((String)value);
        	
    	}
            FileOutputStream fileOut = new FileOutputStream(filepath);
            w.write(fileOut);
            
            //fileOut.flush();
            
            fileOut.close();
            Reporter.log("----"+fileOut+"--successfull---");
        } catch (Exception e) {
        	Reporter.log("----------setdata FAILED----------------",true);
        	
        }
    }
	
}
