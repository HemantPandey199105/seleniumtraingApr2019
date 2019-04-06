package assignment1;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ToolSQA {
	WebDriver driver;

 @Test
	public void toolSQAInputFieldTest() {
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Hemant");
		String actualFirstName = firstName.getAttribute("value");
		System.out.println("First Name: " + actualFirstName);
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys("Pandey");
		String actualLastName = lastName.getAttribute("value");
		System.out.println("Last Name: " + actualLastName);
		driver.findElement(By.id("sex-0")).click();
		driver.findElement(By.id("exp-1")).click();
		WebElement dateOfBirthOfUser = driver.findElement(By.id("datepicker"));
		dateOfBirthOfUser.sendKeys("05-01-1991");
		dateOfBirthOfUser.getAttribute("value");
		System.out.println("DOB of User: " + dateOfBirthOfUser);

		WebElement professionOfUser = driver.findElement(By.id("profession-1"));
		if (!professionOfUser.isSelected()) {
			System.out.println("not seleted");
			professionOfUser.click();
		}

		driver.findElement(By.id("tool-0")).click();
		;
		driver.findElement(By.id("tool-1")).click();
		driver.findElement(By.id("tool-2")).click();

		Select selectContinents = new Select(driver.findElement(By
				.id("continents")));
		System.out.println(selectContinents.getOptions().size());

		ArrayList<String> expectedContinents = new ArrayList();
		ArrayList<String> actualContinents = new ArrayList();

		expectedContinents.add("Asia");
		expectedContinents.add("Europe");
		expectedContinents.add("Africa");
		expectedContinents.add("Australia");
		expectedContinents.add("South America");
		expectedContinents.add("North America");
		expectedContinents.add("Antartica");

		for (WebElement oneElement : selectContinents.getOptions()) {
			actualContinents.add(oneElement.getText());

		}
		// assertEquals(expectedContinents, actualContinents);
		selectContinents.selectByIndex(1);
		selectContinents.selectByVisibleText("South America");

		WebElement optionSelectedByUser = selectContinents
				.getFirstSelectedOption();
		assertEquals(optionSelectedByUser.getText(), "South America");

	}

	//@Test
	public void multiSelectOption() {
		driver.get("https://www.toolsqa.com/automation-practice-form/");

		Select multiSelect = new Select(driver.findElement(By
				.id("selenium_commands")));
		System.out.println(multiSelect.getOptions().size());
	  List<String> expectedSeleniumCommands = new ArrayList();
	  List<String> actualSeleniumCommands = new ArrayList();
	  List <String> allSelectedElements = new ArrayList();
	  List<String> selectedElementM = new ArrayList();
	  expectedSeleniumCommands.add("Browser Commands");
	  expectedSeleniumCommands.add("Navigation Commands");
	  expectedSeleniumCommands.add("Switch Commands");
	  expectedSeleniumCommands.add("Wait Commands");
	  expectedSeleniumCommands.add("Wait Commands");
	  
	  for(WebElement oneElement : multiSelect.getOptions()){
		  
		  actualSeleniumCommands.add(oneElement.getText());
	  }
	  
	  System.out.println(actualSeleniumCommands);
//assertEquals(actualSeleniumCommands, expectedSeleniumCommands);

multiSelect.selectByIndex(1);
multiSelect.selectByIndex(2);

System.out.println(multiSelect.getAllSelectedOptions());	
for (WebElement selectedElement : multiSelect.getAllSelectedOptions())
{
  
	allSelectedElements.add(selectedElement.getText());
}
 System.out.println(allSelectedElements);
	
	}

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver",
				"test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethod() {
	}

}
