package com.framework.fetchtheprice.fetch_the_price;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.BaseTest;
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
	  fp.enterSearchValue("iPhone");
	  
	  Reporter.log("---------Clicking search------------", true);
	  fp.clickSearch();
	  
	  
	  Reporter.log("---------Redirecting to Results of the search--------------", true);
	  
	
	  
	  SearchResultPage srp= new SearchResultPage(driver);
	  
	  Reporter.log("---------Object of SearchPage created-------------", true);
	 
	  srp.setPhoneList();
	  srp.setPriceList();
	  
	  Reporter.log("---------Search results Set to Excelsheet--------------", true);
	  Reporter.log("---------Exiting Browser--------------", true);
	  driver.quit();
	  
	  
	  
  }
}
