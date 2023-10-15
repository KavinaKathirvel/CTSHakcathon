/* Author Name:P.K.RAKSHA
 * MODULE CREATION DATE:18-05-2021
 * MODULE MODIFICATION DATE:21-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */




package com.policybazaar.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.policybazaar.basepage.BasePageClass;
import com.policybazaar.basepage.BasePageUi;
import com.policybazaar.pages.CarInsuranceDetailsPage;
import com.policybazaar.pages.CarInsurancePage;
import com.policybazaar.pages.PolicybazaarHomePage;
import com.policybazaar.utils.ConfigReader;
import com.policybazaar.utils.TestDataProvider;



public class GetErrorInCarInsuranceForm extends BasePageClass {
	PolicybazaarHomePage policybazaarhomepage; //object creation for the home page
	CarInsuranceDetailsPage carinsurancedetailspage;//object creation for the car insurance details page
	CarInsurancePage carinsurancepage;//object creation for the car insurance page 
	ConfigReader configreader=new ConfigReader();
	
	@Test(groups="Smoke",priority=2)
    public void clickCarInsurance() {
		logger = report.createTest("Smoke Test to check if the car insurance page is dispalyed");
		String browserName=configreader.getBrowserName();//to get browser name from the properties file
		invokeBrowser(browserName);//to invoke browser
		BasePageUi basepageui = new BasePageUi(driver,logger);
		PageFactory.initElements(driver, basepageui);
		policybazaarhomepage = basepageui.openWebsite();//to open website
		policybazaarhomepage.clickCarInsurance();//to click car insurance
		driver.quit();
		
	}
	@Test(dataProvider = "getErrorDetailsTestData",priority=1,groups="Regression")
	public void getErrorMeaasageForInvalidDetails(Hashtable<String, String> testData) throws InterruptedException 
	{
		logger = report.createTest("Car Insurance form Details error validation test: "+ testData.get("TestCaseID"));
		String browserName=configreader.getBrowserName();//to get browser name from the properties file
		invokeBrowser(browserName);//to invoke browser
		BasePageUi basepageui = new BasePageUi(driver,logger);
		PageFactory.initElements(driver, basepageui);
		policybazaarhomepage = basepageui.openWebsite();//to open website
		carinsurancepage = policybazaarhomepage.clickCarInsurance();//to click car insurance
		carinsurancedetailspage = carinsurancepage.proceedWithoutCarNumber();//proceed without car number
		carinsurancedetailspage.searchCity(testData.get("RTO & City Name"));//to search city
		carinsurancedetailspage.searchBrand(testData.get("Car Name"));//to search car brand
		carinsurancedetailspage.typeFuel(testData.get("Fuel Variant"));// to search fuel variant
		carinsurancedetailspage.selectVariant(testData.get("Model Variant"));//to search model variant
		carinsurancedetailspage.carYear();//to select the year
		carinsurancedetailspage.enterName(testData.get("Owner Name"));//to enter car owner's name
		carinsurancedetailspage.enterEmail(testData.get("Owner Email"));//to enter car owner's email
		carinsurancedetailspage.enterPhonenumber(testData.get("Owner Phone"));//to enter car owner's phone
		carinsurancedetailspage.proceedClick();//to proceed click
		carinsurancedetailspage.captureError();	//to capture error from the car insurance page
		carinsurancedetailspage.closeCarPage();//to close browser
	}
	
	/**************************test data provider to get data from the excel sheet**************************/
	@DataProvider
	public Object[][] getErrorDetailsTestData()
	{
		return TestDataProvider.getTestData("PolicyBazaarTestData.xlsx", "CarInsuranceData", "getErrorForInvalidDetails");
	}


}
