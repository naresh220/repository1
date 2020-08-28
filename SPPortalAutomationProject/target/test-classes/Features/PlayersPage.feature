Feature: Tests and verifies all the add a player flows.

 
  
  Scenario Outline: Verify user can delete all players on players page
    Given User is on login page of website
    When User performs login with <username> and <password>
    Then Verify user is on players page
    Then Delete all the players on players page
    Examples: 
      | username                          | password    |
      | naresh+automation@squarepanda.com | squarepanda |
      
   
   Scenario Outline: Verify user can add player on players page
    Given User is on login page of website
    When User performs login with <username> and <password>
    Then Verify user is on players page
    Then User clicks on add player button on players page
    Then Verify user creates a player on players page
    Then User delete the player on players page
    Examples:   
      | username                          | password    |
      | naresh+automation@squarepanda.com | squarepanda |

Scenario Outline: Verify user can edit player on players page
    Given User is on login page of website
    When User performs login with <username> and <password>
    Then Verify user is on players page
    Then User clicks on add player button on players page
    Then Verify user creates a player on players page  
    Then User clicks on edit player button on players page
    Then User edits the player on players page  
    Then Verify player updated on players page
    Then User delete the player on players page
    Examples: 
      | username                          | password    |
      | naresh+automation@squarepanda.com | squarepanda |
      
Scenario Outline: Verify user can add maximum three players
    Given User is on login page of website
    When User performs login with <username> and <password>
    Then Verify user is on players page
    Then Verify user can creates three players on players page
    
    Examples: 
      | username                          | password    |
      | naresh+automation@squarepanda.com | squarepanda |
 
 

  