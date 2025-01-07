Feature: User Management
  As an admin
  I want to manage user accounts
  So that I can maintain system integrity and organization
  Scenario: Admin Login
    Given the admin "admin1" exists with password "adminPass"
    When the admin attempts to log in with username "admin1" and password "adminPass"
    Then the admin should be logged in successfully

  Scenario: Admin Login Failure
    Given the admin "admin1" exists with password "adminPass"
    When the admin attempts to log in with incorrect credentials
    Then the system should display "Invalid username or password."
     Scenario: Add Instructor
    Given the user wants to add an instructor
    When the instructor name is "Instructor1" and password is "password123"
    Then the instructor should be added successfully

  Scenario: Update Instructor
    Given the instructor "Instructor1" exists with password "password123"
    When the user updates the password to "newPassword"
    Then the instructor password should be updated successfully

  Scenario: Deactivate Instructor
    Given the instructor "Instructor1" exists in the system
    When the user deactivates the instructor "Instructor1"
    Then the instructor should be removed from the system

  Scenario: Add Client
    Given the user wants to add a client
    When the client name is "Client1" and password is "password123"
    Then the client should be added successfully

  Scenario: Update Client
    Given the client "Client1" exists with password "password123"
    When the user updates the password to "newPassword"
    Then the client password should be updated successfully

  Scenario: Deactivate Client
    Given the client "Client1" exists in the system
    When the user deactivates the client "Client1"
    Then the client should be removed from the system
    