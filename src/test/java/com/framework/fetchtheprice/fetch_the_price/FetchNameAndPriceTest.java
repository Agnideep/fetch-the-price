package com.framework.fetchtheprice.fetch_the_price;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLib.BaseTest;
import genericLib.IAutoConstants;
import genericLib.Utility;
import pageRepo.FlipCartOpeningPage;
import pageRepo.SearchResultPage;
  /*
   * Test class to fetch product query data flipcart.com and set it in a excel sheet
   * Author:Agnideep
   */
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
	  
	  Reporter.log("--------No.of Phones--------:"+actPhCount, true);
	  
	  Iterator<WebElement> itr1=phoneName.iterator();
	  
	  while(itr1.hasNext()) {
		  int flagone=0;
		  for(int i=1;i<=actPhCount;i++) {
		  String pname=itr1.next().getText();
		  Reporter.log(pname,true); 
		   
		  Utility.setXLData(RES_PATH, pname, "Sheet1", i, 0);
		  flagone++;
		  }
		  SoftAssert a=new SoftAssert();
		  a.assertEquals(flagone, actPhCount);
	  }
	  
	  
	  
	  List<WebElement> phonePrice =driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	  int actPriceCount=phoneName.size();
	  
	  Reporter.log("-----no.of prices- pricelist------:"+actPriceCount, true);
	  Iterator<WebElement> itr2=phonePrice.iterator();
	  
	  while(itr2.hasNext()) {
		  int flagtwo=0;
		  
		  for(int j=1;j<=actPriceCount;j++) { 
		  String pprice=itr2.next().getText();
		  Reporter.log(pprice,true);
		  
		 
		  Utility.setXLData(RES_PATH, pprice, "Sheet1", j, 1);
		  flagtwo++;
		}
		 SoftAssert b=new SoftAssert();
		 b.assertEquals(flagtwo, actPriceCount);
		  
	  }
	  
	 
	  Reporter.log("---------Search results Set to Excelsheet--------------", true);
	  Reporter.log("---------Ending test-------------", true);
	  
	  
	  
	  
  }
}
