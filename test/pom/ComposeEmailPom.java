package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ComposeEmailPom extends LoadableComponent<ComposeEmailPom>{
	
    String expectedYahooComposePageTitle = "(398 unread) - hemantpandey49@yahoo.com - Yahoo Mail";
    
	WebDriver driver;
	@FindBy(xpath="//span[text()='Mail']")
	private WebElement mailLink;
	
	@FindBy(xpath="//a[text()='Compose']")
	private WebElement composeButton;
	
	@FindBy(xpath="//input[@class='select-input react-typeahead-input input-to Z_N ir_0 j_n y_Z2uhb3X q_52qC k_w W_6D6F H_6NIX M_0 b_0 P_SMJKi A_6EqO D_X p_a L_0 B_0']")
	private WebElement toFiled;
	
	@FindBy(xpath="//input[@class='q_T y_Z2uhb3X je_0 jb_0 X_0 N_fq7 G_e A_6EqO C_Z281SGl ir_0 P_0 bj3_Z281SGl b_0 j_n d_72FG em_N']")
	private WebElement subjectField;
	
	@FindBy(id="editor-container")
	private WebElement messageField;
	
	@FindBy(xpath="//button/span[text()='Send']")
	private WebElement sendButton;
	
	
	public ComposeEmailPom(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		isLoaded();
	}

	public void composeEmail(String toFld, String subjectFld, String messField){
	mailLink.click();	
    composeButton.click();
	toFiled.sendKeys(toFld);
	subjectField.sendKeys(subjectFld);
	messageField.sendKeys(messField);
	sendButton.click();
	
	
	}

    public String getTitle(){
		return driver.getTitle();
    	
    	
    }
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		//assertEquals(driver.getTitle(),expectedYahooComposePageTitle );
	}
	
}
