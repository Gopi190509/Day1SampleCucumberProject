Feature: Verify the Facebook page details

  Scenario: Verify the login details with invalid credentails
    Given User on the facebook page
    When User enter the username and password
    And User should click on login button
    Then User should verify the error message
