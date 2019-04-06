package pomclassroom;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	LoginTestPOM myLogin;
	MyAccountPo myAccount;

	@Test
	public void loginTest() {
		/*
		 * myAccount = myLogin.loginPage("stc123", "12345");
		 * myAccount.contactUs(); myAccount.signOut();
		 */

		myLogin.loginPage("stc123", "12345").contactUs().signOut()
				.loginPage("stc123", "12345").signOut();

		// assertEquals(myLogin.getTitle(), "My Account");

	}

	@BeforeMethod
	public void beforeMethod() {

		myLogin = new LoginTestPOM();
		myLogin.get();

	}

	@AfterMethod
	public void afterMethod() {
	}

}
