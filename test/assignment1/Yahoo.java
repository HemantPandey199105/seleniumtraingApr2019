package assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Yahoo {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void composeEmail() throws Exception {
		driver.get("https://in.yahoo.com/");
		// Thread.sleep(4000);
		WebElement signIn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@id='uh-signin']")));
		// signIn.findElement(By.xpath("//div/a[text()='Sign in']")).click();
		signIn.click();
		driver.findElement(By.cssSelector("input[id$='username']")).sendKeys(
				"hemantpandey49@yahoo.com");
		driver.findElement(By.id("login-signin")).submit();

		WebElement element1
		 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		element1.sendKeys("hphd199105199410");
		//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("hphd199105199410");
		// Thread.sleep(3000);

		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p/button[@id='login-signin']")));
		//element.submit();
		WebElement element2 =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p/button[@id='login-signin']")));
		element2.submit();*/
	driver.findElement(By.name("verifyPassword")).sendKeys(Keys.ENTER);;
		Thread.sleep(5000);
	WebElement mailElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mail']")));
	mailElement.click();
		
	 driver.findElement(By.xpath("//a[text()='Compose']")).click();
	 
	 driver.findElement(By.xpath("//input[@class='select-input react-typeahead-input input-to Z_N ir_0 j_n y_Z2uhb3X q_52qC k_w W_6D6F H_6NIX M_0 b_0 P_SMJKi A_6EqO D_X p_a L_0 B_0']")).sendKeys("hemantpandey49@gmail.com");
     driver.findElement(By.xpath("//input[@class='q_T y_Z2uhb3X je_0 jb_0 X_0 N_fq7 G_e A_6EqO C_Z281SGl ir_0 P_0 bj3_Z281SGl b_0 j_n d_72FG em_N']")).sendKeys("Page Objet Model");
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 40);
	}

	@AfterMethod
	public void afterMethod() {

	}

}
