package scripts;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AllLinks {
	WebDriver driver;

	/*@Test
	public void printAllLinksOnThecurrentPage() {
		
		
		driver.get("https://www.google.com/");

		List<WebElement> allGoogleLink = driver.findElements(By.tagName("a"));
		System.out.println(allGoogleLink.size());
		for (WebElement oneElement : allGoogleLink) {

			System.out.println(oneElement.getText() + " "
					+ oneElement.getAttribute("href"));

		}
		for (int i = 0; i < allGoogleLink.size(); i++) {
			System.out.println(allGoogleLink.get(i).getText() + " "
					+ allGoogleLink.get(i).getAttribute("href"));

		}
		
		

	}*/

	@Test
	
	public void test() throws Exception{
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		Thread.sleep(70000);
	String element =driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
    String expected = "Hello World!";
    assertEquals(element, expected);
	}
	
	@BeforeMethod
	public void beforeMethod() {

		System.out.println("Before method");
		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver-32bit.exe");
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		// driver= new FirefoxDriver();
		// driver.close();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
	}

}
