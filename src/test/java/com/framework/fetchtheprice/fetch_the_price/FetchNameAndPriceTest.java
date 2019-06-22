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
	  fp.enterSearchValue(genericLib.Utility.getXLdata(DATA_PATH, "Sheet1", 1, 0));
	  fp.clickSearch();
	  
	  
	  Reporter.log("---------Redirecting to Results of the search--------------", true);
	  
	  /*
	  List<WebElement> phones= driver.findElements(By.xpath("//div[@class='_3wU53n']"));
	  Iterator<WebElement> ph= phones.iterator();
	  
	  List<WebElement> prices=driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	  Iterator<WebElement> pr= prices.iterator();
	  
	  */
	  
	  SearchResultPage srp= new SearchResultPage(driver);
	  
	  Reporter.log("---------Object of SearchPage created-------------", true);
	 
	  srp.setPhoneList();
	  srp.setPriceList();
	  
	  Reporter.log("---------Search results Set to Excelsheet--------------", true);
	  Reporter.log("---------Exiting Browser--------------", true);
	  driver.quit();
	  
	  
	  
  }
}
