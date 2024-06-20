package ank_standalone.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ank_standalone.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
    WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);

	}

@FindBy(css=".hero-primary")
WebElement CnfrmMessage;
	
public String getConfirmationMessage() {
    return CnfrmMessage.getText();
}
	
	
	
	
}
