package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class GmailSign {
	
	WebDriver driver;
  @Test
  public void gmailSignup() {

   driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/?tab=rm' ][contains(text(),'Gmail')]")).click();
   
   
   
  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver-32bit.exe");
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		// driver= new FirefoxDriver();
		// driver.close();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();

  }

}
