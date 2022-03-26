package mavenTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.TaskPage;

public class TestClass_Task {
	
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
			
			
			ApplicationHeaderPage  applicationHeaderPage = new ApplicationHeaderPage (driver); 
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
			
			
			 applicationHeaderPage.LogoutfromApplication();
	}
}
