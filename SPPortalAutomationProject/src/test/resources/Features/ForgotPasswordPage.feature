Feature: Tests and verifies all the Forgot password  page flows.
    @SPRegression 
  Scenario: Verify each element on the Forgot password screen.
    Given User is on login page of website
    Then User redirects to forgot password page 
    Then Verify Forgot password page 
    
     @SPRegression @forgot
  Scenario: Verify the back to login link on the Forgot password screen. 
    Given User is on login page of website
    Then User redirects to forgot password page
    Then User clicks on back to login link
    Then Verify login page
    
   @SPRegression 
  Scenario Outline: Verify the forgot password functionality  
    Given User is on login page of website
    Then User requests password for <email>
    Then Verify user gets success notification <notification>
    Then Verify login page
    
    Examples:   
      | email                   | notification        |
      | naresh@squarepanda.com  | Email has been sent |
   