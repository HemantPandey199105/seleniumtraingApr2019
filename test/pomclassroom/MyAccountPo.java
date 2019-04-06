package pomclassroom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MyAccountPo extends LoadableComponent<MyAccountPo> {

	@FindBy(className = "link")
	WebElement contactUsLink;

	@FindBy(className = "glyphicon-user")
	WebElement signOut;

	WebDriver driver;

	public MyAccountPo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		isLoaded();

	}

	public MyAccountPo contactUs() {

		contactUsLink.click();
		return this;
	}

	public LoginTestPOM signOut() {

		signOut.click();
		return new LoginTestPOM(driver);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}

}
