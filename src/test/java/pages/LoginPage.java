package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class LoginPage {
	
	WebDriver driver;
	Actions action;
	public  LoginPage(WebDriver ldriver)
	{
	   this.driver = ldriver;	
	}
	
	
	@FindBy(xpath="//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]") WebElement signin;
	@FindBy(xpath="//a[text()='login']") WebElement tologin;
	@FindBy(xpath="//input[@name='email']") WebElement UserName;
	@FindBy(xpath="//input[@placeholder='Enter Password']") WebElement Password;
	@FindBy(xpath="//button[@class='login-login-button']") WebElement Login;
	@FindBy(xpath="//div[text()=' Logout ']") WebElement Logout;
	@FindBy(xpath="//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]") WebElement mydetails;
	@FindBy(xpath="//input[@placeholder='Search']") WebElement Search;
	@FindBy(xpath="//li[text()='Adidas']") WebElement Adidas;
	
	
	public void loginApplication(String user,String pass)
	{
		
	    action = new Actions(driver);
		action.moveToElement(signin).perform();
		tologin.click();
							
		UserName.sendKeys(user);
		Password.sendKeys(pass);
		Login.click();
	}
	

	public String verifylogouttext()
	{
		action = new Actions(driver);
		action.moveToElement(mydetails).build().perform();
				
		return Logout.getText();
	}
	
	public String VerifySearchbox()
	{
		Search.click();
		Search.sendKeys("adidas");
		Adidas.click();
		return driver.getTitle();
		
		
		
	}

}
