package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName)
	{
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getfirefoxpath());
			driver = new FirefoxDriver();
		
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		
		{
			
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromepath());
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			
			System.setProperty("webdriver.edge.driver", DataProviderFactory.getConfig().getEdgepath());
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void closeBrowser(WebDriver ldriver)
	{
		driver.quit();
	}

}
