package Suites;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Base.TestBase;
import Utills.TestUtils;

public class ContactUs extends TestBase{
@Before
public void preMethod() throws IOException
{
	doInitiliaze();
	boolean runmode = TestUtils.isSkip("ContactUs");
	if(runmode == false) {
		Assert.assertTrue(false);
	}
}
@Test()
public void contact() {
	System.out.println("Good Morning");
}



}
