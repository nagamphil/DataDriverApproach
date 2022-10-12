package Suites;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Base.TestBase;
import Utills.TestUtils;

public class ForgotPassword extends TestBase{
@Before
public void preMethod() throws IOException {
	doInitiliaze();
	boolean runmodeforgot = TestUtils.isSkip("ForgotPassword");
	if(runmodeforgot == false) {
		Assert.assertTrue(false);
	}
			
			
}
@Test
public void Forgotpwd() {
	System.out.println("Happy Sunday");
}
}
