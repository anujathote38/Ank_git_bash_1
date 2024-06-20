package ank_standalone.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ank_standalone.AbstractComponents.AbstractComponents;

public class Landing_page extends AbstractComponents {
        WebDriver driver;
	public Landing_page(WebDriver driver) {
		// TODO Auto-generated constructor stub

		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	

    @FindBy(id="userEmail")
    WebElement Email;
    
    @FindBy(id="userPassword")
    WebElement Password;
    
    @FindBy(id="login")
    WebElement Login;
    
    @FindBy(css="[Class*='flyInOut']")
    WebElement ErrorMsg;
 
    public Product_catalogue loginApplication(String email,String password) {
    	Email.sendKeys(email);
    	Password.sendKeys(password);
    	Login.submit();
        Product_catalogue prodcatlogue= new Product_catalogue(driver);
        return prodcatlogue;
    }
    
    public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");

    }
    public String getErrorMessage() {
    	waitforWebElementToAppear(ErrorMsg);
    	return ErrorMsg.getText();
    	
    }
    
}
