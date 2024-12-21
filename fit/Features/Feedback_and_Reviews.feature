Feature: Feedback and Reviews for Programs

  Scenario: Client submits feedback after completing a program
    Given the client has completed a fitness program
    When the client navigates to the feedback section
    And the client rates the program with a score of 1 to 5
    And the client writes a review
    Then the system saves the feedback and associates it with the completed program

  Scenario: Client submits improvement suggestions to the instructor
    Given the client has completed a fitness program
    When the client navigates to the feedback section
    And the client writes a suggestion for improving the program
    Then the system sends the suggestion to the instructor for review

  Scenario: Client reviews previously completed programs
    Given the client has completed a fitness program
    When the client selects "View Program Feedback" from the main menu
    Then the system displays the client’s previously submitted feedback for the selected program
