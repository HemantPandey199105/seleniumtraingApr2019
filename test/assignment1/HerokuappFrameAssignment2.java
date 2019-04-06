package assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HerokuappFrameAssignment2 {
 WebDriver driver;
  @Test
  public void handlingMultipleFrame() {
	  driver.get("http://the-internet.herokuapp.com/frames");
	  driver.findElement(By.linkText("Nested Frames")).click();
	 // driver.switchTo().defaultContent();
	  driver.switchTo().frame("frame-top");
	  driver.switchTo().frame("frame-middle");
	  
	 String middleFrameText= driver.findElement(By.xpath("//div[text()='MIDDLE']")).getText();
	 System.out.println("Middle frame Text: "+middleFrameText);
	// driver.switchTo().parentFrame();
	 driver.switchTo().defaultContent();
	 
	driver.switchTo().frame("frame-bottom");
	String bottomFrameText = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
	System.out.println("Bottom Frame Text: "+ bottomFrameText);
	/* driver.switchTo().frame("frame-left");
	 String leftFrameText= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
	 
	 System.out.println("Left Frame Text: "+leftFrameText);*/
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
