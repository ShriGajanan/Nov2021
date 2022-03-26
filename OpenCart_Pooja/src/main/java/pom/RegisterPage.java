package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	


	@FindBy(xpath = "//fieldset[@id='account']//div[2]//div//input")
	private WebElement firstName ;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName ;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement email ;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephone ;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password ;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement passwordConfirm ;
	

	@FindBy(xpath = "//input[@value='1']")
	private WebElement yes ;
	

	@FindBy(xpath = "//input[@value='0']")
	private WebElement no ;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicy ;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement btnContinue ;
	

	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement btnContinue1 ;
	

	@FindBy(xpath = "//div[@id='content']//div//div//a")
	private WebElement btnContinue2 ;
	
	public RegisterPage(WebDriver driver)// driver = driver=new chromeDriver()
	{		
		PageFactory.initElements(driver, this);
		
	} 

	
	public void registerAccount() {
		
		firstName.sendKeys("Teena");
		lastName.sendKeys("Sharma");
		email.sendKeys("abhijeet.1234@gmail.com");
		telephone.sendKeys("9898786778");
		password.sendKeys("Teena@11");
		passwordConfirm.sendKeys("Teena@11");
		
		if(  !(no.isSelected()))
			{
				no.click();
			}else
			{
				System.out.println("no already selected");
			}
		
		
		
		  privacyPolicy.click();
		
		  btnContinue.click();
		  
		  btnContinue1.click();
		  
		 
	}
	
	public void  accountLogout() {
		 btnContinue2.click();
			
		
	}

}
