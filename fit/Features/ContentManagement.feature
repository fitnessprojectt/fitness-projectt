Feature: Content Management
  As an admin
  I want to manage articles, tips, recipes, and user feedback
  So that I can ensure the quality and relevance of the content.

  Background:
    Given I am logged into the admin portal
    And I have the necessary permissions to manage content

  Scenario: Approve an article submitted by an instructor
    Given an article has been submitted by an instructor
    When I review the content
    And the article meets the quality guidelines
    Then I approve the article
    And the article is published on the platform

  Scenario: Reject an article submitted by an instructor
    Given an article has been submitted by an instructor
    When I review the content
    And the article does not meet the quality guidelines
    Then I reject the article
    And notify the instructor with feedback

  Scenario: Approve a health or wellness tip
    Given a wellness tip has been shared on the platform
    When I review the tip
    And it aligns with the platform's guidelines
    Then I approve the tip
    And it becomes visible to users

  Scenario: Reject a tip that does not meet the guidelines
    Given a wellness tip has been shared on the platform
    When I review the tip
    And it does not meet health and wellness standards
    Then I reject the tip
    And provide feedback to the submitter

  Scenario: Handle user feedback
    Given a user has submitted feedback about content
    When I review the feedback
    And it highlights a valid issue
    Then I mark the feedback for further action
    And notify the content team

  Scenario: Handle user complaints
    Given a user has submitted a complaint about content
    When I review the complaint
    And the complaint is valid
    Then I remove the content from the platform
    And notify the user of the resolution
