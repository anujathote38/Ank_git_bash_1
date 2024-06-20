package aa_11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Standalone_Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        String ProductName="ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
        
        driver.findElement(By.id("userEmail")).sendKeys("anujathote38@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Rockstar@123");
		Thread.sleep(3000);
		driver.findElement(By.id("login")).click();
		
		
//Add to cart
	    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> Products= driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=Products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	    
	    
	 //Explicit wait and then click to cart   
	    WebDriverWait Wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

	   //Check item in the cart and do checkout
	    
	    List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	    Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(ProductName));
	    Assert.assertTrue(match);
	    driver.findElement(By.cssSelector(".totalRow button")).click();
	    
	    //place order page
	    Actions a= new Actions(driver);
	    a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    
	    driver.findElement(By.xpath("(//button[contains(@class,'ta-item')][2])")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")).click();
	    
	    //Thank you message print
	    String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	    //Assert.assertTrue(false);

      Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER");	    
      System.out.println(confirmMessage);
	    
	    
	}
	    
	
	

}
