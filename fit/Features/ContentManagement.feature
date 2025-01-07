Feature: Content Management
  As an admin
  I want to manage articles, tips, recipes, and user feedback
  So that I can ensure the quality and relevance of the content.

  Background:
    Given I am logged into the admin portal
    And I have the necessary permissions to manage content
  Scenario: Submit Tip
    Given the user wants to submit a tip
    When the tip content is "This is a tip."
    Then the tip should be added successfully

  Scenario: Submit Empty Tip
    Given the user wants to submit a tip
    When the tip content is empty
    Then the system should display "Error: Tip content cannot be empty."

  Scenario: Review Tip
    Given there is a tip "Tip 1" in the system
    When the user reviews tips
    Then the system should display the first tip "Tip 1"

  Scenario: Approve Tip
    Given the tip "Tip 1" exists in the system
    When the user approves the tip "Tip 1"
    Then the system should display "Tip approved: Tip 1"

  Scenario: Reject Tip
    Given the tip "Tip 1" exists in the system
    When the user rejects the tip "Tip 1"
    Then the tip "Tip 1" should be removed from the system

  Scenario: Reject Nonexistent Tip
    Given the user attempts to reject a nonexistent tip
    When the tip content is "Nonexistent Tip"
    Then the system should display "Error: Tip not found."
  