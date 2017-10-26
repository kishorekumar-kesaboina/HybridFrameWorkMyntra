package testcases;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePagewithLogsandReports {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
				
	
	@BeforeMethod
	public void setup()
	{
		
		 driver = BrowserFactory.getBrowser("chrome");
	    //driver = BrowserFactory.getBrowser("edge");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		report = new ExtentReports("E:\\Selenium\\selenium work space\\ProjectHybridFramework\\Reports\\homepage.html");
		logger = report.startTest("myntra");
		logger.log(LogStatus.INFO, "Application has started");
	}
	
	@Test
	public void testHomePage() throws Exception
	{
		
		HomePage home =PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		System.out.println("my application title is:"+ title);
		Assert.assertTrue(title.contains("Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra"));
		logger.log(LogStatus.PASS, "Application title is same as expected");
		
		home.clickOnSignIn();
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
