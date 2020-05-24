Feature: Tests and verifies all the login page flows.



Scenario Outline: Verify existing user is successfully able to login with valid username and password.
    When User performs login with existing account that has players in the account with <username> and <password>
    Then Verify user is on players page
    Examples: 
      | username              | password    |
      | naresh@squarepanda.com| squarepanda |

 
@SPRegression
  Scenario: Verify each element on the login screen.
    Given User is on login page of website
    Then Verify login page
    
     @SPRegression
  Scenario Outline: Verify the default langauge selection on the login screen.-C3186
    Given User is on login page of website
    Then Verify default language is <language>

    Examples: 
      | language |
      | english  |
    
    
    
    
    
    

  