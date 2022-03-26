package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	@FindBy(xpath="//input[@name='visiableFilterString']")
	private WebElement filterName;
	
	@FindBy(xpath="//input[@value='Apply Filter']")
	private WebElement applyfilter;
	
	public TaskPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void sendFilterName()
	{
		filterName.sendKeys("akash dada");
	}
	public void clickOnApplyFilterBtn()
	{
		applyfilter.click();
	}
	

}