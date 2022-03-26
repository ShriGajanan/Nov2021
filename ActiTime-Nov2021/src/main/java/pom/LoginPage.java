package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath ="//input[@name='username']")
	private WebElement userName ;
	
	@FindBy(xpath = "//input[@name='pwd']")
	private WebElement passWord;
	
	@FindBy (xpath = "//input[@name='remember']")
	private WebElement keepMeLogin;
	
	@FindBy ( xpath = "//div[text()='Login ']")
	private WebElement login;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
     public void senduserName()
     {
    	 userName.sendKeys("Admin");
     }
     public void sendpassWord()
     {
    	 passWord.sendKeys("manager");
     }
     
     public void clickOnKeepMeLogin()
     {
    	if ( !(keepMeLogin.isSelected()))
    	{
    		keepMeLogin.click();
        }
    	else 
    	{
    		System.out.println("Checkbox is alreay Selected");
    	}
     }
     
     public void clickOnLogin()
     {
    	 login.click();
    	 
     }
    
     
}
