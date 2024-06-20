package ank_standalone.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ank_standalone.AbstractComponents.AbstractComponents;

public class Cart_page extends AbstractComponents {

	public Cart_page(WebDriver driver) {
		// TODO Auto-generated constructor stub

		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	

    @FindBy(css=".cartSection h3")
    List<WebElement> cartprods;  
    
    @FindBy(css=".totalRow button")
    WebElement checkEle;
    
    
    public Boolean verifyProdutDisplay(String ProductName) {
	    Boolean match=cartprods.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
        return match;
    }
    
    public CheckOutPage goToCheckOut() {
    	checkEle.click();
	    CheckOutPage CheckoutPage=new CheckOutPage(driver);

    	return new CheckOutPage(driver);
    }
    
    
}
