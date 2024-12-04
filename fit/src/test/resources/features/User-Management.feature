Feature: User Management
   As an admin
  I want to manage user accounts
  So that I can maintain system integrity and organization

  Scenario: Add a new user account
    Given I am logged in 
    When I navigate to the "User Management" page
    And I click "Add User"
    And I fill in the user's details (e.g., name, role)
    And I click "Save"
    Then the new user account should be created successfully

  Scenario: Update a user account
    Given I am logged in as an admin
    When I navigate to the "User Management" page
    And I select an existing user account
    And I update the user details (e.g., name, role)
    And I click "Save"
    Then the user account should be updated successfully
Scenario: Deactivate a user account
    Given I am logged in as an admin
    When I navigate to the "User Management" page
    And I select a user account
    And I click "Deactivate"
    Then the user account should be marked as inactive

  Scenario: Approve new instructor registration
    Given I am logged in as an admin
    When I navigate to the "Pending Registrations" page
    And I review an instructor's application
    And I click "Approve"
    Then the instructor account should be activated

  Scenario: Monitor user activity
    Given I am logged in as an admin
    When I navigate to the "User Engagement" page
    Then I should see statistics such as login frequency and program enrollments
    