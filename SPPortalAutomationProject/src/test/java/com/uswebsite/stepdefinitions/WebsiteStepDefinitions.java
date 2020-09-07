package com.uswebsite.stepdefinitions;

import com.squarepanda.generalUtility.LoadProperties;
import com.squarepanda.reporting.ErrorReporter;
import com.squarepanda.testrunners.UsWebsiteBaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebsiteStepDefinitions extends UsWebsiteBaseClass {
	@Given("^User opens us website$")
	public void user_opens_us_website() throws Throwable {
		try {
			 websiteCoreLogic.launchWebsite(LoadProperties.getProjectProperities("USWebsiteUrl"));
			
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the schools link$")
	public void user_clicks_and_verify_the_schools_link() throws Throwable {
		try {
			
			websiteCoreLogic.verifySchoolLink(LoadProperties.getProjectProperities("schoolsUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the squaretales books button$")
	public void user_clicks_and_verify_the_squaretales_books_button() throws Throwable {
		try {
			websiteCoreLogic.verifySquaretalesBooksButton(LoadProperties.getProjectProperities("squaretalesBooksUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the phonics playset button$")
	public void user_clicks_and_verify_the_phonics_playset_button() throws Throwable {
		try {
			
			websiteCoreLogic.verifyPhonicsPlaysetButton(LoadProperties.getProjectProperities("phonicsPlaysetUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the learning games link$")
	public void user_clicks_and_verify_the_learning_games_link() throws Throwable {
		try {
			websiteCoreLogic.verifyLearningGamesLink(LoadProperties.getProjectProperities("learningGamesUrl"), LoadProperties.getProjectProperities("learningGamesTitle"));
			
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the FAQ link$")
	public void user_clicks_and_verify_the_faq_link() throws Throwable {
		try {
			websiteCoreLogic.verifyFaqLink(LoadProperties.getProjectProperities("faqUrl"),LoadProperties.getProjectProperities("faqPageTitle"));
		    } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the about us link$")
	public void user_clicks_and_verify_the_about_us_link() throws Throwable {
		try {
			websiteCoreLogic.verifyAboutUsLink(LoadProperties.getProjectProperities("aboutUsUrl"), LoadProperties.getProjectProperities("aboutUsTitle"));
			
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the login link$")
	public void user_clicks_and_verify_the_login_link() throws Throwable {
		try {
			websiteCoreLogic.verifyLoginLink(LoadProperties.getProjectProperities("loginUrl"));
			
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the order now button$")
	public void user_clicks_and_verify_the_order_now_button() throws Throwable {
		try {
			websiteCoreLogic.verifyOrderNowButtton(LoadProperties.getProjectProperities("orderNowUrl"));
			
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the india flag$")
	public void user_clicks_and_verify_the_india_flag() throws Throwable {
		try {
			websiteCoreLogic.verifyIndiaFlag(LoadProperties.getProjectProperities("indiaUrl"));
			} catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^User clicks and verify the china flag$")
	public void user_clicks_and_verify_the_china_flag() throws Throwable {
		try {
			websiteCoreLogic.verifyChinaFlag(LoadProperties.getProjectProperities("chinaUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify all banner elements$")
	public void verify_all_banner_elements() throws Throwable {
		try {
			websiteCoreLogic.verifyHeroBanner(LoadProperties.getProjectProperities("bannerHeader"), LoadProperties.getProjectProperities("bannerText"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify i'm teacher link$")
	public void verify_i_am_teacher_link() throws Throwable {
		try {
			websiteCoreLogic.verifyIamTeacherLink(LoadProperties.getProjectProperities("iAmTeacherUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify i'm parent link$")
	public void verify_i_am_parent_link() throws Throwable {
		try {
			websiteCoreLogic.verifyIamParentLink(LoadProperties.getProjectProperities("iAmParentUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify watch a demo button$")
	public void verify_watch_a_demo_button() throws Throwable {
		try {
			websiteCoreLogic.verifyBannerButton();
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify learnmore1 link$")
	public void Verify_learnmore1_link() throws Throwable {
		try {
			websiteCoreLogic.verifyLiteracyLearnmore1(LoadProperties.getProjectProperities("literacyLearnMore1Url"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify learnmore2 link$")
	public void verify_learnmore2_link() throws Throwable {
		try {
			websiteCoreLogic.verifyLiteracyLearnmore2(LoadProperties.getProjectProperities("literacyLearnMore2Url"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify learnmore1 image button$")
	public void verify_learnmore1_image_button() throws Throwable {
		try {
			websiteCoreLogic.verifyLearnMoreButton1();
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify learnmore2 image button$")
	public void verify_learnmore2_image_button() throws Throwable {
		try {
			websiteCoreLogic.verifyLearnMoreButton2(LoadProperties.getProjectProperities("learnMoreUrl2"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify learnmore3 image button$")
	public void verify_learnmore3_image_button() throws Throwable {
		try {
			websiteCoreLogic.verifyLearnMoreButton3(LoadProperties.getProjectProperities("learnMoreUrl3"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify get the playset button$")
	public void verify_get_the_playset_button() throws Throwable {
		try {
			websiteCoreLogic.verifyGetThePlaysetButton(LoadProperties.getProjectProperities("getThePlaysetUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify get squaretales button$")
	public void verify_get_squaretales_button() throws Throwable {
		try {
			websiteCoreLogic.verifyGetSquaretalesButton(LoadProperties.getProjectProperities("getSquaretalesUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	
	
	
	
	
	@Then("^Verify blog link$")
	public void verify_blog_link() throws Throwable {
		try {
			websiteCoreLogic.verifyBlogLink(LoadProperties.getProjectProperities("blogUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify press room link$")
	public void verify_press_room_link() throws Throwable {
		try {
			websiteCoreLogic.verifyPressRoomLink(LoadProperties.getProjectProperities("pressRoomUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify contact us link$")
	public void verify_contact_us_link() throws Throwable {
		try {
			websiteCoreLogic.verifyContactUsLink(LoadProperties.getProjectProperities("contactUsUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify faq link$")
	public void verify_faq_link() throws Throwable {
		try {
			websiteCoreLogic.verifyFaqLinkFooter(LoadProperties.getProjectProperities("faqUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify parent resource guide link$")
	public void verify_parent_resource_guide_link() throws Throwable {
		try {
			websiteCoreLogic.verifyParentResourceGuideLink(LoadProperties.getProjectProperities("parentResourceGuideUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify replacement smart letters link$")
	public void verify_replacement_smart_letters_link() throws Throwable {
		try {
			websiteCoreLogic.verifyReplacementSmartLettersLink(LoadProperties.getProjectProperities("replacementSmartLettersUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify support link$")
	public void verify_support_link() throws Throwable {
		try {
			websiteCoreLogic.verifySupportLink(LoadProperties.getProjectProperities("supportUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify application privacy policy link$")
	public void verify_application_privacy_policy_link() throws Throwable {
		try {
			websiteCoreLogic.verifyApplicationPrivacyPolicyLink(LoadProperties.getProjectProperities("applicationPrivacyPolicyUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify website privacy policy link$")
	public void verify_website_privacy_policy_link() throws Throwable {
		try {
			websiteCoreLogic.verifyWebsitePrivacyPolicyLink(LoadProperties.getProjectProperities("websitePrivacyPolicyUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify warranty link$")
	public void verify_warranty_link() throws Throwable {
		try {
			websiteCoreLogic.verifyWarrantyLink(LoadProperties.getProjectProperities("warrantyUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify terms of service link$")
	public void verify_terms_of_service_link() throws Throwable {
		try {
			websiteCoreLogic.verifyTermsOfServiceLink(LoadProperties.getProjectProperities("termsOfServiceUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify twitter link$")
	public void verify_twitter_link() throws Throwable {
		try {
			websiteCoreLogic.verifyTwitterLink(LoadProperties.getProjectProperities("twitterUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify facebook link$")
	public void verify_facebook_link() throws Throwable {
		try {
			websiteCoreLogic.verifyFacebookLink(LoadProperties.getProjectProperities("facebookUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
	@Then("^Verify instagram link$")
	public void verify_instagram_link() throws Throwable {
		try {
			websiteCoreLogic.verifyinstagramLink(LoadProperties.getProjectProperities("instagramUrl"));
		   } catch (Exception e) {
				ErrorReporter.reportError(e);
			}  
	}
}