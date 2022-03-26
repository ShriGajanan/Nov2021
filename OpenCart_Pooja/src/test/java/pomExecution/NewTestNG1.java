package pomExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.RegisterPage;

public class NewTestNG1 {
	
	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	private RegisterPage registerPage ;
	private LoginPage loginPage ;
	
	  @BeforeTest
	  @Parameters("Browsers")
	  public void launchBrowser(String browserName) {
		 System.out.println("launchBrowser");
		 
		 if (browserName.equals("Chrome"))
		 {		 
		 System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");			
		 driver = new ChromeDriver();
		 }
		 if (browserName.equals("Opera"))
		 {		 
		 System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");			
		 driver = new ChromeDriver();
		 }
		
	   
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	  }
	  
	  @BeforeClass()
	  public void createObjectOfPom()
	  {
		  applicationHeaderPage = new ApplicationHeaderPage(driver);
		     registerPage = new RegisterPage(driver);
		     loginPage = new LoginPage(driver); 
		     
	  }

	 @BeforeMethod
	  public void loginToApplication() {
		 System.out.println("loginToApplication");		
		driver.get("https://demo.opencart.com/");	
		 driver.manage().window().maximize();
		 applicationHeaderPage.clickOnMyAccount();
	  }

      @Test
      public void loginPage() {
    	  System.out.println("loginPage");  
    	  applicationHeaderPage.clickOnLogin();
    	  loginPage.loginToApplication(); 
      }

      @AfterMethod
      public void logout() {
    	  System.out.println("logout");	
    	  applicationHeaderPage.clickOnMyAccount();	
    	  applicationHeaderPage.clickOnLogout();
      }
      
      @AfterClass()
      public void clearThePom()
      {
    	  applicationHeaderPage=null;
    	  registerPage=null;
    	  loginPage=null;
      }


      @AfterTest()
     public void closedBrowser() {
    	  System.out.println("closedBrowser");	
    	  driver.close();
    	  driver = null;
    	  System.gc();
      }

}
