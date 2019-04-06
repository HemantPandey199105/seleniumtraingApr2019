package assignment1;

import java.util.List;

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
  public void printAllTheLink() {
  driver.get("https://www.flipkart.com/");	 
   List<WebElement> allLinks=	 driver.findElements(By.tagName("a"));System.out.println(allLinks);
   
  // System.out.println(allLinks.get(1).getAttribute("href"));
  // System.out.println(allLinks.get(1).getText());
   for(WebElement oneElement : allLinks){
	   
	   System.out.println(oneElement.getText()+" _ "+ oneElement.getAttribute("href"));
   }
   
   for(int i = 0; i<allLinks.size();i++){
	   
	  System.out.println( allLinks.get(i).getText()+" - "+ allLinks.get(i).getAttribute("href"));
   }
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
