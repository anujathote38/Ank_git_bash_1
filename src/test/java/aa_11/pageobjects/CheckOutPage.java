package aa_11.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aa.abstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	//List<WebElement> Products= driver.findElements(By.cssSelector(".mb-3"));

@FindBy(css="placeholder='Select Country'")
WebElement CountryList;

@FindBy(xpath="(//button[contains(@class,'ta-item')][2])")
WebElement SelectCountry;

@FindBy(xpath="/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")
WebElement SubmitButton;

By Waitele =By.cssSelector(".ta-results");




   public void selectCountry(String CountryName) {
	
	Actions a= new Actions(driver);
	a.sendKeys(CountryList,CountryName).build().perform();
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
    waitForElementToAppear(By.cssSelector(".ta-results"));
    SelectCountry.click();
    }

    public  ConfirmationPage SubmitOrder() throws InterruptedException {
    Thread.sleep(3000);
    SubmitButton.click();
     return new ConfirmationPage(driver);
    }

}