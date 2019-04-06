package assignment1;

import static org.testng.Assert.fail;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class WindowHandleClassRoom {

	WebDriver driver;

	@Test
	public void windowHandle() throws Exception {
		driver.get("http://selenium-examples.nichethyself.com/");
		driver.findElement(By.xpath("//button[text()='Contact us!']")).click();
		String parentWindowHandle = driver.getWindowHandle();

		try {
			driver.switchTo().window("Contact");
		}

		catch (NoSuchWindowException e) {

			fail("There is no Contact window");
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@onclick='prompty()']")).click();
		Thread.sleep(5000);
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("Pune");
			Thread.sleep(5000);
			alert.accept();
		}

		catch (NoAlertPresentException e) {

			fail("There is no alert present");
		}

		//driver.close();
		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.xpath("//button[text()='Write to us!']")).click();
		Set<String> totalNumbersOfWindow = driver.getWindowHandles();

		System.out.println(totalNumbersOfWindow.size());
		for (String windowHandle : totalNumbersOfWindow) {

			if (!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				try {

					Thread.sleep(5000);
					driver.findElement(By.xpath("//button[@type='submit']"))
							.click();
					break;
				} catch (NoSuchElementException e) {

				}
			}
		}
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
