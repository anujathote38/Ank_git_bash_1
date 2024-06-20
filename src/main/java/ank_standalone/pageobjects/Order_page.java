package ank_standalone.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ank_standalone.AbstractComponents.AbstractComponents;

public class Order_page extends AbstractComponents {

	public Order_page(WebDriver driver) {
		// TODO Auto-generated constructor stub

		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	

    @FindBy(css="tr td:nth-child(3)")
    List<WebElement> OrderedProducts;  
    
    @FindBy(css=".totalRow button")
    WebElement checkEle;
    
    
    public Boolean verifyOrderDisplay(String ProductName) {
	    Boolean match=OrderedProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
        return match;
    }
    
    
    
}
