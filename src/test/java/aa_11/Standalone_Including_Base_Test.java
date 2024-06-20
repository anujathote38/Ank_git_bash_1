package aa_11;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import aa_11.pageobjects.CheckOutPage;
import aa_11.pageobjects.Landing_page;
import aa__11.TestComponent.BaseTest;
import ank_standalone.pageobjects.Cart_page;
import ank_standalone.pageobjects.ConfirmationPage;
import ank_standalone.pageobjects.Order_page;
import ank_standalone.pageobjects.Product_catalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Standalone_Including_Base_Test<object> extends BaseTest {
	//String ProductName="ZARA COAT 3";

		// TODO Auto-generated method stub
        
		@Test(dataProvider="getData",groups="Purchase")
		public void SubmitOrder(String email,String password,String ProductName) throws InterruptedException{
        Product_catalogue prodcatlogue=landingPage.loginApplication(email,password);
        List<WebElement> products=prodcatlogue.getProductList();
        prodcatlogue.addProductToCart(ProductName);
        Cart_page CartPage=prodcatlogue.goToCartPage();
        Boolean match=CartPage.verifyProdutDisplay(ProductName);
	    Assert.assertTrue(match);
	    ank_standalone.pageobjects.CheckOutPage CheckoutPage=CartPage.goToCheckOut();
	    CheckoutPage.selectCountry("India");
	    ConfirmationPage ConfirmationPage=CheckoutPage.submitOrder();
	    String confirmMessage=ConfirmationPage.getConfirmationMessage();
	  //  Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
	    Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");
		}
	
	    
   @Test(dependsOnMethods= {"SubmitOrder"})
   public void OrderHistoryTest(String email,String password,String ProductName) {
         Product_catalogue prodcatlogue=landingPage.loginApplication(email,password);
     	Order_page Orderpage=prodcatlogue.goToOrderPage();
     	//Assert.assertTrue(Orderpage.verifyOrderDisplay(ProductName));
     	System.out.println(Orderpage);
}

   @DataProvider
   public  Object[][] getData() {
	   return new Object[][] {{"anujathote38@gmail.com","Rockstar@123", "ZARA COAT 3"},{ "sunitathote001@gmail.com","Change@123","ADIDAS ORIGINAL"}};
   }
	

}
