package aa_11;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class API {
	@Test
	public void exercise() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice");
		Thread.sleep(3000);
		driver.findElement(By.id("checkBoxOption2")).click();
		Thread.sleep(3000);
	String abc=driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(abc);
		
		//dropdown
		WebElement dropdown= driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
	Select s= new Select(dropdown);
	s.selectByVisibleText(abc);
		
		driver.findElement(By.id("name")).sendKeys(abc);
		Thread.sleep(3000);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		String text= driver.switchTo().alert().getText();
		System.out.println(text);
		
		if(text.contains(abc)) {
			System.out.println("Alert message success");
		}
		else 
			System.out.println("Alert message failed");
		
		driver.quit();

		
		

	}


}
