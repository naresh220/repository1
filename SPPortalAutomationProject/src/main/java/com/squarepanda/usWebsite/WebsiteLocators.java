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
//	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/button[1]")
//	public WebElement hideBar;
	@FindBy(how=How.XPATH,using="//div[@class='main_nav_wrapper']//a[contains(text(),'SquareTales Books')]")
	public WebElement squaretalesBooksButton;
	@FindBy(how=How.XPATH,using="//div[contains(@class,'header-fixed--true header-background--solid')]//a[contains(@class,'dropdown_link')][contains(text(),'For The Home')]")
	public WebElement forTheHome;
	@FindBy(how=How.XPATH,using="//div[@class='main_nav_wrapper']//a[contains(text(),'Phonics Playset')]")
	public WebElement phonicsPlaysetButton;
	@FindBy(how=How.XPATH,using="//div[contains(@class,'header-fixed--true header-background--solid')]//a[contains(@class,'top_link')][contains(text(),'Learning Games')]")
	public WebElement learningGamesLink;
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Reading Games for Today')]")
	public WebElement learningGamesTitle;
	@FindBy(how=How.XPATH,using="//div[contains(@class,'header-fixed--true header-background--solid')]//a[contains(@class,'top_link')][contains(text(),'FAQ')]")
	public WebElement faqLink;
	@FindBy(how=How.XPATH,using="//h1[@class='page-title']")
	public WebElement faqPageTitle;
	@FindBy(how=How.XPATH,using="//div[contains(@class,'header-fixed--true header-background--solid')]//a[contains(@class,'top_link')][contains(text(),'About Us')]")
	public WebElement aboutUsLink;
	@FindBy(how=How.XPATH,using="//h1[contains(@class,'page-title')]")
	public WebElement aboutUsTitle;
	@FindBy(how=How.XPATH,using="//div[contains(@class,'header-fixed--true header-background--solid')]//a[contains(@class,'top_link')][contains(text(),'Login')]")
	public WebElement loginLink;
	@FindBy(how=How.XPATH,using="//div[contains(@class,'header-fixed--true header-background--solid')]//a[contains(@class,'top_link')][contains(text(),'ORDER NOW')]")
	public WebElement orderNowButton;
	@FindBy(how=How.XPATH,using="//div[3]//div[1]//div[1]//a[1]//div[1]//img[1]")
	public WebElement orderNowImage1;
	@FindBy(how=How.XPATH,using="//div[contains(@class,'product-list collection-matrix clearfix')]//div[2]//div[1]//div[1]//a[1]//div[1]//img[1]")
	public WebElement orderNowImage2;
	@FindBy(how=How.XPATH,using="//div[contains(@class,'container col-container')]//div[1]//div[1]//div[1]//a[1]//div[1]//img[1]")
	public WebElement orderNowImage3;
	@FindBy(how=How.XPATH,using="//header[contains(@class,'secondary_logo--true')]//a[1]//img[1]")
	public WebElement indiaFlag;
	@FindBy(how=How.XPATH,using="//header[contains(@class,'secondary_logo--true')]//a[2]//img[1]")
	public WebElement chinaFlag;
	@FindBy(how=How.XPATH,using="//h1[contains(text(),'Reinvent Reading')]")
	public WebElement bannerHeader;
	@FindBy(how=How.XPATH,using="//p[contains(text(),'Technology that transforms passive screen time int')]")
	public WebElement bannerText;
	@FindBy(how=How.XPATH,using="//img[@class='banner-img fade-in lazyloaded']")
	public WebElement bannerImage;
	@FindBy(how=How.XPATH,using="//a[contains(text(),\"I'm a teacher\")]")
	public WebElement iAmTeacher;
	@FindBy(how=How.XPATH,using="//a[contains(text(),\"I'm a parent\")]")
	public WebElement iAmParent;
	@FindBy(how=How.XPATH,using="//a[@class='action_button first_button highlight-true']")
	public WebElement bannerButton;
	@FindBy(how=How.XPATH,using="//*[name()='path' and contains(@d,'M10,10 L30')]")
	public WebElement closeButton;
	@FindBy(how=How.XPATH,using="//div[@id='shopify-section-1526341407039']//div[2]//div[1]//div[1]//a[1]")
	public WebElement literacyLearnmore1;
	@FindBy(how=How.XPATH,using="//div[@id='shopify-section-1526341407039']//div[3]//div[1]//div[1]//a[1]")
	public WebElement literacyLearnmore2;
	@FindBy(how=How.XPATH,using="//div[@id='shopify-section-1597308970109']//div[2]//div[1]//div[1]//a[1]")
	public WebElement learnMoreButton1;
	@FindBy(how=How.XPATH,using="//div[@id='shopify-section-1597308970109']//div[3]//div[1]//div[1]//a[1]")
	public WebElement learnMoreButton2;
	@FindBy(how=How.XPATH,using="//div[@class='index-sections']//div[4]//div[1]//div[1]//a[1]")
	public WebElement learnMoreButton3;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'GET THE PLAYSET')]")
	public WebElement getThePlaysetButton;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'GET SQUARETALES')]")
	public WebElement getSquaretalesButton;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Educators')]")
	public WebElement educatorsLink;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Blog')]")
	public WebElement blogLink;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Press Room')]")
	public WebElement pressRoomLink;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Contact Us')]")
	public WebElement contactUsLink;
	@FindBy(how=How.XPATH,using="//div[@class='toggle_content']//a[contains(text(),'FAQ')]")
	public WebElement faqLinkFooter;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Parent Resource Guide')]")
	public WebElement parentResourceGuide;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Replacement Smart Letters')]")
	public WebElement replacementSmartLetters;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Support')]")
	public WebElement supportLink;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Application Privacy Policy')]")
	public WebElement applicationPrivacyPolicy;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Website Privacy Policy')]")
	public WebElement websitePrivacyPolicy;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Warranty')]")
	public WebElement warrantyLink;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Terms of Service')]")
	public WebElement termsOfService;
	@FindBy(how=How.XPATH,using="//div[@class='footer-social-icons']//a[@class='icon-twitter']")
	public WebElement twitter;
	@FindBy(how=How.XPATH,using="//div[@class='footer-social-icons']//a[@class='icon-facebook']")
	public WebElement facebook;
	@FindBy(how=How.XPATH,using="//div[@class='footer-social-icons']//a[@class='icon-instagram']")
	public WebElement instagram;

}
