package aa_11;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import aa__11.TestComponent.BaseTest;
import ank_standalone.pageobjects.Cart_page;
import ank_standalone.pageobjects.ConfirmationPage;
import ank_standalone.pageobjects.Order_page;
import ank_standalone.pageobjects.Product_catalogue;
public class Standalone_Including_Json_Data<object> extends BaseTest {
	String ProductName="ZARA COAT 3";

		// TODO Auto-generated method stub
        
		@Test(dataProvider="getData",groups="Purchase")
		public void SubmitOrder(HashMap<String,String> input) throws InterruptedException{
        Product_catalogue prodcatlogue=landingPage.loginApplication(input.get("email"),input.get("password"));
        List<WebElement> products=prodcatlogue.getProductList();
        prodcatlogue.addProductToCart(input.get("product"));
        Cart_page CartPage=prodcatlogue.goToCartPage();
        Boolean match=CartPage.verifyProdutDisplay(input.get("product"));
	    Assert.assertTrue(match);
	    ank_standalone.pageobjects.CheckOutPage CheckoutPage=CartPage.goToCheckOut();
	    CheckoutPage.selectCountry("India");
	    ConfirmationPage ConfirmationPage=CheckoutPage.submitOrder();
	    String confirmMessage=ConfirmationPage.getConfirmationMessage();
	  //  Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
	    Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER");
		}
	
	    
  /* @Test(dependsOnMethods= {"SubmitOrder"})
   public void OrderHistoryTest(HashMap<String,String> input) {
         Product_catalogue prodcatlogue=landingPage.loginApplication("anujathote38@gmail.com", "Rockstar@123");
     	Order_page Orderpage=prodcatlogue.goToOrderPage();
     	Assert.assertTrue(Orderpage.verifyOrderDisplay(input.get("product")));
}*/
	
   @DataProvider
   public  object[][] getData(String filepath) throws IOException {
	   List<HashMap<String,String>> data=getJsonDataToMap("C:\\Users\\Admin\\eclipse-workspace123\\aa\\src\\test\\java\\ank_thote\\data\\PurchaseOrder.json");
	   return new object[][] {{data.get(0)},{ data.get(1)}];
	   
   }
	
   }

}  
