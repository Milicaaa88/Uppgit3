Feature: Test if there is "testning" category

  Scenario: In educations should be testning category
    Given Exploring homepage
    When I click on the link utbildningar
    Then There should be category testning
