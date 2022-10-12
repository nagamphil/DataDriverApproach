package Suites;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;
import Utills.TestUtils;
@RunWith(Parameterized.class)
public class LoginTestCase extends TestBase {
	String username;
	String password;
	String testdatatypes;
	public LoginTestCase(String uname, String pwd, String testdatatype)
	{
		 username = uname;
		password = pwd;
		testdatatypes = testdatatype;
	}
	@Before
	public void preRequested() throws IOException {
		doInitiliaze();
		boolean runmode = TestUtils.isSkip("LoginTestCase");
		if(runmode == false) {
			Assert.assertTrue(false);
		}
	}
	
	@Parameters
	public static Collection <String[]>getData()
{
 String[][] testdata= TestUtils.getData("LoginDatause");
	/*
	 * data[0][0] = "Tester"; data[0][1] ="test"; data[1][0] = "ABC"; data[1][1] =
	 * "456";
	 */
 		return Arrays.asList(testdata);
 
		
	}
	@Test
	public void verifyLogin() throws IOException {
		driver.get(configpro.getProperty("url"));
		TestUtils.doLogin(username, password);

		if(isloggedin == true &&  testdatatypes.equals("Y")) {
			System.out.println("Login is Successful for valid test data and test cases are pass");
		}
		if(isloggedin == false && testdatatypes.equals("Y")) {
			System.err.println("Login is not Successful  for valid test data and test cases are fail");
			TestUtils.getScreenShot("LoginToFailure");
			Assert.assertTrue(false);
		}
		if(isloggedin == false && testdatatypes.equals("N")) {
			System.out.println("Login is not successful for invalid test data and  test cases are pass");
		}
		if(isloggedin == true && testdatatypes.equals("N")) {
			System.err.println("Login is successful for invalid test data and test cases are fail");
			TestUtils.getScreenShot("LoginToFailure1");
			Assert.assertTrue(false);
		}
	}
	

}
