package aa_11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import aa_11.pageobjects.Cart_Page;
import aa_11.pageobjects.CheckOutPage;
import aa_11.pageobjects.ConfirmationPage;
import aa_11.pageobjects.Landing_page;
import aa_11.pageobjects.Product_Catalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
public class standalone_pageF {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        String ProductName="ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
       //Login to the application
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		Landing_page landingPage=new Landing_page(driver);
		landingPage.goTo();
        landingPage.loginApplication("anujathote38@gmail.com", "Rockstar@123");
		
        //Add to cart
        Product_Catalogue Product_Catalogue =new Product_Catalogue(driver);
        List<WebElement> Products= Product_Catalogue.getProductList();
        Product_Catalogue.addProductToCart(ProductName);
	    
	    
	 //Explicit wait and then click to cart   
        
        

	   //Check item in the cart and do checkout
	    Cart_Page Cart_Page=new Cart_Page(driver);
	    Cart_Page.goToCartPage();
	    Boolean match=Cart_Page.verifyProductDisplay(ProductName);
	    Assert.assertTrue(match);
	    //place order page

	    CheckOutPage CheckOutPage=Cart_Page.goToCheckOut();
	    CheckOutPage.selectCountry("India");
	    ConfirmationPage ConfirmationPage=CheckOutPage.SubmitOrder();
	    
	    //Thank you message print
	    String confirmMessage=ConfirmationPage.checkSuccessMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
	    
	    
	}
	    
	
	

}
