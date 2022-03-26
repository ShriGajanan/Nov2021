package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email ;
	

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password ;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement login ;
	

	public LoginPage(WebDriver driver)// driver = driver=new chromeDriver()
	{		
		PageFactory.initElements(driver, this);
		
	}
	
	public void loginToApplication() {
		
		email.sendKeys("teenasharma1996@gmail.com");
		password.sendKeys("Teena@11");
				
		login.click();
	}

}
