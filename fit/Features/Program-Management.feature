Feature: Program Management

  Scenario: Create a new fitness program
    Given I am logged in as an instructor
    When I navigate to Create Program page
    And I fill in the program details (title, duration, difficulty level, goals)
    Then Program created successfully

  Scenario: Update an existing fitness program
    Given I am logged in as an instructor
    When I navigate to Update Program page
    And I update the program details
    Then Program updated successfully

  Scenario: Delete a fitness program
    Given I am logged in as an instructor
    When I select a program to delete
    And I confirm the deletion
    Then Program removed from the system

  Scenario: Set schedules for group sessions
    Given I am logged in as an instructor
    When I navigate to Set Schedule page
    And I add a group session schedule (date, time, location)
    Then Group session scheduled successfully
