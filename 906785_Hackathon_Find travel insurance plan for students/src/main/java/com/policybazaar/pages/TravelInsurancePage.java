/* Author Name:M.DEEPARASI
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
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.basepage.BasePageUi;


public class TravelInsurancePage extends BasePageUi{
	/***********************constructor**************************/
	public TravelInsurancePage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
	}
	
	//webElements in the travelinsurance page
	@FindBy(xpath="//body/cclink[1]/div[4]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[4]/ul[1]/li[1]/a[1]/span[1]")
	WebElement travelinc;
	
	@FindBy(xpath="//body/div[@id='policybazaar']/section[1]/div[2]/section[1]/div[2]/article[1]/ul[1]/li[3]/a[1]")
	public WebElement student;
	
	@FindBy(id="destination-autocomplete")
	public WebElement desCountry;
	
	@FindBy(id="memage1")
	public WebElement age1;
	
	@FindBy(id="memage2")
	public WebElement age2;
	
	@FindBy(id="startdate")
	public WebElement startDate;
	
	@FindBy(xpath = "/html[1]/body[1]/div[8]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]/select[1]") //html[1]/body[1]/div[8]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[3]
			
	public WebElement monthSelectRight;
	
	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]/select[1]")
	public WebElement monthSelectLeft;
	
	@FindBy(xpath = "/html[1]/body[1]/div[8]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]/select[2]")
	public WebElement yearSelectRight;
	
	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]/select[2]")
	public WebElement yearSelectLeft;
	
	@FindBy(xpath = "//div[8]//div[2]//tr//td[@class='available' or @class='weekend available']")
	public List<WebElement> daysListRight;
	
	@FindBy(xpath = "//div[9]//div[2]//tr//td[@class='available' or @class='weekend available']")
	public List<WebElement> daysListLeft;
	
	@FindBy(xpath = "//div[@id='isPED']//div//label[contains(text(),'No')]//span")
	public WebElement medicalConditions;
	
	@FindBy(id="enddate")
	public WebElement endDate;
	
	@FindBy(id="proceedStepOne")
	public WebElement proceed;
	
	@FindBy(id="travelgender")
	public WebElement travelerGender;
	
	@FindBy(id="travelname")
	public WebElement travelerName;
	
	@FindBy(id="travelmobile")
	public WebElement travelMobile;
	
	@FindBy(id="travelemail")
	public WebElement travelEmail; 
	
	@FindBy(xpath="//a[contains(text(),'Get Free Quotes')]")
	public WebElement getFreeQuotes;
	
	/**********************function to click student category************************/
	public void clickStudentCategory() {
		click(student,"Clicking the student category","Successfully clicked the student category");
	}
	/**********************function to select start and end trip date**************************/
	public void dateSelect(String date,List<WebElement> daysList,WebElement monthSelect,WebElement yearSelect){
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(3, 5));
		String year= date.substring(6, 10);
		
		Select select = new Select(yearSelect);
		select.selectByVisibleText(year);
		
		Select selectmonth = new Select(monthSelect);
		selectmonth.selectByIndex(month-1);
		
		Actions action = new Actions(driver);
		action.moveToElement(daysList.get(day-1)).click().perform();
	}
	/********************function to select start date******************************/
	public void selectStartDate(String date){
		startDate.click();
		click(startDate,"Clicking the Start Date Calender","Successfully clicked the start date calender");
		dateSelect(date,daysListRight,monthSelectRight,yearSelectRight);
	}
	/*********************function to select end date*****************************/
	public void selectEndDate(String date){
		click(endDate,"Clicking the End Date Calender","Successfully clicked the End date calender");
		dateSelect(date,daysListLeft,monthSelectLeft,yearSelectLeft);
	}
	/*******************selecting medical conditions***************************/
	public void selectMedicalConditions() {
		click(medicalConditions,"Selecting the medical conditions","Successfully selected the medical conditions");
	}
	/******************to click proceed*************************/
	public void clickProceed() {
		click(proceed,"Clicking the Proceed Button", "Successfully clicked the proceed button");
	}
	
	/*****************enter name for the car insurance page***************/
	public void enterName(String name) {
		setWait(1);
		String prefix = name.substring(0,3);
		String travelername = name.substring(4);
		Select prefixselect = new Select(travelerGender);
		prefixselect.selectByVisibleText(prefix);
		travelerName.sendKeys(travelername);
	}
	/*****************enter phone number for the car insurance page***************/
	public void enterMobile(String phone) {
		
		travelMobile.sendKeys(phone);
	}
	
	/*****************enter email for the car insurance page***************/
	public void enterEmail(String mail) {
		travelEmail.sendKeys(mail);
	}
    /****************close browser****************/
	public void closeTravelPage() {
		driver.close();
	}
	
	/**************to click get quotes ****************/
	public TravelInsurancePlansDisplayPage clickGetQuotes() {
		click(getFreeQuotes,"Cliking the Get Free Quotes button", "Clicked the Get Free Quotes button");
		TravelInsurancePlansDisplayPage plansdisplaypage = new TravelInsurancePlansDisplayPage(driver,logger);
		PageFactory.initElements(driver, plansdisplaypage);
		return plansdisplaypage;
	}


}
