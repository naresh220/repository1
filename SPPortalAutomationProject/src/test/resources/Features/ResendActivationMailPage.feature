Feature: Tests and verifies all the resend activation mail page flows.
    @SPRegression 
  Scenario: Verify each element on the Forgot password screen.
    Given User is on login page of website
    Then User redirects to resend activation email page  
    Then Verify resend activation email page  
    
     @SPRegression @forgot
  Scenario: Verify the back to login link on the Resend Activation email screen. 
    Given User is on login page of website
    Then User redirects to resend activation email page
    Then User clicks on back to login link on resend activation email 
    Then Verify login page
    
   @SPRegression 
  Scenario Outline: Verify the Resend Activation email functionality  
    Given User is on login page of website 
    Then User recovers account <email>
    Then Verify user gets success notification <notification>
    Then Verify login page
    
    Examples:   
      | email                   | notification        |
      | naresh@squarepanda.com  | Email has been sent |
   