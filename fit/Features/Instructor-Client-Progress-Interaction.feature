Feature: Instructor Client Progress Interaction

  Scenario: Monitor client progress
    Given the instructor is logged in successfully
    And the instructor navigates to the Client Progress page
    When the instructor selects a client
    Then the instructor should see the client's progress (e.g., completion rate, attendance)

  Scenario: Send motivational reminders
    When the instructor writes a motivational message
    Then the client should receive the motivational reminder