package aa_11.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aa.abstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	@FindBy(css=".hero-primary")
	WebElement ConfirmMessage;

	public String checkSuccessMessage() {
		
	    return ConfirmMessage.getText();
}
		
		
		
	}


