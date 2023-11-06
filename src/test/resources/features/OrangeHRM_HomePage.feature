@regression
Feature: user validation for Homepage functionality

  Background:
    Given user navigates to OrangeHRM Login Page
    When user enters "Admin" username
    And user enters "admin123" password
    And user clicks on login button

  Scenario: User should be able to verify main tabs on OrangeHRM Homepage via ListOfMaps
    Then user verifies main tabs on OrangeHRM Homepage via ListOfMaps
      | TabName     |
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |

  Scenario: User should be able to verify main tabs on OrangeHRM Homepage via ListOfData
    Then user verifies main tabs on OrangeHRM Homepage with ListOfData
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |