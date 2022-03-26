package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReportPage {
	
	@FindBy(xpath="//span[text()='Create Report']")
	private WebElement createReport;
	
	@FindBy(xpath="//span[text()='Staff Performance']")
	private WebElement staffPerformance;
	
	@FindBy(xpath="(//input[@type='button'])[3]")
	private WebElement configureReport;
	
	@FindBy(xpath = "//img[@id='ext-gen 148']")
	private WebElement selectedStaff;
	
	@FindBy(xpath="//span[text()='18']")
	private WebElement startDate;
	
	@FindBy(xpath= "(//button[@type='button'])[2]")
	private WebElement okButton ;
	

	@FindBy(xpath= "(//span[text()='22'])[2]")
	private WebElement endDate;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	private WebElement okButton2;
	
	@FindBy(xpath= "//input[@value='Generate Report']")
	private WebElement generateReport;
	

	
		
  public ReportPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
	 
	  
  }
  
  public void clickOnCreateReport()
  {
	 createReport.click();
	 
  }
  public void staffPerformance()
  {
	  staffPerformance.click();
  }
  public void configureReport()
  {
	  configureReport.click();
	  


  }
  public void selectedStaff()
  {
	  if(!(selectedStaff.isSelected()))
	  {
		  selectedStaff.click();
	  }
	  else
	  {
		  System.out.println("alreadyselected");
	  }
  }
	  public void clickOnStartDate()
	  {
		  startDate.click();
	  }
	  
	  public void clickOnOkButton()
	  {
		  okButton.click();
	  }
	  
	  public void clickOnEndDate()
	    {
	    	endDate.click();
	    }
	    public void clickOnGenerateReport()
	    {
	    	generateReport.click();
	    }
	  public void clickOnButton2()
	  {
		  okButton2.click();
	  }
	  
	  
	
  }    
  
