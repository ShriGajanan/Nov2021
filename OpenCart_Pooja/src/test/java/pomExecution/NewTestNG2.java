package pomExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.AddToCartPage;
import pom.ApplicationHeaderPage;
import pom.LoginPage;
import pom.SearchPage;
import pom.ShoppingCartPage;

public class NewTestNG2 {
	
	private WebDriver driver;
	private ApplicationHeaderPage applicationHeaderPage;
//	private RegisterPage registerPage ;
	private LoginPage loginPage ;
	private SearchPage searchPage;
	private AddToCartPage addToCartPage;
	private ShoppingCartPage shoppingCartPage;
	  @BeforeClass
	  public void launchBrowser() {
		 System.out.println("launchBrowser");
		 System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\\\chromedriver.exe");			
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     applicationHeaderPage = new ApplicationHeaderPage(driver);
	             // registerPage = new RegisterPage(driver);	    
	                 loginPage = new LoginPage(driver);  
	                 searchPage= new SearchPage(driver);
	             addToCartPage = new AddToCartPage(driver);
	          shoppingCartPage = new ShoppingCartPage(driver);
	  }

	 @BeforeMethod
	  public void loginToApplication() {
		 System.out.println("loginToApplication");		
		driver.get("https://demo.opencart.com/");		  	    
		
	  }

      @Test (priority = 1)
      public void loginPage() {
    	  System.out.println("loginPage");  
    	  applicationHeaderPage.clickOnMyAccount();
    	  applicationHeaderPage.clickOnLogin();
    	  loginPage.loginToApplication(); 
    	  System.out.println("searchPage");  
    	  searchPage.searchProduct();
    	  System.out.println("addToCartPage");  
    	  addToCartPage.clickOnQuantity();
    	  System.out.println("shoppingCartPage");  
    	  applicationHeaderPage.clickOnShoppingCart();
    	  shoppingCartPage.clickOnCheckOutBtn();
    	   
      }
//      @Test (priority = 3,dependsOnMethods = {"searchPage"})
//      public void addToCartPage() {
//    	  System.out.println("addToCartPage");  
//    	  addToCartPage.clickOnQuantity();
//      }
//      @Test (priority = 4,dependsOnMethods = {"addToCartPage"})
//      public void shoppingCartPage() {
//    	  System.out.println("shoppingCartPage");  
//    	  applicationHeaderPage.clickOnShoppingCart();
//    	  shoppingCartPage.clickOnCheckOutBtn();
//    	   
//      }

      @AfterMethod
      public void logout() {
    	 System.out.println("logout");	
    	 applicationHeaderPage.clickOnMyAccount();	
         applicationHeaderPage.clickOnLogout();
      }


      @AfterClass
     public void closedBrowser() {
    	  System.out.println("closedBrowser");	
    	  driver.close();
      }
	

}
