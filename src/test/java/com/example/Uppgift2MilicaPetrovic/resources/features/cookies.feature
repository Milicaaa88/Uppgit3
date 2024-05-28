Feature: Test confirm cookies on iths.se website

  Scenario: Test confirming cookies
    Given I am on the homepage
    When I click on the link
    Then Cookies should be confirmed
