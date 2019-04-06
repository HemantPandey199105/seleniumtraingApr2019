package assignment1;

import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AlertAssign2 {
	WebDriver driver;
	Alert myAlert;

	@Test
	public void handlingAlert() throws Exception {

		driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
		driver.findElement(By.id("simple")).click();
		myAlert = driver.switchTo().alert();
		String firstAlertBoxText = myAlert.getText();
		System.out.println("First Alert Box Text: " + firstAlertBoxText);
		Thread.sleep(3000);
		myAlert.accept();

		Thread.sleep(3000);
		driver.findElement(By.id("confirm")).click();
		myAlert = driver.switchTo().alert();
		String secondAlertBoxText = myAlert.getText();
		System.out.println("Second Alert Box Text: " + secondAlertBoxText);
		Thread.sleep(3000);
		myAlert.accept();
		String actualSuccessMessageForSecondAlert = driver.findElement(By.id("demo"))
				.getText();
       System.out.println("Success message for second alert box:" +actualSuccessMessageForSecondAlert);
       
       Thread.sleep(3000);
       driver.findElement(By.id("prompt")).click();
       myAlert= driver.switchTo().alert();
       String thirdAlertBoxText = myAlert.getText();
       System.out.println("Third Alert Box Text:" +thirdAlertBoxText);
       myAlert.sendKeys("Hemant Pandey");
       Thread.sleep(3000);
       myAlert.accept();
       String actualSuccessMessageForThirdAlert= driver.findElement(By.id("prompt_demo")).getText();
       System.out.println("Success message for 3rd alert box:"+actualSuccessMessageForThirdAlert);
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
