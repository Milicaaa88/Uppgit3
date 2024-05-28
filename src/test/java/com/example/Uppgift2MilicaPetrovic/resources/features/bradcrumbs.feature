Feature: Test confirm breadcrumbs

  Scenario: Test confirming breadcrumbs after opening a link
    Given I want to see all courses
    When I click on the link all our courses
    Then Page should have breadcrumbs
