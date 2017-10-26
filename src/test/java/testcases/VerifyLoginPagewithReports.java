package testcases;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.LoginPage;
import utility.Helper;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPagewithReports {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup()
	{
		Date date = new Date();		
		String today= date.toString().replace(" ", "_").replace(":", "_");
		
		reports = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\Loginpage"+today+".html");
		logger = reports.startTest("myntra");
		
		 driver = BrowserFactory.getBrowser("chrome");
	    //driver = BrowserFactory.getBrowser("edge");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application started");
		
		
	}
	
	@Test
	public void testHomePage()
	{
		
		HomePage home =PageFactory.initElements(driver, HomePage.class);
		
		String title = home.getApplicationTitle();
		
		System.out.println("my application title is:"+ title);
		Assert.assertTrue(title.contains("Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra"));
		logger.log(LogStatus.PASS, "Application title is as expected");
		
		//home.clickOnSignIn();
		
		
		LoginPage login =PageFactory.initElements(driver, LoginPage.class);
		
		login.loginApplication(DataProviderFactory.getexcel().getData(0, 0, 0), DataProviderFactory.getexcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "Application Login displayed");
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.CaptureScreenshot(driver, "loginapplication")));
		
		
		String text = login.verifylogouttext();
		
		Assert.assertTrue(text.equalsIgnoreCase("logout"));
		
		logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.CaptureScreenshot(driver, "logouttext")));
		
		
		
		String SearchTitle = login.VerifySearchbox();
		Assert.assertTrue(SearchTitle.contains("Adidas"));
		logger.log(LogStatus.PASS, logger.addScreenCapture(Helper.CaptureScreenshot(driver, "Searchbox Title")));
		logger.log(LogStatus.INFO, "Search page Title displayed");
	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path =Helper.CaptureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
			
		}
		
		BrowserFactory.closeBrowser(driver);
		reports.endTest(logger);
		reports.flush();
	}

}
