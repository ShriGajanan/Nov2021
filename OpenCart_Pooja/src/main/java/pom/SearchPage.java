package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement search ;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	private WebElement searchClick ;
	

	@FindBy(xpath = "(//img[@title='iMac'])[2]")
	private WebElement clickOnProduct ;
	
	

	public SearchPage(WebDriver driver)// driver = driver=new chromeDriver()
	{		
		PageFactory.initElements(driver, this);
		
	}
	
	public void searchProduct() {
		search.sendKeys("Mac");	
		searchClick.click();
		clickOnProduct.click();
		
	}

}
