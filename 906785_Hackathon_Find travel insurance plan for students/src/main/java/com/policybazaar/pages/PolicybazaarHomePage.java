/* Author Name:K.KAVINA
 * MODULE CREATION DATE:18-05-2021
 * MODULE MODIFICATION DATE:21-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */

package com.policybazaar.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.policybazaar.basepage.BasePageUi;

public class PolicybazaarHomePage extends BasePageUi{

	/**************************constructor******************************/
	public PolicybazaarHomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	//webelements in the policybazaar homepage
	@FindBy(xpath="/html/body/cclink/div[4]/div[1]/div/ul/li[2]/a")
	public WebElement insuranceProducts;
	
	@FindBy(xpath="/html/body/cclink/div[4]/div[1]/div/ul/li[2]/div/div/div[4]/ul/li[1]/a/span")
	public WebElement travelInsurance;

	@FindBy(xpath = "/html/body/cclink/div[4]/div[1]/div/ul/li[2]/div/div/div[3]/h3/a")
	public WebElement carInsurance;
	
	@FindBy(xpath="/html/body/cclink/div[4]/div[1]/div/ul/li[2]/div/div/div[2]/h3/a")
	public WebElement healthInsurance;
	
	@FindBy(xpath="/html/body/cclink/div[4]/div[1]/div/ul/li[2]/div/div/div[2]/ul")
	public List<WebElement> healthInsuranceList;
	
	
	/*************************function to click travel insurance**********************/
	public TravelInsurancePage clickTravelInsurance(){
		try {
			Actions action = new Actions(driver);
			action.moveToElement(insuranceProducts);
			action.build().perform();
			action.moveToElement(travelInsurance);
			logger.log(Status.INFO, "Clicking the Travel Insurance Link from the Other Insurance List");
			travelInsurance.click();
			logger.log(Status.PASS, "Clicked the Travel Insurance Link");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		TravelInsurancePage travelinsurancepage = new TravelInsurancePage(driver,logger);
		PageFactory.initElements(driver, travelinsurancepage);
		return travelinsurancepage;
	}
	/************************* function to return the health insurance name list**********************/
	public String[] getHealthInsuranceList()
	{
		Actions action=new Actions(driver);
		action.moveToElement(insuranceProducts).build().perform();
		action.moveToElement(healthInsurance).build().perform();
		logger.log(Status.INFO, "Getting the Health Insurance List from the Policy Bazzar Home Page");
		String[] healthInsuranceTypes=new String[healthInsuranceList.size()];
		System.out.println("=====================================================================");
		System.out.println("Health Insurance Name List:");
		System.out.println("=====================================================================");
		//iterating through the loop to get the health insurance name list
		for(int i=0;i<healthInsuranceList.size();i++)
		{
			healthInsuranceTypes[i]=healthInsuranceList.get(i).getText();
			System.out.println(healthInsuranceTypes[i]+"\n");
		}
		logger.log(Status.PASS, "Retrieved the Health Insurance Names List");
		return healthInsuranceTypes;
	}
	/************************* function to click car insurance **********************************/
	public CarInsurancePage clickCarInsurance() {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(insuranceProducts).build().perform();
			action.moveToElement(carInsurance);
			action.build().perform();
			logger.log(Status.INFO, "Clicking the Car Insurance Link from the Insurance Products");
			carInsurance.click();
			logger.log(Status.PASS, "Clicked the Car Insurance Link");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
		CarInsurancePage carinsurancepage = new CarInsurancePage(driver,logger);
		PageFactory.initElements(driver, carinsurancepage);
		return carinsurancepage;
	}
	/*****************************close browser********************************/
	public void closePolicyBazzar() {
		driver.quit();
	}
}
