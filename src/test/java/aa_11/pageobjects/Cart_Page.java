package aa_11.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aa.abstractComponent.AbstractComponent;

public class Cart_Page extends AbstractComponent{
	WebDriver driver;

	public Cart_Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	//List<WebElement> Products= driver.findElements(By.cssSelector(".mb-3"));

@FindBy(css=".cartSection h3")
List<WebElement> cartElements;

@FindBy(css=".totalRow button")
WebElement CheckoutButton;

By productsBy =By.cssSelector(".mb-3");


public Boolean verifyProductDisplay(String ProductName) {
	
    Boolean match=cartElements.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
    return match;

	
	
}

public CheckOutPage goToCheckOut() {
	CheckoutButton.click();
	return new CheckOutPage(driver);
}






}