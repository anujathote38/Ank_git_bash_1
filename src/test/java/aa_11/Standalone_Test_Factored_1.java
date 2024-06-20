package aa_11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import aa_11.pageobjects.CheckOutPage;
import aa_11.pageobjects.Landing_page;
import ank_standalone.pageobjects.Cart_page;
import ank_standalone.pageobjects.ConfirmationPage;
import ank_standalone.pageobjects.Product_catalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Standalone_Test_Factored_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        String ProductName="ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.manage().window().maximize();
        
      //Login to the application
        Landing_page landingpage=new Landing_page(driver);
        landingpage.goTo();
        Product_catalogue prodcatlogue=landingpage.loginApplication("anujathote38@gmail.com", "Rockstar@123");
        List<WebElement> products=prodcatlogue.getProductList();
        prodcatlogue.addProductToCart(ProductName);
        Cart_page CartPage=prodcatlogue.goToCartPage();
        Boolean match=CartPage.verifyProdutDisplay(ProductName);
	    Assert.assertTrue(match);
	    ank_standalone.pageobjects.CheckOutPage CheckOutPage=CartPage.goToCheckOut();
	    CheckOutPage.selectCountry("India");
	    ConfirmationPage ConfirmationPage=CheckOutPage.submitOrder();
	    String confirmMessage=ConfirmationPage.getConfirmationMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));

	}
	    
		
	}
	
	


