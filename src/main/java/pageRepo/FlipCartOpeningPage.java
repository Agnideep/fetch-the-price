package pageRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.BaseTest;

public class FlipCartOpeningPage extends BaseTest {
	
	private WebDriver driver;
	
	public FlipCartOpeningPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='LM6RPg']")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	private WebElement searchButton;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	private WebElement popupCloseBtn;
	
	
	public void enterSearchValue(String keyword) {
		
		searchBox.sendKeys(keyword);
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
	public void closePopup() {
		popupCloseBtn.click();
	}
}
