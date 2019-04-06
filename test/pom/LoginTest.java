package pom;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	YahooLoginPOM myLogin;
    ComposeEmailPom composeEmail;

	@BeforeMethod
	public void beforeMethod() {

		 myLogin = new YahooLoginPOM();
		myLogin.get();
	}
	@Test
	public void yahooLoginTest() throws Exception {
		try {
			myLogin.loginTest("hemantpandey49", "hphd199105199410").composeEmail("hemantpandey49@gmail.com", "POM Assignment", "Hi Ketan, I have done my assignment successfully");;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(composeEmail.getTitle(), "Yahoo");
	}

	

	@AfterMethod
	public void afterMethod() {

		myLogin.close();

	}

}
