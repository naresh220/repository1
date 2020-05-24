Feature: Tests and verifies all the add a player flows.

  Background: 
    Then Delete the player added from backend for account with "testing+select@squarepanda.com" and "12345678"

  @SPRegression
  Scenario Outline: Verify user can add, edit and delete a player.-C3501,C3502,C3503,C3506,C3507,C3508,C3510
    When User performs login with existing account that has players in the account with <username> and <password>
    Then Verify user is on players page
    Then User clicks add player button on player page
    Then Verify add player popup on player page
    Then User clicks add player button on add player screen
    Then User creates a player "with all" information on add player page
    Then User clicks on newly created player on add player page
    Then Verify edit player popup on add player page
    Then User edits the player "with all" information on add player page
    Then Verify player updated on add player page
    Then User clicks on updated player on add player page
    Then User clicks delete icon on edit player popup on add player page
    Then Verify delete popup on add player page
    Then User clicks delete button on delete popup on add player page
    Then Verify player deleted on add player page

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify user is able to see three different options like take a picture, upload from library and choose an avatar on add picture popup from add player screen.-C12326
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User clicks image icon on add player screen
    Then Verify add picture popup from "addplayer" screen on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify the spaces before the first name while adding a player are trimmed.-C12327
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "with spaces before firstName" information on add player screen
    Then Verify player added on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify the spaces after the first name while adding a player are trimmed.-C12328
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "with spaces after firstName" information on add player screen
    Then Verify player added on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify error popup is displayed if user does not input first name while adding a player.-C3504
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "without firstName" information on add player screen
    Then Verify player "name" missing error popup on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify error popup is displayed if user does not input birthday while adding a player.-C3504
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "without birthday" information on add player screen
    Then Verify player "birthday" missing error popup on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify the spaces before the first name while editing a player are trimmed and player is successfully updated.-C3513
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "with all" information on add player screen
    Then User clicks on newly created player on add player screen
    Then User edits the player "with spaces before firstName" information on add player screen
    Then Verify player updated on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify the spaces after the first name while editing a player are trimmed and player is successfully updated.-C3514
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "with all" information on add player screen
    Then User clicks on newly created player on add player screen
    Then User edits the player "with spaces after firstName" information on add player screen
    Then Verify player updated on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify error popup is displayed if user does not input first name while editing a player.-C3511
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "with all" information on add player screen
    Then User clicks on newly created player on add player screen
    Then User edits the player "without firstName" information on add player screen
    Then Verify player "name" missing error popup on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify error popup is displayed if user does not input birthday while editing a player.-C3511
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "with all" information on add player screen
    Then User clicks on newly created player on add player screen
    Then User edits the player "without birthday" information on add player screen
    Then Verify player "birthday" missing error popup on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify clicking on cancel button on add player popup user is navigated to add player screen.-C3505
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User clicks cancel button on add player popup
    Then Verify add player screen is displayed

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify clicking on cancel button on edit player popup user is navigated to add player screen.-C3509
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "with all" information on add player screen
    Then User clicks on newly created player on add player screen
    Then User clicks cancel button on edit player popup
    Then Verify add player screen is displayed

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: Verify clicking on cancel button on delete player popup user is navigated to edit player screen.-C12329
    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then User clicks add player button on add player screen
    Then User creates a player "with all" information on add player screen
    Then User clicks on newly created player on add player screen
    Then User clicks delete icon on edit player popup on add player screen
    Then User clicks cancel button on delete player popup on add player screen
    Then Verify edit player popup on add player screen

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |

  @SPRegression
  Scenario Outline: 
    Verify a new user is successfully able to login with valid username and password and is able to see add player screen.-C12330,C3540

    Then User performs login with new user account that does not have players in the account with <username> and <password>
    Then Verify user can add maximum of three players on add player screen
    Then User clicks continue button on add player screen
    Then Verify you are all set screen
    Then User cicks take me to game button
    Then Verify select a player screen is displayed
    Then User performs a logout

    Examples: 
      | username                       | password |
      | testing+select@squarepanda.com | 12345678 |
