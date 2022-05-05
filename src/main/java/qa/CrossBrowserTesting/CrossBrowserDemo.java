package qa.CrossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserDemo {

	WebDriver driver;
	String actualTitle="";
	String expectedTitle="Google";

	@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(String browser){

		/*switch(browser.toLowerCase()){
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
			break;

		default:
			driver=null;
			break;

		}*/

		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://www.google.com/");
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("msedge")){
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();	
				driver.get("https://www.google.com/");
				driver.manage().window().maximize();	
		}

	}


	@Test
	public void verifypageTitle(){
		actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod
	public void tearDown(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}


}
