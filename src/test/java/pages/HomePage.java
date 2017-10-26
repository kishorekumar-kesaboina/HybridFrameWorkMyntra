package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	
	@FindBy(xpath="//*[@id='desktop-header-cnt']/div[2]/div[3]/input") WebElement search;
	@FindBy(xpath="//*[@id='desktop-header-cnt']/div[2]/div[2]/div/div[1]") WebElement signin;
	@FindBy(xpath="//*[@id='desktop-header-cnt']/div[2]/div[2]/a/span[1]") WebElement shoppingBag;
	
	public void clickOnSearch()
	{
		search.click();
	}
	public void clickOnSignIn()
	{
		signin.click();
	
	}
	public void clickOnShoppingBag()
	{
		shoppingBag.click();
	}
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
		
	
	}
	
	
}
