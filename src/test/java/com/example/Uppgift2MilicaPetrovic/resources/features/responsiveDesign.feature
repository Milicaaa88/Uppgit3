Feature: Check if navbar is responsive

  Scenario: Test if hamburger menu is visible on smaller screens
    Given I am on iths homepage
    When I adjust the screen size
    Then I check if hamburger menu is visible
