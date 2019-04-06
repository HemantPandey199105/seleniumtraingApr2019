package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class YahooLoginPOM extends LoadableComponent<YahooLoginPOM> {

	@FindBy(id = "uh-signin")
	private WebElement signInLink;

	@FindBy(id = "login-username")
	private WebElement userName;

	@FindBy(id = "login-signin")
	private WebElement nextButton;

	@FindBy(id = "login-passwd")
	private WebElement password;

	@FindBy(id = "login-signin")
	private WebElement signInButton;

	private WebDriver driver;

	String expectedTitle = "Yahoo";

	public YahooLoginPOM() {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://in.yahoo.com");
		// PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, this);

	}

	public ComposeEmailPom loginTest(String user, String pass) throws Exception {

		signInLink.click();
		userName.sendKeys(user);
		nextButton.submit();
		Thread.sleep(5000    );
		password.sendKeys(pass);
		signInButton.sendKeys(Keys.ENTER);;
		
		ComposeEmailPom composeEmail = new ComposeEmailPom(driver);
		return composeEmail;
		

	}

	public String getTitle() {
		return driver.getTitle();

	}

	public void close() {

		driver.quit();
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get("https://in.yahoo.com");

	}

	@Override
	protected void isLoaded() throws Error {

		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(), expectedTitle);
	}

}


