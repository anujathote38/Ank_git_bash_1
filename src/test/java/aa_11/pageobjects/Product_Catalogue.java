package aa_11.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aa.abstractComponent.AbstractComponent;

public class Product_Catalogue extends AbstractComponent{
	WebDriver driver;

	public Product_Catalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	//List<WebElement> Products= driver.findElements(By.cssSelector(".mb-3"));

@FindBy(css=".mb-3")
List<WebElement> Products;

@FindBy(css=".ng-animating")
WebElement Spinner;

@FindBy(css="[routerlink*='cart']")
WebElement cartClick;
By productsBy =By.cssSelector(".mb-3");
By addToCart =By.cssSelector(".card-body button:last-of-type");
By toastMessage = By.cssSelector("#toast-container");


public List<WebElement> getProductList() {
	waitForElementToAppear(productsBy);
	
	return Products;
}

public WebElement getProductByName(String ProductName) {
    WebElement prod=getProductList().stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
    return prod;
	
}

public void addProductToCart(String ProductName) {
	WebElement prod=getProductByName(ProductName);
    prod.findElement(addToCart).click();
    waitForElementToAppear(toastMessage);
    waitForElementToDisappear(Spinner);

}

public void clickOnCart() {
	
	cartClick.click();

}



}