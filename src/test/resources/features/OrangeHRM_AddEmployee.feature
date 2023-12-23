Feature: user verifications for HRM Employee Page

  Background:
    Given user logs in to OrangeHRM

  Scenario: as an admin user should be able to successfully add employee
    When user clicks on PIM tab
    And user clicks on Add Employee Button
    And user fills out first, middle and last name
    And user clicks on save
    Then user validates new account got created with correct details

  Scenario: as an admin I should be able to successfully add Contact Details
    When user clicks on PIM tab
    And user clicks on employee name
    And user clicks on contact Details
    And user clicks on edit and fill out address
    And user clicks on save
    Then user verifies full address is displayed