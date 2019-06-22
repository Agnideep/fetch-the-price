package com.framework.fetchtheprice.fetch_the_price;


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
	  List<WebElement> phonePrice =driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	  int actPrice=phoneName.size();
	  Reporter.log("---- pricelist------:"+actPrice, true);
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
   
	  
	  Reporter.log("---------Search results Set to Excelsheet--------------", true);
	  Reporter.log("---------Ending test-------------", true);
	  
	  
	  
	  
  }
}
