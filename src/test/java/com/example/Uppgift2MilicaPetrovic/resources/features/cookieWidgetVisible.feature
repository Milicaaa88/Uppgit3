Feature: Check if cookie settings is visible

  Scenario: Test confirming cookie settings is visible on homepage
    Given I want to setup cookies
    When I open homepage
    Then Cookie settings button should be visible
