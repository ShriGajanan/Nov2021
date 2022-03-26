package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaderPage {
	

	@FindBy(xpath = "/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")
	private WebElement myAccount ;
	

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement register ;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOut ;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement headerLogin ;
	

	@FindBy(xpath = "//div[@id='top-links']//ul//li[4]//a//i")
	private WebElement shoppingCart ;
	
	
	
	private Actions actions;
	
	public ApplicationHeaderPage(WebDriver driver)// driver = driver=new chromeDriver()
	{		
		PageFactory.initElements(driver, this);
		
		actions = new Actions(driver);
	}

   
	public void clickOnMyAccount() {
		myAccount.click();
		
	}
	
	public void clickOnRegister() {
		actions.moveToElement(register).click().build().perform();
		
		
	}
	
	public void clickOnLogout() {
		actions.moveToElement(logOut).click().build().perform();
		
		
	}
	
	public void clickOnLogin() {
		actions.moveToElement(headerLogin).click().build().perform();
		
		
	}
	

	public void clickOnShoppingCart() {
		shoppingCart.click();
		
	}


}
