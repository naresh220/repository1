Feature: Tests and verifies all the login page flows.
    @SPRegression  
  Scenario: Verify each element on the login screen.
    Given User is on login page of website
    Then Verify login page
    
     @SPRegression
  Scenario Outline: Verify the default langauge selection on the login screen. 
    Given User is on login page of website
    Then Verify the selected language is <language>
    Examples: 
      | language |
      | English  |
    
   @SPRegression
  Scenario Outline: Verify the functionality of language selection to switch from english to chinese on the login page
    Given User is on login page of website
    Then User selects the <language> language 
    Then Verify the selected language is <language>
 
    Examples: 
      | language |
      | 中文            |
    
    @SPRegression 
  Scenario Outline: Verify the user able to redirected to china region 
    Given User is on login page of website
    Then User selects the region is <region> 
    Then Verify the selected region <url>
    	
    Examples: 
      | region |url                                                |
      | China  |https://playground-dev.squarepanda.cn/#/auth/login |
   @SPRegression
  Scenario Outline: Verify the user able to redirected to india region 
    Given User is on login page of website
    Then User selects the region is <region> 
    Then Verify the selected region <url>
    	
    Examples: 
      | region |url                                                   |
      | India  |https://playground-dev-in.squarepanda.com/#/auth/login|
   
    @SPRegression 
    Scenario: Verify user can contact the squarepanda for teacher account.
    Given User is on login page of website
    Then Verify the class button and contact us popup
    Then User provides the information to contact
    @SPRegression 
   Scenario Outline: Verify user is not able to login with invalid username and password and gets error notification
    Given User is on login page of website
    When User performs login with <username> and <password>
    Then Verify user gets success notification <notification>
    Examples:   
      | username                | password    | notification                |
      | naresh@squarepanda.com  | squarepanda | Incorrect login information |
   @SPRegression 
   Scenario Outline: Verify existing user is successfully able to login with valid username and password.
    Given User is on login page of website
    When User performs login with <username> and <password>
    Then Verify user is on players page
    Examples: 
      | username                           | password    |
      | naresh+automation@squarepanda.com  | squarepanda |   

  