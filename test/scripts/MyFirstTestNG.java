package scripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class MyFirstTestNG {
	WebDriver driver;

	@Test
	public void f() {
		WebElement userName = driver.findElement(By.id("loginname"));
		userName.sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();

		String expectedTitle = "My account1";
		String actualTitle = driver.getTitle();
		System.out.println(driver.getTitle());  

		/*if (expectedTitle.equals(actualTitle)) {
			System.out.println("Login Test Case Passed . !");
		} else
			System.out.println("Login Test Case Failed . !");
*/
		assertEquals(expectedTitle,actualTitle,"Login Test Case Failed . !");
		
		
		
	}
   @BeforeClass
   public void beforeClass(){
	   
	   System.out.println("Before method");
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver-32bit.exe");
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		// driver= new FirefoxDriver();
		// driver.close();
		driver = new ChromeDriver();
		driver.get("http://selenium-examples.nichethyself.com/");
		driver.manage().window().maximize();
	   
   }
	@BeforeMethod
	public void beforeMethod() {
		

	}
  @AfterClass
  
  public void afterMenthod(){
	  
	  System.out.println("After Method");
		driver.quit();
  }
	@AfterMethod
	public void afterMethod() {
		
	}

}
