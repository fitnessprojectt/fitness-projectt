Feature: Client Interaction
  As an instructor
  I want to communicate with clients
  So that I can provide guidance and feedback

  Scenario: Send a message to enrolled clients
    Given I am logged in as an instructor
    When I navigate to the "Client Interaction" page
    And I select a group of enrolled clients
    And I compose a message
    And I click "Send"
    Then the clients should receive the message

  Scenario: Respond to client messages in a discussion forum
    Given I am logged in as an instructor
    When I navigate to a program's discussion forum
    And I view client messages
    And I reply to a message
    Then my response should appear in the discussion forum

  Scenario: Provide progress reports to a client
    Given I am logged in as an instructor
    When I navigate to a client's profile
    And I review the client's progress
    And I write a progress report
    And I click "Submit"
    Then the client should receive the progress report