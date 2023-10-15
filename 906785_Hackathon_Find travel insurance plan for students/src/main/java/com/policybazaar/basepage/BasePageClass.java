/* Author Name:B.KOUSHALYA
 * MODULE CREATION DATE:15-05-2021
 * MODULE MODIFICATION DATE:17-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */


package com.policybazaar.basepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.policybazaar.utils.*;

public class BasePageClass {
	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();//report object to get report instance
	public ExtentTest logger;
   
	/***************************function to invoke browser*******************************/
	public void invokeBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			//Setting the chrome driver path
			System.setProperty("webdriver.chrome.driver", "browserdrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");  //Disables all notifications
			options.setAcceptInsecureCerts(true);  //Handles insecure website certification
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); //Handles and accept the unexpected alert
			driver = new ChromeDriver(options);  //Initiallizing the driver with chrome
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			//Setting the firefox driver path
			System.setProperty("webdriver.gecko.driver","browserdrivers\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications"); //Disables all notifications
			options.setAcceptInsecureCerts(true); //Handles insecure website certification
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);  //Handles and accept the unexpected alert
			driver = new FirefoxDriver(options);  //Initiallizing the driver with firefox
		}
		
		driver.manage().window().maximize();  //Maximizes the window
		driver.manage().deleteAllCookies();   //Delete all the cookies
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //Defining Implicit Wait for the driver
	}
	
	
	
	
	  public void setWait(int i)
	  {
		  try {
		  Thread.sleep(i*1000);
		  } catch(InterruptedException e) {
			  e.printStackTrace(); 
			  }
		  }
	 
	/**********************************after method to flush reports*********************************/
	@AfterMethod
	public void flushReports() {
		report.flush();
	}


}
