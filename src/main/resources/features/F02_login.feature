Feature: User Could login with valid Credentials
  Scenario: guest user login with valid credentials
    Given user navigate to login page
    And guest user click on login tab
    When user set valid email and password
    Then user click on login button

