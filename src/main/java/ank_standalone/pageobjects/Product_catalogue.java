package ank_standalone.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ank_standalone.AbstractComponents.AbstractComponents;

public class Product_catalogue extends AbstractComponents {

	WebDriver driver;
	public Product_catalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

	

    @FindBy(css=".mb-3")
    List<WebElement> prodlist;
    
    @FindBy(css=".ng-animating")
    WebElement spinner;
    
    @FindBy(css="[routerlink*='cart']")
    WebElement cartclick;
    
    By productWaitBy= By.cssSelector(".mb-3");
    By addToCart=By.cssSelector(".card-body button:last-of-type");
    By toastMessage=By.cssSelector("#toast-container");
    
    
    public List<WebElement> getProductList () {
    	waitForElementToAppear(productWaitBy);
    	return prodlist;
    }
    
    public WebElement getproductByName(String ProductName) {
		WebElement prod=getProductList ().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
        return prod;
    }
    
    public void addProductToCart(String ProductName) {
    	WebElement prod=getproductByName(ProductName);
	    prod.findElement(addToCart).click();
	    waitForElementToAppear(toastMessage);
	    waitforElementToDisappear(spinner);

    }
    public Cart_page goToCartPage() {
	    cartclick .click();
	    Cart_page CartPage=new Cart_page(driver);
	    return CartPage;

    }

    
    
   
}
