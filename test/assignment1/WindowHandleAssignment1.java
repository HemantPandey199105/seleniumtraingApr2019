package assignment1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class WindowHandleAssignment1 {
 WebDriver driver;
 @Test
  public void windowHandle() {
	 driver.get("http://cookbook.seleniumacademy.com/Config.html");
	 String parentWindowHandle=driver.getWindowHandle();
	 driver.findElement(By.id("chatbutton")).click();
	 driver.findElement(By.id("helpbutton")).click();
	 Set<String> allWindowHandle= driver.getWindowHandles(); 
	 for(String oneWindow:allWindowHandle){
		 if(!parentWindowHandle.equals(oneWindow))
		 {
			driver.switchTo().window(oneWindow);
			try{
				String a = driver.getWindowHandle();
				System.out.println(a);				
				String childWindowText = driver.findElement(By.xpath("//div/h3[text()='Build my Car - Configuration - Online Chat']")).getText();
				driver.switchTo().window(a);		
				String helpWindowTitle=driver.getTitle();
				System.out.println("Help:"+helpWindowTitle);
				System.out.println("Child Window Text: "+childWindowText);
				
				break;
				
			}
			 catch(NoSuchElementException e){
				 
				 
			 }
		 }		 
	 }
	// driver.switchTo().window(parentWindowHandle);
	 String parentWindowUrl = driver.getTitle();
	 System.out.println("Parent Window Url: "+parentWindowUrl);
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
