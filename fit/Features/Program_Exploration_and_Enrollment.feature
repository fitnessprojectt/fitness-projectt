Feature: Program Exploration and Enrollment

  Scenario: Browse programs by difficulty level
    Given the client is on the program browsing page
    When the client filters programs by difficulty level "Beginner"
    Then the system displays all available programs with difficulty level "Beginner"

  Scenario: Browse programs by focus area
    Given the client is on the program browsing page
    When the client filters programs by focus area "Weight Loss"
    Then the system displays all available programs with focus area "Weight Loss"

  Scenario: Browse programs by both difficulty level and focus area
    Given the client is on the program browsing page
    When the client filters programs by difficulty level "Intermediate" and focus area "Muscle Building"
    Then the system displays all available programs with difficulty level "Intermediate" and focus area "Muscle Building"

  Scenario: Enroll in a program
    Given the client has selected a program
    When the client clicks "Enroll"
    Then the system adds the selected program to the client’s profile and confirms enrollment

  Scenario: View program schedule
    Given the client is enrolled in a program
    When the client requests to view the schedule for the program
    Then the system displays the start and end date, and time for the program