package Utills;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;
import Base.XlsReader;


public class TestUtils extends TestBase {
	
	public static void doLogin(String usernamedata, String passworddata) {
		try {
		WebElement username = getObject("username");
		username.sendKeys(usernamedata);
		WebElement password = getObject("password");
		password.sendKeys(passworddata);
		WebElement login = getObject("login");
		login.click();
		if (getObject("logout").isDisplayed())
			{
			isloggedin = true;
			
			}
		else {
			isloggedin =false;
		}
		}catch(Exception e) {
			isloggedin = false;
		}
		
	}
	public static boolean isSkip(String TestCasesName) {
		//String TestCasesName = "LoginTestCase";
		
		for(int rownumber=2; rownumber<=data.getRowCount("TestCasesList"); rownumber++ ) {
			String Actualtestcase = data.getCellData("TestCasesList", 0, rownumber);
			if(TestCasesName.equals(Actualtestcase)) {
				String Runmodestatus = data.getCellData("TestCasesList", 2, rownumber);
				if(Runmodestatus.equals("Y")) {
					System.out.println("Run the testcases");
					return true;
					
				}
				else
				{
					System.out.println("skip the testcases");
					return false;
				}
			}
		}
		return false;
	}
	
	public static String[][] getData(String datasheetname) {
		data= new XlsReader("user.dir" + "\\src\\Inputs\\AutomationCases.xlsx");
		
		// TODO Auto-generated method stub
		System.out.print("sheet name is" + datasheetname);
		int rowcount = data.getRowCount(datasheetname);
		System.out.println("number of rows" + rowcount);
		int colcount = data.getColumnCount(datasheetname);
		System.out.println("number of colms" + colcount);
		String[][] datarowcol = new String[rowcount -1][colcount];
		for(int rownum =2; rownum<=rowcount; rownum++)
		{
			for(int colnum = 0; colnum<colcount; colnum++) {
				datarowcol[rownum -2][colnum] = data.getCellData(datasheetname, colnum, rownum);
				
				
			}
		}
		return datarowcol;
		
		
	}
	public static void getScreenShot(String filename) throws IOException {
		//java.io.File screen = new File();
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File("user.dir" + "\\src\\Outputs" +filename+".png"));
		//System.out.println(System.getProperty("user.dir"));
	}
	
}
