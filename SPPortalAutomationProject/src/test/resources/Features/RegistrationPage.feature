Feature: Tests and verifies all registration flows.


  @tag1
  Scenario Outline:: Verify the country selection popup and default selected country region and back button
    Given User is on login page of website
    When User is on country selection popup
    Then Verify the selected country region is <countryregion> 
  Examples: 
     | countryregion  | 
     | United States  | 
   @tag1  
  Scenario Outline:: Verify if user selects india region user will be redirected to india website registration page
    Given User is on login page of website
    When User redirects to the signup popup of <countryregion> region 
    Then Verify the selected region <url>
  Examples:
     | countryregion  | url                                                      |
     | India          | https://playground-dev-in.squarepanda.com/#/auth/register|
   @tag1
  Scenario Outline:: Verify if user selects china region user will be redirected to china website registration page
   Given User is on login page of website
   When User redirects to the signup popup of <countryregion> region 
   Then Verify the selected region <url>
  Examples:
     | countryregion  | url                                                 |
     | Mainland China |https://playground-dev.squarepanda.cn/#/auth/register|
   @tag1 
  Scenario Outline: Verify all elements on signup popup and functionality of back button
   Given User is on login page of website
    When User redirects to the signup popup of <countryregion> region
    Then Verify all elements on signup popup 
     Examples:
     | countryregion  |       
     | United States  | 
    
    @nnn 
  Scenario Outline: Verify user can registrate with valid information
   Given User is on login page of website
   When User redirects to the signup popup of <countryregion> region 
   Then User creates parent account with country of <country>
   Then User accepts privacy policy and terms and conditions 
   Then Verify login page
    Examples:
     | countryregion|country      |
     | United States|United States|    