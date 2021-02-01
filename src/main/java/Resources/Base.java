package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class Base 
{
	public  static WebDriver driver;
	public  static Properties pr; 
	public  static Properties pr1;	
	
	//------------Browser Initialization for different browser -------------------------------- 
	public  static WebDriver lunchapplication() throws IOException
	{	pr= new Properties ();
		FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\globaldata.properties");
		pr.load(fp);
		String browsername=pr.getProperty("browser");	
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
			if(browsername.contentEquals("Chrome"))
			{
				driver=new ChromeDriver();
				
			}		
		if(browsername.contentEquals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Gekodriver\\geckodriver.exe");
			
			driver =new FirefoxDriver();
		}
		driver.get("http://automationpractice.com/index.php");		 
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		return driver;	
	}	
	
//------------------------- GET APIKEY-----------------------------
	public static String APIkey() throws IOException
	{
		pr= new Properties ();
		FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\globaldata.properties");
		pr.load(fp);
		String APIKey=pr.getProperty("API_KEY");
		return APIKey;
	}
//-----------------------Store and Get Value after POST API successfully executed using hashtable---------------------
	public static Hashtable<String, String> ht = new Hashtable<String, String> ();

	public static void putvalueinhashtable(String key,String Keyvale)
	{
		ht.put(key, Keyvale);
	}
	public static String getvalufromhashtable(String key)
	{
		String actualvalue=ht.get(key);
		return actualvalue;
		
	}
}
