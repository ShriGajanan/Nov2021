package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	@FindBy(xpath = "//a[text()='Checkout']")
	private WebElement checkoutbtn ;
	
	
	public ShoppingCartPage(WebDriver driver)// driver = driver=new chromeDriver()
	{		
		PageFactory.initElements(driver, this);
		
	}

	public void clickOnCheckOutBtn() {
		
		checkoutbtn.click();
	}
	

}
