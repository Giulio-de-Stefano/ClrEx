Feature: Cookies alert behaviour

  Background:
    When I navigate to the home page

  Scenario: the cookie alert panel is displayed
    Then the cookies alert panel is displayed

  Scenario: the cookie alert panel disappears when dismissed
    Then the cookies alert panel is displayed
    And I click on the cookie dismissal button
    Then the cookies alert panel is not displayed

  Scenario: the cookie alert is not displayed if already dismissed
    And I click on the cookie dismissal button
    When I navigate to the home page
    Then the cookies alert panel is not displayed

  Scenario: dismissing the cookie alert adds a cookie to the browser
    And I click on the cookie dismissal button
    Then the browser contains the cookie alert dismissal cookie