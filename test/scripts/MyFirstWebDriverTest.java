package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstWebDriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;

		System.setProperty("webdriver.gecko.driver",
				"test\\resources\\geckodriver-32bit.exe");
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		// driver= new FirefoxDriver();
		// driver.close();
		driver = new ChromeDriver();
		driver.get("http://selenium-examples.nichethyself.com/");
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.id("loginname"));
		userName.sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		
		String expectedTitle = "My Account";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Login Test Case Passed . !");
		}
		else
			System.out.println("Login Test Case Failed . !");
			
	}
}
