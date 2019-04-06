package scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Flipkart {
	WebDriver driver;
	
  @Test
  public void printAllTheLinkElements () {
	  
	driver.get("https://www.flipkart.com/");  
	List<WebElement> allFlipkartLinks=driver.findElements(By.tagName("a"));
	
	for(WebElement oneElement: allFlipkartLinks){
		System.out.println(oneElement.getText()+"-  "+oneElement.getAttribute("href"));
		
	}
	  for(int i =0; i<allFlipkartLinks.size();i++){
		  System.out.println(allFlipkartLinks.get(i).getText()+" - "+allFlipkartLinks.get(i).getAttribute("href"));
	  }
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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
