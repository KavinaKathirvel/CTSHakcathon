/* Author Name:P.K.RAKSHA
 * MODULE CREATION DATE:18-05-2021
 * MODULE MODIFICATION DATE:21-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */
package com.policybazaar.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.policybazaar.basepage.BasePageUi;

public class TravelInsurancePlansDisplayPage extends BasePageUi {
	/********************constructor*******************/
	
	public TravelInsurancePlansDisplayPage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
	}
	//web elements of the travel insurance display page
	@FindBy(xpath = "//a[@class='pb-logo']")
	public WebElement policyBazaarButton;
	
	@FindBy(className="sort_select")
	public WebElement sortPrice;
	
	@FindBy(xpath="//div[@class='desktop leftLogo']/div[1]")
	public List<WebElement> insuranceProvider;
	
	@FindBy(xpath="//div[@class='col-md-3 cta desktop']/div[1]/button")
	public List<WebElement> insuranceCost;
	
	/**************************function to get three lowest travel plans************************/
	public void getThreeLowTravelPlans() throws IOException {
		try {
			logger.log(Status.INFO, "Getting the Lowest Three Travel Plan Quotes");
			Select priceSort = new Select(sortPrice);
			priceSort.selectByVisibleText("Price: Low to High");
			Iterator<WebElement> itr = insuranceProvider.iterator();
			Iterator<WebElement> itr2 = insuranceCost.iterator();
		    logger.log(Status.PASS, "Retrieved the Lowest Travel Plan Quotes");
		    System.out.println("===============================================================");
			System.out.println("Three Lowest Travel Insurance Plan for the selected Category:");
			System.out.println("===============================================================");
			//iterating through the loop to get the travel insurance plan provider's name
			for(int i=0;i<3;i++) {
			String insuranceName = itr.next().getAttribute("class");
			String[] providerName = insuranceName.split("\\s+");
			String name = providerName[1];
			System.out.println((i+1)+":"+" Insurance Provider's Name: "+name);
			
			//iterating through the loop to get the cost of the insurance plan
			if(itr2.hasNext()) {
				String insuranceCost = itr2.next().getText();
				String[] providerCost = insuranceCost.split("\\s+");
				String cost = providerCost[1];
				System.out.println("Amount: Rupees: "+cost);
			    System.out.println("***********************************");
			}
			
			}
		    }catch(Exception e) {
			reportFail("Failed to Retrieve the Travel Plan Quotes");
		}
		
	}
	



}
