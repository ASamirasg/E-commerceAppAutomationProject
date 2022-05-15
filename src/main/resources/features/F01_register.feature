Feature: guest user could register with valid data successfully
  Scenario: guest user register wih valid data
    Given guest user open chrome browser
    And guest user navigates to home page
    And guest user click on register
    When guest user fill personal valid data
    And guest user fill password
    And guest user click on register button
    Then guest user get success message
    And guest user quit driver



