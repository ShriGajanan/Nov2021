package pomExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.RegisterPage;

public class NewTestNG extends Browser {
	
	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
	private RegisterPage registerPage ;
	private LoginPage loginPage ;
	
	  @BeforeTest
	  @Parameters("browser")
	  public void launchBrowser(String browserName) {
		 System.out.println("launchBrowser");
		 
		 if(browserName.equals("Chrome"))
		 {	 
		    driver = launchChromeBrowser();
		 }
		 
		 if(browserName.equals("Opera"))
		 {	 
			 driver = launchOperaBrowser();
		 }
		 
		 
		 driver.manage().window().maximize();
	   
	  // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	  }
	  
	  @BeforeClass
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
		 applicationHeaderPage.clickOnMyAccount();	
	  }

      @Test
      public void registerPage() {
    	  System.out.println("registerPage");
    	  
    	  applicationHeaderPage.clickOnRegister();	    	 
		  registerPage.registerAccount();
		  
		  String url = driver.getCurrentUrl();
		  
		    
      }

      @AfterMethod
      public void logout() {
    	  System.out.println("logout");	
    	  applicationHeaderPage.clickOnMyAccount();	
    	  applicationHeaderPage.clickOnLogout();
      }
      
      @AfterClass()
      public void clearPomObject()
      {
    	  applicationHeaderPage = null;
    	  registerPage = null;
    	  loginPage = null;
      }


      @AfterTest( )
     public void closedBrowser() {
    	  System.out.println("closedBrowser");	
    	  driver.close();
    	  driver = null ;
    	  System.gc();
      }


}
