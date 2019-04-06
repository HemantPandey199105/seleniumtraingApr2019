package assignment1;

import java.awt.RenderingHints.Key;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class WindowGoogleAssignment {
	WebDriver driver;

	@Test
	public void switchingBetweenTwoTab() throws Exception {
		driver.get("https://www.google.com/");
		String parentWindowId = driver.getWindowHandle();

		WebElement contextArea = driver.findElement(By
				.xpath("//a[text()='Gmail']"));

		Actions builder = new Actions(driver);
		// Thread.sleep(5000);

		builder.moveToElement(contextArea)
				.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click()
				.keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();

		Set<String> allWindowId = driver.getWindowHandles();

		for (String oneWindow : allWindowId) {
			if (!oneWindow.equals(parentWindowId)) {
				try {
					String childWindowText = driver
							.findElement(
									By.xpath("//h1[text()='Get more done with Gmail']"))
							.getText();
					System.out.println("Child Window Text: " + childWindowText);

				} catch (NoSuchElementException e) {

				}
			}
		}
		driver.switchTo().window(parentWindowId);
		//driver.navigate().refresh();
		 WebElement inputField= driver.findElement(By.name("q"));
		 inputField.click();
		 inputField.sendKeys("Jobs in Selenium");
		 inputField.sendKeys(Keys.ENTER);
		 //builder.keyDown(Keys.ENTER).perform();;
		//System.out.println("Parent Window Text: "+parentWindowText);

	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
