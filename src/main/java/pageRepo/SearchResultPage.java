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
	 
	 @FindBy(xpath=("//div[@class='_3wU53n']"))
	 private List<WebElement> phoneName;
	 
	 @FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK']")
	 private List<WebElement> phonePrice;
	 
	 
	 
	 public void setPhoneList() {
		 
	try {	 
		Iterator<WebElement> name=phoneName.iterator();
		int i=0;
		while(i<phoneName.size()) {
			WebElement ph=name.next();
			String phName=ph.getText().toString();
			Utility.writeToXL(IAutoConstants.RES_PATH, phName, i+1, 0);
			}
		}catch(Exception e) {
			Reporter.log("-------ERROR in setting list of Phones to excel----",true);
		}
	 }
	 
	 public void setPriceList() {
		try {
		 	Iterator<WebElement> cost=phonePrice.iterator();
			int i=0;
			while(i<phonePrice.size()) {
				WebElement pr=cost.next();
				String phPrice=pr.getText().toString();
				Utility.writeToXL(IAutoConstants.RES_PATH, phPrice, i+1, 1);
			}
		 }catch(Exception e) {
				Reporter.log("-------ERROR in setting list of Prices to excel----",true);
			}
	 }
}
