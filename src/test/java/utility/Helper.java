package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
  public static String CaptureScreenshot(WebDriver driver, String ScreenshotName)
  {
	  Date date = new Date();		
		String today= date.toString().replace(" ", "_").replace(":", "_");
	  
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  
	File src =  ts.getScreenshotAs(OutputType.FILE);
	
	String destination = (System.getProperty("user.dir")+"\\Screenshots\\"+ScreenshotName+today+".png");
	try {
		FileUtils.copyFile(src, new File(destination));
	} 
	catch (IOException e) {
		System.out.println("Failed to capture the screenshot :"+e.getMessage());
	}
	  
	  return destination;
	  
  }


}


