package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	

	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement quantity ;
	 
	@FindBy(xpath = "//button[text()='Add to Cart']")
	private WebElement addToCartbtn ;
	 
	
	
	
	public AddToCartPage(WebDriver driver)// driver = driver=new chromeDriver()
	{		
		PageFactory.initElements(driver, this);
		
	}

	public void clickOnQuantity() {
		
		quantity.clear();
		quantity.sendKeys("2");
		addToCartbtn.click();
		
	}
	

}
