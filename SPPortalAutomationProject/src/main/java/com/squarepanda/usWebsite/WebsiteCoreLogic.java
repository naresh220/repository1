package com.squarepanda.usWebsite;

import org.openqa.selenium.support.PageFactory;

public class WebsiteCoreLogic {
	
	WebsiteLocators websitelocators;
	public WebsiteCoreLogic() {
		websitelocators = new WebsiteLocators();
		PageFactory.initElements(websitelocators.getDriver(), websitelocators);
	}
	public void clickSchool()   {
		
		websitelocators.clickElement(websitelocators.hideBar);
//		websitelocators.waitForElement(30, websitelocators.learnMore2);
//		
//		websitelocators.clickElement(websitelocators.learnMore2);
	}
	

}
