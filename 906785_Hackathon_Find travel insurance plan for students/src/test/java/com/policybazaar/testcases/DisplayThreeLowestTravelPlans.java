/* Author Name:B.KOUSHALYA
 * MODULE CREATION DATE:17-05-2021
 * MODULE MODIFICATION DATE:21-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */



package com.policybazaar.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.policybazaar.basepage.BasePageClass;
import com.policybazaar.basepage.BasePageUi;
import com.policybazaar.pages.PolicybazaarHomePage;
import com.policybazaar.pages.TravelInsurancePage;
import com.policybazaar.pages.TravelInsurancePlansDisplayPage;
import com.policybazaar.utils.ConfigReader;
import com.policybazaar.utils.TestDataProvider;


public class DisplayThreeLowestTravelPlans extends BasePageClass {
	PolicybazaarHomePage policybazaarhomepage; //object for the policybazaar home page
	TravelInsurancePage travelinsurancepage;  //object for the travelinsurance page
	TravelInsurancePlansDisplayPage plansdisplaypage; //object for the travel insurance plan display page
	ConfigReader configreader=new ConfigReader(); //object creation for the configreader
	
	
	@Test(groups="Smoke",priority=0)
	public void validateHomePage(){
		logger = report.createTest("Smoke Test to validate Home Page");
		String browserName=configreader.getBrowserName();//to get browser name from properties file
		invokeBrowser(browserName);//invoke browser
		BasePageUi basepageui = new BasePageUi(driver,logger);
		PageFactory.initElements(driver, basepageui);
		basepageui.openWebsite();//to open policy bazaar website
		basepageui.getTitle("Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car");
		driver.quit();
		}
	
	@Test(groups="Smoke",priority=1)
	public void clickTravelInsurance(){
		logger = report.createTest("Smoke Test to check if the travel insurance page is displayed");
		String browserName=configreader.getBrowserName();//to get browser name from properties file
		invokeBrowser(browserName);//invoke browser
		BasePageUi basepageui = new BasePageUi(driver,logger);
		PageFactory.initElements(driver, basepageui);
		policybazaarhomepage = basepageui.openWebsite();//to open policy bazaar website
		policybazaarhomepage.clickTravelInsurance(); //click travel insurance
		driver.quit();
		}
	
	
	@Test(dataProvider = "getThreeLowestTravelQuotes",priority=0,groups={"Regression"})
	public void displayThreeLowestTravelInsurancePlans(Hashtable<String, String> testData) throws IOException 
	{
	    logger = report.createTest("Display Lowest Travel Plan Quotes(Policy Bazaar) " +testData.get("TestCaseID"));
		String browserName=configreader.getBrowserName();//to get browser name from properties file
		invokeBrowser(browserName);//invoke browser
		BasePageUi basepageui = new BasePageUi(driver,logger);
		PageFactory.initElements(driver, basepageui);
		policybazaarhomepage = basepageui.openWebsite();//to open policy bazaar website
		travelinsurancepage = policybazaarhomepage.clickTravelInsurance(); //click travel insurance
		travelinsurancepage.clickStudentCategory();//click student category
		travelinsurancepage.desCountry.sendKeys(testData.get("Country"));//to enter country
		travelinsurancepage.desCountry.sendKeys(Keys.ENTER);
		travelinsurancepage.age1.sendKeys(testData.get("Age1"));//to enter age 1
		travelinsurancepage.age2.sendKeys(testData.get("Age2"));//to enter age 2
		travelinsurancepage.selectStartDate("06-09-2021");//start date for the trip
		travelinsurancepage.selectEndDate("19-09-2021");//end date for the trip
		travelinsurancepage.selectMedicalConditions();//select the medical condition
		travelinsurancepage.clickProceed();
		travelinsurancepage.enterName(testData.get("Traveller Name"));//to enter traveller name
		travelinsurancepage.enterMobile(testData.get("Traveller Phone"));//to enter the traveller phone
		travelinsurancepage.enterEmail(testData.get("Traveller Mail"));//to enter the traveller mail
		plansdisplaypage = travelinsurancepage.clickGetQuotes();
		plansdisplaypage.getThreeLowTravelPlans();//to retrieve travel insurance plans
		travelinsurancepage.closeTravelPage();//close browser
	}
	
	/***********************data provider to read excel data***********************/ 
	@DataProvider()
	public Object[][] getThreeLowestTravelQuotes(){
		return TestDataProvider.getTestData("PolicyBazaarTestData.xlsx", "TravelInsurancePlanData", "displayLowestTravelPlans");
	}

}
