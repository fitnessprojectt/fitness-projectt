Feature: Program Monitoring System

  As an admini,
  I want to monitor program statistics, generate reports, track active and completed programs,
  So that I can manage the programs effectively and ensure client progress.

  Background:
    Given I am logged into the Program Monitoring System

  # 1. View Statistics on the Most Popular Programs by Enrollment
  Scenario: View Most Popular Programs by Enrollment
    When I navigate to the "Most Popular Programs" section
    Then I should see a list of programs sorted by enrollment numbers
    And I should see a bar chart representing the enrollment numbers
    And I should be able to filter by different time periods

  # 2. Generate Revenue, Attendance, and Client Progress Reports
  Scenario: Generate Revenue Report
    Given I am on the "Reports" section
    When I select "Revenue Report" and specify a date range
    Then I should see a report with total revenue for each program
    And I should see the amount paid by each client for the program
    And I should be able to export the report in PDF or Excel format

  Scenario: Generate Attendance Report
    Given I am on the "Reports" section
    When I select "Attendance Report"
    And I specify a program or client
    Then I should see attendance statistics with the number of sessions attended
    And I should see the number of sessions missed by each client

  Scenario: Generate Client Progress Report
    Given I am on the "Reports" section
    When I select "Client Progress Report"
    And I specify a client or program
    Then I should see the client's progress through the program
    And I should see milestones and achievements reached by the client

  # 3. Track Active and Completed Programs
  Scenario: View Active Programs
    Given I am on the "Programs Management" section
    When I select the "Active Programs" tab
    Then I should see a list of active programs with the number of enrollees
    And I should see the program start and end dates
    And I should see the remaining capacity for each active program

  Scenario: View Completed Programs
    Given I am on the "Programs Management" section
    When I select the "Completed Programs" tab
    Then I should see a list of completed programs with total revenue and attendance statistics
    And I should be able to archive or deactivate completed programs

  # 4. Track Client Progress
  Scenario: View Client Progress
    Given I am on the client dashboard
    When I view my enrolled programs
    Then I should see a progress bar indicating my completion status
    And I should see the milestones and key achievements I’ve completed

  # 5. Receive Notifications and Alerts
  Scenario: Receive Program Notifications
    Given I am a client enrolled in a program
    When a program session is approaching
    Then I should receive a notification about the upcoming session
    And I should receive a reminder for any tasks or assessments that need to be completed

  Scenario: Receive Program Update Alerts
    Given I am a client enrolled in a program
    When I complete a milestone or reach 50% completion
    Then I should receive an alert about my progress and achievements

  # 6. Export Reports and Data
  Scenario: Export Revenue Report
    Given I am viewing a revenue report
    When I click on the "Export" button
    Then I should be able to select PDF or Excel format
    And I should receive the report in the selected format

