Feature: Test confirm contact gbg

  Scenario: Test confirming there is a field with Gbg contact text
    Given I want to contact gbg office
    When I click on the nav link contact
    Then Page should have gothenburg contact field
