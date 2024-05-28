Feature: Test if there is link to mobile app

  Scenario: Test if there is link to mobile app
    Given I want to get mobile app
    When I click on the link student portal
    Then Page should have link to mobile app
