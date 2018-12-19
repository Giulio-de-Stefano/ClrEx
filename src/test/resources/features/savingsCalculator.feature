Feature: Savings calculator

  Background:
    Given I am on the savings calculator page

  Scenario: the current score is correctly updated
    When I update my current score to 50
    And I update my goal score to 680
