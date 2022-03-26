package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaderPage {
	
	@FindBy(xpath="//div[text()='Time-Track']")
	private WebElement timeTrack;
	
	
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement task;
	
	 @FindBy(xpath= "//div[text()='Reports']")
	    private WebElement reports;
	
    @FindBy(xpath= "//div[text()='Users']")
    private WebElement user;
	
  
	@FindBy(xpath= "//a[text()='Logout']")
	private WebElement logOut;
	
	
	public ApplicationHeaderPage(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTimeTrack()
	{
		timeTrack.click();
	}

	public void clickOnTask()
	{
		task.click();
	}
	
	public void clickOnReportsButton()
	{
		reports.click();
	}
	
	public void clickOnUserTab()
	{
		user.click();
	}
	
	  public void LogoutfromApplication()
	  {
		  logOut.click();
	  }
	
}

