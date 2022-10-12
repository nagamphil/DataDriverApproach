package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public	static WebDriver driver;
	 public static Properties objectrepo;
	public static  Properties configpro;
	public static boolean isloggedin;
	public static XlsReader data;
	 
	public static void doInitiliaze() throws IOException {
		if(driver == null)
		{
			FileInputStream objfis = new FileInputStream(System.getProperty("user.dir") +"\\src\\Config\\ObjectRepository.properties");
			 objectrepo = new Properties();
			objectrepo.load(objfis);
			FileInputStream confis = new FileInputStream(System.getProperty("user.dir") +"\\src\\Config\\Config.properties");
			 configpro = new Properties();
			configpro.load(confis);
			String browserdata = configpro.getProperty("browser");
			if(browserdata.equals("chrome")) {
				//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver_105.exe");
				WebDriverManager.chromedriver().setup();
				driver =  new ChromeDriver();
			}
			else if(browserdata.equals("firefox"))
			{ 
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserdata.equals("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Driver\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			data= new XlsReader("D:\\workspace\\naga\\git\\AutomationPackUsingDataDrivenApproach\\src\\Inputs\\AutomationCases.xlsx");
			
		}
		
		
	}
		public static WebElement getObject(String xpathValue) {		
			return driver.findElement(By.xpath(objectrepo.getProperty(xpathValue)));
	}
		
}


