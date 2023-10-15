/* Author Name:L.MUKESH
 * MODULE CREATION DATE:16-05-2021
 * BROWSERS USED:Chrome,Firefox
 * BROWSER VERSION:Chrome  90.0.4430.212 (Official Build) (64-bit) and Firefox(Version 88.01 (64-bit))
 * TestNG version:7.3.0
 */
package com.policybazaar.utils;

import java.util.Date;

public class DateUtil {
	/***************function to get the time stamp**************/
	public static String getTimeStamp(){
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}

}
