package mavenTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.UserPage;

public class TestNG2 {
	
	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	 private UserPage userPage;
	
	@BeforeClass
	public void launchTheBrowser()
	{
		System.out.println("LaunchTheBrowser");
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		
		 driver = new 	ChromeDriver();
		
		driver.get("http://localhost/login.do");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	
	@BeforeMethod()
	public void launchTheApplication()
	{
		System.out.println("LaunchThe Application");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.senduserName();
		loginPage.sendpassWord();
		loginPage.clickOnKeepMeLogin();
		loginPage.clickOnLogin();
	}
	
	@Test()
	public void userPageTab() throws InterruptedException
	{
		System.out.println("verify userpage");
		
		 applicationHeaderPage = new ApplicationHeaderPage(driver);
		
		applicationHeaderPage.clickOnUserTab();
		
		String url = driver.getCurrentUrl();
		
		if (url.equals("http://localhost/administration/userlist.do#page-1"))
			
		{
			System.out.println("Pass");
		}
		
		else
		{
			System.out.println("Fail");
		}
		
		 userPage = new UserPage(driver);
		
		 userPage.clickOnAddUser();
		 userPage.sendFirstName();
		 userPage.sendLastName();
		
		String title = driver.getTitle();
		
	  Assert.assertEquals(title ,"actiTIME -  User List");
		 
		 
		 Thread.sleep(3000);
		 userPage.clickOnClosebtn();

	}
	
	@AfterMethod()
	public void logOutFromApplication()
	{
		System.out.println("logOut");
		 applicationHeaderPage.LogoutfromApplication();
		
	}
	
	@AfterClass()
	public void closeTheBrowser()
	{
		System.out.println("Close the browser");
	}

}
