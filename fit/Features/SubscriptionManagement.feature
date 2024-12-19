Feature: Subscription Management

  Scenario: Creating a Subscription Plan
    Given an admin wants to create a new subscription plan
    When they provide the required plan details
    Then the new plan should be saved and made available for assignment

  Scenario: Assigning a Subscription Plan
    Given a user needs to be assigned a subscription plan
    When the admin assigns the plan to the user
    Then the user should gain access to the features of the assigned plan

  Scenario: Viewing Active Subscriptions
    Given the admin wants to view all active subscriptions
    When they access the subscription management dashboard
    Then a list of active subscriptions with relevant details should be displayed

  Scenario: Upgrading a Subscription
    Given a user wants to upgrade their current subscription
    When they initiate an upgrade request
    Then the system should process the upgrade and activate the new plan
