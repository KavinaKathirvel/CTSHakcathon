/* Author Name:M.DEEPARASI
 * MODULE CREATION DATE:15-05-2021
 * MODULE MODIFICATION DATE:22-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */


package com.policybazaar.basepage;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.policybazaar.pages.PolicybazaarHomePage;
import com.policybazaar.utils.ConfigReader;
import com.policybazaar.utils.DateUtil;

public class BasePageUi extends BasePageClass {
	public BasePageUi(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	ConfigReader configreader=new ConfigReader(); 
	/****************** OpenApplication ***********************/

	public PolicybazaarHomePage openWebsite() {
		logger.log(Status.INFO, "Opening the WebSite");
		driver.get(configreader.getUrl());
		logger.log(Status.PASS, "Successfully Opened the Policy Bazaar Website");
		PolicybazaarHomePage policybazaarhomepage = new PolicybazaarHomePage(driver, logger);
		PageFactory.initElements(driver, policybazaarhomepage);
		return policybazaarhomepage;
	}
		
	/****************** Get Page Title ***********************/
	
	 public void getTitle(String expectedTitle) { 
		 try {
	  Assert.assertEquals(driver.getTitle(), expectedTitle);
	  reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle); 
	  } 
	 catch (Exception e) {
	  reportFail(e.getMessage()); }
	  
	  }
	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	/****************** Capture Screen Shot ***********************/
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/************************* to click the webElement **********************/
	public void click(WebElement element, String info, String pass) {
		try {
			logger.log(Status.INFO, info);
			element.click();
			logger.log(Status.PASS, pass);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

}
