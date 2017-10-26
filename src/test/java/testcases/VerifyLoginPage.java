package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPage {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		 driver = BrowserFactory.getBrowser("chrome");
	    //driver = BrowserFactory.getBrowser("edge");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test
	public void testHomePage()
	{
		
		HomePage home =PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		System.out.println("my application title is:"+ title);
		Assert.assertTrue(title.contains("Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra"));
		
		
		//home.clickOnSignIn();
		
		
		LoginPage login =PageFactory.initElements(driver, LoginPage.class);
		
		login.loginApplication(DataProviderFactory.getexcel().getData(0, 0, 0), DataProviderFactory.getexcel().getData(0, 0, 1));
		
	}
	
	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
