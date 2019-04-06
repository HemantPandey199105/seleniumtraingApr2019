package assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ToolsqaFrameAssignment {
	WebDriver driver;
	@Test
	public void switcingBetweenTheFrame() {
      
		driver.get("https://www.toolsqa.com/iframe-practice-page");
		
		driver.switchTo().frame("iframe1");
		driver.findElement(By.name("firstname")).sendKeys("hemant pandey");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("iframe2");
	String secondFrameText	= driver.findElement(By.xpath("//h1[text()='Error establishing a database connection']")).getText();
	System.out.println("Second Frame text: "+secondFrameText);
	
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {

	}
}
