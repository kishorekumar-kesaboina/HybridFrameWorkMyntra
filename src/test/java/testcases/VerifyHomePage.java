package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePage {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		 driver = BrowserFactory.getBrowser("chrome");
	    //driver = BrowserFactory.getBrowser("edge");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test
	public void testHomePage() throws Exception
	{
		
		HomePage home =PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		System.out.println("my application title is:"+ title);
		Assert.assertTrue(title.contains("Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra"));
		
		
		home.clickOnSignIn();
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
