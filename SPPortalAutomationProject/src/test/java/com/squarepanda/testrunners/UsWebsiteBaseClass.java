package com.squarepanda.testrunners;

import org.openqa.selenium.WebDriver;

import com.squarepanda.generalUtility.LoadProperties;
import com.squarepanda.seleniumUtility.SeleniumDriver;
import com.squarepanda.usWebsite.WebsiteCoreLogic;

public class UsWebsiteBaseClass {
	
	
	
		
		public static WebDriver driver = null;
		public static WebsiteCoreLogic websiteCoreLogic;
		
		public void setup() {
			SeleniumDriver.openPage(LoadProperties.getProjectProperities("USWebsiteUrl"));
			instantiateHelpers();
			}
			
		
		public void instantiateHelpers() {
			websiteCoreLogic = new WebsiteCoreLogic();
			
		}
		

		public void tearDown() {
			SeleniumDriver.tearDown();
		}

	


}
