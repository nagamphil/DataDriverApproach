package Suites;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebElement;

import Base.TestBase;
import Utills.TestUtils;
@RunWith(Parameterized.class)
public class Registration extends TestBase{
	String username;
	String password;
	String cusname;
	String street;
	String city;
	String state;
	String zip;
	public Registration(String cname,String st,String cy, String stt, String z, String uname, String pwd)
	{
		username = uname;
		password = pwd; 
		cusname = cname;
		street =st;
		city = cy;
		state = stt;
		zip =z;
		
	}
	@Before

	public void doNavigate() throws IOException {
				doInitiliaze();
				boolean runmode = TestUtils.isSkip("Registration");
				if(runmode == false) {
					Assert.assertTrue(false);
				}
	}
	@Parameters
	public static Collection <String []>getData()
	{
		
		String[][] regdata = TestUtils.getData("RegistrationData");
		return Arrays.asList(regdata);
	}
	
	@Test
	public void doOrder() {
		driver.get(configpro.getProperty("url"));
		TestUtils.doLogin(username,password);
		WebElement order = getObject("order");
		order.click();
		WebElement custname = getObject("customername");
		custname.sendKeys(cusname);
		WebElement stt = getObject("street");
		stt.sendKeys(street);
		WebElement cy= getObject("city");
		cy.sendKeys(city);
		WebElement st= getObject("state");
		st.sendKeys(state);
		WebElement zi = getObject("zip");
		zi.sendKeys(zip);
		
		
	}
}
