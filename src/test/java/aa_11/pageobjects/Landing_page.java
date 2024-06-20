package aa_11.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aa.abstractComponent.AbstractComponent;
import ank_standalone.pageobjects.Product_catalogue;

public class Landing_page extends AbstractComponent {
	WebDriver driver;

	public Landing_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

//driver.findElement(By.id("userEmail")).sendKeys("anujathote38@gmail.com");

@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement PasswordEle;

@FindBy(id="login")
WebElement Submit;

@FindBy(css="[class*='.ng-tns-c4-15.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error']")
WebElement errormsg;

public Product_catalogue loginApplication(String Email,String Password){
	userEmail.sendKeys(Email);
	PasswordEle.sendKeys(Password);
	Submit.click();
    Product_catalogue prodcatlogue= new Product_catalogue(driver);
    return prodcatlogue;

}

public void goTo() {
	driver.get("https://rahulshettyacademy.com/client");

}

public String getErrorMessage() throws InterruptedException {
	// TODO Auto-generated method stub
	Thread.sleep(3000);
	
	return errormsg.getText();
}






}