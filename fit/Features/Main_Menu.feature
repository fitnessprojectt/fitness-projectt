Main_Menu.feature

Feature: Fitness Management System Main Menu

  Scenario: User selects Admin login option
    Given the user is on the main menu
    When the user selects option 1
    Then the user should be taken to the Admin login screen

  Scenario: User selects Instructor login option
    Given the user is on the main menu
    When the user selects option 2
    Then the user should be taken to the Instructor login screen

  Scenario: User selects Client login option
    Given the user is on the main menu
    When the user selects option 3
    Then the user should be taken to the Client login screen

  Scenario: User selects Exit option
    Given the user is on the main menu
    When the user selects option 4
    Then the system should exit