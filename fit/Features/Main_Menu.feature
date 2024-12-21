Feature: Main Menu Navigation

  Scenario: Main menu functionality
    Given the user is logged in and on the main dashboard
    When the user accesses the main menu
    Then they should see the following options:
      | Admin  |
      | Instructor |
      | Client |

  Scenario: Admin menu navigation
    Given the user is logged in as an admin
    When the admin selects the "Admin" option from the main menu
    Then they should be directed to the Admin Section, where they can manage users, programs, and view statistics

  Scenario: Instructor menu navigation
    Given the user is logged in as an instructor
    When the instructor selects the "Instructor" option from the main menu
    Then they should be directed to the Instructor Section, where they can manage programs, track client progress, and send notifications

  Scenario: Client menu navigation
    Given the user is logged in as a client
    When the client selects the "Client" option from the main menu
    Then they should be directed to the Client Section, where they can explore programs, track progress, and provide feedback