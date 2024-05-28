Feature: Test take me to yh-antagning.se

  Scenario: Test to check if link to application is correct
    Given I am on the home page iths
    When I click on the link to read more and later to apply link
    Then Second link should take me to application page
