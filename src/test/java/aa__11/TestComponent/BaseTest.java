package aa__11.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import aa_11.pageobjects.Landing_page;

public class BaseTest {
	public static WebDriver driver;

	public Landing_page landingPage;
	public WebDriver InitializeDriver() throws IOException {
		//Properties class in Java

		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace123\\aa\\src\\main\\java\\ank_resources\\Global data.resources");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		//WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/client/dashboard/thanks?prop=%5B%2266473f79a86f8f74dce6a5b0%22%5D");
		
		}
		else if(browserName.equalsIgnoreCase("Firefox")){
			 // System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\geckodriver-v0.34.0-win64.zip\\geckodriver.exe");
			   driver= new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("EdgeDriver")){
			 // System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Downloads\\edgedriver_win64.zip\\msedgedriver.exe");
			   driver= new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
}
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		//Convert Json to String
		String JsonContent= FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		//Convert string JsonContent to hashMap
		ObjectMapper mapper=new ObjectMapper();
	    List<HashMap<String,String>> data=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	   //{map,map1}
	    return data;
	}


	@BeforeMethod(alwaysRun=true)
	public Landing_page launchApplication() throws IOException {
		driver= InitializeDriver();
		landingPage=new Landing_page(driver);
        landingPage.goTo();
		return landingPage;

	}
	
	@AfterMethod(alwaysRun=true)
	public void TearDown(){
		driver.close();
	}
	
}
	


