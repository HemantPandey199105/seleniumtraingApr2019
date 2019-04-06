package pomclassroom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginTestPOM extends LoadableComponent<LoginTestPOM> {

	@FindBy(id="loginname")
	private WebElement userName;
	
	@FindBy(id="loginpassword")
	private WebElement password;
	
	@FindBy(id="loginbutton")
	private WebElement loginButton;
	
	private WebDriver driver;
	
	String homePageTitle = "STC Tourism";
	
	public LoginTestPOM(){
		
		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		PageFactory.initElements(driver, this);
	}
	
	public LoginTestPOM(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

		
	}
	
	public MyAccountPo loginPage(String user, String pass){

		userName.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		
		MyAccountPo myAccount = new MyAccountPo(driver);
		return myAccount;
	
		
	}
	
	public String getTitle(){
		return driver.getTitle();
		
	}
	
	
	public void close(){
		
		driver.quit();
	}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get("http://selenium-examples.nichethyself.com/");
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(), homePageTitle);
	}

}
