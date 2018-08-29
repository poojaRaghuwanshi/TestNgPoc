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
	  driver.get("http://vm00001255.nl.eu.abnamro.com:14053/sta/action/pleaseLogonFirst");
	  Runtime.getRuntime().exec("C:\\Users\\C49563\\Qmtery\\ChromeLogin1.exe");
	  driver.findElement(By.xpath("(//table/tbody/tr[2]/td[2]/table/tbody/tr/td/a[text()='Intranet logon'])[1]")).click();    
	  //Thread.sleep(2000);
		        
	  Thread.sleep(20000);
      driver.get("http://vm00005800.nl.eu.abnamro.com:14874/nl/cnicwidgetdelivery/cnicwidget/index.html#/overview");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 
  }
  @Test(priority=1)
  public void CreateBooking() throws IOException, InterruptedException {
	  Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id='header']/div/div[2]/nav/div/ul/li[2]/a/span/span")).click();
	//*[@id="header"]/div/div[2]/nav/div/ul/li[2]/a/span/spanten#3	
  
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='header']/div/div[1]/div/div/button[2]")).click();
	  Thread.sleep(2000);
	  Select dropdown = new Select(driver.findElement(By.id("percentType")));
	  dropdown.selectByVisibleText("T (threshold)");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='startDate']/div/input")).sendKeys("22.08.2018");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\'searchblock\']/form/div[1]/div[1]/div[2]/div[4]/md-datepicker/div[1]/input")).sendKeys("30.08.2018");
	//*[@id="conditionSource"]
	  dropdown = new Select(driver.findElement(By.id("conditionSource")));
	  dropdown.selectByVisibleText("Credit");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='percpart1']")).sendKeys("01202");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='grens']")).sendKeys("1000");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='1']")).sendKeys("123559786");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='searchblock']/form/div[4]/button")).click();
	  Thread.sleep(5000);
	  
  }
  @Test(priority=2)
  public void verifyBooking() throws IOException, InterruptedException {
	  driver.findElement(By.xpath("//*[@id='header']/div/div[2]/nav/div/ul/li[1]/a/span/span")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='contractNumber']")).sendKeys("123559786");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='searchblock1']/aab-button/div[1]/button")).click();
	  Thread.sleep(2000);
	  
	/*  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  Boolean isPresent = driver.findElements(By.xpath(Xpath)).size() > 0;
	  //return isPresent;*/
	  String srt =  driver.findElement(By.xpath("//*[@id='tableToExport']/table/tbody/tr/td[2]/span")).getText();
	                                             //*[@id="tableToExport"]/table/tbody/tr/td[2]/span
	  Thread.sleep(1000);
	  Assert.assertEquals(srt,"123559786");
  }
  @AfterTest
  public void afterTest() {
  }

}

