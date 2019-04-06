package scripts.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGConfig4 {
	@Test
	  public void test1() {
		  System.out.println("insider test1 of TestNGConfig4");
	  }
	  
	  @Test
	  public void test2() {
		  System.out.println("insider test2 of TestNGConfig4");
	  }
	  
	  @Test
	  public void test3() {
		  System.out.println("insider test3 of TestNGConfig4");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("insider beforeMethod of TestNGConfig4");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("insider afterMethod of TestNGConfig4");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("insider beforeClass of TestNGConfig4");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("insider afterClass of TestNGConfig4");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("insider beforeTest of TestNGConfig4");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("insider afterTest of TestNGConfig4");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("insider beforeSuite of TestNGConfig4");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("insider afterSuite of TestNGConfig4");
	  }

	}

