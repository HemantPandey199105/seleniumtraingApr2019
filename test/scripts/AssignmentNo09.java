package scripts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AssignmentNo09 {

	WebDriver driver;

//	@Test
	public void dropDownTestUsingSelect() {

		driver.get("https://www.wikipedia.org/");
		driver.findElement(By.xpath("//strong[text()='English']")).click();
		WebElement element = driver.findElement(By
				.xpath("//div/input[@type='search']"));
		element.sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Selenium - Wikipedia";
		//assertEquals(actualTitle, expectedTitle, "Title not matched");
		
	String actualSelenium=	driver.findElement(By.xpath("//h1[@id='firstHeading']")).getText();
  System.out.println(actualSelenium);
  String expectedSelenium = "Selenium";
  assertEquals(actualSelenium, expectedSelenium);
		
		// driver.findElement(by)
		// WebElement element =
		// driver.findElement(By.xpath("//select[@id='dropdown']"));

		/*
		 * ArrayList list = new ArrayList(); Select select = new
		 * Select(element); System.out.println(select.getOptions().size());
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); for(
		 * WebElement e:select.getOptions()){ list.add(e.getText()); }
		 * assertEquals(arg0, arg1);
		 */
	}
	@Test
	public void toolSQA(){
		
		driver.get("https://www.toolsqa.com/automation-practice-form/");
	//String text1=	driver.findElement(By.xpath("//span[@class='bcd']")).getText();
	String text2=	driver.findElement(By.tagName("br")).getAttribute("innerText");
	
		System.out.println(text2);
		//System.out.println(text1);
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
