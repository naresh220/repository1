package com.squarepanda.usWebsite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.squarepanda.seleniumUtility.GenericMethods;

public class WebsiteLocators extends GenericMethods {
	
	@FindBy(how=How.XPATH,using="//div[contains(@class,'header-fixed--true header-background--solid')]//a[contains(@class,'top_link')][contains(text(),'SCHOOLS')]")
	public WebElement schoolsLink;
	@FindBy(how=How.XPATH,using="//div[@id='shopify-section-1597308970109']//div[3]//div[1]//div[1]//a[1]")
	public WebElement learnMore2;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/button[1]")
	public WebElement hideBar;


}
