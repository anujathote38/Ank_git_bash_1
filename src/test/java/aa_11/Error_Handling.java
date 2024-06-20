package aa_11;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import aa__11.TestComponent.BaseTest;

public class Error_Handling extends BaseTest {
    @Test(groups= {"Error Handling"})
	public void loginErrorValidation() throws InterruptedException {
    landingPage.loginApplication("anujathote38@gmail.com", "Rocksta@123");
      //Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email or password.");
	}

@Test
    public void ProductError() {
    	System.out.println("No Error in Product Exists");
    }
}

