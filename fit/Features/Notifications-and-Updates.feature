Feature: Notifications and Updates
  As an instructor
  I want to notify clients of changes and updates
  So that they stay informed about programs and offers

  Scenario: Notify clients about schedule changes
    Given I am logged in as an instructor
    When I update the schedule of a program
    Then all enrolled clients should receive a notification about the schedule change

  Scenario: Announce a new fitness program
    Given I am logged in as an instructor
    When I create a new fitness program
    And I click "Announce"
    Then all clients should receive a notification about the new program

  Scenario: Announce special offers
    Given I am logged in as an instructor
    When I navigate to the "Special Offers" page
    And I create a new offer (e.g., discount on a program)
    And I click "Announce"
    Then all clients should receive a notification about the special offer