package mavenTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.ReportPage;

public class TestClass {
	
	
	
	
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
			
			ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage (driver);
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

			applicationHeaderPage.LogoutfromApplication();
			
	}

}
