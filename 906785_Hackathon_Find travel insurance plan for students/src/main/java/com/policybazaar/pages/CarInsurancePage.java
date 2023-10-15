/* Author Name:B.KOUSHALYA
 * MODULE CREATION DATE:17-05-2021
 * MODULE MODIFICATION DATE:20-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */
package com.policybazaar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.basepage.BasePageUi;

public class CarInsurancePage extends BasePageUi{
	/*************************constructor********************************/
	
	public CarInsurancePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	@FindBy(xpath = "//*[@id=\"frmCar\"]/div[1]/div/div/div[6]/a[1]")
	public WebElement proceedWithoutNumber;
	
	/**************************procced to the next page without car number*******************************/
	public CarInsuranceDetailsPage proceedWithoutCarNumber() {
		click(proceedWithoutNumber,"Clicking the Proceed Without CarNumber button","Clicked the Proceed Without CarNumber button");
		CarInsuranceDetailsPage carinsurancedetailspage = new CarInsuranceDetailsPage(driver,logger);
		PageFactory.initElements(driver, carinsurancedetailspage);
		return carinsurancedetailspage;
	} 

}
