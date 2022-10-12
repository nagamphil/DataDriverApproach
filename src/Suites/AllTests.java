package Suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ContactUs.class, ForgotPassword.class, LoginTestCase.class, Registration.class })
public class AllTests {
	

}
