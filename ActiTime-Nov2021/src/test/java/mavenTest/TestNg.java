package mavenTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.ReportPage;
import pom.TaskPage;

public class TestNg {
	
	private WebDriver driver;
	private 	ApplicationHeaderPage  applicationHeaderPage;
	
	@BeforeClass
	public void launchTheBrowser() {
		System.out.println("Launch Browser");
		

	       System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
			
			 driver = new 	ChromeDriver();
			
			driver.get("http://localhost/login.do");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@BeforeMethod()
	public void launchTheApplication()
	{
		System.out.println("Launch Application");
		
		  applicationHeaderPage = new ApplicationHeaderPage (driver);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.senduserName();
		loginPage.sendpassWord();
		loginPage.clickOnKeepMeLogin();
		loginPage.clickOnLogin();
	}
	
	@Test()
	public void verifyTaskPage()
	{
		System.out.println("Verify TaskPage");
		
		 
		 applicationHeaderPage.clickOnTask();
		 
		 TaskPage taskPage = new TaskPage(driver);
		 taskPage.sendFilterName();
		 taskPage.clickOnApplyFilterBtn();
		 
		 String title = driver.getTitle();
		 
		 if ( title.equals("http://localhost/tasks/otasklist.do?rnd=1"))
		 {
			 System.out.println("Pass");
		 }
		 else
		 {
			 System.out.println("Fail");
		 }
		 
		
	}
		
	@Test()
	public void verifyReportPage()
	{
		System.out.println("verify report page");
		
		applicationHeaderPage.clickOnReportsButton();
		
		ReportPage reportPage = new ReportPage(driver);
		reportPage.clickOnCreateReport();
		reportPage.staffPerformance();
		reportPage.configureReport();
	
		
		String url = driver.getCurrentUrl();
		
		if(url.equals("http://localhost/reports/staffoutput.do"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	@AfterMethod()
	public void logOutFromApplication()
	{
		System.out.println("logout from Application");
		applicationHeaderPage.LogoutfromApplication();
	
	}
	
	@AfterClass()
	public void closeBrowser()
	{
		System.out.println("close browser");
		driver.quit(); 
	}



}
