package mavenTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.ReportPage;
import pom.TaskPage;

public class MavenTest {
	
	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new 	ChromeDriver();
		
		driver.get("http://localhost/login.do");
		
		Thread.sleep(3000);
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.senduserName();
		  
		loginPage.sendpassWord();
	
		loginPage.clickOnKeepMeLogin();
		loginPage.clickOnLogin();
	
		Thread.sleep(3000);
		
		ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(driver);
	
		applicationHeaderPage.clickOnTask();
	
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		
//		if(url.equals("http://localhost/tasks/otasklist.do"))
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
		
		
		Assert.assertEquals(url,"http://localhost/tasks/otasklist.do");
		
		if(title.equals("actiTIME -  Open Tasks"))
		{
			System.out.println("Pass");
		}
		{
			System.out.println("Fail");
		}
		
		
		Thread.sleep(3000);
	

				TaskPage taskPage = new TaskPage(driver);
				taskPage.sendFilterName();
				taskPage.clickOnApplyFilterBtn();
				
				String ulr1 = driver.getCurrentUrl();
				String title1 = driver.getTitle();
				
				if(ulr1.equals("http://localhost/tasks/otasklist.do"))
						
						{	
					System.out.println("Pass");
						}
				else
				{
					System.out.println("Fail");
				}
				
				
				if(title1.equals("actiTIME -  Open Tasks"))
				{
					System.out.println("Pass");
				}
				{
					System.out.println("Fail");
				}
		 
		 
		
	
	}

}
