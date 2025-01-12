Feature: Progress Tracking for Clients

  Scenario: Track personal fitness milestones
    Given the client has completed a fitness program
    When the client navigates to the progress section
    And the client requests to view milestones
    Then the system displays the client’s current weight, BMI, and attendance records

  Scenario: View achievements after completing a program
    Given the client has completed a fitness program
    When the client views their achievements
    Then the system displays any badges earned for completing the program

  Scenario: Client views program attendance
    Given the client has enrolled in a fitness program
    When the client requests to view attendance
    Then the system displays the client’s attendance history for the program

  Scenario: Client checks progress towards goals
    Given the client has set fitness goals
    When the client checks progress towards those goals
    Then the system shows how far the client has progressed in terms of weight, BMI, or other metrics