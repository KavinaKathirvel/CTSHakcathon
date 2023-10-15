/* Author Name:K.KAVINA
 * MODULE CREATION DATE:18-05-2021
 * MODULE MODIFICATION DATE:23-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */


package com.policybazaar.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.policybazaar.basepage.BasePageClass;
import com.policybazaar.basepage.BasePageUi;
import com.policybazaar.pages.PolicybazaarHomePage;
import com.policybazaar.utils.ConfigReader;


public class GetHealthInsuranceNameList extends BasePageClass {
PolicybazaarHomePage policybazaarhomepage;//object creation for policybazaar home page
ConfigReader configreader=new ConfigReader();//object for config reader
	
	@Test(priority=2,groups="Regression")
	public void getInsuranceNameList() 
	{
		logger = report.createTest("Getting the Health Insurance List from top menu DropDown");
		String browserName=configreader.getBrowserName();//to get browser name from the properties file 
		invokeBrowser(browserName);//invoke browser
		BasePageUi basepageui = new BasePageUi(driver,logger);
		PageFactory.initElements(driver, basepageui);
		policybazaarhomepage = basepageui.openWebsite();//open policybazaar website
		policybazaarhomepage.getHealthInsuranceList();//to get the list of the health insurance name list
		policybazaarhomepage.closePolicyBazzar();//to close browser
	}
	
	

}
