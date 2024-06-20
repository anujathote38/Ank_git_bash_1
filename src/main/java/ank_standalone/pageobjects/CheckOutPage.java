package ank_standalone.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ank_standalone.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
        super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

@FindBy(css="[placeholder='Select Country']")
WebElement dropdownClick;

@FindBy(xpath="/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")
WebElement Submit;

@FindBy(xpath="(//button[contains(@class,'ta-item')][2])")
WebElement SelectCountry;

@FindBy(xpath="/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")
WebElement Submitbutton;

By results=By.cssSelector(".ta-results");

public void selectCountry(String CountryName) {
    Actions a= new Actions(driver);
    a.sendKeys(dropdownClick,CountryName).build().perform();
    waitForElementToAppear(results);
    SelectCountry.click();
}

public ConfirmationPage submitOrder() throws InterruptedException {
	Thread.sleep(3000);
	Submit.click();
	ConfirmationPage ConfirmationPage=new ConfirmationPage(driver);
	return new ConfirmationPage(driver);
}
	
	

}
