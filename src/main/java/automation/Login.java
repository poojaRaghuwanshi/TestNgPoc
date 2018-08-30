package automation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Login {
 public static WebDriver driver;
  @Test(priority=0)
  public void Login() throws IOException, InterruptedException {
	 // System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\WebDrivers\\Chrome\\chromedriver.exe");
	// driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://google.co.in");
	 driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("ABNAMRO");
	 driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(Keys.ENTER);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "chromedriver");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 
  }
  
 
  @AfterTest
  public void afterTest() {
  }

}

