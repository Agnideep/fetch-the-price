package pageRepo;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import genericLib.BaseTest;
import genericLib.IAutoConstants;
import genericLib.Utility;

public class SearchResultPage extends BaseTest{
	
private WebDriver driver;
	
	 public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	 //Identified in testclass by findElements
	 
	 @FindBy(xpath=("//div[@class='_3wU53n']"))
	 private List<WebElement> phoneName;
	 
	 @FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK']")
	 private List<WebElement> phonePrice;
	 
	 /*
	  * Unused methods
	  */
	 
	 public void setPhoneList() {
		 
	try {	 
		//Iterator<WebElement> name=phoneName.iterator();
		
		for(int i=0;i<=phoneName.size();i++) {
			
			//WebElement ph=name.next();
			//String phName=ph.getText().toString();
			String phName=phoneName.get(i).getText().toString();
			Utility.writeToXL(IAutoConstants.RES_PATH, phName, "Sheet1", i+1, 0);
			}
		}catch(Exception e) {
			Reporter.log("-------ERROR in setting list of Phones to excel----",true);
		}
	 }
	 
	 public void setPriceList() {
		try {
		 	//Iterator<WebElement> cost=phonePrice.iterator();
			
			for(int i=0;i<=phonePrice.size();i++) {
				//WebElement pr=cost.next();
				//String phPrice=pr.getText().toString();
				String phPrice=phonePrice.get(i).toString();
				Utility.writeToXL(IAutoConstants.RES_PATH, phPrice, "Sheet1", i+1, 1);
			}
		 }catch(Exception e) {
				Reporter.log("-------ERROR in setting list of Prices to excel----",true);
			}
	 }
}
