package com.framework.fetchtheprice.fetch_the_price;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseTest;
import genericLib.IAutoConstants;
import genericLib.Utility;
import pageRepo.FlipCartOpeningPage;
import pageRepo.SearchResultPage;

public class FetchNameAndPriceTest extends BaseTest {
  @Test
  public void FetchNameAndPriceforIphone() {
	  
	  
	  Reporter.log("---------Navigated to Flipcart.com HomePage------------", true);
	  
	  FlipCartOpeningPage fp= new FlipCartOpeningPage(driver);
	  
	  Reporter.log("---------Closing popup------------", true);
	  fp.closePopup();
	  
	  String searchkey=genericLib.Utility.getXLdata(DATA_PATH,"data",1, 0);
	  Reporter.log("---------Entering input data :"+ searchkey + " into editbox------------", true);
	  fp.enterSearchValue(searchkey);
	  
	  Reporter.log("---------Clicking search------------", true);
	  fp.clickSearch();
	  
	  
	  Reporter.log("---------Redirecting to Results of the search--------------", true);
	  
	
	  
	  
	  
	  List<WebElement> phoneName =driver.findElements(By.xpath("//div[@class='_3wU53n']"));
	  int actPhCount=phoneName.size();
	  Reporter.log("----No.of Phones---:"+actPhCount, true);
	  Iterator<WebElement> itr1=phoneName.iterator();
	  while(itr1.hasNext()) {
		  //System.out.println(itr1.next().getText());
		  String pname=itr1.next().getText();
		  System.out.println(pname); 
		  
		  //Utility.writeDataToXL(RES_PATH, pname, 1, 0);
		  Utility.setXLData(RES_PATH, pname, 1, 0);
		  //Utility.writeToXL(RES_PATH, pname, "Sheet1", 1, 0);
		  
		  
		  
		  
	  }
	  
	  
	  
	  List<WebElement> phonePrice =driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	  int actPrice=phoneName.size();
	  Reporter.log("-----no.of prices- pricelist------:"+actPrice, true);
	  Iterator<WebElement> itr2=phonePrice.iterator();
	  while(itr2.hasNext()) {
		  //System.out.println(itr2.next().getText());
		  String pprice=itr2.next().getText();
		  System.out.println(pprice);
		  //Utility.writeDataToXL(RES_PATH, pprice, 1, 1);
		  Utility.setXLData(RES_PATH, pprice, 1, 1);
		  //Utility.writeToXL(RES_PATH, pprice, "Sheet1", 1, 1);
		  
		  
	  }
	  
	 
	/*   
	   try {	 
		
			for(int i=0;i<=phoneName.size();i++) {
				String phName=phoneName.get(i).getText().toString();
				Reporter.log("----Phone name fetched-----: "+phName, true);
				Utility.writeToXL(IAutoConstants.RES_PATH, phName, "Sheet1", i, 0);
				}
			}catch(Exception e) {
				Reporter.log("-------ERROR in setting list of Phones to excel----",true);
			}
		 
  
  	try {
		for(int i=0;i<=phonePrice.size();i++) {
			
			String phPrice=phonePrice.get(i).toString();
			Reporter.log("----Phone price fetched-----: "+phPrice, true);
			Utility.writeToXL(IAutoConstants.RES_PATH, phPrice, "Sheet1", i, 1);
		}
	 }catch(Exception e) {
			Reporter.log("-------ERROR in setting list of Prices to excel----",true);
		}
   
	*/  
	  Reporter.log("---------Search results Set to Excelsheet--------------", true);
	  Reporter.log("---------Ending test-------------", true);
	  
	  
	  
	  
  }
}
