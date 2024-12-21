Feature: Account Management for Clients

  As a client
  I want to create and customize my profile
  So that I can manage my fitness journey effectively

  Scenario: Create a new client profile with personal details
    Given the client opens the system
    When the client enters personal details such as age and fitness goals
      | Age | Fitness Goals   |
      | 25  | Weight Loss     |
    And the client submits the profile creation form
    Then the system saves the client profile and confirms the profile creation

  Scenario: Add dietary preferences to the client profile
    Given the client has an existing profile
    When the client adds dietary preferences
      | Dietary Preference         |
      | Vegetarian                 |
      | Gluten-Free                |
    And the client submits the dietary preferences form
    Then the system updates the client profile with dietary preferences and confirms the update

  Scenario: Update personal details in the client profile
    Given the client has an existing profile
    When the client updates their personal details
      | Age | Fitness Goals         |
      | 30  | Muscle Building        |
    And the client submits the changes
    Then the system updates the profile and confirms the changes

  Scenario: Attempt to create a profile with missing details
    Given the client opens the system
    When the client submits the profile creation form without entering personal details
    Then the system displays an error message indicating that all fields are required
