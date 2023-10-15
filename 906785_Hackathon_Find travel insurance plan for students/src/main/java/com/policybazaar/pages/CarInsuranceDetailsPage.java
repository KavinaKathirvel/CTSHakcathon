/* Author Name:L.MUKESH
 * MODULE CREATION DATE:19-05-2021
 * MODULE MODIFICATION DATE:20-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */



package com.policybazaar.pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.policybazaar.basepage.BasePageUi;

public class CarInsuranceDetailsPage extends BasePageUi {
	/**************************Constructor***************************/
	public CarInsuranceDetailsPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	//webElements in the car insurance page
	@FindBy(xpath = "//a[@class='pb-logo']")
	public WebElement policyBazaarButton;
		
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement citySerach;

	@FindBy(xpath ="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement carBrand;
	
	@FindBy(xpath="//*[@id=\"modelScroll\"]/li[3]/span")
	public WebElement carModel;

	@FindBy(xpath = "//ul//div//li//span")
	public List<WebElement> fuelType;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	public WebElement variant;

	@FindBy(xpath = "//b[contains(text(),'Brand New Car')]")
	public WebElement year;

	@FindBy(xpath = "//input[@id='name']")
	public WebElement Name;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement errorEmail;

	@FindBy(xpath = "//input[@id='mobileNo']")
	public WebElement errorMobileno;

	@FindBy(xpath = "//span[contains(text(),'View Prices')]")
	public WebElement clickProceed;
	
	@FindBy(xpath ="//div[@class='msg-error show']")
	public List<WebElement> errorMessageList;
	

	
	
	/******************to search city in the car insurance page********************/
	public void searchCity(String RTOValue) {
		try {
			logger.log(Status.INFO, "Selecting the city by passing the Value in Search");
			citySerach.sendKeys(RTOValue);
			citySerach.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			logger.log(Status.PASS, "Successfully selected the City");
		}catch (Exception e) {
			reportFail("Failed to Select the RTO and City");
			System.out.println("Failed to Select the RTO and City");
		}
		
	}
	/******************to search city in the car insurance page********************/
	public void searchBrand(String carName) {
		try {
			logger.log(Status.INFO, "Selecting the CAR Brand in suggestion list by passing the Value in Search");
			setWait(1);
			carBrand.sendKeys(carName);
			carBrand.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			logger.log(Status.PASS, "Successfully selected the Car Brand");
		} catch (Exception e) {
			reportFail("Failed to Select the Car Brand");
			System.out.println("Failed to Select the Car Brand");
		}
		
	}
	
	/******************to select the fuel type in the car insurance page********************/
	public void typeFuel(String fType) {
		try {
			logger.log(Status.INFO, "Selecting the Fuel Type in List");
			setWait(1);
			for (WebElement Fuel : fuelType) {
				if (Fuel.getText().equalsIgnoreCase(fType)) {
					Fuel.click();
					break;
				}
			}
			logger.log(Status.PASS, "Successfully selected the Fuel Type");
		} catch (Exception e) {
			reportFail("Failed to select the Fuel Type");
		}
		
	}
	/******************to select variant in the car insurance page********************/
	public void selectVariant(String Variant)   {
		try {
		    logger.log(Status.INFO, "Selecting the car version in List");
		    setWait(1);
			variant.sendKeys(Variant);
			variant.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			logger.log(Status.INFO, "Selecting the CAR Brand in suggestion list by passing the Value in Search");
		
	}
		 catch (Exception e) {
				reportFail("Failed to select the car version");
			}
	}
	
	/******************to click year in the car insurance page********************/	
	public void carYear() {
		year.click();
	}
	/******************enter name in the car insurance page********************/
	public void enterName(String Na) {
		Name.sendKeys(Na);
	}
	
	/******************enter email in the car insurance page********************/
	public void enterEmail(String mail) {
		errorEmail.sendKeys(mail);
		
	}
	
	/******************enter phone number in the car insurance page********************/
	public void enterPhonenumber(String mno) {
		errorMobileno.sendKeys(mno);
	}
	/********************** to click the proceed button************************/
	public void proceedClick() {
		clickProceed.click();
	}
	
	/******************to capture error from the car insurance details page********************/
	public void captureError() {
		try{
			logger.log(Status.INFO, "Capturing the error messages for invalid input");
			System.out.println("=================================================");
			System.out.println("Capturing Error Message in Car Insurance Form:");
			System.out.println("=================================================");
			for (WebElement e : errorMessageList) //iterating through the loop to get the text of web elements
			{
				System.out.println("* "+e.getText());
			}
			System.out.println("The above error messages were captured\n");
			logger.log(Status.PASS, "Successfully captured the error messages");
		} catch (Exception e) {
			reportFail("Failed to capture error messages for invalid inputs");
			System.out.println("failed to capture");
		}
	}
	/**************************to close browser****************************/
	public void closeCarPage() {
		driver.quit();
	}

	



}
