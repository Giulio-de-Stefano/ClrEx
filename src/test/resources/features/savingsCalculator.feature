Feature: Savings calculator

  Background:
    Given I am on the savings calculator page

  Scenario: the current score is correctly updated
    When I update my current score to 50
    And I update my goal score to 680
    Then the current score average interest is 36.5%
    And the current annual cost is 849 GBP
    And the current number of cards available is 22
    And the goal score average interest is 25%
    And the goal annual cost is 520 GBP
    And the goal number of cards available is 241
    And the potential savings are 384 GBP
