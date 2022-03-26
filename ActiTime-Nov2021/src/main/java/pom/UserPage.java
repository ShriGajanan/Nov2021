package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

	//div[@id='userDataLightBox_cancelBtn']
	
	@FindBy(xpath= "//div[text()='Users']")
	private WebElement userPage;
	
	@FindBy(xpath= "//div[@id='ext-comp-1002']")
	private WebElement addUser;
	

	@FindBy(xpath= "//input[@name='firstName']")
	private WebElement firstName;
	

	@FindBy(xpath= "//input[@id='userDataLightBox_lastNameField']")
	private WebElement lastName;
	
	@FindBy(xpath= "//input[@name='lastName']")
	private WebElement createUser;
	
	@FindBy(xpath= "//img[@class='closeButton']")
	private WebElement close;
	
  private WebDriver driver;
  private Actions act;
	
	public UserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	public void clickOnAddUser()
	{
		addUser.click();
	}
	
	public void sendFirstName()
	{
		firstName.sendKeys("pUSHPa");
	}
	
	public void sendLastName()
	{
		lastName.sendKeys("aggaj");
	}
	
	public void clickOnCreateUser()
	{
		createUser.click();
	}
	
	public void clickOnClosebtn()
	{
		
		
		close.click();
	}
	
	
}
