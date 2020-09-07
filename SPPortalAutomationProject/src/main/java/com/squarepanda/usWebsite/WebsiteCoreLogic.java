package com.squarepanda.usWebsite;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class WebsiteCoreLogic {
	
	WebsiteLocators websitelocators;
	public WebsiteCoreLogic() {
		websitelocators = new WebsiteLocators();
		PageFactory.initElements(websitelocators.getDriver(), websitelocators);
	}
	public void launchWebsite(String url) {
		if(websitelocators.getDriver().getWindowHandles().size()>1)
		websitelocators.closeTab();
		websitelocators.switchTab(0);
		websitelocators.openPage(url);	
	}
	public void verifyUrl(String url) {
		websitelocators.waitFor(10);
    	String actualUrl = websitelocators.getDriver().getCurrentUrl();
    	System.out.println(actualUrl);
    	websitelocators.assertValuesEqual(actualUrl, url);
    	
    }
	public void verifySchoolLink(String url)   {
		websitelocators.waitForElement(30, websitelocators.schoolsLink);
		websitelocators.clickElement(websitelocators.schoolsLink);
		verifyUrl(url);
	}
	public void verifySquaretalesBooksButton(String url) {
		websitelocators.waitForElement(30, websitelocators.forTheHome);
		websitelocators.clickElement(websitelocators.forTheHome);
		websitelocators.clickElement(websitelocators.squaretalesBooksButton);
		verifyUrl(url);
	}
	public void verifyPhonicsPlaysetButton(String url) {
		websitelocators.waitForElement(30, websitelocators.forTheHome);
		websitelocators.clickElement(websitelocators.forTheHome);
		websitelocators.clickElement(websitelocators.phonicsPlaysetButton);
		verifyUrl(url);
	}
	public void verifyLearningGamesLink(String url,String title) {
		websitelocators.waitForElement(30, websitelocators.learningGamesLink);
		websitelocators.clickElement(websitelocators.learningGamesLink);
		verifyUrl(url);
		websitelocators.assertValuesEqual(websitelocators.getText(websitelocators.learningGamesTitle), title);
		
	}
	public void verifyFaqLink(String url,String title) {
		websitelocators.waitForElement(30, websitelocators.faqLink);
		websitelocators.clickElement(websitelocators.faqLink);
		verifyUrl(url);
		websitelocators.assertValuesEqual(websitelocators.getText(websitelocators.faqPageTitle),title);
	}
	public void verifyAboutUsLink(String url,String title) {
		websitelocators.waitForElement(30, websitelocators.aboutUsLink);
		websitelocators.clickElement(websitelocators.aboutUsLink);
		verifyUrl(url);
		websitelocators.assertValuesEqual(websitelocators.getText(websitelocators.aboutUsTitle), title);
		
	}
	public void verifyLoginLink(String url) {
		websitelocators.waitForElement(30, websitelocators.loginLink);
		websitelocators.clickElement(websitelocators.loginLink);
		verifyUrl(url);
	}
	public void verifyOrderNowButtton(String url) {
		websitelocators.waitForElement(30, websitelocators.orderNowButton);
		websitelocators.clickElement(websitelocators.orderNowButton);
		verifyUrl(url);
		websitelocators.verifyElementVisible(websitelocators.orderNowImage1);
		websitelocators.verifyElementVisible(websitelocators.orderNowImage2);
		websitelocators.verifyElementVisible(websitelocators.orderNowImage3);
		
	}
	public void verifyIndiaFlag(String url) {
		websitelocators.waitForElement(30, websitelocators.indiaFlag);
		websitelocators.clickElement(websitelocators.indiaFlag);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyChinaFlag(String url) {
		websitelocators.waitForElement(30, websitelocators.chinaFlag);
		websitelocators.clickElement(websitelocators.chinaFlag);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyHeroBanner(String header,String text) {
		websitelocators.verifyElementVisible(websitelocators.bannerImage);
		websitelocators.verifyElementVisible(websitelocators.bannerHeader);
		websitelocators.verifyElementVisible(websitelocators.bannerText);
		websitelocators.assertValuesEqual(websitelocators.getText(websitelocators.bannerHeader),header, "Banner header is incorrect");
		websitelocators.assertValuesEqual(websitelocators.getText(websitelocators.bannerText), text, "banner text is incorrect");
		
	}
	public void verifyIamTeacherLink(String url) {
		websitelocators.waitForElement(30, websitelocators.iAmTeacher);
		websitelocators.clickElement(websitelocators.iAmTeacher);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyIamParentLink(String url) {
		websitelocators.waitForElement(30, websitelocators.iAmParent);
		websitelocators.clickElement(websitelocators.iAmParent);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyBannerButton( ) {
		websitelocators.verifyElementVisible(websitelocators.bannerButton);
		websitelocators.clickElement(websitelocators.bannerButton);
		websitelocators.clickElement(websitelocators.closeButton);
	}
	public void verifyLiteracyLearnmore1(String url) {
		websitelocators.clickElement(websitelocators.literacyLearnmore1);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyLiteracyLearnmore2(String url) {
		websitelocators.clickElement(websitelocators.literacyLearnmore2);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyLearnMoreButton1( ) {
		websitelocators.verifyElementVisible(websitelocators.learnMoreButton1);
		websitelocators.clickElement(websitelocators.learnMoreButton1);
		websitelocators.clickElement(websitelocators.closeButton);
	}
	public void verifyLearnMoreButton2(String url) {
		websitelocators.clickElement(websitelocators.learnMoreButton2);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyLearnMoreButton3(String url) {
		websitelocators.clickElement(websitelocators.learnMoreButton3);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyGetThePlaysetButton(String url) {
		websitelocators.clickElement(websitelocators.getThePlaysetButton);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyGetSquaretalesButton(String url) {
		websitelocators.clickElement(websitelocators.getSquaretalesButton);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyBlogLink(String url) {
		websitelocators.clickElement(websitelocators.blogLink);
		verifyUrl(url);
	}
	public void verifyPressRoomLink(String url) {
		websitelocators.clickElement(websitelocators.pressRoomLink);
		verifyUrl(url);
	}
	public void verifyContactUsLink(String url) {
		websitelocators.clickElement(websitelocators.contactUsLink);
		verifyUrl(url);
	}
	public void verifyFaqLinkFooter(String url) {
		websitelocators.clickElement(websitelocators.faqLinkFooter);
		verifyUrl(url);
	}
	public void verifyParentResourceGuideLink(String url) {
		websitelocators.clickElement(websitelocators.parentResourceGuide);
		verifyUrl(url);
	}
	public void verifyReplacementSmartLettersLink(String url) {
		websitelocators.clickElement(websitelocators.replacementSmartLetters);
		verifyUrl(url);
	}
	public void verifySupportLink(String url) {
		websitelocators.clickElement(websitelocators.supportLink);
		verifyUrl(url);
	}
	public void verifyApplicationPrivacyPolicyLink(String url) {
		websitelocators.clickElement(websitelocators.applicationPrivacyPolicy);
		verifyUrl(url);
	}
	public void verifyWebsitePrivacyPolicyLink(String url) {
		websitelocators.clickElement(websitelocators.websitePrivacyPolicy);
		verifyUrl(url);
	}
	public void verifyWarrantyLink(String url) {
		websitelocators.clickElement(websitelocators.warrantyLink);
		verifyUrl(url);
	}
	public void verifyTermsOfServiceLink(String url) {
		websitelocators.clickElement(websitelocators.termsOfService);
		verifyUrl(url);
	}
	public void verifyTwitterLink(String url) {
		websitelocators.clickElement(websitelocators.twitter);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyFacebookLink(String url) {
		websitelocators.clickElement(websitelocators.facebook);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}
	public void verifyinstagramLink(String url) {
		websitelocators.clickElement(websitelocators.instagram);
		websitelocators.switchTab(1);
		verifyUrl(url);
		websitelocators.closeTab();
		websitelocators.switchTab(0);
	}

}
