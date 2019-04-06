package assignment1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AlertAssign {
	WebDriver driver;

	@Test
	public void handlingJavaScriptAlert() throws Exception {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		String actualTitle = driver.getTitle();
		String expectedTitle = "The Internet";
		assertEquals(actualTitle, expectedTitle);
		// driver.getPageSource();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current Url is: " + currentUrl);
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

		Alert javaScriptAlert;

		Thread.sleep(3000);
		try {
			javaScriptAlert = driver.switchTo().alert();
			String firstAlertActualText = javaScriptAlert.getText();
			String expectedFirstAlertText = "I am a JS Alert";
			assertEquals(firstAlertActualText, expectedFirstAlertText);
			javaScriptAlert.accept();
			String actualSuccessMessage = driver.findElement(By.id("result"))
					.getText();
			String expectedSuccessMessage = "You successfuly clicked an alert";
			assertEquals(actualSuccessMessage, expectedSuccessMessage);
			String colorOfFirstTextResult = driver.findElement(By.id("result"))
					.getCssValue("color");
			System.out.println("Success message color for first Button "
					+ colorOfFirstTextResult);
		}

		catch (Exception e) {
			fail("There is no Alert for first JavaScript Button");

		}

		/*
		 * Thread.sleep(4000);
		 * driver.findElement(By.xpath("//button[@onclick='jsAlert()']"
		 * )).click();; //seconButton.click();
		 * 
		 * javaScriptAlert = driver.switchTo().alert(); String
		 * secondAlertActualText = javaScriptAlert.getText(); String
		 * expectedSecondAlertActualText = "I am a JS Confirm";
		 * System.out.println("Second Alert Actual Text: "+
		 * secondAlertActualText); javaScriptAlert.accept();
		 */

		try {
			Thread.sleep(5000);

			driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"))
					.click();

			Thread.sleep(3000);

			javaScriptAlert = driver.switchTo().alert();
			// javaScriptAlert.getText();
			javaScriptAlert.dismiss();
			String secondsSuccessMessage = driver.findElement(By.id("result"))
					.getText();
			System.out.println("Second Success message On Dismiss:"
					+ secondsSuccessMessage);
			String secondResultTextColor = driver.findElement(By.id("result"))
					.getCssValue("color");
			System.out.println("Success message color for 2nd Button: "
					+ secondResultTextColor);
		}

		catch (Exception e) {

			fail("There is no Alert for second JavaScript Button");
		}

		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(3000);
		javaScriptAlert = driver.switchTo().alert();
		String thirdAlertBoxText = javaScriptAlert.getText();
		System.out.println("3rd Alert box text: " + thirdAlertBoxText);
		javaScriptAlert.sendKeys("I Am Hemant Pandey");
		javaScriptAlert.accept();
		String thirdSuccessMessage = driver.findElement(By.id("result"))
				.getText();
		System.out.println("Third Button Success Message:"
				+ thirdSuccessMessage);
		String thirdResultTextColor = driver.findElement(By.id("result"))
				.getCssValue("color");
		System.out.println("Success message color for 3rd Button: "
				+ thirdResultTextColor);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {
	}

}
