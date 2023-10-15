/* Author Name:L.MUKESH
 * MODULE CREATION DATE:16-05-2021
 * MODULE MODIFICATION DATE:20-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */
package com.policybazaar.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
public static Properties prop;
	
	/*********************************to read the properties file*******************************/
	public ConfigReader()
	{
	try{
	if(prop==null){
		prop = new Properties();
		FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\test-data\\projectconfig.properties");
			prop.load(file);
		}}
	catch (Exception e) {
			e.printStackTrace();
		}
	}

	/************************function to return the browser name from the properties file*******************************/

	public String getBrowserName() 
	{
		return prop.getProperty("BROWSERNAME");
	}
	public String getUrl() 
	{
		return prop.getProperty("URL");
	}
		
	


}
